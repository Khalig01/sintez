package course.sintez.service;

import course.sintez.exception.NotEnoughQuestionsException;
import course.sintez.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaService;
    private final QuestionService mathService;
    private final Random random= new Random();
    public ExaminerServiceImpl(@Qualifier("java") QuestionService mathService,
                               @Qualifier("math") QuestionService javaService) {
        this.mathService=mathService;
         this.javaService=javaService;

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allQuestions=new ArrayList<>(mathService.getAll());
        allQuestions.addAll(javaService.getAll());


        if(amount>allQuestions.size()){
            throw new NotEnoughQuestionsException();
        }
        if(amount== allQuestions.size()){
            return allQuestions;
        }
        Set<Question> questions= new HashSet<>();
        while(questions.size()< amount){
           var question= random.nextBoolean() ? mathService.getRandomQuestion() : javaService.getRandomQuestion();
            questions.add(question);
        }
return questions;

    }
}
