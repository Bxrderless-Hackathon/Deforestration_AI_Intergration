package co.za.heckathonchallenge.soil_detection_app.util;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreeDataService {

    private List<Map<String, Object>> trees;

    public TreeDataService() {
        trees = new ArrayList<>();
        loadTreeData();
    }

    private void loadTreeData() {
        trees.add(createTree("Alberta magna", "Natal Flame Bush", "5-13m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Albizia adianthifolia", "Flat-crown", "10-40m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Allophylus natalensis", "Dune Allophylus", "2-5m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Anthocleista grandiflora", "Forest Fever Tree", "6-30m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Apodytes dimidiata", "White Pear", "4-20m", 0, 7.0, 1.7, 25, 3.0));

        trees.add(createTree("Brachylaena discolor", "Coast Silver Oak", "4-10m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Calodendrum capense", "Cape Chestnut", "7-20m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Canthium mundianum", "Rock Alder", "1-5m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Cassine peragua", "Cape Saffron", "3-10m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Combretum kraussii", "Forest Bushwillow", "8-12m", 0, 7.0, 1.7, 25, 3.0));

        trees.add(createTree("Cryptocarya woodii", "Cape Laurel", "5-10m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Cunonia capensis", "Red Alder", "20-30m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Curtisia dentata", "Assegai", "6-20m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Ekebergia capensis", "Cape Ash", "7-20m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Erythrina caffra", "Coastal Coral Tree", "9-12m", 0, 7.0, 1.7, 25, 3.0));

        trees.add(createTree("Ficus bizanae", "Pondo Fig", "10m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Ficus craterostoma", "Forest Fig", "10m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Ficus natalensis", "Natal Fig", "5-20m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Ficus sur", "Broom Cluster Fig", "10-18m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Ficus trichopoda", "Swamp Fig", "8m", 0, 7.0, 1.7, 25, 3.0));

        trees.add(createTree("Harpephyllum caffrum", "Wild Plum", "6-10m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Ilex mitis", "African Holly", "10-30m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Maytenus acuminata", "Silky Bark", "3-15m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Millettia grandis", "Umzimbeet", "7-13m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Millettia sutherlandii", "Giant Umzimbeet", "8-30m", 0, 7.0, 1.7, 25, 3.0));

        trees.add(createTree("Mimusops caffra", "Coast Red Milkwood", "2-15m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Mimusops obovata", "Red Milkwood", "8-20m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Nuxia floribunda", "Forest Nuxia", "3-15m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Podocarpus falcatus", "Outeniqua Yellowwood", "12-30m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Podocarpus henkelii", "Natal Yellowwood", "5-10m", 0, 7.0, 1.7, 25, 3.0));

        trees.add(createTree("Podocarpus latifolius", "Yellowwood", "5-30m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Prunus africana", "Red Stinkwood", "10-20m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Rapanea melanophloeos", "Cape Beech", "4-20m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Rothmannia capensis", "Cape Gardenia", "5-14m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Schefflera umbellifera", "Forest Cabbage Tree", "3-10m", 0, 7.0, 1.7, 25, 3.0));

        trees.add(createTree("Syzygium gerrardii", "Forest Waterberry", "0-9m", 0, 6.5, 1.3, 20, 2.5));
        trees.add(createTree("Trema orientalis", "Pigeon Wood", "3-13m", 0, 6.7, 1.4, 22, 2.7));
        trees.add(createTree("Trichilia dregeana", "Forest Mahogany", "0-30m", 0, 6.8, 1.5, 23, 2.8));
        trees.add(createTree("Vepris lanceolata", "White Ironwood", "4-20m", 0, 6.9, 1.6, 24, 2.9));
        trees.add(createTree("Virgilia divaricata", "Keurboom", "5-10m", 0, 7.0, 1.7, 25, 3.0));
        trees.add(createTree("Warburgia salutaris", "Pepperbark Tree", "5-20m", 0, 6.5, 1.3, 20, 2.5));
    }


    private Map<String, Object> createTree(String scientificName, String commonName, String size, int waterWise,
                                           double ph, double bulkDensity, double clayContent, double carbonOrganic) {
        Map<String, Object> tree = new HashMap<>();
        tree.put("scientificName", scientificName);
        tree.put("commonName", commonName);
        tree.put("size", size);
        tree.put("waterWise", waterWise);
        tree.put("ph", ph);
        tree.put("bulkDensity", bulkDensity);
        tree.put("clayContent", clayContent);
        tree.put("carbonOrganic", carbonOrganic);
        return tree;
    }

    public List<Map<String, Object>> getTrees() {
        return trees;
    }
}
