package co.edu.usa.ciclo3.ciclo3.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.ciclo3.ciclo3.entidades.Cliente;
import co.edu.usa.ciclo3.ciclo3.repositorios.ClienteRepository;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        return  clienteRepository.getAll();
    }
    public Optional<Cliente> getCliente(int id){
        return clienteRepository.getCliente(id);
    }

    public Cliente save(Cliente c){
        if(c.getIdClient()==null){
            return clienteRepository.save(c);
        }else{
            Optional<Cliente> paux=clienteRepository.getCliente(c.getIdClient());
            if(paux.isEmpty()){
                return clienteRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
}
