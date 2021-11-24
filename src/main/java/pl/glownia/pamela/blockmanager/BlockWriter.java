package pl.glownia.pamela.blockmanager;

import java.io.File;
import java.io.FileWriter;

class BlockWriter {

    static void writeFile(File file, Block block) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(block.toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.printf("Something went wrong.... %s", e.getMessage());
        }
    }
}