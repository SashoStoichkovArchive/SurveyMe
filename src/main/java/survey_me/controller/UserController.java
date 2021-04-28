package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import survey_me.entity.SurveyEntity;
import survey_me.entity.UserEntity;
import survey_me.repository.UserRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "user/register";
    }

    @PostMapping(path = "/register")
    public String registerUser(@ModelAttribute UserEntity user, Model model) {
        model.addAttribute("user", user);

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        System.out.println(user);

        userRepository.save(user);

        return "user/registerSuccess";
    }

    @GetMapping(path = "/surveys/{username}")
    public Set<SurveyEntity> getSurveys(@PathVariable String username) {
        Optional<UserEntity> possibleUser = userRepository.findByUsername(username);

        return possibleUser.map(UserEntity::getSurveys).orElse(null);
    }

    @GetMapping(path = "/stats/{id}")
    public void func(@PathVariable UUID id) {

    }
}
