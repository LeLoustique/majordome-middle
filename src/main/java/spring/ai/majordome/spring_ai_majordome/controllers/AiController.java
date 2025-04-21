package spring.ai.majordome.spring_ai_majordome.controllers;

import org.springframework.ai.huggingface.HuggingfaceChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AiController {

    private final HuggingfaceChatModel chatModel;

    @Autowired
    public AiController(HuggingfaceChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate")
    public Map<String, Object> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.chatModel.call(message));
    }
}
