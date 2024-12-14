package com.javaminds.spring_ai_llama2.controller;

import com.javaminds.spring_ai_llama2.service.LlamaAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    private final LlamaAIService aiService;

    public AIController(LlamaAIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/api/v1/generate")
    public String generate(@RequestParam(value = "message") String prompt) {
        return aiService.generateResult(prompt);
    }

    @GetMapping("/api/v1/generateFromImage")
    public String generateImagePrompt(@RequestParam String imagePath, @RequestParam ( defaultValue = "Explain what do you see on this picture?" ) String message) {
        return aiService.generateImagePromptResult(imagePath,message);
    }
}
