package pl.glownia.pamela;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class Blockchain {
    List<Block> blockchain;

    Blockchain() {
        blockchain = new ArrayList<>();
    }

    private List<Block> createBlockchain() {
        Instant startTime = Instant.now();
        int numberOfZeros = new Input().takeNumberFromUser();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                blockchain.add(BlockFactory.createInstance(i, numberOfZeros, "0", startTime, Instant.now()));

            } else {
                blockchain.add(BlockFactory.createInstance(i, numberOfZeros, blockchain.get(blockchain.size() - 1).getHashOfCurrentBlock(), startTime, Instant.now()));
            }
            BlockFactory.writeFile(blockchain.get(i));
        }
        return blockchain;
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
        blockchain = createBlockchain();
        if (isValid()) {
            Printer.printBlockchain(blockchain);
        }
    }
}