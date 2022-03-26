package pl.edu.zse.projectTemplate.validators;

public interface ILoginValidator {
    boolean validateMatchingPassword(String password, String repeatpass);
    boolean validatePasswordStrength(String password);
    boolean validateUsernameLength(String username);
    boolean validateEmailAdress(String email);
}
