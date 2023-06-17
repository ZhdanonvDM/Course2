package pro.sky.java.course2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.domain.Question;
import pro.sky.java.course2.service.ExaminerServiceImpl;
import pro.sky.java.course2.service.JavaQuestionService;
import org.mockito.Mockito.*;

import java.util.*;

import static org.apache.logging.log4j.util.LambdaUtil.getAll;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
/*    private Map<String, Question> baseQuestion = new HashMap<>(Map.of(
            "Как еще называют периметр круга?", new Question("Как еще называют периметр круга?", "Окружность"),
            "Какое самое популярное счастливое число от 1 до 9?", new Question("Какое самое популярное счастливое число от 1 до 9?", "семь"),
            "Кто изобрел знак равенства '='?", new Question("Кто изобрел знак равенства '='?", "Роберт Рекорд"),
            "Чему равно число пи", new Question("Чему равно число пи", "3,14")
    ));*/
    Question q = new Question("Чему равно число пи", "3,14");
    Collection<Question> cs = new ArrayList<>();


    @InjectMocks
    private ExaminerServiceImpl es;

    @Mock
    JavaQuestionService jqs;

    @BeforeEach
    void setUp() {
        cs.add(q);
        Mockito.when(jqs.getRandomQuestion()).thenReturn(q);
        Mockito.when(jqs.size()).thenReturn(1);
    }

    @Test
    void getQuestions() {
        assertArrayEquals(es.getQuestions(1).toArray(), cs.toArray());
    }


}