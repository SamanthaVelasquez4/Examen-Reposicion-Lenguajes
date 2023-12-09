package reposicion.dorian.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reposicion.dorian.modelos.Posiciones;
import reposicion.dorian.servicios.impl.PosicionesServiceImpl;

@RestController
@RequestMapping("/api/posiciones")

public class PosicionesController {

    @Autowired
    private PosicionesServiceImpl posicionesServiceImpl;

    @GetMapping("/obtenerTodo")
    public List<Posiciones> obtenerTodo(){
        return this.posicionesServiceImpl.obtenerTodo();
    }
    
    
}
