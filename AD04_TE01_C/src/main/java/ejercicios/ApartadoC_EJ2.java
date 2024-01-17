package ejercicios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entidades.Course;
import entidades.Student;
import entidades.Tuition;
import entidades.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ApartadoC_EJ2 {

	/**
	 * 4. ManyToMany bidireccional entre entidades Student y Course
	 * Borra una Student pero no el curso
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud4");
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.getTransaction().begin();
		
		try {			
			// Borra un objeto Student
			System.out.println("Borrando un objeto Student ");
			
			int student_id = 8;
			
			Student tempStudent= entityManager.find(Student.class, student_id);
			// comienza la transacci�n
			//session.beginTransaction();
		
			// borra el objecto Student pero sin CascadeType.REMOVE no elimina el curso
			entityManager.remove(tempStudent);
			
			// hace commit de la transaccion
			entityManager.getTransaction().commit();
					
			System.out.println("Hecho!");
		}
		catch ( Exception e ) {
			// rollback ante alguna excepci n
			System.out.println("Realizando Rollback");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			factory.close();
		}
	}
	
}




