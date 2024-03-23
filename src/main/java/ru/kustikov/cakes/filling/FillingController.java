package ru.kustikov.cakes.filling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fillings")
@RequiredArgsConstructor
public class FillingController {

    private final FillingService fillingService;

    @PostMapping("/save-fillings")
    public ResponseEntity<List<Filling>> saveFillings(@RequestBody List<Filling> fillings) {
        return fillingService.save(fillings);
    }

    @PostMapping("/delete-filling")
    public ResponseEntity<String> deleteFilling(@RequestBody Long fillingId) {
        return fillingService.delete(fillingId);
    }
}
