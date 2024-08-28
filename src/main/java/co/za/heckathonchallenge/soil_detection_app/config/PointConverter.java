package co.za.heckathonchallenge.soil_detection_app.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;

@Converter(autoApply = true)
public class PointConverter implements AttributeConverter<Point, String> {

    private static final GeometryFactory geometryFactory = new GeometryFactory();
    private static final WKTReader wktReader = new WKTReader(geometryFactory);

    @Override
    public String convertToDatabaseColumn(Point attribute) {
        return attribute != null ? attribute.toText() : null;
    }

    @Override
    public Point convertToEntityAttribute(String dbData) {
        try {
            return dbData != null ? (Point) wktReader.read(dbData) : null;
        } catch (Exception e) {
            // Handle parsing exception
            return null;
        }
    }
}