package org.gabydev.app.util;

// Pattern para poder compilar un patrón de expresión regular
import java.util.regex.Pattern;
// interfaz utilizada para realizar coincidencias de patrones en una cadena específica utilizando un objeto Pattern
import java.util.regex.Matcher;

public class ValidateData {
    public static boolean validateStr(String str, int length) {
        if (str.trim().length() > length) {
            return true;
        } else {
            throw new Error("no se permite una longitud menor a 4 caracteres");
        }
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (validateStr(email, 8)) {
            // compilamos la expresión regular que deseamos utilizar
            Pattern pattern = Pattern.compile(emailRegex);
            // realizamos el mactch entre la regex y el email para validar que cumpla con los requisitos
            Matcher matcher = pattern.matcher(email);

            return matcher.matches();
        } else {
            return false;
        }
    }

    public static boolean validatePassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).+$";

        if (validateStr(password, 8)) {
            Pattern pattern = Pattern.compile(passwordRegex);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        } else {
            return false;
        }
    }
}
