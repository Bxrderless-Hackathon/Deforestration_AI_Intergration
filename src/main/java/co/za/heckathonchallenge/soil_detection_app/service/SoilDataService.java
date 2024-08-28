package co.za.heckathonchallenge.soil_detection_app.service;

import co.za.heckathonchallenge.soil_detection_app.model.SoilData;
import co.za.heckathonchallenge.soil_detection_app.repository.SoilDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoilDataService {

    @Autowired
    private SoilDataRepository soilDataRepository;

    public List<SoilData> getSoilDataWithin(double longitude, double latitude, double distance) {
        return soilDataRepository.findWithinDistance(longitude, latitude, distance);
    }
}

