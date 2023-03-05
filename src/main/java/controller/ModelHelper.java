/**
 * @author Isaac Roetman - ijroetman
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Models;
public class ModelHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DealerInventory");
	
	public void insertTeam(Models m) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Models> showAllModels(){
		EntityManager em = emfactory.createEntityManager();
		List<Models> allModels = em.createQuery("SELECT m FROM Models m").getResultList();
		return allModels;
	}
	
	public Models findModel(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Models> typedQuery = em.createQuery("select mh from Models mh where mh.modelName = :selectedName", Models.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Models foundModel;
		
		try {
			foundModel = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundModel = new Models(nameToLookUp);
		}
		em.close();
		
		return foundModel;
	}
	
	public Models searchForModelById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Models found = em.find(Models.class, idToEdit);
		em.close();

		return found;
	}
	
	public void updateModel(Models toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void deleteModel (Models toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Models> typedQuery = em.createQuery("select m from Models m where m.modelName = :selectedName", Models.class);
		typedQuery.setParameter("selectedName", toDelete.getModelName());
		typedQuery.setMaxResults(1);
		Models result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
