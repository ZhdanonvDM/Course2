package pro.sky.java.course2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.service.JavaQuestionService;
import pro.sky.java.course2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/")
public class JavaQuestionController {
    private final JavaQuestionService jqs;
    public  JavaQuestionController (JavaQuestionService jqs) {
        this.jqs = jqs;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/add")
    public Question addQuestion (@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return jqs.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion (@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return jqs.remove(question, answer);
    }

    @GetMapping("")
    public Collection<Question> getAllQuestion () {
        return jqs.getAll();
    }


}
