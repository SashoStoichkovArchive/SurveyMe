package survey_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import survey_me.repository.SurveyRepository;

@RestController
@RequestMapping("survey")
public class SurveyController {
    @Autowired
    private SurveyRepository surveyRepository;

//    @PostMapping(path = "/create")
//    some func
//
//    @PostMapping(path = "/edit/{id}")
//    some func
//
//    @PostMapping(path = "/vote/{id}")
//    some func
}
