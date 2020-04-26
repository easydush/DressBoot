package com.dressup.demo.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

/**
 *
 * Source
 * http://stackoverflow.com/questions/1972933/cross-field-validation-with-hibernate-validator-jsr-303
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String errorMessage;

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        errorMessage = constraintAnnotation.message();
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            final BeanWrapperImpl bean = new BeanWrapperImpl(value);
            final Object firstObj = bean.getPropertyValue(firstFieldName);
            final Object secondObj = bean.getPropertyValue(secondFieldName);
            boolean returnValue = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
            //If the validation failed
            if (!returnValue) {
                context.disableDefaultConstraintViolation();
                //In the initialiaze method you get the errorMessage: constraintAnnotation.message();
                context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(secondFieldName).addConstraintViolation();
            }
            return returnValue;
        } catch (final Exception ignore) {
            // ignore
        }
        return true;
    }
}