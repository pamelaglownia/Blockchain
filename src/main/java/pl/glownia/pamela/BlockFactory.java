package pl.glownia.pamela;

class BlockFactory {

    static Block createInstance(int id, int numberOfZeros, String previousHash) {
        return new Block(id, numberOfZeros, previousHash);
    }
}