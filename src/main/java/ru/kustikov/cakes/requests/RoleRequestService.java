package ru.kustikov.cakes.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class RoleRequestService {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:4300/api/v1/role-request";

    public ResponseEntity<List<RoleRequest>> getRequests() {
        ResponseEntity<String> response = restTemplate.getForEntity(URL + "/get-all", String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<RoleRequest> requests = objectMapper.readValue(response.getBody(), new TypeReference<>() {
                });
                return ResponseEntity.ok(requests);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(500).build();
            }
        } else {
            log.error("Запрос завершился неудачно. Код ответа: " + response.getStatusCode().value());
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }

    public ResponseEntity<String> approve(RoleRequest roleRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RoleRequest> request = new HttpEntity<>(roleRequest, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL + "/approve", request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(roleRequest.getUser().getUsername() + " теперь кондитер!");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

    public ResponseEntity<String> decline(RoleRequest roleRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RoleRequest> request = new HttpEntity<>(roleRequest, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL + "/decline", request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Заявка отклонена");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }
}