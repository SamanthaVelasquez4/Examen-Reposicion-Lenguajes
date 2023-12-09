package reposicion.dorian.servicios;

import reposicion.dorian.modelos.Equipo;

public interface EquipoServices {

    public String guardarEquipo(Equipo equipo);

    public String eliminarEquipo(int idEquipo);

    public Equipo buscarEquipo(int idEquipo);
    
}
