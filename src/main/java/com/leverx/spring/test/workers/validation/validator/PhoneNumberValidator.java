package com.leverx.spring.test.workers.validation.validator;

import com.leverx.spring.test.workers.validation.annotation.PhoneNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    @Override
    public void initialize(PhoneNumberConstraint phoneNumber) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext cxt) {
        return phoneNumber != null
                && phoneNumber.matches("[+]\\d{3}-\\d{2}-\\d{3}-\\d{2}-\\d{2}");
    }

}