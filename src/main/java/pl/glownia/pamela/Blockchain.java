package pl.glownia.pamela;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Blockchain {
    List<Block> blockchain;

    Blockchain() {
        blockchain = new ArrayList<>();
    }

    int getNewBlockId() {
        return blockchain.size();
    }

    String getPreviousHash() {
        if (blockchain.isEmpty()) {
            return "0";
        }
        return blockchain.get(blockchain.size() - 1).getHashOfCurrentBlock();
    }

    void calculateElapsedTime(int blockId, Instant startTime) {
        Instant finishTime = Instant.now();
        blockchain.get(blockId).setElapsedTimeToGenerateBlock(Duration.between(startTime, finishTime).toSeconds());
    }

    void addBlockToBlockChain() {
        Instant startTime = Instant.now();
        int blockId = getNewBlockId();
        blockchain.add(BlockFactory.createInstance(blockId, getPreviousHash()));
        calculateElapsedTime(blockId, startTime);
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

    void printBlockchain() {
        if (isValid()) {
            Printer.printBlockchain(blockchain);
        }
    }
}