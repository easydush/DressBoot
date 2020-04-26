package com.dressup.demo.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validation annotation to validate that 2 fields have the same value. An array
 * of fields and their matching confirmation fields can be supplied.
 * <p>
 * Example, compare 1 pair of fields:
 *
 * @FieldMatch(first = "password", second = "confirmPassword", message = "The
 * password fields must match")
 * <p>
 * Example, compare more than 1 pair of fields:
 * @FieldMatch.List({
 * @FieldMatch(first = "password", second = "confirmPassword", message = "The
 * password fields must match"),
 * @FieldMatch(first = "email", second = "confirmEmail", message = "The email
 * fields must match")})
 * <p>
 * Source
 * http://stackoverflow.com/questions/1972933/cross-field-validation-with-hibernate-validator-jsr-303
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {

    /**
     * Defines several <code>@FieldMatch</code> annotations on the same element
     *
     * @see FieldMatch
     */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface List {
        FieldMatch[] value();
    }

    public String message() default "{constraints.fieldmatch}";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

    /**
     * @return The first field
     */
    public String first();

    /**
     * @return The second field
     */
    public String second();
}
