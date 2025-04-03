package com.hina.backend_btl_java.service;

import com.hina.backend_btl_java.dto.request.SetCoinRequest;
import com.hina.backend_btl_java.entity.User;
import com.hina.backend_btl_java.repository.UserRepository;
import com.hina.backend_btl_java.utils.AuthUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log4j2
public class CoinService {
    UserRepository userRepository;
    AuthUtils authUtils;

    public int getCoin() {
        return authUtils.getCurrentUser().getCoin();
    }

    public void addCoin(SetCoinRequest request) {
        int coin = request.getCoin();
        if (coin <= 0) {
            coin = 0;
        }

        User user = authUtils.getCurrentUser();
        user.setCoin(coin);
        userRepository.save(user);
    }
}
