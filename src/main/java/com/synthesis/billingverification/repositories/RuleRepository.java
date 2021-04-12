package com.synthesis.billingverification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synthesis.billingverification.domain.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long>{

}
