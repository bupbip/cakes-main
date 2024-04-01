package ru.kustikov.cakes.producttype;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductTypeService {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:4300/api/v1/product-type";

    public ResponseEntity<?> delete(Long productTypeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Long> request = new HttpEntity<>(productTypeId, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL + "/delete", request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("ProductType deleted successfully");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }
}
