package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Hi");
    }

    @BeforeEach
    void before() {
        result = getRult();
    }

    @Test
    @Disabled
    @Tag("simple_test")
    void firstTest() {
        Assertions.assertTrue(result > 2);
    }

    private int getRult() {
        return 3;
    }

    @AfterEach
    void after() {
        result = 0;
    }
}
