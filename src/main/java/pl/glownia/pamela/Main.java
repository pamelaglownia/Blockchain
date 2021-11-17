package pl.glownia.pamela;

public class Main {
    public static void main(String[] args) {
        int numberOfZeros = new Input().takeNumberFromUser();
        Controller controller = new Controller();
        Blockchain blockchain = new Blockchain();
        Command blockCreating = new BlockCreator(blockchain);

        for (int i = 0; i < 5; i++) {
            controller.setCommand(blockCreating);
            controller.executeCommand(numberOfZeros);
        }
        blockchain.printBlockchain();
    }
}