package pl.glownia.pamela.chatsimulator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Encryptor {

    static byte[] encryptRsa(byte[] bytesKey, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-512AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(bytesKey);
    }

    static void encrypt(String text) {
        try {
            byte[] bytesKey = Files.readAllBytes(Paths.get("src/main/java/pl/glownia/pamela/chatsimulator/publicKey.txt"));
            PublicKey publicKey = KeysManager.getPublicKey(bytesKey);
            byte[] dataToEncrypt = text.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedData = encryptRsa(dataToEncrypt, publicKey);
            Files.write(Paths.get("src/main/java/pl/glownia/pamela/chatsimulator/encryptedData.txt"), encryptedData);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}