package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import survey_me.entity.AnswerEntity;
import survey_me.entity.QuestionEntity;
import survey_me.entity.SurveyEntity;
import survey_me.repository.AnswerRepository;
import survey_me.repository.QuestionRepository;
import survey_me.repository.SurveyRepository;

import java.util.*;

@Controller
@RequestMapping("survey")
public class SurveyController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(path = "/create")
    public String createSurveyForm(Model model) {
        model.addAttribute("survey", new SurveyEntity());
        return "survey/create";
    }

    @PostMapping(path = "/create")
    public String createSurvey(@ModelAttribute SurveyEntity survey, Model model) {
        model.addAttribute("survey", survey);

        survey.setId(UUID.randomUUID());
        surveyRepository.save(survey);

        return "redirect:/question/add/" + survey.getId();
    }

//    @PostMapping(path = "/edit/{id}")
//    some func

//    @PostMapping(path = "/vote/{id}")
//    some func

    @GetMapping(path = "/stats/{id}")
    public String getStatsForSurvey(@PathVariable UUID id, Model model) {
        for (SurveyEntity survey : surveyRepository.findAll()) {
            if (survey.getId().equals(id)) {
                Set<QuestionEntity> questions = survey.getQuestions();
                List<AnswerEntity> answers = new ArrayList<>();

                for (QuestionEntity question : questions) {
                    answers.addAll(question.getAnswers());
                }

                model.addAttribute("survey", survey);
                model.addAttribute("questions", questions);
                model.addAttribute("answers", answers);

                return "survey/stats";
            }
        }

        return "error";
    }
}
