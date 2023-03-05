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

import model.InventoryDetails;

public class InventoryDetailsHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DealerInventory");
	
	public void insertNewInventoryDetails(InventoryDetails i) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<InventoryDetails> getInventories(){
		EntityManager em = emfactory.createEntityManager();
		List<InventoryDetails> allDetails = em.createQuery("SELECT i FROM InventoryDetails i").getResultList();
		return allDetails;
	}
	
	public InventoryDetails searchForInventoryDetailsById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		InventoryDetails found = em.find(InventoryDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteInventory(InventoryDetails inventoryToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<InventoryDetails> typedQuery = em.createQuery("SELECT detail from InventoryDetails detail where detail.id= :selectedId", InventoryDetails.class);
		typedQuery.setParameter("selectedId", inventoryToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		InventoryDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateInventory(InventoryDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
