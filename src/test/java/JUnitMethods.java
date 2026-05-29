import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitMethods {

    @Test public void parsAndSum (){
        //positive tests

        int res = MethodsForTest.parsAndSum("1", "22");
        assertEquals(23, res);

        res = MethodsForTest.parsAndSum( "-1", "0");
        assertEquals(-1, res);

        res = MethodsForTest.parsAndSum("78", "-033");
        assertEquals(45, res);

        res = MethodsForTest.parsAndSum("0", "0");
        assertEquals(0, res);

        res = MethodsForTest.parsAndSum("000001", "90");
        assertEquals(91, res);

        res = MethodsForTest.parsAndSum("2147483647", "0"); //max integer value
        assertEquals(2147483647, res);

        res = MethodsForTest.parsAndSum("0", "-2147483648");  //the min integer value
        assertEquals(-2147483648, res);

        res = MethodsForTest.parsAndSum("-2147483648", "2147483647");  //the min and max integer value
        assertEquals(-1, res);

        res = MethodsForTest.parsAndSum("2147483647", "2147483647");  // two max integer value
        assertEquals(-2, res);

        res = MethodsForTest.parsAndSum("7624 ", "766");  //the min and max integer value
        assertEquals(8390, res);

        res = MethodsForTest.parsAndSum("767", " -678");  //the min and max integer value
        assertEquals(89, res);
        //negative tests

        res = MethodsForTest.parsAndSum(" ", "45");
        assertEquals(301707, res);

        res = MethodsForTest.parsAndSum("767", "");
        assertEquals(301707, res);

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("2147483648", "2147483647");}); //grater than max value

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("8", "21434645737384384686487483647");});

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("8", "-2147483649");}); //less than min value

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("hello","45");});

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("45","FIFA2026");});

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("40years","34");});

        res = MethodsForTest.parsAndSum("2147483647", "1");  //? works according Java specification
        assertEquals(-2147483648, res);

        res = MethodsForTest.parsAndSum("-45", "-2147483648"); //the lowest integer value
        assertEquals(2147483603, res);

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("8600","3.4");});

        assertThrows(NumberFormatException.class,
                ()->{MethodsForTest.parsAndSum("8,600","34");});

        res = MethodsForTest.parsAndSum(null, "-45");
        assertEquals(301707, res);

        res = MethodsForTest.parsAndSum("-2147483648", null);
        assertEquals(301707, res);

    }

    @Test public void sumElementsAray(){
        //positive tests

        int[] ar = {1,2,3,4,5};

        int res = MethodsForTest.sumElementsAray(ar, 2, 3);
        assertEquals(7, res);

        int[] ar1 = {10, 20, 30, 40, 50};
        res= MethodsForTest.sumElementsAray(ar1, 0,0);
        assertEquals(20, res);

        res= MethodsForTest.sumElementsAray(ar1, 4,4);
        assertEquals(100, res);

        int[] ar2 = {0, 0, 0, 0, 0};

        res= MethodsForTest.sumElementsAray(ar2, 1,4);
        assertEquals(0, res);

        int[] ar4 = {2147483647, -2147483648, 1, 0, 0};
        res= MethodsForTest.sumElementsAray(ar4, 0,1);
        assertEquals(-1, res);

        res= MethodsForTest.sumElementsAray(ar4, 0,2);
        assertEquals(-2147483648, res);



        //negative tests
        int[] ar3 = {};
        res= MethodsForTest.sumElementsAray(ar3, 1,4);
        assertEquals(301707, res);

        res= MethodsForTest.sumElementsAray(ar, -1,4);
        assertEquals(301707, res);

        res= MethodsForTest.sumElementsAray(ar, 1,-4);
        assertEquals(301707, res);

        res= MethodsForTest.sumElementsAray(ar, 1,5);
        assertEquals(301707, res);
    }

    @Test public void concatStringArray (){
        //positive tests

        String[] ar = {"hello", "", "money", "happy", " "};
        String res = MethodsForTest.concatStringArray(ar,0,2);
        assertEquals("hellomoney", res);

        res = MethodsForTest.concatStringArray(ar,0,0);
        assertEquals("hellohello", res);

        res = MethodsForTest.concatStringArray(ar,1,2);
        assertEquals("money", res);

        res = MethodsForTest.concatStringArray(ar,3,4);
        assertEquals("happy ", res);

        res = MethodsForTest.concatStringArray(ar,4,3);
        assertEquals(" happy", res);


        //negative tests

        res = MethodsForTest.concatStringArray(null,1,2);
        assertNull(res);

        res = MethodsForTest.concatStringArray(ar,0,5);
        assertNull(res);

        String[] ar1 = {};

        res = MethodsForTest.concatStringArray(ar1,1,4);
        assertNull(res);

        String[] ar2 = {"\0", "\0", "bye"};

        res = MethodsForTest.concatStringArray(ar,-1,2);
        assertNull(res);

        String[] ar3 = {null, "bye", "life", "\n"};

        res = MethodsForTest.concatStringArray(ar3,0,2);
        assertNull(res);

        String[] ar4 = {null, "bye", "life"};

        res = MethodsForTest.concatStringArray(ar4,0,2);
        assertNull(res);
    }
}
