package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import survey_me.entity.UserEntity;
import survey_me.repository.SurveyRepository;
import survey_me.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("")
public class PublicController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all-users")
    public String displayUsers(Model model) {
        List<UserEntity> allUsers = userRepository.findAll();

        model.addAttribute("users", allUsers);

        return "user/all_users";
    }

    // @GetMapping(path = "/list-public")
    // some func
}
