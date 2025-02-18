package test.java.com.ageng_setyo;

import com.ageng_setyo.Effect;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@Tag("effec-test")
@DisplayName("Effect Class Unit Test")
public class EffectTest {

    @Test
    @DisplayName("Effect Should Return the Correct Total Qty: 9")
    public void effectShouldReturnCorrectTotalQty() {
        String input = "1 10\n2 20\n3 30\n4 40\n5 50\n6 60\n7 70\n8 80\n9 90\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Effect effect = new Effect(9);
        assertEquals(9, effect.getTotal());
    }

    @Test
    @DisplayName("Check should return correct effect value when found")
    public void checkShouldReturnCorrectValueWhenFound() {
        String input = "1 10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Effect effect = new Effect(1);
        assertEquals(10, effect.check(1));
    }

    @Test
    @DisplayName("Check should return 0 when not found")
    public void checkShouldReturnZeroWhenNotFound() {
        String input = "1 10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Effect effect = new Effect(1);
        assertEquals(0, effect.check(10));
    }
}
