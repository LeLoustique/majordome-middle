package spring.ai.majordome.spring_ai_majordome.services;


import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.huggingface.HuggingfaceChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final HuggingfaceChatModel chatModel;

    public ChatService(HuggingfaceChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String generateResponse(String message) {
        ChatResponse response = chatModel.call(new Prompt(message));
        // Récupère la première génération de la liste
        return response.getResults().get(0).getOutput().getText();
    }
}
