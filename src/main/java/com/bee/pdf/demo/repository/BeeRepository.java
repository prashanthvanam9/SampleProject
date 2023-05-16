package com.bee.pdf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bee.pdf.demo.entity.Bees;

@Repository
public interface BeeRepository extends JpaRepository<Bees, Long> {

	Bees findBeeById(Long id);
}
