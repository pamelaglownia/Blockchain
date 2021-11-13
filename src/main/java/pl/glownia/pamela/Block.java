package pl.glownia.pamela;

class Block {
    private final int id;
    private final long timestamp;
    private final String hashOfPreviousBlock;
    private final String hashOfCurrentBlock;

    Block(int id, long timestamp, String hashOfPreviousBlock, String hashOfCurrentBlock) {
        this.id = id;
        this.timestamp = timestamp;
        this.hashOfPreviousBlock = hashOfPreviousBlock;
        this.hashOfCurrentBlock = hashOfCurrentBlock;
    }

    String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    String getHashOfCurrentBlock() {
        return hashOfCurrentBlock;
    }

    @Override
    public String toString() {
        return "Block:" +
                "\nId: " + (id + 1) +
                "\nTimestamp: " + timestamp +
                "\nHash of the previous block:\n" + hashOfPreviousBlock +
                "\nHash of the block:\n" + hashOfCurrentBlock + "\n";
    }
}