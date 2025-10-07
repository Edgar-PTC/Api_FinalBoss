package finalboss.edgarpineda_camilarugamas_B_G1.Services;

import finalboss.edgarpineda_camilarugamas_B_G1.Entities.PeliculasEntity;
import finalboss.edgarpineda_camilarugamas_B_G1.Exceptions.Peliculas.ExceptionFindPeliculas;
import finalboss.edgarpineda_camilarugamas_B_G1.Exceptions.Peliculas.ExceptionGetPeliculas;
import finalboss.edgarpineda_camilarugamas_B_G1.Models.DTO.PeliculasDTO;
import finalboss.edgarpineda_camilarugamas_B_G1.Repositories.PeliculasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PeliculasService {
    @Autowired
    private PeliculasRepository repo;

    private PeliculasEntity convertirAEntity(PeliculasDTO dto){
        PeliculasEntity entity = new PeliculasEntity();
        entity.setId(dto.getId());
        entity.setDirector(dto.getDirector());
        entity.setGenero(dto.getGenero());
        entity.setAnio_estreno(dto.getAnio_estreno());
        entity.setDuracion_min(dto.getDuracion_min());
        entity.setFecha_creacion(dto.getFecha_creacion());
        return entity;
    }

    private PeliculasDTO convertirADTO(PeliculasEntity entity){
        PeliculasDTO json = new PeliculasDTO();
        json.setId(entity.getId());
        json.setDirector(entity.getDirector());
        json.setGenero(entity.getGenero());
        json.setAnio_estreno(entity.getAnio_estreno());
        json.setDuracion_min(entity.getDuracion_min());
        json.setFecha_creacion(entity.getFecha_creacion());
        return json;
    }

    public List<PeliculasDTO> traerTodos(){
        try {
            List<PeliculasEntity> entity = repo.findAll();

        } catch (Exception e) {
            throw new ExceptionGetPeliculas("Hubo problemas obteniendo las peliculas");
        }
    }

    public PeliculasDTO getById(Integer id){
        PeliculasEntity entity = repo.findById(id).orElseThrow(() -> new ExceptionFindPeliculas("El id enviado no pertenece a ningun registro"));
    }
}
