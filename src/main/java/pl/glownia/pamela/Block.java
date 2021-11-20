package pl.glownia.pamela;

import java.util.Date;

class Block {
    private final long miner;
    private final int id;
    private final long timestamp;
    private final long magicNumber;
    private final int numberOfZeros;
    private final String hashOfPreviousBlock;
    private final String hashOfCurrentBlock;
    private long elapsedTimeToGenerateBlock;

    Block(int id, int numberOfZeros, String hashOfPreviousBlock) {
        this.miner = Thread.currentThread().getId();
        this.id = id;
        this.timestamp = new Date().getTime();
        this.numberOfZeros = numberOfZeros;
        this.magicNumber = HashGenerator.generateMagicNumber(numberOfZeros);
        this.hashOfPreviousBlock = hashOfPreviousBlock;
        this.hashOfCurrentBlock = HashGenerator.generateHashOfBlock(String.valueOf(magicNumber));
    }

    public int getNumberOfZeros() {
        return numberOfZeros;
    }

    String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    String getHashOfCurrentBlock() {
        return hashOfCurrentBlock;
    }

    long getElapsedTimeToGenerateBlock() {
        return elapsedTimeToGenerateBlock;
    }

    void setElapsedTimeToGenerateBlock(long elapsedTimeToGenerateBlock) {
        this.elapsedTimeToGenerateBlock = elapsedTimeToGenerateBlock;
    }

    private String setMessage() {
        if (elapsedTimeToGenerateBlock < 15) {
            return "N was increased to " + (numberOfZeros + 1);
        } else if (elapsedTimeToGenerateBlock <= 60) {
            return "N stays the same";
        } else {
            return "N was decreased by 1";
        }
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nCreated by miner # " + miner +
                "\nId: " + (id + 1) +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:\n" + hashOfPreviousBlock +
                "\nHash of the block:\n" + hashOfCurrentBlock +
                "\nBlock was generating for " + elapsedTimeToGenerateBlock + " seconds" +
                "\n" + setMessage() + "\n";
    }
}