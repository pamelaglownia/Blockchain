package pl.glownia.pamela.chatsimulator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ChatSimulator {
    private final List<String> users = List.of("Alice", "Tom", "Rob", "Emma", "Lisa", "Andy", "Peter", "Anna", "Mary");
    private final List<String> messages = List.of("Hello! Have a nice day!", "Today is my lucky day!", "Nice chat", "I hate school", "bla bla bla", "My boss is the best", "How do you do?");


    private String getRandomData(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    private Set<ChatMessage> generateMessages() {
        Set<ChatMessage> chat = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            String text = getRandomData(messages);
            ChatMessage chatMessage = new ChatMessage(getRandomData(users),text);
            chat.add(chatMessage);
            KeysManager.writeToAFile();
            Encryptor.encrypt(text);
        }
        return chat;
    }

    public String generateRandomMessage() {
        Set<ChatMessage> messages = generateMessages();
        return messages.iterator().next().toString();
    }
}