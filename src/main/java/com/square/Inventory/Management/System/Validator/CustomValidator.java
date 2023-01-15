package com.square.Inventory.Management.System.Validator;

import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class CustomValidator<T>{

    private final ValidatorFactory factory= Validation.buildDefaultValidatorFactory();

    private final Validator validator= factory.getValidator();

    public Set<String> setValidator(T objectValidator) {
        Set<ConstraintViolation<T>> validators=validator.validate(objectValidator);
        if(!validators.isEmpty()) {
            validators.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining());
        }
        return Collections.emptySet();
    }
}
