package ru.kustikov.cakes.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity<User> getAll(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/save-user")
    public ResponseEntity<User> saveProduct(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-confectioners")
    public ResponseEntity<List<User>> getAllConfectioners(@RequestParam Integer skip,
                                                          @RequestParam Integer limit) {
        return userService.getAllConfectioners(skip, limit);
    }
}
