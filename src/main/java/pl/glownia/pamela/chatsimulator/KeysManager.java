package pl.glownia.pamela.chatsimulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeysManager {

    private static KeyPair generateKeys() throws NoSuchAlgorithmException {
        SecureRandom randomNumber = new SecureRandom();
        KeyPairGenerator keysGenerator = KeyPairGenerator.getInstance("RSA");
        keysGenerator.initialize(2048, randomNumber);
        return keysGenerator.genKeyPair();
    }

    void writeToAFile(String privateKeyPath, String publicKeyPath) {
        try {
            KeyPair keyPair = generateKeys();
            Files.write(Paths.get(privateKeyPath), keyPair.getPrivate().getEncoded());
            Files.write(Paths.get(publicKeyPath), keyPair.getPublic().getEncoded());
        } catch (NoSuchAlgorithmException | IOException exception) {
            exception.printStackTrace();
        }
    }

    static PublicKey getPublicKey(byte[] bytesKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec encoder = new X509EncodedKeySpec(bytesKey);
        return keyFactory.generatePublic(encoder);
    }

   private PrivateKey getPrivateKey(byte[] bytesKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec encoder = new PKCS8EncodedKeySpec(bytesKey);
        return keyFactory.generatePrivate(encoder);
    }

    byte[] signTheMessage(String text, String privateKeyPath, String signedDataPath) throws Exception {
        byte[] privateKeyData = Files.readAllBytes(Paths.get(privateKeyPath));
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(getPrivateKey(privateKeyData));
        signature.update(text.getBytes());
        byte[] signatureBytes = signature.sign();
        Files.write(Paths.get(signedDataPath), signatureBytes);
        return signatureBytes;
    }
}