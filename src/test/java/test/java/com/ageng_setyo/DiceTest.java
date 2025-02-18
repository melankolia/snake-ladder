package test.java.com.ageng_setyo;
import com.ageng_setyo.Dice;

// Semua method di Assert itu static, jadi import nya import static
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * Cara testing menggunakan @Tag
 * mvn test -Dgroups=dice-test
 * Bisa test lebih dari satu @Tag
 * */
@Tag("dice-test")
@DisplayName("Dice Class Unit Test")
public class DiceTest {

    private final Dice dice = new Dice(6);

    @BeforeAll
    public static void setUp() {
        System.out.println("Test setup Before All");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Test setup After All");
    }

    @Test
    @DisplayName("Dice Should Return <= 6")
    public void diceShouldReturnLessThanOrEqualToSix() {
        assertTrue(dice.shuffle() <= 6);
    }

    @Test
    @DisplayName("Dice Should Return <= maxPoint")
    public void diceShouldReturnLessThanMaxPoint() {
        Dice diceMax = new Dice(12);

        assertEquals(12, diceMax.getMaxPoint());
        assertTrue(diceMax.shuffle() <= 12);
    }
}
