package jwttoken.jwttoken.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Entity
@Setter
public class Token {
    @Id
    public UUID tokenId;
    public String token;
    @Enumerated(EnumType.STRING)
    public TokenType tokenType;
    public boolean revoked;
    public boolean expired;

    public UUID userId;

    public Token(UUID tokenId, String token, TokenType tokenType, boolean revoked, boolean expired, UUID userId) {
        this.tokenId = tokenId;
        this.token = token;
        this.tokenType = tokenType;
        this.revoked = revoked;
        this.expired = expired;
        this.userId = userId;
    }

    public Token() {

    }
}
