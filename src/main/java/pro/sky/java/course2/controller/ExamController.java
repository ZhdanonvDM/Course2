package pro.sky.java.course2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.service.ExaminerService;
import pro.sky.java.course2.service.ExaminerServiceImpl;
import pro.sky.java.course2.service.JavaQuestionService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerServiceImpl es;
    public  ExamController (ExaminerServiceImpl es) {
        this.es = es;
    }

    //Collection<Question>
    @GetMapping("/{amount}")
    @ResponseStatus(HttpStatus.CREATED)
    public Collection<Question> getQuestion (@PathVariable("amount") int amount) {
        return es.getQuestions(amount);
    }

}
