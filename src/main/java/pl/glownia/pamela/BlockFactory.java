package pl.glownia.pamela;

class BlockFactory {

    static Block createInstance(int id, String previousHash) {
            return new Block(id, previousHash);
        }
    }