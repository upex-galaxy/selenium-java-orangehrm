package e2e.data;

import java.util.function.Supplier;

import com.github.javafaker.Faker;

public class GX3_3082_DataForTest {

    private String endpointAddUserCredential = "/admin/saveSystemUser";
    private static Faker faker = new Faker();
    private String userFiveChar = faker.lorem().characters(5);
    private String userFourthChar = faker.lorem().characters(4);
    private String usernameMaxLong = faker.lorem().characters(40);
    private String usernameMaxOverLong = faker.regexify("[a-zA-Z0-9]{41}");
    private String usernameExist = "Admin";
    private String passwdSevenChar = "Pas12#&";
    private String passwdSixChar = "Pas12#";
    private String passwdNoUppercase = "pass12&";
    private String passwdNoLowercase = "PASS12#";
    private String passwdNoLetter = "12345#&&=";
    private String passwdNoSpecialChar = "Pass123";
    private String passwdNoNumbers = "Pass???";
    private String passwordMaxLong = faker.regexify("[a-zA-Z0-9!@#$]{64}");
    private String passwordOverMaxLong = faker.regexify("[a-zA-Z0-9!@#$]{65}");

    public Supplier<String> getUsernameFiveChar = () -> userFiveChar;
    public Supplier<String> getUsernameFourthChar = () -> userFourthChar;
    public Supplier<String> getUsernameMaxLong = () -> usernameMaxLong;
    public Supplier<String> getUsernameMaxOverLong = () -> usernameMaxOverLong;
    public Supplier<String> getUsernameExist = () -> usernameExist;
    public Supplier<String> getPasswordSevenChar = () -> passwdSevenChar;
    public Supplier<String> getPasswordSixChar = () -> passwdSixChar;
    public Supplier<String> getPasswordNoUpper = () -> passwdNoUppercase;
    public Supplier<String> getPasswordNoLower = () -> passwdNoLowercase;
    public Supplier<String> getPasswordNoSpecialChar = () -> passwdNoSpecialChar;
    public Supplier<String> getPasswordNoNumbers = () -> passwdNoNumbers;
    public Supplier<String> getPasswordMaxLong = () -> passwordMaxLong;
    public Supplier<String> getPasswordOverMaxLong = () -> passwordOverMaxLong;
    public Supplier<String> getPasswordNoLetter = () -> passwdNoLetter;
    public Supplier<String> getEndpointUserCredential = () -> endpointAddUserCredential;

}
