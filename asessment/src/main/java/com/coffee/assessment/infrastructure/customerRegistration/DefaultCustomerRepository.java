package com.coffee.assessment.infrastructure.customerRegistration;

import com.coffee.assessment.core.dto.CustomerRequestDTO;
import com.coffee.assessment.core.exception.GeneralRepositoryException;
import com.coffee.assessment.core.repository.CustomerRepository;
import com.coffee.assessment.infrastructure.customerRegistration.entity.CustomerEntity;

public class DefaultCustomerRepository implements CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;

    public DefaultCustomerRepository(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public void saveCustomer(CustomerRequestDTO customerRequestDTO) {
        try {
            CustomerEntity customerEntity = buildCustomerEntity(customerRequestDTO);
            customerJpaRepository.save(customerEntity);
        } catch (Exception ex){
            throw new GeneralRepositoryException("Encountered error saving Customer caused by " + ex.getMessage());
        }

    }

    private CustomerEntity buildCustomerEntity(CustomerRequestDTO customerRequestDTO) {
        return CustomerEntity.builder()
                .firstName(customerRequestDTO.getValues().getFirstName())
                .lastName(customerRequestDTO.getValues().getLastName())
                .address(customerRequestDTO.getValues().getAddress())
                .mobileNumber(customerRequestDTO.getValues().getMobileNumber())
                .build();
    }
}
