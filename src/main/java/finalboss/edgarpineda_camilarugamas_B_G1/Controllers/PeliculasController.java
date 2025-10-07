package finalboss.edgarpineda_camilarugamas_B_G1.Controllers;

import finalboss.edgarpineda_camilarugamas_B_G1.Services.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apiPeliculas")
public class PeliculasController {
    @Autowired
    private PeliculasService service;
}
