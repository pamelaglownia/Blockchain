package pl.glownia.pamela.chatsimulator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatSimulator {
    private final List<String> users = List.of("Alice", "Tom", "Rob", "Emma", "Lisa");

    private Set<ChatMessage> generateMessages() {
        Set<ChatMessage> messages = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            messages.add(new ChatMessage(users.get(i), "Hello! Have a nice day!"));
            messages.add(new ChatMessage(users.get(i), "Today is lucky day"));
            messages.add(new ChatMessage(users.get(i), "Nice chat"));
            messages.add(new ChatMessage(users.get(i), "blablabla"));
        }
        return messages;
    }

    public String generateRandomMessage() {
        Set<ChatMessage> messages = generateMessages();
        return messages.iterator().next().toString();
    }
}