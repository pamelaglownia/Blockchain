package pl.glownia.pamela.chatsimulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeysManager {

    static KeyPair generateKeys() throws NoSuchAlgorithmException {
        SecureRandom randomNumber = new SecureRandom();
        KeyPairGenerator keysGenerator = KeyPairGenerator.getInstance("RSA");
        keysGenerator.initialize(2048, randomNumber);
        return keysGenerator.genKeyPair();
    }

    static void writeToAFile() {
        final Logger LOG = Logger.getLogger(KeysManager.class.getName());
        try {
            KeyPair keyPair = generateKeys();
            Files.write(Paths.get("src/main/java/pl/glownia/pamela/chatsimulator/privateKey.txt"), keyPair.getPrivate().getEncoded());
            Files.write(Paths.get("src/main/java/pl/glownia/pamela/chatsimulator/publicKey.txt"), keyPair.getPublic().getEncoded());
        } catch (NoSuchAlgorithmException | IOException exception) {
            exception.printStackTrace();
            LOG.log(Level.SEVERE, "Error during the keys generating");
        }
    }

    static PublicKey getPublicKey(byte[] bytesKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec encoder = new X509EncodedKeySpec(bytesKey);
        return keyFactory.generatePublic(encoder);
    }

    static PrivateKey getPrivateKey(byte[] bytesKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec encoder = new PKCS8EncodedKeySpec(bytesKey);
        return keyFactory.generatePrivate(encoder);
    }
}