package pl.glownia.pamela;

import java.io.File;

class BlockFactory {
    static File file = new File("src/main/java/pl/glownia/pamela/Blockchain.txt");

    static Block createInstance(int id, int numberOfZeros, String previousHash) {
        return new Block(id, numberOfZeros, previousHash);
    }

    static void writeFile(Block block) {
        BlockWriter.writeFile(file, block);
    }

}