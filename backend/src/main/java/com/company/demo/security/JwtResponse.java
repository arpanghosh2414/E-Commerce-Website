package com.company.demo.security;

import com.company.demo.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse
{
    private User user;
    private String jwt;
}
