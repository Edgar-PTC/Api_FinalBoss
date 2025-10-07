package finalboss.edgarpineda_camilarugamas_B_G1.Controllers;

import finalboss.edgarpineda_camilarugamas_B_G1.Models.DTO.PeliculasDTO;
import finalboss.edgarpineda_camilarugamas_B_G1.Services.PeliculasService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
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

}
