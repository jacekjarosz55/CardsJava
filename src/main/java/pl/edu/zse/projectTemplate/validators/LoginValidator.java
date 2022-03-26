package pl.edu.zse.projectTemplate.validators;

import org.apache.commons.validator.routines.EmailValidator;

public class LoginValidator implements ILoginValidator {
    @Override
    public boolean validateMatchingPassword(String password, String repeatpass) {
        return password == repeatpass;
    }

    @Override
    public boolean validatePasswordStrength(String password) {
        return
        password.length() >= 8
        && password.matches("^.*[a-z].*$")
        && password.matches("^.*[A-Z].*$")
        && password.matches("^.*[0-9].*$");
    }

    @Override
    public boolean validateUsernameLength(String username) {
        return username.length() > 0 && username.length() <= 30;
    }

    @Override
    public boolean validateEmailAdress(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
