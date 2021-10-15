package co.edu.usa.ciclo3.ciclo3.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.ciclo3.ciclo3.entidades.Reserva;
import co.edu.usa.ciclo3.ciclo3.repositorios.ReservaRepository;
@Service
public class ReservaServicio {

    
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAll(){
        return  reservaRepository.getAll();
    }
    public Optional<Reserva> getReserva(int id){
        return reservaRepository.getReserva(id);
    }

    public Reserva save(Reserva r){
        if(r.getIdReservation()==null){
            return reservaRepository.save(r);
        }else{
            Optional<Reserva> paux=reservaRepository.getReserva(r.getIdReservation());
            if(paux.isEmpty()){
                return reservaRepository.save(r);
            }else{
                return r;
            }
        }
    }
    
}
