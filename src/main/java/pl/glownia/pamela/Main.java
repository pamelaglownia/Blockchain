package pl.glownia.pamela;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Blockchain blockchain = new Blockchain();
        Command blockCreating = new BlockCreator(blockchain);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <= 10; i++) {
            executorService.execute(new MinerThread(controller, blockchain, blockCreating));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blockchain.printBlockchain();
    }
}