package reposicion.dorian.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reposicion.dorian.modelos.Equipo;
import reposicion.dorian.repositorios.EquipoRepository;
import reposicion.dorian.repositorios.PosicionesRepository;
import reposicion.dorian.servicios.EquipoServices;

@Service
public class EquipoServiceImpl implements EquipoServices {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private PosicionesRepository posicionesRepository;

    @Override
    public String guardarEquipo(Equipo equipo) {
        if(equipo!=null){
            this.equipoRepository.save(equipo);
            return "Equipo guardador correctamente";
        }

        return "Error al guardar Equipo";
    }

    @Override
    public String eliminarEquipo(int idEquipo) {
        //Comprobar si esta en la tabla de posiciones
        if(this.posicionesRepository.existsById(idEquipo)){
            return "No se puede eliminar equipo, ya esta en la tabla de posiciones";

        //Comprobar que existe equipo    
        }else if(this.equipoRepository.existsById(idEquipo)){
            this.equipoRepository.deleteById(idEquipo);
            return "Equipo eliminado correctamente";

        //No exite el equipo    
        }else{
            return "Equipo no encontrado";
        }
    }

    @Override
    public Equipo buscarEquipo(int idEquipo) {

        if(this.equipoRepository.existsById(idEquipo)){
            return this.equipoRepository.findById(idEquipo).get();
        }

        return null;
    }
    
}
