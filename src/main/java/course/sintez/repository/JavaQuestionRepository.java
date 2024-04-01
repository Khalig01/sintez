package course.sintez.repository;

import course.sintez.exception.NotFoundQuestionException;
import course.sintez.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> storage = new HashSet<>();

    @PostConstruct
    private void init(){
        storage.add(new Question("questionjava1","ajava1"));
        storage.add (new Question("questionjava2","ajava2"));
        storage.add (new Question ("questionjava3","ajava3"));
    }
   // private final Random random= new Random();


    @Override
    public Question add(String question,String answer){
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question){
        storage.add(question);
        return question;
    }
    @Override
    public Question remove(Question question){
        if (storage.remove(question)){
            return question;
        }
        return null;
    }
    @Override
    public Collection<Question> getAll(){
        return Collections.unmodifiableSet(storage);
    }

    }

