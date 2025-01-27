package es.cursosprhib.jpa03ejerciciojpa.service;

import java.util.List;

import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modeloDto.ClienteDto;

public interface ClienteDao {

    public Cliente save (Cliente cliente);

    public void deleteById(Integer id);

    public void delete(Cliente cliente);

    public Cliente getById (Integer id);

    public List<ClienteDto> findAll();
    
}
