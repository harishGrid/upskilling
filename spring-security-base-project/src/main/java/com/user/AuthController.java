package com.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private MyUserDetailService userDetailsService;

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestBody AuthRequest request) throws Exception {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid credentials");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return Map.of("token", jwt);
    }
}

