package com.practice.spring_ai_api.config;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AiConfig {

    @Bean
    @Primary
    @ConditionalOnProperty(name = "spring.ai.ollama.chat.enabled", havingValue = "true")
    public ChatModel ollamaModel(OllamaChatModel ollamaChatModel) {
        return ollamaChatModel;
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "spring.ai.openai.chat.enabled", havingValue = "true")
    public ChatModel openAiModel(OpenAiChatModel openAiChatModel) {
        return openAiChatModel;
    }
}
