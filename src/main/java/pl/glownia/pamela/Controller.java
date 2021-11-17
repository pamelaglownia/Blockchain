package pl.glownia.pamela;

class Controller {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand(int numberOfZeros) {
        command.execute(numberOfZeros);
    }
}