package course.sintez.service;

import course.sintez.exception.NotEnoughQuestionsException;
import course.sintez.exception.NotFoundQuestionException;
import course.sintez.model.Question;
import course.sintez.repository.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    static List<Question> QUESTIONS=List.of(
            new Question("test1", "question1"),
            new Question("test2", "question2"),
            new Question("test3", "question3"),
            new Question("test4", "question4"));

    @Mock
    JavaQuestionRepository repository;
    @InjectMocks
    JavaQuestionService service;

    @BeforeEach
    void setUp() {
        when(repository.getAll()).thenReturn(QUESTIONS);
    }

    @Test
    void testRandomQuestion() {
        for (int i = 0; i < 50; i++) {
            assertTrue(QUESTIONS.contains(service.getRandomQuestion()));
        }
    }

    @Test
    void testEmpQuestions(){
        when(repository.getAll()).thenReturn(List.of());
        assertThrows(NotFoundQuestionException.class,() -> service.getRandomQuestion());
    }
}