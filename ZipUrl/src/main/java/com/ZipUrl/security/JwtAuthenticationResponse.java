package com.ZipUrl.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.boot.internal.Abstract;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;


}
