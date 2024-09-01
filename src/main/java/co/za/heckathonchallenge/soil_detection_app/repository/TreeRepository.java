package co.za.heckathonchallenge.soil_detection_app.repository;

import co.za.heckathonchallenge.soil_detection_app.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
}
