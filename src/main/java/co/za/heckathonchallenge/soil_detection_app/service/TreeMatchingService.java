package co.za.heckathonchallenge.soil_detection_app.service;

import co.za.heckathonchallenge.soil_detection_app.util.TreeDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TreeMatchingService {

    private final TreeDataService treeDataService;

    // Define tolerances and acceptable ranges
    private static final double PH_TOLERANCE = 0.2;
    private static final double CARBON_ORGANIC_TOLERANCE = 0.5;
    private static final double BULK_DENSITY_TOLERANCE = 0.3;
    private static final double CLAY_CONTENT_TOLERANCE = 5.0;

    private static final double MIN_PH = 5.5;
    private static final double MAX_PH = 7;
    private static final double MIN_CARBON_ORGANIC = 2.0;
    private static final double MAX_CARBON_ORGANIC = 3.0;
    private static final double MIN_BULK_DENSITY = 1.0;
    private static final double MAX_BULK_DENSITY = 1.7;
    private static final double MIN_CLAY_CONTENT = 20.0;
    private static final double MAX_CLAY_CONTENT = 25.0;

    public List<Map<String, Object>> findSuitableTrees(double ph, double carbonOrganic, Double bulkDensity, Double clayContent) {
        List<Map<String, Object>> suitableTrees = new ArrayList<>();
        List<Map<String, Object>> allTrees = treeDataService.getTrees();

        for (Map<String, Object> tree : allTrees) {
            if (isTreeSuitable(tree, ph, carbonOrganic, bulkDensity, clayContent)) {
                suitableTrees.add(tree);
            }
        }

        return suitableTrees;
    }

    private boolean isTreeSuitable(Map<String, Object> tree, double ph, double carbonOrganic, Double bulkDensity, Double clayContent) {
        double treePh = (double) tree.get("ph");
        double treeCarbonOrganic = (double) tree.get("carbonOrganic");
        double treeBulkDensity = (double) tree.get("bulkDensity");
        double treeClayContent = (double) tree.get("clayContent");

        boolean phSuitable = isWithinRange(treePh, ph, PH_TOLERANCE, MIN_PH, MAX_PH);
        boolean carbonOrganicSuitable = isWithinRange(treeCarbonOrganic, carbonOrganic, CARBON_ORGANIC_TOLERANCE, MIN_CARBON_ORGANIC, MAX_CARBON_ORGANIC);

        boolean bulkDensitySuitable = bulkDensity == null || isWithinRange(treeBulkDensity, bulkDensity, BULK_DENSITY_TOLERANCE, MIN_BULK_DENSITY, MAX_BULK_DENSITY);
        boolean clayContentSuitable = clayContent == null || isWithinRange(treeClayContent, clayContent, CLAY_CONTENT_TOLERANCE, MIN_CLAY_CONTENT, MAX_CLAY_CONTENT);

        return phSuitable && carbonOrganicSuitable && bulkDensitySuitable && clayContentSuitable;
    }

    private boolean isWithinRange(double value, double target, double tolerance, double min, double max) {
        return (Math.abs(value - target) <= tolerance) || (value >= min && value <= max);
    }

    private boolean isWithinRangeForNullable(Double value, Double target, double tolerance, double min, double max) {
        return value != null && target != null && (Math.abs(value - target) <= tolerance) && (value >= min && value <= max);
    }


}
