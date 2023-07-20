public class Main {
    public static void main(String[] args) {
        try {
            AuthenticationValidator.testAuthentication("ldappp", "gdsgg", "sdfsdf");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}