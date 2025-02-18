package test.java.com.ageng_setyo;
import com.ageng_setyo.Player;

// Semua method di Assert itu static, jadi import nya import static
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

/**
 * Cara testing menggunakan @Tag
 * mvn test -Dgroups=snake-test,player-test
 * Bisa test lebih dari satu @Tag
 * */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("player-test")
@DisplayName("Player Class Unit Test")
public class PlayerTest {
    private final Player player = new Player("Ageng");

    @BeforeEach
    public void setUp() {
        System.out.println("Test setup Before Each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test setup After Each");
    }

    @Test
    @Order(3)
    @DisplayName("Player Should Return Correct Name: Ageng")
    public void playerShouldReturnCorrectName() {
        assertEquals("Ageng", player.getName());
    }

    @Test
    @Order(1)
    @DisplayName("Player Should Move to Correct Position: 6")
    public void playerShouldMoveToPositionSix(TestInfo testInfo) {
        int maxCell = 100;

        System.out.println("Display Name: " + testInfo.getDisplayName());
        System.out.println("Tags: " + testInfo.getTags());
        System.out.println("Test: " + testInfo.getTestClass());

        player.move(6, maxCell);
        assertEquals(6, player.getPosition());
    }

    @Test
    @Order(2)
    @DisplayName("Player Should Not Move When Player Position Exceed the Max Cell")
    public void playerShouldNotMoveWhenMaxCellReached() {
        int maxCell = 100;

        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(10, maxCell);
        player.move(5, maxCell);

        assertEquals(95, player.getPosition());

        player.move(10, maxCell);

        assertEquals(95, player.getPosition());
    }

    @Test
    @Disabled
    public void testAborted() {
        String profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }
    }

    @Test
    @Order(4)
    public void testAssumption() {

        // Assumptions jika tidak passed maka akan throw err TestAbortedException
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
