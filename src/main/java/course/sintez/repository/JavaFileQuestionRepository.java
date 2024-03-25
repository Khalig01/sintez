package course.sintez.repository;

import course.sintez.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository("javaFile")
public class JavaFileQuestionRepository implements QuestionRepository{
    @Override
   public Question add(String question, String answer) {
        return null;
    }
    @Override
   public Question add(Question question){
        return null;
   }
   @Override
    public Question remove(Question question){
        return null;
    }
    @Override
    public Collection<Question> getAll(){
        return null;
    }
}
