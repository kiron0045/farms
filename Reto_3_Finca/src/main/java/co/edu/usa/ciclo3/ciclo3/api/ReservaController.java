package co.edu.usa.ciclo3.ciclo3.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.edu.usa.ciclo3.ciclo3.entidades.Reserva;
import co.edu.usa.ciclo3.ciclo3.servicios.ReservaServicio;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ReservaController {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/all")
    public List<Reserva> getReservas(){
        return reservaServicio.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reserva> getReserva(@PathVariable("id") int id){
        return reservaServicio.getReserva(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva r){
        return reservaServicio.save(r);
    }
    
}
