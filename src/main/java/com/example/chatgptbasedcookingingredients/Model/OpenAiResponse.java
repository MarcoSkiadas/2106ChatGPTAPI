package com.example.chatgptbasedcookingingredients.Model;

import java.util.List;

/**
 * {
 *     "choices": [
 *         {
 *             "message": {
 *                 "role": "assistant",
 *                 "content": "This is a test!"
 *             }
 *     ]
 * }
 */
public record OpenAiResponse(List<OpenAiChoices> choices) {

    public String getAnswer() {
        return choices.get(0).message().content();
    }
}