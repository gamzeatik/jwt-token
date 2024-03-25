package jwttoken.jwttoken.api;

import jwttoken.jwttoken.application.AddUserCommand;
import jwttoken.jwttoken.application.TokenResponse;
import jwttoken.jwttoken.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create-token")
    public TokenResponse createToken(@RequestBody AddUserCommand command) {
        return userService.registerUser(command);
    }

    @GetMapping("/user-info")
    public String getUserInfo() {
        return "hello world!";
    }
}
