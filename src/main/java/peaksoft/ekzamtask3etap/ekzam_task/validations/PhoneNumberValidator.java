package peaksoft.ekzamtask3etap.ekzam_task.validations;

import jakarta.validation.ConstraintValidator;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber,String> {
    @Override
    public boolean isValid(String phoneNumber, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber.startsWith("+996") && phoneNumber.length()==13;
    }
}