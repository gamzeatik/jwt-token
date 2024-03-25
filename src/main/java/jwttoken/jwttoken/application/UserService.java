package jwttoken.jwttoken.application;

import jwttoken.jwttoken.domain.UserRepository;
import jwttoken.jwttoken.infrastructure.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @Transactional
    public TokenResponse registerUser(AddUserCommand command) {
        if (userRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("User already exists");
        }
        UserDto userDto = new UserDto(
                UUID.randomUUID(),
                command.email(),
                command.name(),
                command.surname(),
                command.passwordHash(),
                command.clientId()
        );
        return authenticationService.register(userDto);
    }
}
