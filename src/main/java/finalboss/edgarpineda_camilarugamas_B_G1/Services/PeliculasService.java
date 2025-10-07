package finalboss.edgarpineda_camilarugamas_B_G1.Services;

import finalboss.edgarpineda_camilarugamas_B_G1.Entities.PeliculasEntity;
import finalboss.edgarpineda_camilarugamas_B_G1.Exceptions.Peliculas.*;
import finalboss.edgarpineda_camilarugamas_B_G1.Models.DTO.PeliculasDTO;
import finalboss.edgarpineda_camilarugamas_B_G1.Repositories.PeliculasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PeliculasService {
    @Autowired
    private PeliculasRepository repo;

    private PeliculasEntity convertirAEntity(PeliculasDTO dto){
        PeliculasEntity entity = new PeliculasEntity();
        entity.setId(dto.getId());
        entity.setTitulo(dto.getTitulo());
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
        json.setTitulo(entity.getTitulo());
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
            return entity.stream()
                    .map(this::convertirADTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Hubo problemas obteniendo las peliculas", e);
            throw new ExceptionGetPeliculas("Hubo problemas obteniendo las peliculas");
        }
    }

    public PeliculasDTO getById(Integer id){
        PeliculasEntity entity = repo.findById(id).orElseThrow(() -> new ExceptionFindPeliculas("El id enviado no pertenece a ningun registro"));
        return convertirADTO(entity);
    }

    public PeliculasDTO createPelicula(PeliculasDTO json){
        try{
            PeliculasEntity entity = convertirAEntity(json);
            PeliculasEntity res = repo.save(entity);
            return convertirADTO((res));
        } catch (Exception e) {
            log.error("Hubo problemas creando la pelicula", e);
            throw new ExceptionCreatePeliculas("Hubo problemas creando la pelicula");
        }
    }

    public PeliculasDTO updatePelicula(Integer id, PeliculasDTO json){
        try{
            PeliculasEntity entity = repo.findById(id).orElseThrow(() -> new ExceptionFindPeliculas("El id enviado no pertenece a ningun registro"));
            entity.setTitulo(json.getTitulo());
            entity.setDirector(json.getDirector());
            entity.setGenero(json.getGenero());
            entity.setAnio_estreno(json.getAnio_estreno());
            entity.setDuracion_min(json.getDuracion_min());
            entity.setFecha_creacion(json.getFecha_creacion());
            PeliculasEntity res = repo.save(entity);
            return convertirADTO(res);
        } catch (Exception e) {
            log.error("Hubo problemas actualizando la pelicula", e);
            throw new ExceptionUpdatePeliculas("Hubo problemas actualizando la pelicula");
        }
    }

    public PeliculasDTO deletePelicula(Integer id){
        try{
            PeliculasEntity entity = repo.findById(id).orElseThrow(() -> new ExceptionFindPeliculas("No se encontro ninguna pelicula con el id enviado"));
            repo.deleteById(id);
            return convertirADTO(entity);
        } catch (Exception e) {
            log.error("Hubo problemas eliminando la pelicula", e);
            throw new ExceptionDeletePelicula("Hubo problemas eliminando la pelicula ");
        }
    }
}
