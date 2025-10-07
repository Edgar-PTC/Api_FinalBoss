package finalboss.edgarpineda_camilarugamas_B_G1.Repositories;

import finalboss.edgarpineda_camilarugamas_B_G1.Entities.PeliculasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculasRepository extends JpaRepository<PeliculasEntity, Integer> {
    List<PeliculasEntity> findAll();
}
