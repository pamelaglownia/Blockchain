package pl.glownia.pamela.threadmanaging;

import pl.glownia.pamela.Blockchain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockchainGenerator {

    public void generateBlockchain() {
        Controller controller = new Controller();
        Blockchain blockchain = new Blockchain();
        Command blockCreating = new BlockCreator(blockchain);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MinerThread(controller, blockchain, blockCreating));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        blockchain.printBlockchain();
    }
}
