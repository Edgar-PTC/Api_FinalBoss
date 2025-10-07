package finalboss.edgarpineda_camilarugamas_B_G1.Controllers;

import finalboss.edgarpineda_camilarugamas_B_G1.Models.DTO.PeliculasDTO;
import finalboss.edgarpineda_camilarugamas_B_G1.Services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiPeliculas")
public class PeliculasController {
    @Autowired
    private PeliculasService service;

    @GetMapping("/getAll")
    public List<PeliculasDTO> conseguirPeliculas(){
        List<PeliculasDTO> list = service.traerTodos();
        return list;
    }

    @GetMapping("/getById/{id}")
    public PeliculasDTO conseguirPorId(@PathVariable Integer id){
        PeliculasDTO res = service.getById(id);
        return res;
    }

    @PostMapping("/postPelicula")
    public ResponseEntity<?> crearPelicula(@RequestBody PeliculasDTO json){
        try {
            PeliculasDTO dto = service.createPelicula(json);
            if (dto == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "failed",
                        "message", "Datos invalidos"
                ));
            }
            return ResponseEntity.ok().body(Map.of(
                    "status", "success",
                    "data", dto
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "failed conection",
                    "message", e.getMessage()
            ));
        }
    }

    @PutMapping("/putPelicula/{id}")
    public ResponseEntity<?> actualizarPelicula(@PathVariable Integer id, @RequestBody PeliculasDTO json){
        try {
            PeliculasDTO dto = service.updatePelicula(id, json);
            if (dto == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "failed",
                        "message", "Datos invalidos"
                ));
            }
            return ResponseEntity.ok().body(Map.of(
                    "status", "success",
                    "data", dto
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "failed conection",
                    "message", e.getMessage()
            ));
        }
    }

    @DeleteMapping("/deletePelicula/{id}")
    public ResponseEntity<?> crearPelicula(@PathVariable Integer id){
        try {
            PeliculasDTO dto = service.deletePelicula(id);
            if (dto == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "failed",
                        "message", "Datos invalidos"
                ));
            }
            return ResponseEntity.ok().body(Map.of(
                    "status", "success",
                    "data", dto
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "failed conection",
                    "message", e.getMessage()
            ));
        }
    }
}
