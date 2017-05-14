import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Apok on 14.05.2017.
 */
public class RootValueFinderTest {
    @Test
    public void findRootValueOfFunction() throws Exception {
        RootValueFinder rootValueFinder = new RootValueFinder(-10.0, 10.0, 0.001, 20, 0.0, 1.0);
        assertEquals(0, rootValueFinder.findRootValueOfFunction(), 0);
    }

    @Test
    public void findRootValueOfFunction2() throws Exception {
        RootValueFinder rootValueFinder = new RootValueFinder(-10, 10, 0.0001 ,200, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
        assertEquals(-1, rootValueFinder.findRootValueOfFunction(), 0.0001);
    }

    @Test(expected = Exception.class)
    public void findRootValueOfFunction3() throws Exception {
        RootValueFinder rootValueFinder = new RootValueFinder(-10.0, 10.0, 0.000001, 20, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
        assertEquals(0, rootValueFinder.findRootValueOfFunction(), 0);
    }

}