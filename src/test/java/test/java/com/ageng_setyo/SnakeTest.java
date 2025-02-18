package test.java.com.ageng_setyo;
import com.ageng_setyo.Snake;

// Semua method di Assert itu static, jadi import nya import static
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Tags({
        @Tag("effect-test"),
        @Tag("snake-test")
})
@DisplayName("Snake Class Unit Test")
public class SnakeTest {

    @BeforeAll
    public static void setups() {
        System.out.println("Test setup Before All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Test setup Before Each");
    }

    @AfterAll
    public static void tearDowns() {
        System.out.println("Test setup After All");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test setup After Each");
    }

    @Test
    @DisplayName("Snake Should Return the Correct Total Qty: 9")
    public void snakeShouldReturnCorrectTotalQty() {
        String input = "1 10\n2 20\n3 30\n4 40\n5 50\n6 60\n7 70\n8 80\n9 90\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Snake snake = new Snake(9);
        assertEquals(9, snake.getTotal());
    }
}
