package com.coffee.assessment.infrastructure.customerRegistration;

import com.coffee.assessment.infrastructure.customerRegistration.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
