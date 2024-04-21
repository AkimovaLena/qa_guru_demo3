import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Hi");
    }

    @BeforeEach
    void before(){
       result = getRult();
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(result>2);
    }

    private int getRult(){
        return 3;
    }

    @AfterEach
    void after(){
        result = 0;
    }
}
