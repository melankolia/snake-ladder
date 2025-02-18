package test.java.com.ageng_setyo;

import com.ageng_setyo.Ladder;
// Semua method di Assert itu static, jadi import nya import static
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Cara testing menggunakan @Tag
 * mvn test -Dgroups=effect-test
 * Bisa test lebih dari satu @Tag
 * */
@Tags({
        @Tag("effect-test"),
        @Tag("ladder-test")
})
@DisplayName("Ladder Class Unit Test")
public class LadderTest {

    @Test
    @DisplayName("Ladder Should Return the Correct Total Qty: 9")
    public void ladderShouldReturnCorrectTotalQty() {
        String input = "1 10\n2 20\n3 30\n4 40\n5 50\n6 60\n7 70\n8 80\n9 90\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Ladder ladder = new Ladder(9);
        assertEquals(9, ladder.getTotal());
    }

//    Apakah harus test beda type, sedangkan Java itu Statictly Type ?
//    Jika iya harus, bagaimana cara mock scan.nextInt();

    @Test
    @Disabled
    @DisplayName("Ladder Should Return the Correct Total Qty When User Input Wrong Type")
    public void ladderShouldReturnCorrectTotalQtyWrongType() {
        Ladder ladder = new Ladder(10);
        assertEquals(10, ladder.getTotal());
    }
}
