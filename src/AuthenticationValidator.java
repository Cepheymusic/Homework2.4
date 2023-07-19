public class AuthenticationValidator {

    private static final String ALLOWED_CHARS = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
    public static void testAuthentication(String login, String password, String confirmPassword) {
        testLogin(login);
        testPassword(password);
        testConfirmPassword(password, confirmPassword);
    }

    private static void testLogin(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("В логине больше 20 знаков");
        }

        for (char symbols : login.toCharArray()) {
            if (!ALLOWED_CHARS.contains(String.valueOf(symbols))) {
                throw new WrongLoginException("Login содержать в себе только латинские буквы, цифры и знак подчеркивания");
            }
        }
    }
    private static void testPassword(String password) {
        if (password.length() > 20) {
            throw new WrongPasswordException("В пароле больше 20 знаков");
        }

        for (char symbols : password.toCharArray()) {
            if (!ALLOWED_CHARS.contains(String.valueOf(symbols))) {
                throw new WrongPasswordException("Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания");
            }
        }

    }
    private static void testConfirmPassword(String confirmPassword, String password) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

}
