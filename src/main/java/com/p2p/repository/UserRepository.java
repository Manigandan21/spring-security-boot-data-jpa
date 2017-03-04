package com.p2p.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.p2p.models.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	  public User findByEmail(String email);
}
