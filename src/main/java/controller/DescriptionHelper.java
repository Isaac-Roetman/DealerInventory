/**
 * @author Isaac Roetman - ijroetman
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Descriptions;
public class DescriptionHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DealerInventory");
	
	public void insertDescription(Descriptions d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Descriptions> showAllDescriptions() {
		EntityManager em = emfactory.createEntityManager();
		List<Descriptions> allDescriptions = em.createQuery("SELECT d FROM Descriptions d").getResultList();
		return allDescriptions;
	}
	
	public void deleteDescription (Descriptions toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Descriptions> typedQuery = em.createQuery("select d from Descriptions d where d.color = :selectedColor and d.year = :selectedYear and d.acquisitionDate = :selectedAcquisitionDate", Descriptions.class);
		typedQuery.setParameter("selectedColor", toDelete.getColor());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedAcquisitionDate", toDelete.getAcquisitionDate());
		typedQuery.setMaxResults(1);
		Descriptions result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Descriptions searchForDescriptionsById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Descriptions found = em.find(Descriptions.class, idToEdit);
		em.close();

		return found;
	}
	
	public void updateDescriptions(Descriptions toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Descriptions> searchForDescriptionByColor(String color) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Descriptions> typedQuery = em.createQuery("select d from Descriptions d where d.color = :selectedColor", Descriptions.class);
		typedQuery.setParameter("selectedColor", color);
		List<Descriptions> foundDescription = typedQuery.getResultList();
		em.close();

		return foundDescription;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
