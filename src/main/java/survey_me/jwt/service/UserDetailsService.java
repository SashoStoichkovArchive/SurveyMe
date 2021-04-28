package survey_me.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import survey_me.entity.UserEntity;
import survey_me.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> possibleUser = userRepository.findByUsername(username);

        if (possibleUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        UserEntity user = possibleUser.get();

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
