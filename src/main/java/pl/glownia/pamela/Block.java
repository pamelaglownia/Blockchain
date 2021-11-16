package pl.glownia.pamela;

import java.util.Date;

class Block {
    private final int id;
    private final long timestamp;
    private final long magicNumber;
    private final String hashOfPreviousBlock;
    private final String hashOfCurrentBlock;
    private long elapsedTimeToGenerateBlock;

    Block(int id, int numberOfZeros, String hashOfPreviousBlock) {
        this.id = id;
        this.timestamp = new Date().getTime();
        this.magicNumber = HashGenerator.generateMagicNumber(numberOfZeros);
        this.hashOfPreviousBlock = hashOfPreviousBlock;
        this.hashOfCurrentBlock = HashGenerator.generateHashOfBlock(String.valueOf(magicNumber));
    }

    String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    String getHashOfCurrentBlock() {
        return hashOfCurrentBlock;
    }

    public void setElapsedTimeToGenerateBlock(long elapsedTimeToGenerateBlock) {
        this.elapsedTimeToGenerateBlock = elapsedTimeToGenerateBlock;
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + (id + 1) +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:\n" + hashOfPreviousBlock +
                "\nHash of the block:\n" + hashOfCurrentBlock +
                "\nBlock was generating for " + elapsedTimeToGenerateBlock + " seconds\n";
    }
}