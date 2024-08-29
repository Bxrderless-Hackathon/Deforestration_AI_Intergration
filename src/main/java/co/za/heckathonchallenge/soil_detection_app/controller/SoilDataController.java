package co.za.heckathonchallenge.soil_detection_app.controller;

import co.za.heckathonchallenge.soil_detection_app.model.SoilData;
import co.za.heckathonchallenge.soil_detection_app.service.SoilDataApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/soil-data")
public class SoilDataController {

    @Autowired
    private SoilDataApiService soilDataApiService;

    @GetMapping("/copernicus")
    public SoilData getSoilDataFromCopernicus(
            @RequestParam double longitude,
            @RequestParam double latitude) {
        return soilDataApiService.fetchSoilDataFromCopernicus(longitude, latitude);
    }

    @GetMapping("/dea")
    public SoilData getSoilDataFromDea(
            @RequestParam double longitude,
            @RequestParam double latitude) {
        return soilDataApiService.fetchSoilDataFromDea(longitude, latitude);
    }
}
