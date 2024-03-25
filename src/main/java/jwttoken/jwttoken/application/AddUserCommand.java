package jwttoken.jwttoken.application;

import java.util.UUID;

public record AddUserCommand(
        String email,
        String name,
        String surname,
        String passwordHash,
        UUID clientId) {
}
