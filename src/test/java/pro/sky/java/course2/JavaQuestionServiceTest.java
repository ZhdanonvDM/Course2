package pro.sky.java.course2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.service.JavaQuestionService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private Map<String, Question> baseQuestion = new HashMap<>(Map.of(
            "Как еще называют периметр круга?", new Question("Как еще называют периметр круга?", "Окружность"),
            "Какое самое популярное счастливое число от 1 до 9?", new Question("Какое самое популярное счастливое число от 1 до 9?", "семь"),
            "Кто изобрел знак равенства '='?", new Question("Кто изобрел знак равенства '='?", "Роберт Рекорд"),
            "Чему равно число пи", new Question("Чему равно число пи", "3,14")
    ));
    Question q = new Question("Question 1", "Answer1");
    JavaQuestionService jqs;
    @BeforeEach
    void setUp() {

        jqs = new JavaQuestionService();
    }

    @Test
    void add() {
        assertEquals(q, jqs.add("Question 1", "Answer1"));
    }

    @Test
    void testAdd() {
        assertEquals(q, jqs.add(q));
    }

    @Test
    void remove() {
        assertEquals(q, jqs.add("Question 1", "Answer1"));
    }

    @Test
    void getAll() {
        assertArrayEquals(baseQuestion.values().toArray(), jqs.getAll().toArray());
    }
}