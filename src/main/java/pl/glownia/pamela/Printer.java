package pl.glownia.pamela;

import java.util.List;

class Printer {

    static void printBlockchain(List<Block> blockchain) {
        blockchain.forEach(System.out::println);
    }
}