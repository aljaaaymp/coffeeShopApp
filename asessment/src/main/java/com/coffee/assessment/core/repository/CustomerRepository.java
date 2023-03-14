package com.coffee.assessment.core.repository;

import com.coffee.assessment.core.dto.CustomerRequestDTO;
import org.springframework.data.repository.core.RepositoryCreationException;

public interface CustomerRepository {
    void saveCustomer(CustomerRequestDTO customerRequestDTO) throws RepositoryCreationException;

}
