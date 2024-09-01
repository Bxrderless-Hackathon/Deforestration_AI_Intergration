package co.za.heckathonchallenge.soil_detection_app.service;

import co.za.heckathonchallenge.soil_detection_app.model.SoilData;
import co.za.heckathonchallenge.soil_detection_app.repository.SoilDataRepository;
import co.za.heckathonchallenge.soil_detection_app.response.ApiResponse;
import co.za.heckathonchallenge.soil_detection_app.response.ApiResponse.SoilProperty;
import co.za.heckathonchallenge.soil_detection_app.util.TreeDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SoilDataApiService {

    @Value("${api.isda.url}")
    private String isdaApiUrl;

    @Value("${api.isda.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final GeometryFactory geometryFactory = new GeometryFactory();
    private final SoilDataRepository soilDataRepository;
    private final TreeMatchingService treeMatchingService;
    private final TreeDataService treeDataService;

    public String fetchAndSaveSoilDataFromIsda(double latitude, double longitude) throws JsonProcessingException {
        String[][] propertiesWithDepth = {
                {"bulk_density", "0-20"},
                {"clay_content", "0-20"},
                {"carbon_organic", "0-20"},
                {"ph", "0-20"}
        };

        SoilData soilData = new SoilData();
        Point location = geometryFactory.createPoint(new Coordinate(longitude, latitude));
        soilData.setLocation(location);

        for (String[] propertyDepth : propertiesWithDepth) {
            String property = propertyDepth[0];
            String depth = propertyDepth[1];

            String url = String.format("%s?key=%s&lat=%f&lon=%f&property=%s&depth=%s",
                    isdaApiUrl, apiKey, latitude, longitude, property, depth);
            fetchAndSetSoilProperty(url, property, soilData);
        }

        SoilData savedSoilData = soilDataRepository.save(soilData);

        Double ph = soilData.getPhLevel();
        Double carbonOrganic = soilData.getCarbonOrganic();
        Double bulkDensity = soilData.getBulkDensity();
        Double clayContent = soilData.getClayContent();

        List<Map<String, Object>> suitableTrees = treeMatchingService.findSuitableTrees(ph, carbonOrganic, bulkDensity, clayContent);

        return createGeoJsonWithTrees(savedSoilData, suitableTrees);
    }

    private void fetchAndSetSoilProperty(String url, String property, SoilData soilData) {
        try {
            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
            ApiResponse apiResponse = response.getBody();

            if (apiResponse != null && apiResponse.getProperty() != null) {
                List<SoilProperty> soilProperties;
                switch (property) {
                    case "bulk_density":
                        soilProperties = apiResponse.getProperty().getBulkDensity();
                        soilData.setBulkDensity(extractValue(soilProperties));
                        break;
                    case "clay_content":
                        soilProperties = apiResponse.getProperty().getClayContent();
                        soilData.setClayContent(extractValue(soilProperties));
                        break;
                    case "carbon_organic":
                        soilProperties = apiResponse.getProperty().getCarbonOrganic();
                        soilData.setCarbonOrganic(extractValue(soilProperties));
                        break;
                    case "ph":
                        soilProperties = apiResponse.getProperty().getPhLevel();
                        soilData.setPhLevel(extractValue(soilProperties));
                        break;
                }
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }

    private Double extractValue(List<SoilProperty> soilProperties) {
        return (soilProperties != null && !soilProperties.isEmpty())
                ? soilProperties.get(0).getValue().getValue()
                : null;
    }

    private String createGeoJsonWithTrees(SoilData soilData, List<Map<String, Object>> suitableTrees) throws JsonProcessingException {
        Map<String, Object> geoJson = new HashMap<>();
        geoJson.put("type", "FeatureCollection");

        Map<String, Object> feature = new HashMap<>();
        feature.put("type", "Feature");

        Map<String, Object> geometry = new HashMap<>();
        geometry.put("type", "Point");
        geometry.put("coordinates", Arrays.asList(
                soilData.getLocation().getX(), // Longitude
                soilData.getLocation().getY()  // Latitude
        ));
        feature.put("geometry", geometry);

        Map<String, Object> properties = new HashMap<>();
        properties.put("bulk_density", soilData.getBulkDensity());
        properties.put("clay_content", soilData.getClayContent());
        properties.put("carbon_organic", soilData.getCarbonOrganic());
        properties.put("ph_level", soilData.getPhLevel());

        List<Map<String, String>> treeList = new ArrayList<>();
        for (Map<String, Object> tree : suitableTrees) {
            Map<String, String> treeInfo = new HashMap<>();
            treeInfo.put("scientific_name", (String) tree.get("scientificName"));
            treeInfo.put("common_name", (String) tree.get("commonName"));
            treeList.add(treeInfo);
        }
        properties.put("suitable_trees", treeList);

        feature.put("properties", properties);

        geoJson.put("features", Collections.singletonList(feature));

        return new ObjectMapper().writeValueAsString(geoJson);
    }
}
