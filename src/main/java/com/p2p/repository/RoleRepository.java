package com.p2p.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleRepository{

	@PersistenceContext
	private EntityManager entityManager;
	  
	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public List<String> getUserByRole(Integer role_type) {
		 javax.persistence.Query query1 = entityManager.createQuery("Select u.name from Role u where u.id=:id");
		 query1.setParameter("id", role_type);
		 List<String> roles = (List<String>) query1.getResultList();
		 return roles;
	}
	
}
