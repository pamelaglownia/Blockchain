package pl.glownia.pamela;

import java.util.Date;

class Block {
    private final int id;
    private final long timestamp;
    private final String hashOfPreviousBlock;
    private final String hashOfCurrentBlock;

    Block(int id, String hashOfPreviousBlock) {
        this.id = id;
        this.timestamp = new Date().getTime();
        this.hashOfPreviousBlock = hashOfPreviousBlock;
        this.hashOfCurrentBlock = HashGenerator.generateHashOfBlock(HashGenerator.getTextToHash(id));
    }

    String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    String getHashOfCurrentBlock() {
        return hashOfCurrentBlock;
    }


    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + (id + 1) +
                "\nTimestamp: " + timestamp +
                "\nHash of the previous block:\n" + hashOfPreviousBlock +
                "\nHash of the block:\n" + hashOfCurrentBlock + "\n";
    }
}