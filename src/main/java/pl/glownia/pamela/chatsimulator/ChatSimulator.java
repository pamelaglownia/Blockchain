package pl.glownia.pamela.chatsimulator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ChatSimulator {
    private final List<String> users = List.of("Alice", "Tom", "Rob", "Emma", "Lisa", "Andy", "Peter", "Anna", "Mary");
    private final List<String> messages = List.of("Hello! Have a nice day!", "Today is my lucky day!", "Nice chat", "I love potatoes", "bla bla bla", "My boss is the best", "How do you do?");

    private String getRandomData(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    private Set<ChatMessage> generateMessages() {
        KeysManager keysManager = new KeysManager();
        Set<ChatMessage> chat = new HashSet<>();
        int identifier = 1;
        for (int i = 0; i < 5; i++) {
            try {
                String text = getRandomData(messages);
                ChatMessage chatMessage = new ChatMessage(getRandomData(users), text, identifier);
                chat.add(chatMessage);
                String privateKeyPath = "src/main/java/pl/glownia/pamela/chatsimulator/privatekeys/privateKey" + identifier + ".txt";
                String publicKeyPath = "src/main/java/pl/glownia/pamela/chatsimulator/publickeys/publicKey" + identifier + ".txt";
                String signedDataPath = "src/main/java/pl/glownia/pamela/chatsimulator/signeddata/signedData" + identifier + ".txt";
                keysManager.writeToAFile(privateKeyPath, publicKeyPath);
                chatMessage.setSignature(keysManager.signTheMessage(text, privateKeyPath, signedDataPath));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            identifier++;
        }
        return chat;
    }

    public String generateRandomMessage() {
        Set<ChatMessage> messages = generateMessages();
        if (messages.isEmpty()) {
            return "Something went wrong... Refresh chat.";
        }
        return messages.iterator().next().toString();
    }
}