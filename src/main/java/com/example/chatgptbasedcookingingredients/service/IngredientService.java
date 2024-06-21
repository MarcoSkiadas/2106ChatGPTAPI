package com.example.chatgptbasedcookingingredients.service;

import com.example.chatgptbasedcookingingredients.Model.OpenAiMessage;
import com.example.chatgptbasedcookingingredients.Model.OpenAiRequest;
import com.example.chatgptbasedcookingingredients.Model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class IngredientService {

    private final RestClient restClient;

    public IngredientService(@Value("${BASE_URL}") String baseurl,
                                @Value("${OPEN_API_KEY}") String openaiApiKey) {
        this.restClient = RestClient.builder()
                .defaultHeader("Authorization", "Bearer " + openaiApiKey)
                .baseUrl(baseurl)
                .build();
    }
    public String categorizeIngredient(String q) {
        String responseMsg = "Gib als JSON eines der 3 Ingredients \"vegan\", \"vegetarian\" oder \"regular\" abhängig von der jeweiligen Zutat: "+q+" in diesem Format aus (Beispiel: `{ingredients: [\\\"vegetarian\\\"]}`)";
        OpenAiRequest request= new OpenAiRequest("gpt-3.5-turbo",
                List.of(new OpenAiMessage("user", responseMsg)), 0.7);

        OpenAiResponse response = restClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(OpenAiResponse.class);

        return response.getAnswer();
    }
}
