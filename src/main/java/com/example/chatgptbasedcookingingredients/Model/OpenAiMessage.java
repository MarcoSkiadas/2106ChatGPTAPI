package com.example.chatgptbasedcookingingredients.Model;

/**
 * {
 *  *         "role": "system",
 *  *         "content": "You are a helpful assistant."
 *  *       }
 */
public record OpenAiMessage(
        String role,
        String content
) {
}