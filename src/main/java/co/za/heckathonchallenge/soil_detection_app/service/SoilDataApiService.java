package co.za.heckathonchallenge.soil_detection_app.service;

import co.za.heckathonchallenge.soil_detection_app.model.SoilData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class SoilDataApiService {

    @Value("${api.copernicus.url}")
    private String copernicusApiUrl;

    @Value("${api.dea.url}")
    private String deaApiUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public SoilDataApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SoilData fetchSoilDataFromCopernicus(double longitude, double latitude) {
        String url = String.format("%s?longitude=%f&latitude=%f", copernicusApiUrl, longitude, latitude);
        ResponseEntity<SoilData> response = restTemplate.getForEntity(url, SoilData.class);
        return response.getBody();
    }

    public SoilData fetchSoilDataFromDea(double longitude, double latitude) {
        String url = String.format("%s?longitude=%f&latitude=%f", deaApiUrl, longitude, latitude);
        ResponseEntity<SoilData> response = restTemplate.getForEntity(url, SoilData.class);
        return response.getBody();
    }
}
