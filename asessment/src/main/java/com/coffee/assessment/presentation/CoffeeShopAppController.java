package com.coffee.assessment.presentation;

import com.coffee.assessment.core.dto.CustomerRequestDTO;
import com.coffee.assessment.core.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@Slf4j
public class CoffeeShopAppController {
    CustomerService customerService;

    public CoffeeShopAppController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/customer")
    public ResponseEntity saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) throws RepositoryCreationException {
        customerService.saveCustomer(customerRequestDTO);
        return ResponseEntity.ok("Customer saved");
    }
}
