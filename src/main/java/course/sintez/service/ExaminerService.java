package course.sintez.service;

import course.sintez.model.Question;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
