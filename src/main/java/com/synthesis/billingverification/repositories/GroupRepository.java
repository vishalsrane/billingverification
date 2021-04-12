package com.synthesis.billingverification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synthesis.billingverification.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{

}
