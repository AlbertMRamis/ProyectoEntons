package registro;

import java.util.Random;
import java.util.Scanner;

/**
 * La clase ValidarCampos permet crear un objecte
 * ValidarCampos y validar que els atributs rebuts siguin correctes.
 * 
 * @author albert
 *
 */

public class ValidarCampos implements nombre, ValidarCampos {
    public ValidarCampos() {
        super();
        // TODO Apéndice de constructor generado automáticamente
    }

    public static boolean validarCampos(String nombre, String email, String password) {
        validarNombre(nombre, null);
        validarEmail(email);
        compruebaPassword(password);

        return compruebaCodigo();

    }

    /**
     * Metode que comproba el codig que s'escrio
     * 
     * @param codig String que pasam al mètode per que el validi
     * @return boolean que es true si el valor introduit es correcte
     * @author pau
     */
    public static boolean compruebaCodigo() {
        StringBuilder codigo = new StringBuilder();
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#@-_";
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }

        // Mostrar código de seguridad por pantalla
        System.out.println("El código de seguridad es: " + codigo);

        // Pedir al usuario que escriba el código de seguridad
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el código de seguridad: ");
        String codigoUsuario = scanner.nextLine();

        // Comprobar si el código de seguridad introducido es correcto
        if (codigo.toString().equals(codigoUsuario)) {
            return true;
        } else {
            System.out.println("error");
            return false;

        }
    }

    /**
     * Mètode que comprova si la contraseña es valida
     * 
     * @param contraseña String que pasam al mètode per que el validi
     * @return boolean que es true si el valor introduit es correcte
     * @author pau
     */
    public static boolean compruebaPassword(String password) {
        if (password.length() != 8) {
            System.out.println("introduce password de 8 caracteres"); // ok
            return false;
        }
        if (!Character.isUpperCase(password.charAt(0))) {
            System.out.println("el password debe empezar con mayúsculas");
            return false; // OK
        }
        if (!(password.contains("@") || password.contains("-") ||
                password.contains("#") || password.contains("_"))) {
            System.out.println("introduce uno de los siguientes símbolos @,#,-, _");
            return false; // ok
        }
        if (!Character.isDigit(password.charAt(password.length() - 1))
                || !Character.isDigit(password.charAt(password.length() - 2))) {
            System.out.println("el password debe terminar en dos dígitos");
            return false; // ok
        }
        return true;
    }

    /**
     * Mètode que mira si el email introduit compleix el format correcte
     * 
     * @param email String que pasam al mètode per que el validi
     * @return boolean que es true si el valor introduit es correcte
     * @author albert
     */
    public static boolean validarEmail(String email) {
        String[] dominiosPermitidos = { "paucasesnovescifp", "yahoo", "gmail",
                "hotmail" };
        boolean dominioValido = false;
        if (!email.contains("@")) {
            System.out.println("falta @"); // ok
            return false;
        }

        for (String dominio : dominiosPermitidos) {
            if (email.contains("@" + dominio)) {

                dominioValido = true; // ok
                break;
            }
        }
        if (!dominioValido) {
            System.out.println("error dominio");
            return false; // ok
        }

        if (!(email.endsWith(".com") || email.endsWith(".es") ||
                email.endsWith(".cat"))) {
            System.out.println("error de extensión"); // ok
            return false;
        }
        return dominioValido;
    }

    /**
     * Metode que que mira si el nom introduit compleix el format correcte
     * 
     * @param nombre   String que pasam al mètode per que validi que es un nom
     *                 correcte
     * @param usuarios array de noms que hem afegit per probar la refactoritzacio de
     *                 cambi de signatura del mètode.
     * @return
     */

    public static boolean validarNombre(String nombre, String[] usuarios) {
        if (nombre.length() > 16) {
            System.out.println("el nombre no puede tener mas de 16 carácteres"); // ok
            return false;
        }
        if (!Character.isUpperCase(nombre.charAt(0))) { // ok
            System.out.println("el nombre tiene que empezar por mayúsculas");
            return false;
        }
        for (int i = 1; i < nombre.length() - 4; i++) {
            if (Character.isUpperCase(nombre.charAt(i))) {
                System.out.println("solo la primera letra del nombre en mayúsculas"); // ok
                return false;
            }
        }
        if (nombre.charAt(nombre.length() - 4) != '_' && // ok
                nombre.charAt(nombre.length() - 4) != '-') {
            System.out.println("Falta el guión o no esta en la cuarta posicion contando desde el final");
            return false;
        }
        for (int i = nombre.length() - 3; i < nombre.length(); i++) { // ok
            if (!Character.isDigit(nombre.charAt(i))) {
                System.out.println("El nombre tiene que terminar con tres dígitos");
                return false;
            }
        }
        return true;
    }
}