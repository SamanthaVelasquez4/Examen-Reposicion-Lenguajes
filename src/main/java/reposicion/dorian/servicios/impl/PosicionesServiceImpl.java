package reposicion.dorian.servicios.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reposicion.dorian.modelos.Posiciones;
import reposicion.dorian.repositorios.EquipoRepository;
import reposicion.dorian.repositorios.PosicionesRepository;
import reposicion.dorian.servicios.PosicionesService;

@Service
public class PosicionesServiceImpl implements PosicionesService{

    @Autowired
    private PosicionesRepository posicionesRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public String simularPartidos() {

        //Validar que existan mas de 6 equipos
        if(this.equipoRepository.findAll().size() < 6){
            return "Se ocupan al menos 6 equipos para hacer la simulacion";
        }else{

            //Aqui se iba a llamar la funcion de partido para cada equipo
        }    

        return "Simulacion creada";
        
    }

    @Override
    public List<Posiciones> obtenerTodo() {
       return this.posicionesRepository.findAll();
    }

    public void partido(int idEquipo1, int idEquipo2){

        //generar goles
        Random random = new Random();
        int golesEquipo1 = random.nextInt(10) + 1;
        int golesEquipo2 = random.nextInt(10) + 1;

        //obtener posiciones
        Posiciones posicion1 = new Posiciones();
        Posiciones posicion2 = new Posiciones();

        //Comprueba si existe el equipo 1
        if(this.posicionesRepository.existsById(idEquipo1)){
            posicion1= this.posicionesRepository.findById(idEquipo1).get();
            posicion1.setGolesContra(posicion1.getGolesContra()+golesEquipo2);
            posicion1.setGolesFavor(posicion1.getGolesFavor()+golesEquipo1);
        
        //si no existe lo crea    
        }else{
            posicion1.setCodigoEquipo(idEquipo1);
            posicion1.setGolesFavor(golesEquipo1);
            posicion1.setGolesContra(golesEquipo2);
            posicion1.setEmpates(0);
            posicion1.setGanados(0);
            posicion1.setPuntos(0);
            posicion1.setPerdidos(0);
        }

        //Comprueba si existe el equipo 2
        if(this.posicionesRepository.existsById(idEquipo2)){
            posicion2= this.posicionesRepository.findById(idEquipo2).get();
            posicion2.setGolesContra(posicion2.getGolesContra()+golesEquipo1);
            posicion2.setGolesFavor(posicion2.getGolesFavor()+golesEquipo2);
        }else{
            posicion2.setCodigoEquipo(idEquipo2);
            posicion2.setGolesContra(golesEquipo1);
            posicion2.setGolesFavor(golesEquipo2);
            posicion2.setGanados(0);
            posicion2.setPuntos(0);
            posicion2.setPerdidos(0);
        }
        
        if(golesEquipo1==golesEquipo2){
            posicion1.setEmpates(posicion1.getEmpates()+1);
            posicion2.setEmpates(posicion2.getEmpates()+1);
            posicion1.setPuntos(posicion1.getPuntos()+1);
            posicion2.setPuntos(posicion2.getPuntos()+1);
        }else if(golesEquipo1>golesEquipo2){
            posicion1.setGanados(posicion1.getGanados()+1);
            posicion2.setPerdidos(posicion2.getPerdidos()+1);
            posicion1.setPuntos(posicion1.getPuntos()+3);
        }else{
            posicion2.setGanados(posicion2.getGanados()+1);
            posicion1.setPerdidos(posicion1.getPerdidos()+1);
            posicion2.setPuntos(posicion2.getPuntos()+3);
        }

        //guardar
        this.posicionesRepository.save(posicion1);
        this.posicionesRepository.save(posicion2);

        
    }

    
}
