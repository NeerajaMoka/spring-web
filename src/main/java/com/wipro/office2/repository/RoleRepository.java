package com.wipro.office2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.office2.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(String name);
}