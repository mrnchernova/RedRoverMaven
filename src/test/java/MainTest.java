import org.example.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void testSum() {
        Assert.assertEquals(Main.getSum(1, 1), 2);
        Assert.assertEquals(Main.getSum(3, 4), 7);
        Assert.assertEquals(Main.getSum(-1, 8), 7);
    }

    @Test
    public void StringUtilsTest(){
        Assert.assertEquals(Main.apacheCommonLeftPad("  1"), "001");
    }
}
