package jwttoken.jwttoken.application;

import lombok.Value;

import java.util.UUID;

@Value
public class UserDto {
    UUID userId;
    String email;
    String name;
    String surname;
    String passwordHash;
    UUID clientId;
}
