package co.za.heckathonchallenge.soil_detection_app.model;

import co.za.heckathonchallenge.soil_detection_app.config.PointConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoilData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PointConverter.class)
    private Point location;

    private double bulkDensity;
    private String soilType;
    private double phLevel;
    private String moisture;

    // Add other relevant fields here...
}
