package co.za.heckathonchallenge.soil_detection_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import jakarta.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "soil_data")
public class SoilData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Point location; // GeoJSON location

    // Soil properties
    private Double bulkDensity; // Bulk density (g/cc)
    private Double clayContent; // Clay content (%)
    private Double carbonOrganic; // Carbon organic content (%)
    private Double phLevel; // pH level

}
