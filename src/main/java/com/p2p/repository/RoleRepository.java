package com.p2p.repository;

import org.springframework.data.repository.CrudRepository;

import com.p2p.models.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{
		Role getById(Integer id);
}
