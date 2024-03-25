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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
static List<Question> MATH_QUESTIONS= List.of(
        new Question("2+3","5"),
        new Question("1+1","2"));

    static List<Question> JAVA_QUESTIONS= List.of(
            new Question("question","java"),
            new Question("stend","three"));
    @Mock
    JavaQuestionService javaQuestionService;
    @Mock
    MathQuestionService mathQuestionService;

    ExaminerService examinerService;

    @BeforeEach
    void setUp() {
        examinerService= new ExaminerServiceImpl(javaQuestionService,mathQuestionService);
        when(javaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);
        when(javaQuestionService.getAll()).thenReturn(MATH_QUESTIONS);
    }

    @Test
    void testNotQuestion(){
        assertThrows(NotEnoughQuestionsException.class,() -> examinerService.getQuestions(100000));
    }
@Test
    void testRandomQuestions(){
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(JAVA_QUESTIONS.get(0));
    when(mathQuestionService.getRandomQuestion())
            .thenReturn(MATH_QUESTIONS.get(0))
            .thenReturn(MATH_QUESTIONS.get(1));

    var actual= examinerService.getQuestions(3);
    assertThat(actual).containsExactlyInAnyOrder(
               JAVA_QUESTIONS.get(0),
            MATH_QUESTIONS.get(0),
           MATH_QUESTIONS.get(1));




}

}