package pl.glownia.pamela.blockmanager;

import java.util.List;

class Printer {

    static void printBlockchain(List<Block> blockchain) {
        blockchain.stream()
                .limit(15)
                .forEach(System.out::println);
    }
}