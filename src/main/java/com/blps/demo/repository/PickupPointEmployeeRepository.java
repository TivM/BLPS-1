package com.blps.demo.repository;

import com.blps.demo.entity.PickupPointEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupPointEmployeeRepository extends JpaRepository<PickupPointEmployee, Integer> {
}
