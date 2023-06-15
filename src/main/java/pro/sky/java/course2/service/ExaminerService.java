package pro.sky.java.course2.service;

import pro.sky.java.course2.domain.Question;

import java.util.Collection;

public interface ExaminerService {
 //   Collection<Question>
 Collection<Question> getQuestions(int amount);

}
