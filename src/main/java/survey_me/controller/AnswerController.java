package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import survey_me.entity.AnswerEntity;
import survey_me.entity.QuestionEntity;
import survey_me.repository.AnswerRepository;
import survey_me.repository.QuestionRepository;

import java.util.Random;
import java.util.Set;

@Controller
@RequestMapping("answer")
public class AnswerController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping(path = "/add/{surveyId}/{questionId}")
    public String addAnswerForm(@PathVariable Long surveyId, @PathVariable Long questionId, Model model) {
        model.addAttribute("answer", new AnswerEntity());
        model.addAttribute("surveyId", surveyId);
        model.addAttribute("questionId", questionId);
        return "answer/add";
    }

    @PostMapping(path = "/add/{surveyId}/{questionId}")
    public String addAnswer(@PathVariable Long surveyId, @PathVariable Long questionId, @ModelAttribute AnswerEntity answer, Model model) {
        for (QuestionEntity question : questionRepository.findAll()) {
            if (question.getId().equals(questionId)) {
                model.addAttribute("answer", answer);

                answer.setId(new Random().nextLong());
                answer.setQuestion(question);
                answerRepository.save(answer);

                Set<AnswerEntity> answers = question.getAnswers();
                answers.add(answer);
                question.setAnswers(answers);

                questionRepository.save(question);

                return "redirect:/answer/add/" + surveyId + "/" + question.getId();
            }
        }

        return "error";
    }
}
