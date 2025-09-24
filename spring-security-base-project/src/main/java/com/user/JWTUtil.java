package com.user;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
	
	private final String secret="mySecretKey12345";
	private final long expiration=1000 * 60 * 60;
	
	public String generateToken(UserDetails userDetails) {
		
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.claim("role", userDetails.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				        .setIssuedAt(new Date())
				        .setExpiration(new Date(System.currentTimeMillis()+expiration))
				        .signWith(Keys.hmacShaKeyFor(secret.getBytes()),SignatureAlgorithm.HS256)
				        .compact();
	}
	
	public String extractUserName(String token) {
		return Jwts.parserBuilder().setSigningKey(secret.getBytes()).build()
				.parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
        return extractUserName(token).equals(userDetails.getUsername()) &&
               !Jwts.parserBuilder().setSigningKey(secret.getBytes()).build()
                       .parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
	
	

}
