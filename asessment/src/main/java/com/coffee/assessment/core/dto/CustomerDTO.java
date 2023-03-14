package com.coffee.assessment.core.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String address;
    private Integer mobileNumber;
}
