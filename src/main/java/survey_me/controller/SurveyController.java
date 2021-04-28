package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import survey_me.entity.SurveyEntity;
import survey_me.repository.SurveyRepository;

import java.util.UUID;

@Controller
@RequestMapping("survey")
public class SurveyController {
    @Autowired
    private SurveyRepository surveyRepository;

//    @GetMapping(path = "/create")
//    public String createSurveyForm(Model model) {
//        model.addAttribute("survey", new SurveyEntity());
//        return "survey/survey_create";
//    }
//
//    @PostMapping(path = "/create")
//    public String createSurvey(@ModelAttribute SurveyEntity survey, Model model){
//        model.addAttribute("survey", survey);
//
//        survey.setId(UUID.randomUUID());
//        surveyRepository.save(survey);
//
//        return "user/all_users";
//    }

//    @PostMapping(path = "/edit/{id}")
//    some func

//    @PostMapping(path = "/vote/{id}")
//    some func

//    @GetMapping(path = "/stats/{id}")
//    some func
}
