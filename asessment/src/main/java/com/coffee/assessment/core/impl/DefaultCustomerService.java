package com.coffee.assessment.core.impl;

import com.coffee.assessment.core.dto.CustomerRequestDTO;
import com.coffee.assessment.core.repository.CustomerRepository;
import com.coffee.assessment.core.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.core.RepositoryCreationException;
@Slf4j
public class DefaultCustomerService implements CustomerService {
    private final CustomerRepository customerRepository;

    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(CustomerRequestDTO customerRequestDTO) {
        try {
            log.info("Saving Customer");
            customerRepository.saveCustomer(customerRequestDTO);
        }catch (Exception ex){
            throw new RepositoryCreationException("Failed to save customer caused by " , ex.getMessage().getClass());

        }
    }
}
