package ru.kustikov.cakes.products;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:4300/api/v1/product";

    public ResponseEntity<List<Product>> getProducts(Integer skip, Integer limit) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL + "/get-all")
                .queryParam("skip", skip)
                .queryParam("limit", limit);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                String.class);

        return getListResponseEntity(response);
    }

    private ResponseEntity<List<Product>> getListResponseEntity(ResponseEntity<String> response) {
        if (response.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Product> productList = objectMapper.readValue(response.getBody(), new TypeReference<>() {
                });
                return ResponseEntity.ok(productList);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(500).build();
            }
        } else {
            log.error("Запрос завершился неудачно. Код ответа: " + response.getStatusCode().value());
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }

    public ResponseEntity<List<Product>> getProductsByUsername(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("username", username);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(URL + "/get-all?username={username}", HttpMethod.GET, entity, String.class, username);
        return getListResponseEntity(response);
    }

    public ResponseEntity<?> save(Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> request = new HttpEntity<>(product, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL + "/save", request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Product saved successfully");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

    public ResponseEntity<?> delete(Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> request = new HttpEntity<>(product, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL + "/delete", request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

}
