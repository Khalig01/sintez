package course.sintez.controller;

import course.sintez.model.Question;
import course.sintez.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final QuestionService service;
    public MathQuestionController(@Qualifier("math") QuestionService service){
        this.service=service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return service.add(question,answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String question,@RequestParam String answer){
        return service.remove(new Question(question,answer));
    }
    @GetMapping("/add")
    public Collection<Question> getAll(){
        return service.getAll();
    }
}
