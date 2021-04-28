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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        return "survey/survey_create";
    }

    @PostMapping(path = "/create")
    public void createSurvey(@RequestBody Map<String, String> data){
        SurveyEntity survey = new SurveyEntity();

        survey.setId(UUID.randomUUID());
        survey.setName(data.get("survey-title"));
        survey.setDescription(data.get("survey-description"));

//        TODO: This should happen (pseudocode)
//        for (question in data) {
//            QuestionEntity question = new QuestionEntity();
//            question.setQuestion(data.get(question.question-title-n));
//            question.setRequired(data.get(question.required-n));
//            question.setMultiple(data.get(question.multiple-n));
//
//            List<AnswerEntity> answers = new ArrayList<>();
//
//            for (answer in data) {
//                AnswerEntity answer = new AnswerEntity();
//                answer.setAnswer(data.get(question.answer.text));
//                answerRepository.save(answer);
//
//                answers.add(answer);
//            }
//        }

//        surveyRepository.save(survey);

//        return "redirect:";
    }

//    @PostMapping(path = "/edit/{id}")
//    some func

//    @PostMapping(path = "/vote/{id}")
//    some func

//    @GetMapping(path = "/stats/{id}")
//    some func
}
