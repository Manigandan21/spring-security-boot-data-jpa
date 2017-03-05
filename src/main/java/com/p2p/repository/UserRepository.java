package com.p2p.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	
	
}
