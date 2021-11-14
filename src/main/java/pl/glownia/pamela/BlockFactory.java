package pl.glownia.pamela;

import java.util.Date;

class BlockFactory {

    static Block createInstance(int id) {
        if (id == 0) {
            return new Block(id, new Date().getTime(), "0", HashGenerator.generateHashOfBlock(HashGenerator.getTextToHash(id)));
        } else {
            return new Block(id, new Date().getTime(), HashGenerator.generateHashOfBlock(HashGenerator.getTextToHash(id - 1)), HashGenerator.generateHashOfBlock(HashGenerator.getTextToHash(id)));
        }
    }
}