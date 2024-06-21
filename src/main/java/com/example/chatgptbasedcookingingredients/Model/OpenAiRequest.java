package com.example.chatgptbasedcookingingredients.Model;

import java.util.List;

/**
 * {
 *     "model": "gpt-3.5-turbo",
 *     "messages": [
 *       {
 *         "role": "user",
 *         "content": "You are a helpful assistant."
 *       }
 *     ],
 *     "temperature": 0.7
 *   }
 */

public record OpenAiRequest(
        String model,
        List<OpenAiMessage> messages,
        double temperature
) {

}