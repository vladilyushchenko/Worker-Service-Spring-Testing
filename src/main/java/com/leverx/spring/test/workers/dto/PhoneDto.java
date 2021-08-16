package com.leverx.spring.test.workers.dto;

import com.leverx.spring.test.workers.validation.annotation.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto {

    private String operator;

    @PhoneNumberConstraint
    private String number;

    private String ownerCountry;
}
