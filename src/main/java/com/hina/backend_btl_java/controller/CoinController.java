package com.hina.backend_btl_java.controller;

import com.hina.backend_btl_java.dto.request.SetCoinRequest;
import com.hina.backend_btl_java.service.CoinService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CoinController {
    CoinService coinService;

    @GetMapping("/coin")
    public ResponseEntity<?> coin() {
        return ResponseEntity.ok(coinService.getCoin());
    }

    @PostMapping("/coin")
    public ResponseEntity<?> addCoin(@RequestBody SetCoinRequest request) {
        coinService.addCoin(request);
        return ResponseEntity.ok("set coin success");
    }
}
