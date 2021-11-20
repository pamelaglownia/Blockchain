package pl.glownia.pamela;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Blockchain {
    List<Block> blockchain;

    Blockchain() {
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
        } else if (blockchain.get(blockId - 1).getElapsedTimeToGenerateBlock() < 15) {
            return blockchain.get(blockId - 1).getNumberOfZeros() + 1;
        } else if (blockchain.get(blockId - 1).getElapsedTimeToGenerateBlock() <= 60) {
            return blockchain.get(blockId - 1).getNumberOfZeros();
        } else {
            return blockchain.get(blockId - 1).getNumberOfZeros() - 1;
        }
    }

    void addBlockToBlockchain() {
        Instant startTime = Instant.now();
        int blockId = getNewBlockId();
        blockchain.add(BlockFactory.createInstance(blockId, calculateNumberOfZeros(blockId), getPreviousHash()));
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

    void printBlockchain() {
        if (isValid()) {
            Printer.printBlockchain(blockchain);
        }
    }
}