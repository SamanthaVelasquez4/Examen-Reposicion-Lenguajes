package reposicion.dorian.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reposicion.dorian.modelos.Equipo;
import reposicion.dorian.servicios.impl.EquipoServiceImpl;

@RestController
@RequestMapping("/api/equipo")

public class EquipoController {

    @Autowired
    private EquipoServiceImpl equipoServiceImpl;

   @PostMapping("/guardar")
    public String guardarEquipo(@RequestBody Equipo equipo) {
        return this.equipoServiceImpl.guardarEquipo(equipo);
    }

    @DeleteMapping("/eliminar/{idEquipo}")
    public String eliminarEquipo(@PathVariable (name= "idEquipo") int idEquipo){
        return this.equipoServiceImpl.eliminarEquipo(idEquipo);
    } 

    @GetMapping("/obtener/{idEquipo}")
    public Equipo buscarEquipo(@PathVariable (name= "idEquipo") int idEquipo){
        return this.equipoServiceImpl.buscarEquipo(idEquipo);
    }
    
}
