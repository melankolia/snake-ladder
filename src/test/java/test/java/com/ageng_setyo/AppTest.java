package test.java.com.ageng_setyo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    @EnabledOnOs(value = {OS.LINUX})
    public void shouldOnlyRunOnLinux() {
        System.out.println("Running only Linux");
    }

    @Test
    @DisabledOnOs(value = {OS.LINUX})
    public void shouldNotRunOnWindows() {
        System.out.println("Shouldnt run on Linux");
    }
}
