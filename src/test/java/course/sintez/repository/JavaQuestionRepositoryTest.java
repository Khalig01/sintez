package course.sintez.repository;

import course.sintez.model.Question;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    JavaQuestionRepository repository= new JavaQuestionRepository();

    @Test
    void testAdd() {
        repository.add(new Question("test1","question1"));
        repository.add(new Question("test2","question2"));

       assertThat(repository.getAll()).containsExactlyInAnyOrder(
               new Question("test1","question1"),
               new Question("test2","question2"));

    }

    @Test
    void testRemove() {
        repository.add(new Question("test1","question1"));
        repository.add(new Question("test2","question2"));
var removed= repository.remove(new Question("test2","question2"));
assertThat(removed).isEqualTo(new Question("test2","question2"));
        var emp= repository.remove(new Question("ran","but"));
        assertThat(emp).isNull();

        assertThat(repository.getAll()).containsExactlyInAnyOrder(
                new Question("test1","question1"));

    }

}