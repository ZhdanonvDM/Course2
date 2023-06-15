package pro.sky.java.course2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.exceptions.TooManyRequestException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


//@Component
@Service
public class ExaminerServiceImpl implements ExaminerService{
  //  @Autowired
    private JavaQuestionService jqs;

    public ExaminerServiceImpl(JavaQuestionService jqs) {
        this.jqs = jqs;
    }

   // Collection<Question>
    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> q = new HashSet<>();
        if (amount > jqs.size()) {
            throw new TooManyRequestException("Too Many Request");
        }
       while (q.size()+1 <= amount) {
           q.add(jqs.getRandomQuestion());
        }
        return q;
    }
}
