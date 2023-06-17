package pro.sky.java.course2.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.domain.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Component
public class JavaQuestionService implements QuestionService {

    private Map<String, Question> baseQuestion = new HashMap<>(Map.of(
            "Как еще называют периметр круга?", new Question("Как еще называют периметр круга?", "Окружность"),
            "Какое самое популярное счастливое число от 1 до 9?", new Question("Какое самое популярное счастливое число от 1 до 9?", "семь"),
            "Кто изобрел знак равенства '='?", new Question("Кто изобрел знак равенства '='?", "Роберт Рекорд"),
            "Чему равно число пи", new Question("Чему равно число пи", "3,14")
    ));
//    baseQuestion = new HashMap<>();
    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        baseQuestion.put(question, q);
        return q;
    }

    @Override
    public Question add(Question question) {
        baseQuestion.put(question.getQuestion(), question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        baseQuestion.remove(question);
        return new Question(question, answer);
    }

    @Override
    public Collection<Question> getAll() {
        return baseQuestion.values();
    }

    @Override
    public Question getRandomQuestion() {
        int random = new Random().nextInt(baseQuestion.size());
        return baseQuestion.entrySet().stream().collect(Collectors.toList()).get(random).getValue();
    }
    public int size() {
        return baseQuestion.size();
    }


}
