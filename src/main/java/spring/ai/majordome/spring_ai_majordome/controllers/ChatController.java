package spring.ai.majordome.spring_ai_majordome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ai.majordome.spring_ai_majordome.services.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins ="*")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String chat(@RequestBody String message) {
        return chatService.generateResponse(message);
    }
}
