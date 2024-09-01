package co.za.heckathonchallenge.soil_detection_app.controller;

import co.za.heckathonchallenge.soil_detection_app.model.SoilData;
import co.za.heckathonchallenge.soil_detection_app.service.SoilDataApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SoilDataController {

    private final SoilDataApiService soilDataApiService;

    @Autowired
    public SoilDataController(SoilDataApiService soilDataApiService) {
        this.soilDataApiService = soilDataApiService;
    }

    @GetMapping("/soil-data")
    public String getSoilData(
            @RequestParam double latitude,
            @RequestParam double longitude) throws JsonProcessingException {
        return soilDataApiService.fetchAndSaveSoilDataFromIsda(latitude, longitude);
    }
}
