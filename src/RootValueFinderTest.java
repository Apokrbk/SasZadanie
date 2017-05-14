import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void findRootValueOfFunction4() throws Exception {
        RootValueFinder rootValueFinder = new RootValueFinder(0, 5 , 0.001, 40, -100.0, 0.0, 4.444, -1.11, 9.234);
        assertEquals(1.77757, rootValueFinder.findRootValueOfFunction(), 0.001);
    }

    @Test(expected = Exception.class)
    public void findRootValueOfFunction5() throws Exception {
        RootValueFinder rootValueFinder = new RootValueFinder(10.0, 10.0, 0.1, 20666, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0);
        assertEquals(0, rootValueFinder.findRootValueOfFunction(), 0);
    }

    @Test
    public void findRootValueOfFunction6() throws Exception {
        RootValueFinder rootValueFinder = new RootValueFinder(-3.0, 5.0, 0.00001, 100,-1.11,0.0,0.0,0.0,0.0, 2.428, -2.99, 5585.182 );
        assertEquals(0.295793, rootValueFinder.findRootValueOfFunction(), 0.00001);
    }

}