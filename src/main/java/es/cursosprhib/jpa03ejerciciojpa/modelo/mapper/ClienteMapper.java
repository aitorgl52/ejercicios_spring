package es.cursosprhib.jpa03ejerciciojpa.modelo.mapper;

import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modeloDto.ClienteDto;

public class ClienteMapper {
    public static Cliente toCliente(ClienteDto cliDto) {
        Cliente cli = new Cliente();
        cli.setIdPersona(cliDto.getIdPersona());
        cli.setApellidos(cliDto.getAèllidos());
        cli.setNroCliente(cliDto.getNroCliente());
        return cli;
    }

    public static ClienteDto toClienteDto(Cliente cli) {
        return new ClienteDto(cli.getIdPersona(), cli.getApellidos(), cli.getNroCliente());
    }
}
