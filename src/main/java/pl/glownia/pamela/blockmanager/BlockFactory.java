package pl.glownia.pamela.blockmanager;

import pl.glownia.pamela.chatsimulator.ChatSimulator;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

class BlockFactory {
    private static final File file = new File("src/main/java/pl/glownia/pamela/Blockchain.txt");

    static Block createInstance(int id, int numbersOfZeros, String previousHash) {
        return new Block(id, numbersOfZeros, previousHash);
    }

    static void writeAMessage(Block block) {
        if (block.getId() == 0) {
            block.setChatMessage("no messages");
        } else {
            block.setChatMessage(new ChatSimulator().generateRandomMessage());
        }
    }

    static void calculateElapsedTime(Block block, Instant startTime) {
        Instant finishTime = Instant.now();
        block.setElapsedTimeToGenerateBlock(Duration.between(startTime, finishTime).toMillis());
    }

    static void writeFile(Block block) {
        BlockWriter.writeFile(file, block);
    }
}