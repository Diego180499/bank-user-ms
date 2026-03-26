package com.bank.user_microservice.utils;


import com.bank.user_microservice.error.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Objects;

@Service
public class PasswordUtils {

    private static final String PASSWORD_PEPPER = "user-microservice-password-pepper-v1";
    private static final int HASH_MAX_LENGTH = 10;


    public String encryptPassword(String originalPassword) {
        if (Objects.isNull(originalPassword)) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "El valor de la contraseña no debe ser nulo");
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(PASSWORD_PEPPER.getBytes(StandardCharsets.UTF_8));
            digest.update(originalPassword.getBytes(StandardCharsets.UTF_8));
            byte[] hash = digest.digest();
            String hex = HexFormat.of().formatHex(hash);
            return hex.substring(0, HASH_MAX_LENGTH);
        } catch (NoSuchAlgorithmException e) {
            throw new BusinessException(HttpStatus.BAD_REQUEST,"SHA-256 algorithm not available");
        }
    }


    public Boolean validatePassword(String originalPassword, String passwordHashed) {
        if (originalPassword == null || passwordHashed == null) {
            return Boolean.FALSE;
        }
        String computedHash = encryptPassword(originalPassword);
        return MessageDigest.isEqual(
                computedHash.getBytes(StandardCharsets.UTF_8),
                passwordHashed.getBytes(StandardCharsets.UTF_8));
    }

}
