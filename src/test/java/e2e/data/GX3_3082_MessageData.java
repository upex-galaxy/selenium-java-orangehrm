package e2e.data;

import com.google.common.base.Supplier;

public class GX3_3082_MessageData {
    private String usernameMinCharacter = "Should be at least 5 characters";
    private String usernameReadyExist = "Already exist";
    private String usernameMaxOverCharacter = "Should not exceed 40 characters";
    private String passwdMinCharacter = "Should have at least 7 characters";
    private String passwdMaxOverCharacter = "Should not exceed 64 characters";
    private String passwdNoLowerCase = "Your password must contain minimum 1 lower-case letter";
    private String passwdNoUpperCase = "Your password must contain minimum 1 uppercase letter";
    private String passwdNoNumber = "Your password must contain minimum 1 number";
    private String passwdNoSpecialChar = "Your password must contain minimum 1 special character";
    private String passwdNoMatch = "Passwords do not match";
    private String fieldsEmpty = "Required";

    public Supplier<String> getUsernameErrorMinCharacter = () -> usernameMinCharacter;
    public Supplier<String> getUsernameErrorReadyExist = () -> usernameReadyExist;
    public Supplier<String> getUsernameErrorMaxOverCharacter = () -> usernameMaxOverCharacter;
    public Supplier<String> getPasswdErrorMinCharacter = () -> passwdMinCharacter;
    public Supplier<String> getPasswdErrorMaxOverCharacter = () -> passwdMaxOverCharacter;
    public Supplier<String> getPasswdErrorNoLowerCase = () -> passwdNoLowerCase;
    public Supplier<String> getPasswdErrorNoUpperCase = () -> passwdNoUpperCase;
    public Supplier<String> getPasswdErrorNoNumber = () -> passwdNoNumber;
    public Supplier<String> getPasswdErrorNoSpecialChar = () -> passwdNoSpecialChar;
    public Supplier<String> getPasswdErrorNoMatch = () -> passwdNoMatch;
    public Supplier<String> getFieldsErrorEmpty = () -> fieldsEmpty;
}
