package pl.glownia.pamela;

class BlockCreator implements Command {

    private final Blockchain blockchain;

    BlockCreator(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public void execute(int numberOfZeros) {
        blockchain.addBlockToBlockChain(numberOfZeros);
    }
}