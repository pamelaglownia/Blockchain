package pl.glownia.pamela;

import java.time.Instant;

class BlockFactory {

    static Block createInstance(int id, int numberOfZeros, String previousHash, Instant startTime, Instant finishTime) {
        return new Block(id, numberOfZeros, previousHash, startTime, finishTime);
    }
}