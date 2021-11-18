package pl.glownia.pamela;

import java.io.File;

class BlockFactory {
    private static final File file = new File("src/main/java/pl/glownia/pamela/Blockchain.txt");

    static Block createInstance(int id, String previousHash) {
        return new Block(id, previousHash);
    }

    static void writeFile(Block block) {
        BlockWriter.writeFile(file, block);
    }
}