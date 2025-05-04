package com.ai.example.chatbot;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotController {

    private final ChatModel chatModel;

    public ChatBotController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(value = "message", defaultValue = "Hello, how can I assist you today?") String message) {
        Prompt prompt = new Prompt(message);
        Message output = chatModel.call(prompt).getResult().getOutput();
        return chatModel.call(prompt).getResult().getOutput().toString();
    }

    
}
