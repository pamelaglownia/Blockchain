package pl.glownia.pamela.blockmanager;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;

class HashGenerator {

    private static int generateRandomNumber() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }

    private static String generateHashPrefix(int numbersOfZeros) {
        return "0".repeat(numbersOfZeros);
    }

    static long generateMagicNumber(int numbersOfZeros) {
        int magicNumber;
        String hash;
        String prefix = generateHashPrefix(numbersOfZeros);
        if (prefix.length() == 0) {
            return generateRandomNumber();
        }
        do {
            magicNumber = generateRandomNumber();
            hash = generateHashOfBlock(String.valueOf(magicNumber));
        } while (!hash.startsWith(prefix));
        return magicNumber;
    }

    /* Method from Jetbrains Academy to generate hash*/
    static String generateHashOfBlock(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte element : hash) {
                String hex = Integer.toHexString(0xff & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}