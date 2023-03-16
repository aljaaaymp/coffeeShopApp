package com.coffee.assessment.infrastructure.customerRegistration;

import com.coffee.assessment.core.dto.CustomerRequestDTO;
import com.coffee.assessment.core.exception.GeneralCustomerException;
import com.coffee.assessment.core.repository.CustomerRepository;
import com.coffee.assessment.infrastructure.customerRegistration.entity.CustomerEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultCustomerRepository implements CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;

    public DefaultCustomerRepository(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    // This method is to save details of the customer, building DTO to Entity
    @Override
    public void saveCustomer(CustomerRequestDTO customerRequestDTO) {
        try {
            log.info("Saving Customer Info");
            CustomerEntity customerEntity = buildCustomerEntity(customerRequestDTO);
            log.info("Customer Info Saved");
            customerJpaRepository.save(customerEntity);
        } catch (Exception ex){
            log.error("Error encountered during saving Customer " , ex);
            throw new GeneralCustomerException("Encountered error saving Customer caused by " + ex.getMessage());
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
