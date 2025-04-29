package com.scrumapp.utils;

/* Libreria de encriptamiento */
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 

public class EncryptUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /* Clase que encripta la contraseña */
    public static String hashPassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /* Clase que verifica una contraseña */
    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}
