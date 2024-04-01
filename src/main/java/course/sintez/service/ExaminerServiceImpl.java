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
    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("java") QuestionService mathService,
                               @Qualifier("math") QuestionService javaService) {
        this.mathService = mathService;
        this.javaService = javaService;

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questions = new ArrayList<>();

        while (questions.size() < amount) {
            if (random.nextBoolean()) {
                             Question question = mathService.getRandomQuestion();
                if (question != null) {
                    questions.add(question);
                } else {
                    throw new NotEnoughQuestionsException();
                }
            } else {
                Question question = javaService.getRandomQuestion();
                if (question != null) {
                    questions.add(question);
                } else {
                    throw new NotEnoughQuestionsException();
                }
            }

            if (questions.size() >= amount ) {

                break;
            }
        }

        return questions;
    }
}