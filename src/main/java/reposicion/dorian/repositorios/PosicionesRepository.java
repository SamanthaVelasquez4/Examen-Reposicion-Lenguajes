package reposicion.dorian.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import reposicion.dorian.modelos.Posiciones;

public interface PosicionesRepository extends JpaRepository<Posiciones, Integer>{
    
}
