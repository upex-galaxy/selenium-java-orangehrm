package e2e.data;

import java.util.function.Supplier;

import com.github.javafaker.Faker;

public class GX3_3082_DataForTest {

    private String endpointAddUserCredential = "/admin/saveSystemUser";
    private String endpointViewSystemUsers = "/admin/viewSystemUsers";
    private static Faker faker = new Faker();
    private String userFiveChar = "chars";
    private String userFourthChar = "char";
    private String usernameMaxLong = "a".repeat(64);
    private String usernameMaxOverLong = "a".repeat(64).concat("g");
    private String usernameExist = "CrossFire";
    private String passwdSevenChar = "Pas12#&";
    private String passwdSixChar = "Pas12#";
    private String passwdNoUppercase = "pass12&";
    private String passwdNoLowercase = "PASS12#";
    private String passwdNoLetter = "12345#&&=";
    private String passwdNoSpecialChar = "Pass123";
    private String passwdNoNumbers = "Pass???";
    private String passwordMaxLong = generatePassword(64);
    private String passwordOverMaxLong = generatePassword(64).concat("s");

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
    public Supplier<String> getEndpointViewUsers = () -> endpointViewSystemUsers;

    public static String generatePassword(int desiredLength) {
        StringBuilder password = new StringBuilder();

        while (password.length() < desiredLength) {
            char c = (char) faker.number().numberBetween(33, 126);
            password.append(c);

            if (password.length() == desiredLength) {
                break;
            }
        }

        return password.toString();
    }
}
