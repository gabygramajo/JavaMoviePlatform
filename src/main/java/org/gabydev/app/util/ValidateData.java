package org.gabydev.app.util;

// Pattern para poder compilar un patrón de expresión regular
import java.util.regex.Pattern;
// interfaz utilizada para realizar coincidencias de patrones en una cadena específica utilizando un objeto Pattern
import java.util.regex.Matcher;

/**
 * Clase con métodos estáticos para validar inputs
 * @author Gabriel Gramajo
 * @version 1.0.0
 * @see <a href="https://github.com/gabygramajo">mi github</a>
 */
public class ValidateData {

    /**
     * Método para validar que una cadena de texto cumpla con una determinada longitud.
     * @param str Cadena a validar.
     * @param length Cantidad de caracteres que deberá de tener la cadena para ser válida.
     * @return Devuelve true si la cadena es válida o false si no cumple con la validación.
     */
    public static boolean validateStr(String str, int length) {
        return str.trim().length() >= length;
    }

    /**
     * Método para validar que un email.
     * @param email email a validar.
     * @return Devuelve true si es válida o false si no cumple con la validación.
     */
    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // compila la expresión regular que deseamos utilizar
        Pattern pattern = Pattern.compile(emailRegex);
        // realiza el match entre la regex y el email para validar que cumpla con los requisitos
        Matcher matcher = pattern.matcher(email);

        return matcher.matches() && validateStr(email, 8);
    }

    /**
     * Método para validar que una contraseña tenga una longitud de 8 y al menos contenga una minúscula, mayúscula, carácter especial y un número.
     * @param password contraseña a validar.
     * @return Devuelve true si es válida o false si no cumple con la validación.
     */
    public static boolean validatePassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).+$";

        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches() && validateStr(password, 8);
    }
}
