package reposicion.dorian.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import reposicion.dorian.modelos.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer>{
    
}
