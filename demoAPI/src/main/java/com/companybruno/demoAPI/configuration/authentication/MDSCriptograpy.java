package com.companybruno.demoAPI.configuration.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDSCriptograpy {

    private static MessageDigest messageDigest = null;

    static {
        try {
            // Corrigido: SHA-256 é um algoritmo válido
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao inicializar MessageDigest", e);
        }
    }

    // método para converter um valor criptografado byte[] para string hexadecimal
    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexStr;

        for (int i = 0; i < text.length; i++) {
            hexStr = "00" + Integer.toHexString(text[i] & 0xff); // corrigido para evitar negativo
            hexStr.toUpperCase().getChars(hexStr.length() - 2, hexStr.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }

    // método para realizar a criptografia
    public static String encrypt(String value) {
        if (value != null) {
            return new String(hexCodes(messageDigest.digest(value.getBytes()))).toLowerCase();
        }
        return null;
    }
}