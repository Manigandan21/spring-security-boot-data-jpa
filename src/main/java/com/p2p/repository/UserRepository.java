package com.p2p.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.p2p.models.User;

@Transactional
@Repository
public class UserRepository{

	@PersistenceContext
	private EntityManager entityManager;
	  
	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public User saveUser(User user) {
		this.getEntityManager().persist(user);
		return user;
	}
	
	 @Transactional
	public User findByEmail(String email){
		 Query query1 = entityManager.createQuery("Select u from User u where u.email=:email");
		 query1.setParameter("email", email);
		 User user = (User) query1.getSingleResult();
		 return user;
	 }
	
}
