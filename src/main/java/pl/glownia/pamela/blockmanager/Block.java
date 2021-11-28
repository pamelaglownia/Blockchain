package pl.glownia.pamela.blockmanager;

import java.util.Date;

class Block {
    private final long miner;
    private final int id;
    private final long timestamp;
    private final long magicNumber;
    private final int numberOfZeros;
    private final String hashOfPreviousBlock;
    private final String hashOfCurrentBlock;
    private String chatMessage;
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


    int getId() {
        return id;
    }

    int getNumberOfZeros() {
        return numberOfZeros;
    }

    String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    String getHashOfCurrentBlock() {
        return hashOfCurrentBlock;
    }

    void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    long getElapsedTimeToGenerateBlock() {
        return elapsedTimeToGenerateBlock;
    }

    void setElapsedTimeToGenerateBlock(long elapsedTimeToGenerateBlock) {
        this.elapsedTimeToGenerateBlock = elapsedTimeToGenerateBlock;
    }

    private String setMessage() {
        return elapsedTimeToGenerateBlock < 15 ? "Number of zeros was increased to " + (numberOfZeros + 1)
                : elapsedTimeToGenerateBlock <= 60 ? "Number of zeros stays the same" : "Number of zeros was decreased by 1";
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nCreated by miner #" + miner +
                "\nMiner #" + miner + " gets 100 Virtual Coins" +
                "\nId: " + (id + 1) +
                "\nTimestamp: " + timestamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:\n" + hashOfPreviousBlock +
                "\nHash of the block:\n" + hashOfCurrentBlock +
                "\nBlock data:\n" + chatMessage +
                "\nBlock was generating for " + elapsedTimeToGenerateBlock + " miliseconds" +
                "\n" + setMessage() + "\n";
    }
}