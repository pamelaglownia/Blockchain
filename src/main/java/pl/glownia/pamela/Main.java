package pl.glownia.pamela;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Blockchain blockchain = new Blockchain();
        Command blockCreating = new BlockCreator(blockchain);

        for (int i = 0; i < 5; i++) {
            Thread minerThread = new Thread(new MinerThread(controller, blockchain, blockCreating));
            minerThread.start();
            try {
                minerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blockchain.printBlockchain();
    }
}