package com.javaminds.spring_ai_llama2.service;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class LlamaAIService {

    private final OllamaChatModel chatModel;

    public LlamaAIService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String generateResult(String prompt){
        ChatResponse response = chatModel.call(
                new Prompt( prompt,
                        OllamaOptions.builder()
                                .withModel(OllamaModel.LLAMA3_1)
//                                .withTemperature(0.4F)
                                .build()
                ));
        return response.getResult().getOutput().getContent();
    }

    public String generateImagePromptResult(String imagePath, String promptMessage) {

//        var imageResource = new ClassPathResource(imagePath);
        var imageResource = new ClassPathResource("/static/multimodal.test.png");

        var userMessage = new UserMessage(promptMessage,
                new Media(MimeTypeUtils.IMAGE_PNG, imageResource));

        ChatResponse response = chatModel.call(
                new Prompt(userMessage,
                        OllamaOptions.builder().withModel(OllamaModel.MISTRAL).build()
                ));

        return response.getResult().getOutput().getContent();
    }
}
