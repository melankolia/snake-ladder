package test.java.com.ageng_setyo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;

import com.ageng_setyo.Board;
import com.ageng_setyo.Player;
import com.ageng_setyo.Effect;
import com.ageng_setyo.Ladder;
import com.ageng_setyo.Snake;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

@Tag("board-test")
@DisplayName("Board Class Unit Test")
class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        // Simulate user input for board creation
        // Format: number of snakes, number of ladders, player1 name, player2 name
        String simulatedInput = "1\n1\nPlayer1\nPlayer2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Mock the Board creation to avoid Scanner issues
        board = new Board() {
            @Override
            public void initSnake(Scanner scan) {
                String simulatedInput = "90 1";
                System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

                effects.add(new Snake(1));
            }

            @Override
            public void initLadder(Scanner scan) {
                String simulatedInput = "2 20";
                System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

                effects.add(new Ladder(1));
            }

            @Override
            public void initPlayer(Scanner scan) {
                addPlayer("Player1");
                addPlayer("Player2");
            }
        };
    }

    @Test
    @DisplayName("Board Should Initialize Correctly")
    void testBoardInitialization() {
        assertNotNull(board);
        assertEquals(2, board.getPlayers().size());
        assertEquals(2, board.getEffects().size());
        assertNotNull(board.getDice());
    }

    @Test
    @DisplayName("Add Player Should Add Player Correctly")
    void testAddPlayer() {
        board.addPlayer("TestPlayer");
        assertEquals("TestPlayer", board.getPlayers().get(2).getName());
        assertEquals(0, board.getPlayers().get(2).getPosition());
    }

    @Test
    @DisplayName("Player Movement Should Move Correctly")
    void testPlayerMovement() {
        Player player = board.getPlayers().getFirst();
        int initialPosition = player.getPosition();

        player.move(3, board.getMaxCell());
        assertEquals(initialPosition + 3, player.getPosition());
    }

    @Test
    @DisplayName("Player Wins at Max Cell")
    void testPlayerWinsAtMaxCell() {
        Player player = board.getPlayers().getFirst();
        player.setPosition(board.getMaxCell() - 1);

        player.move(1, board.getMaxCell());
        assertEquals(board.getMaxCell(), player.getPosition());
    }

    @Test
    @DisplayName("Effect Application Should Work Correctly")
    void testEffectApplication() {
        Effect snake = board.getEffects().getFirst();
        assertNotNull(snake);
        assertTrue(snake instanceof Snake);
    }

    @Test
    @DisplayName("Max Cell Boundary Should Work Correctly")
    void testMaxCellBoundary() {
        Player player = board.getPlayers().getFirst();
        player.setPosition(98);
        player.move(4, board.getMaxCell());
        assertTrue(player.getPosition() <= board.getMaxCell());
    }
}