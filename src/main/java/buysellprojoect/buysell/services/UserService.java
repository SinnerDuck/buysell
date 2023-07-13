package buysellprojoect.buysell.services;


import buysellprojoect.buysell.models.enums.Role;
import buysellprojoect.buysell.models.User;
import buysellprojoect.buysell.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncode;

    public boolean createUser(User user){
        String email = user.getEmail();
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new user with email: {}", email );
        userRepository.save(user);
        return true;
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public void userBan(Long id){
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            user.setActive(false);
            log.info("Ban user with id: {}; email: {}", user.getId(), user.getEmail());
        }
        assert user != null;
        userRepository.save(user);
    }
}
