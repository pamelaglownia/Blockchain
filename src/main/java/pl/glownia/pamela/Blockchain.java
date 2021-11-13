package pl.glownia.pamela;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Blockchain {
    List<Block> blockchain;

    Blockchain() {
        blockchain = new ArrayList<>();
    }

    private long getTimeStamp() {
        return new Date().getTime();
    }

    private String getTextToHash(int id) {
        return String.valueOf(id);
    }

    /* Method from Jetbrains Academy to generate hash*/
    private String generateHashOfBlock(String text) {
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

    private List<Block> createBlockchain() {
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                blockchain.add(new Block(i, getTimeStamp(), "0", generateHashOfBlock(getTextToHash(i))));

            } else {
                blockchain.add(new Block(i, getTimeStamp(), blockchain.get(i - 1).getHashOfCurrentBlock(), generateHashOfBlock(getTextToHash(i))));
            }
        }
        return blockchain;
    }

    void printBlockchain() {
        blockchain = createBlockchain();
        if (isValid()) {
            blockchain.forEach(System.out::println);
        } else {
            System.out.println("Blockchain is invalid.");
        }
    }

    private boolean isValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            if (!(blockchain.get(i - 1).getHashOfCurrentBlock().equals(blockchain.get(i).getHashOfPreviousBlock()))) {
                return false;
            }
        }
        return true;
    }
}