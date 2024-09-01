package co.za.heckathonchallenge.soil_detection_app.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    private Property property;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Property {

        @JsonProperty("bulk_density")
        private List<SoilProperty> bulkDensity;

        @JsonProperty("clay_content")
        private List<SoilProperty> clayContent;

        @JsonProperty("carbon_organic")
        private List<SoilProperty> carbonOrganic;

        @JsonProperty("ph")
        private List<SoilProperty> phLevel;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SoilProperty {
        private Value value;
        private Depth depth;
        private List<Uncertainty> uncertainty;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Value {
            private String unit;
            private String type;
            private double value;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Depth {
            private String value;
            private String unit;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Uncertainty {
            @JsonProperty("confidence_interval")
            private String confidenceInterval;

            @JsonProperty("lower_bound")
            private double lowerBound;

            @JsonProperty("upper_bound")
            private double upperBound;
        }
    }
}
