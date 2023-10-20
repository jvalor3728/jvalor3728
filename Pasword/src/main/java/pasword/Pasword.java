package pasword;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

 

public class Pasword{

 

    public static void main(String[] args) {
        try {
            String password = Password();
            String confirmPassword = ConfirmPassword();

 

            validatePassword(password, confirmPassword);

 

            System.out.println("Contraseña válida y confirmada con éxito.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

 

    public static String Password() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la contraseña: ");
        return scanner.nextLine();
    }

 

    public static String ConfirmPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirma la contraseña: ");
        return scanner.nextLine();
    }

 

    public static void validatePassword(String password, String confirmPassword) throws Exception {
        int minLength = 8;
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$/%^&+=!]).*$";

 

        if (password.length() < minLength) {
            throw new Exception("La contraseña debe tener al menos " + minLength + " caracteres.");
        }

 

        if (password.contains(" ")) {
            throw new Exception("La contraseña no debe contener espacios en blanco.");
        }

 

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new Exception("La contraseña debe contener al menos un carácter en minúscula, un carácter en mayúscula, un número y un carácter especial.");
        }

 

        if (!password.equals(confirmPassword)) {
            throw new Exception("Las contraseñas no coinciden.");
        }
    }
}
