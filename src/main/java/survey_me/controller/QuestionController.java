package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import survey_me.repository.QuestionRepository;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

//    @PostMapping(path = "/create")
//    some func

//    @PostMapping(path = "/edit/{id}")
//    some func
}
