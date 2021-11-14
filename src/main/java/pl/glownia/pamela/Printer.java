package pl.glownia.pamela;

import java.util.List;

class Printer {

    static void printBlockchain(List<Block> blockchain) {
        blockchain.stream()
                .limit(5)
                .forEach(System.out::println);
    }
}