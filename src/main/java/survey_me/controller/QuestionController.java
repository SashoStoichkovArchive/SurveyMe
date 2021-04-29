package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import survey_me.entity.QuestionEntity;
import survey_me.entity.SurveyEntity;
import survey_me.repository.QuestionRepository;
import survey_me.repository.SurveyRepository;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping(path = "/add/{id}")
    public String addQuestionForm(@PathVariable Long id, Model model) {
        model.addAttribute("question", new QuestionEntity());
        model.addAttribute("surveyId", id);
        return "question/add";
    }

    @PostMapping(path = "/add/{id}")
    public String addQuestion(@PathVariable Long id, @ModelAttribute QuestionEntity question, Model model) {
        for (SurveyEntity survey : surveyRepository.findAll()) {
            if (survey.getId().equals(id)) {
                model.addAttribute("question", question);

                question.setId(new Random().nextLong());
                question.setSurvey(survey);
                questionRepository.save(question);

                Set<QuestionEntity> questions = survey.getQuestions();
                questions.add(question);
                survey.setQuestions(questions);

                surveyRepository.save(survey);

                return "redirect:/answer/add/" + id + "/" + question.getId();
            }
        }

        return "error";
    }
}
