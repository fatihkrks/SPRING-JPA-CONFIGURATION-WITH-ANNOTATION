package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Soldier;

@Repository
public class SoldierRepositoryImpl implements SoldierRepository {

	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}




	@Override
	public void insert(Soldier soldier) {
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(soldier);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
