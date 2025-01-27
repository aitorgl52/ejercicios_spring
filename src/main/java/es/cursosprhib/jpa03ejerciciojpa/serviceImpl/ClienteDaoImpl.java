package es.cursosprhib.jpa03ejerciciojpa.serviceImpl;

import java.util.List;

import es.cursosprhib.EMF;
import es.cursosprhib.jpa03ejerciciojpa.execeptions.ClientePersistException;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modeloDto.ClienteDto;
import es.cursosprhib.jpa03ejerciciojpa.service.ClienteDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ClienteDaoImpl implements ClienteDao{
    private EntityManager em = EMF.getInstance().createEntityManager();
    private EntityManagerFactory emf = em.getEntityManagerFactory();

    @Override
    public Cliente save(Cliente cliente) {
        Cliente saved;
        try {
            em.getTransaction().begin();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        saved = em.merge(cliente);
        em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new ClientePersistException();
        } finally {
            em.close();
        }
        return saved;
    }

    @Override
    public void delete(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new ClientePersistException();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(Integer id) {
        delete(getById(id));

    }

    @Override
    public Cliente getById(Integer id) {
        Cliente cli;
        try {
            em = emf.createEntityManager();
            cli = em.find(Cliente.class, id);
            cli.getProductos().size();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClientePersistException();
        } finally {
            em.close();
        }
        return cli;
    }

    @Override
    public List<ClienteDto> findAll() {
        List<ClienteDto> cli;
        try {
            em = emf.createEntityManager();
            String jpql = "select new es.cursosprhib.jpa03ejerciciojpa.modeloDto.ClienteDto(c.idPersona, c.apellidos, c.nroCliente) from Cliente c";
            TypedQuery<ClienteDto> q = em.createQuery(jpql, ClienteDto.class);
            cli = q.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ClientePersistException();
        } finally {
            em.close();
        }
        return cli;
    }

    
}
