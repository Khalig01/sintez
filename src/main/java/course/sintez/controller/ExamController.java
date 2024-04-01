package course.sintez.controller;
import course.sintez.service.ExaminerService;
import course.sintez.model.Question;
import course.sintez.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {
    private final ExaminerService service;
    public ExamController(ExaminerService service){
        this.service=service;
    }
    @GetMapping("/{amount}")
    public Collection<Question> getQuestion(@PathVariable int amount){
        return service.getQuestions(amount);
    }

}
