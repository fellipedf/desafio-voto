package io.swagger.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.exception.ApplicationException;
import io.swagger.exception.ExceptionType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class CpfValidatorIntegration {

    public void validateVotingAssociate(String cpf) {

        try {
            String body = getVoteStatus(cpf);
            if (body.equals("UNABLE_TO_VOTE")) {
                throw new ApplicationException("Não possui direito a voto", ExceptionType.OTHER);
            }

        } catch (RestClientException e) {
            e.getMessage();
        }
    }

    public void validate(String cpf) {
        try {
            String voteStatus = getVoteStatus(cpf);
        } catch (RestClientException e) {
            throw new ApplicationException("CPF Inválido", ExceptionType.OTHER);
        }
    }

    private String getVoteStatus(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://user-info.herokuapp.com/users";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/" + cpf, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode status = root.path("status");
            return status.asText();
        } catch (IOException e) {
            throw new ApplicationException("Erro ao tentar validar o CPF", ExceptionType.OTHER);
        }
    }


}