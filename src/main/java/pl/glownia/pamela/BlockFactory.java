package pl.glownia.pamela;

import java.io.File;
import java.time.Instant;

class BlockFactory {
    static File file = new File("src/main/java/pl/glownia/pamela/Blockchain.txt");

    static Block createInstance(int id, int numberOfZeros, String previousHash, Instant startTime, Instant finishTime) {
        return new Block(id, numberOfZeros, previousHash, startTime, finishTime);
    }

    static void writeFile(Block block) {
        BlockWriter.writeFile(file, block);
    }
}