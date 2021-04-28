package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import survey_me.entity.SurveyEntity;
import survey_me.entity.UserEntity;
import survey_me.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

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
        userRepository.save(user);

        return "user/registerSuccess";
    }

    @GetMapping(path = "/profile/{username}")
    public String getSurveys(@PathVariable String username, Model model) {
        Optional<UserEntity> possibleUser = userRepository.findByUsername(username);

        if (possibleUser.isPresent()) {
            UserEntity user = possibleUser.get();

            List<SurveyEntity> surveys = user.getSurveys().stream()
                    .filter(SurveyEntity::getPublic).collect(Collectors.toList());

            model.addAttribute("user", user);
            model.addAttribute("surveys", surveys);

            return "user/profile";
        }

        return "error";
    }
}
