package com.coffee.assessment.core.service;

import com.coffee.assessment.core.dto.CustomerRequestDTO;
import org.springframework.data.repository.core.RepositoryCreationException;

public interface CustomerService {
    void saveCustomer(CustomerRequestDTO customerRequestDTO) throws RepositoryCreationException;
}
