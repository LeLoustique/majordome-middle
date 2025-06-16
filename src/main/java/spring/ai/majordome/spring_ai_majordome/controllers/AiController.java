package spring.ai.majordome.spring_ai_majordome.controllers;

import org.springframework.ai.huggingface.HuggingfaceChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ai.majordome.spring_ai_majordome.models.ChatRequest;
import spring.ai.majordome.spring_ai_majordome.models.ChatResponse;

@RestController
public class AiController {

    private final HuggingfaceChatModel chatModel;

    @Autowired
    public AiController(HuggingfaceChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate")
    public ChatResponse generate(@RequestBody ChatRequest request) {
        String result = this.chatModel.call(request.getMessage());
        return new ChatResponse(result);
    }
}
