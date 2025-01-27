package es.cursosprhib.jpa03ejerciciojpa.tests;

import java.util.List;

import es.cursosprhib.EMF;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Cliente;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Colaborador;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Empleado;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Persona;
import es.cursosprhib.jpa03ejerciciojpa.modelo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = EMF.getInstance().createEntityManager();
		
		// Persona p = em.find(Persona.class, 5);
		
		// System.out.println(p);
		
		
		// Colaborador c = em.find(Colaborador.class, 11);
		// System.out.println(c);
		
		// Empleado e = em.find(Empleado.class, 15);
		// System.out.println(e);
		
		// Cliente cli = em.find(Cliente.class, 3);
		// System.out.println(cli);
		// System.out.println(cli.getProductos());

		// 1- Listar todos los clientes de una categoria

		String sql1 = "select c from Cliente c where c.categoria = :cat";
		TypedQuery<Cliente> q = em.createQuery(sql1, Cliente.class);
        q.setParameter("cat", "VIP");
        List<Cliente> clientesCategoria = q.getResultList();
		System.out.println(clientesCategoria);

		// 2-

		System.out.println("----------------------------");
		String sql2 = "select e from Empleado e where e.categoria.categoria = :cat";
		TypedQuery<Empleado> q2 = em.createQuery(sql2, Empleado.class);
		q2.setParameter("cat", "PROGRAMADOR SR");
		List<Empleado> empleadosCategoria = q2.getResultList();
		System.out.println(empleadosCategoria);

		// 3-

		System.out.println("-----------------------------");
		String sql3 = "select e from Empleado e where e.categoria.categoria = :cat and e.apellidos like :ape";
		TypedQuery<Empleado> q3 = em.createQuery(sql3, Empleado.class);
		q3.setParameter("ape", "%a%");
		q3.setParameter("cat", "PROGRAMADOR SR");
		List<Empleado> empleadosCatApe = q3.getResultList();
		System.out.println(empleadosCatApe);

		//4- 

		System.out.println("------------------------------");
		String sql4 = "select c from Cliente c join c.productos p where p.precio > :pre";
		TypedQuery<Cliente> q4 = em.createQuery(sql4, Cliente.class);
		q4.setParameter("pre", 100);
		List<Cliente> clientesPrecio = q4.getResultList();
		System.out.println(clientesPrecio);

		// 5-

		System.out.println("---------------------------------");
		String sql5 = "select p from Producto p join p.clientes c where c.nroCliente = :num";
		TypedQuery<Producto> q5 = em.createQuery(sql5, Producto.class);
		q5.setParameter("num", 12);
		List<Producto> productosCliente = q5.getResultList();
		System.out.println(productosCliente);

		// 6-

		System.out.println("--------------------------------");
		String sql6 = "select p from Producto p left join p.clientes c where c is null";
		TypedQuery<Producto> q6 = em.createQuery(sql6, Producto.class);
		List<Producto> productosNoVendidos = q6.getResultList();
		System.out.println(productosNoVendidos);

		// 7-

		System.out.println("------------------------------------");
		String sql7 = "select p from Producto p where p.precio = (select max(p.precio) from Producto p) ";
		TypedQuery q7 = em.createQuery(sql7, Producto.class);
		List<Producto> productoMax = q7.getResultList();
		System.out.println(productoMax);

		// 8- 

		System.out.println("-----------------------------------------");
		String sql8 = "select c.categoria, count(p.idProducto) from Producto p join p.clientes c group by c.categoria";
		TypedQuery q8 = em.createQuery(sql8, Object[].class);
		List<Object[]> productosCategoria = q8.getResultList();
		System.out.println(productosCategoria);

		em.close();

	}
}
