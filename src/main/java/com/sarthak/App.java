package com.sarthak;

import java.io.File;

public class App {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java -jar file-encryptor.jar <encrypt|decrypt> <key> <inputFile> <outputFile>");
            System.out.println("The key must be exactly 16 characters long for AES-128.");
            return;
        }

        String mode = args[0];
        String key = args[1];
        File inputFile = new File(args[2]);
        File outputFile = new File(args[3]);

        if (key.length() != 16) {
            System.err.println("Error: The encryption key must be exactly 16 characters long.");
            return;
        }

        try {
            if (mode.equalsIgnoreCase("encrypt")) {
                CryptoUtils.encrypt(key, inputFile, outputFile);
                System.out.println("Encryption successful. Output file: " + outputFile.getAbsolutePath());
            } else if (mode.equalsIgnoreCase("decrypt")) {
                CryptoUtils.decrypt(key, inputFile, outputFile);
                System.out.println("Decryption successful. Output file: " + outputFile.getAbsolutePath());
            } else {
                System.err.println("Error: Invalid mode. Use 'encrypt' or 'decrypt'.");
            }
        } catch (CryptoException ex) {
            System.err.println("Error performing crypto operation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}