package pl.glownia.pamela;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

class HashGenerator {
    static String getTextToHash(int id) {
        return String.valueOf(id);
    }

    /* Method from Jetbrains Academy to generate hash*/
    static String generateHashOfBlock(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte element : hash) {
                String hex = Integer.toHexString(0xff & element);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}