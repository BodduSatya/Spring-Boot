package com.satya.HotelServer.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)  // Set extra claims
                .setSubject(userDetails.getUsername())  // Set the username as the subject
                .setIssuedAt(new Date(System.currentTimeMillis()))  // Set issue time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))  // Set expiration to 24 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)  // Set the signing key with HS256 algorithm
                .compact();  // Create the JWT
    }

    private Key getSigningKey() {
        // Base64-encoded secret key
        String base64SecretKey = "78ea313a2ee48ab1e56ff1c513d194152ed5f12de51158f73b2ebb1889b810f58ce229f19ff248e219edc4a43bec4eba109d79f07706379e8b22f66a3ef7471925f9e770bbe0de01d8a5fff6f187899b7113d3bc915514a08c968b4dd62dde42fbedbd8857575a775903fc74d99ebaf0d06842377b13fc16804de60d3a4d1d491bf3e97ab05fb391ce8896b48111fdb2bc12d690713566b66517f0916d16eb1c0a15fe2d75367bd5598c0eebcf3fd2d188468cebfb49650c1d6429ebe041350e4bcdef7619262a7f8f6dc7f6e4f75456c3fb52d9fb3486588632628bbd51f52e2b31b616d2a1e5193e72dcbfe6dabdfaa11f83a8a7dca25792797d784f644f3f";

        // Decode base64 secret key to byte array
        byte[] keyBytes = java.util.Base64.getDecoder().decode(base64SecretKey);
        return Keys.hmacShaKeyFor(keyBytes);  // Generate HMAC key for signing
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSigningKey()).build()
                .parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
