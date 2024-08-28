package co.za.heckathonchallenge.soil_detection_app.repository;


import co.za.heckathonchallenge.soil_detection_app.model.SoilData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SoilDataRepository extends JpaRepository<SoilData, Long> {
    @Query(value = "SELECT * FROM soil_data WHERE ST_DWithin(location, ST_SetSRID(ST_MakePoint(?1, ?2), 4326), ?3)", nativeQuery = true)
    List<SoilData> findWithinDistance(double longitude, double latitude, double distanceInMeters);
}
