package pl.glownia.pamela.threadmanaging;

import pl.glownia.pamela.Blockchain;

class BlockCreator implements Command {

    private final Blockchain blockchain;

    BlockCreator(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public void execute() {
        blockchain.addBlockToBlockchain();
    }
}