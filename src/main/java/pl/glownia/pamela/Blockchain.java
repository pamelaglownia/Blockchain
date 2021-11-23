package pl.glownia.pamela;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    List<Block> blockchain;

    public Blockchain() {
        blockchain = new ArrayList<>();
    }

    private int getNewBlockId() {
        return blockchain.size();
    }

    private String getPreviousHash() {
        if (blockchain.isEmpty()) {
            return "0";
        }
        return blockchain.get(blockchain.size() - 1).getHashOfCurrentBlock();
    }

    private int calculateNumberOfZeros(int blockId) {
        if (blockId == 0) {
            return 0;
        }
        return blockchain.get(blockId - 1).getElapsedTimeToGenerateBlock() < 15 ?
                blockchain.get(blockId - 1).getNumberOfZeros() + 1 : blockchain.get(blockId - 1).getElapsedTimeToGenerateBlock() >= 60 ?
                blockchain.get(blockId - 1).getNumberOfZeros() - 1 : blockchain.get(blockId - 1).getNumberOfZeros();
    }

    public void addBlockToBlockchain() {
        Instant startTime = Instant.now();
        int blockId = getNewBlockId();
        blockchain.add(BlockFactory.createInstance(blockId, calculateNumberOfZeros(blockId), getPreviousHash()));
        BlockFactory.writeAMessage(blockchain.get(blockId));
        BlockFactory.calculateElapsedTime(blockchain.get(blockId), startTime);
        BlockFactory.writeFile(blockchain.get(blockId));
    }

    private boolean isValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            if (!(blockchain.get(i - 1).getHashOfCurrentBlock().equals(blockchain.get(i).getHashOfPreviousBlock()))) {
                System.out.println("Blockchain is invalid.");
                return false;
            }
        }
        return true;
    }

    public void printBlockchain() {
        if (isValid()) {
            Printer.printBlockchain(blockchain);
        }
    }
}