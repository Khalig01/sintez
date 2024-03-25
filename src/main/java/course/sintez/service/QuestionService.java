package course.sintez.service;

import course.sintez.model.Question;

import java.util.Collection;
import java.util.Collections;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
