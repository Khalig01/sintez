package course.sintez.service;

import course.sintez.exception.NotEnoughQuestionsException;
import course.sintez.model.Question;
import org.assertj.core.api.AbstractBooleanArrayAssert;
import org.assertj.core.api.FactoryBasedNavigableListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    static List<Question> MATH_QUESTIONS = List.of(
            new Question("2+3", "5"),
            new Question("1+1", "2"));

    static List<Question> JAVA_QUESTIONS = List.of(
            new Question("question", "bar"),
            new Question("stend", "three"));
    @Mock
    JavaQuestionService javaQuestionService;
    @Mock
    MathQuestionService mathQuestionService;
@InjectMocks
    ExaminerServiceImpl examinerService;


    void setUp() {
      //  examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
        when(javaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);
        when(mathQuestionService.getAll()).thenReturn(MATH_QUESTIONS);
    }

    @Test
    void testNotQuestion() {
        assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(1));
    }

    @Test
    void testRandomQuestions() {
        when(javaQuestionService.getRandomQuestion())
             //   .thenReturn(JAVA_QUESTIONS.get(0))
                .thenReturn(JAVA_QUESTIONS.get(1));
        when(mathQuestionService.getRandomQuestion())
             //   .thenReturn(MATH_QUESTIONS.get(0))
                .thenReturn(MATH_QUESTIONS.get(1));


        var actual = examinerService.getQuestions(1);
        assertThat(actual).hasSize(1);
        assertThat(actual).containsAnyOf(
                JAVA_QUESTIONS.get(0),
                JAVA_QUESTIONS.get(1),
                MATH_QUESTIONS.get(0),
                MATH_QUESTIONS.get(1));
verify(javaQuestionService,atMostOnce()).getRandomQuestion();
        verify(mathQuestionService,atMostOnce()).getRandomQuestion();
     //   verifyZeroInteractions()
    }

}