package es.cursosprhib.jpa03ejerciciojpa.tests;

import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.serviceImpl.ClienteDaoImpl;

public class Test02 {
    public static void main(String[] args) {
        ClienteDaoImpl cli = new ClienteDaoImpl();
        cli.getById(1);
    }
}
