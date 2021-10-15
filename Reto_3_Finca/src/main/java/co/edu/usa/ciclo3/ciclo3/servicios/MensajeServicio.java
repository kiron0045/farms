package co.edu.usa.ciclo3.ciclo3.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.ciclo3.ciclo3.entidades.Mensaje;
import co.edu.usa.ciclo3.ciclo3.repositorios.MensajeRepository;

@Service
public class MensajeServicio {
    
    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> getAll(){
        return  mensajeRepository.getAll();
    }
    public Optional<Mensaje> getMensaje(int id){
        return mensajeRepository.getMensaje(id);
    }

    public Mensaje save(Mensaje m){
        if(m.getIdMessage()==null){
            return mensajeRepository.save(m);
        }else{
            Optional<Mensaje> paux=mensajeRepository.getMensaje(m.getIdMessage());
            if(paux.isEmpty()){
                return mensajeRepository.save(m);
            }else{
                return m;
            }
        }
    }
}
