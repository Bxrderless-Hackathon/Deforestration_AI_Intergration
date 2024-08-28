package co.za.heckathonchallenge.soil_detection_app.controller;

import co.za.heckathonchallenge.soil_detection_app.model.SoilData;
import co.za.heckathonchallenge.soil_detection_app.service.SoilDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soil-data")
public class SoilDataController {

    @Autowired
    private SoilDataService soilDataService;

    @GetMapping("/within")
    public List<SoilData> getSoilDataWithin(
            @RequestParam double longitude,
            @RequestParam double latitude,
            @RequestParam double distance) {
        return soilDataService.getSoilDataWithin(longitude, latitude, distance);
    }
}
