package ru.kustikov.cakes.requests;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/role-request")
@RequiredArgsConstructor
public class RoleRequestController {

    private final RoleRequestService roleRequestService;

    @GetMapping("/get-all")
    public ResponseEntity<List<RoleRequest>> getAll() {
        return roleRequestService.getRequests();
    }

    @PostMapping("/approve")
    public ResponseEntity<String> approve(@RequestBody RoleRequest request) {
        return roleRequestService.approve(request);
    }

    @PostMapping("/decline")
    public ResponseEntity<String> decline(@RequestBody RoleRequest request) {
        return roleRequestService.decline(request);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody RoleRequest request) {
        return roleRequestService.save(request);
    }

}