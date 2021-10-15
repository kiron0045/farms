package co.edu.usa.ciclo3.ciclo3.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.ciclo3.ciclo3.entidades.Reserva;

@Repository
public class ReservaRepository {
    
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reserva> getAll(){
        return (List<Reserva>) reservaCrudRepository.findAll();
    }
    public Optional<Reserva>getReserva(int id){
        return reservaCrudRepository.findById(id);
    }
    public Reserva save(Reserva r){
        return reservaCrudRepository.save(r);
    }
}
