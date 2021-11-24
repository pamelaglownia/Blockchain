package pl.glownia.pamela.threadmanaging;

import pl.glownia.pamela.blockmanager.Blockchain;

class MinerThread implements Runnable {
    Controller controller;
    Blockchain blockchain;
    Command blockCreating;

    MinerThread(Controller controller, Blockchain blockchain, Command blockCreating) {
        this.controller = controller;
        this.blockchain = blockchain;
        this.blockCreating = blockCreating;
    }

    @Override
    public void run() {
        controller.setCommand(blockCreating);
        controller.executeCommand();
    }
}