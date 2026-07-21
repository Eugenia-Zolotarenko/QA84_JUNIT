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
        assertNull(res);

        res = MethodsForTest.parsAndSum("767", "");
        assertNull(res);

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
        assertNull(res);

        res = MethodsForTest.parsAndSum("-2147483648", null);
        assertNull(res);
    }

    @Test public void sumElementsAray(){
        //positive tests Lesson 29.05.2026

        int[] arr = {-1,9,0, 24,-56,0, Integer.MAX_VALUE};
        Integer res = MethodsForTest.sumElementsAray(arr, 0, 4);
        assertTrue(-57==res);

        res = MethodsForTest.sumElementsAray(arr, 0, 3);
        assertTrue(23==res);

        res = MethodsForTest.sumElementsAray(arr, 1, 3);
        assertTrue(33==res);

        res = MethodsForTest.sumElementsAray(arr, 2, 5);
        assertTrue(0==res);

        res = MethodsForTest.sumElementsAray(arr, 3, 1);
        assertTrue(33==res);

        res = MethodsForTest.sumElementsAray(arr, 1, 1);
        assertTrue(18==res);

        res = MethodsForTest.sumElementsAray(arr, 2, 3);
        assertTrue(24==res);

        res = MethodsForTest.sumElementsAray(arr, 4, 5);
        assertTrue(-56==res);

        //negative tests Lesson 29.05.2026
        res = MethodsForTest.sumElementsAray(null, 4, 5);
        assertNull(res);

        res = MethodsForTest.sumElementsAray(arr,6,1);
        assertNull(res);


        int[] arr1 = {};

        res = MethodsForTest.sumElementsAray(arr1, 4, 5);
        assertNull(res);

        res = MethodsForTest.sumElementsAray(arr, 4, 9);
        assertNull(res);

        res = MethodsForTest.sumElementsAray(arr, -4, 5);
        assertNull(res);

        res = MethodsForTest.sumElementsAray(arr, 9, 5);
        assertNull(res);

        res = MethodsForTest.sumElementsAray(arr, 4, arr.length);
        assertNull(res);

        res = MethodsForTest.sumElementsAray(arr, arr.length, 4);
        assertNull(res);


        //positive tests

        int[] ar = {1,2,3,4,5};

        res = MethodsForTest.sumElementsAray(ar, 2, 3);
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
        assertNull(res);
        res = MethodsForTest.sumElementsAray(arr, 4, 4);
        assertTrue(-112==res);


        //negative tests
        int[] ar3 = {};
        res= MethodsForTest.sumElementsAray(ar3, 1,4);
        assertNull(res);

        res= MethodsForTest.sumElementsAray(ar, -1,4);
        assertNull(res);

        res= MethodsForTest.sumElementsAray(ar, 1,-4);
        assertNull(res);

        res= MethodsForTest.sumElementsAray(ar, 1,5);
        assertNull(res);
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

    @Test public void concatWithSym(){
        //positive test

        String str1 = "hello";
        String str2 = "money";
        char sym = '#';

        String res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("hello#money", res);

        str1 = "Pneumonoultramicroscopicsilicovolcanoconiosis";
        str2 = "illness";
        sym = ':';
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("Pneumonoultramicroscopicsilicovolcanoconiosis:illness", res);

        str1 = "300000 km";
        str2 = "sec is The Speed of Light in a Vacuum";
        sym = '/';
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("300000 km/sec is The Speed of Light in a Vacuum", res);

        str1 = "A";
        str2 = "z";
        sym = '-';
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("A-z", res);

        str1 = "23";
        str2 = "67";
        sym = '+';
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("23+67", res);

        str1 = "";  //empty string
        str2 = ""; //empty string
        sym = ' '; //space
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals(" ", res);

        str1 = " ";  //space
        str2 = " "; //space
        sym = ' '; //space
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("   ", res);

        str1 = "";  //empty string
        str2 = ""; //empty string
        sym = '?'; //space
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("?", res);

        str1 = "Centaurus";
        str2 = "Nessus";
        sym = ' '; //space
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertEquals("Centaurus Nessus", res);

        //negative tests

        str1 = null;
        str2 = "dgjdtyjdt";
        sym = ']';
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertNull(res);

        str1 = "null";
        str2 = null;
        sym = 'F';
        res = MethodsForTest.concatWithSym(str1, str2, sym);
        assertNull(res);
    }

    @Test public void concatStsrs(){
        //positive tests

        String[] arStr1 = {"hello", "bye", "money", " " , null, "happy"}; //[4]space
        String[] arStr2 = {"yes", "no", "", null, "maybe"}; //[2] empty

        String res = MethodsForTest.concatStrs(arStr1, arStr2, 0,0);
        assertEquals("helloyes", res);

        res = MethodsForTest.concatStrs(arStr1, arStr2, 5,4);
        assertEquals("happymaybe", res);

        res = MethodsForTest.concatStrs(arStr1, arStr2, 2,1);
        assertEquals("moneyno", res);

        res = MethodsForTest.concatStrs(arStr1, arStr2, 1,2);
        assertEquals("bye", res);

        res = MethodsForTest.concatStrs(arStr1, arStr2, 3,1);
        assertEquals(" no", res);

        res = MethodsForTest.concatStrs(arStr1, arStr1, 2,5);
        assertEquals("moneyhappy", res);

        res = MethodsForTest.concatStrs(arStr2, arStr2, 1,1);
        assertEquals("nono", res);

        //negative tests

        String[] arStr3 = {};
        String[] arStr4 = null;

        res = MethodsForTest.concatStrs(arStr3, arStr1, 0,1); //arStr3={};
        assertNull(res);

        res = MethodsForTest.concatStrs(arStr2, arStr3, 2,1); //arStr3={};
        assertNull(res);

        res = MethodsForTest.concatStrs(arStr4, arStr1, 2,1); //arStr4 = null;
        assertNull(res);

        res = MethodsForTest.concatStrs(arStr2, arStr4, 2,1); //arStr4 = null;
        assertNull(res);

        //res = MethodsForTest.concatStrs(arStr1, arStr2, -1,1);
        //assertNull(res);

        assertThrows(IndexOutOfBoundsException.class,
                ()->{MethodsForTest.concatStrs(arStr1, arStr2, -1,1);});

//        res = MethodsForTest.concatStrs(arStr2, arStr1, 2,-1);
//        assertNull(res);
        assertThrows(IndexOutOfBoundsException.class,
                ()->{MethodsForTest.concatStrs(arStr1, arStr2, 2,-1);});

        res = MethodsForTest.concatStrs(arStr1, arStr2, arStr1.length,1);
        assertNull(res);

        res = MethodsForTest.concatStrs(arStr1, arStr2, 2, arStr2.length);
        assertNull(res);

        res = MethodsForTest.concatStrs(arStr1, arStr2, 4, 0);//arStr1[4]==null
        assertNull(res);

        res = MethodsForTest.concatStrs(arStr1, arStr2, 2, 3); //arStr2[3]==null
        assertNull(res);
    }
}


/*
Homework 29.05.2026
1.
public static String concatWithSum(String s1, String s2, char sym){}

s1-> "hello"
s2-> "money"
sym-> '#'

return "hello#money"

in case any problem, return null;

2.
public static String concatStrs(String[] ar1, String[] ar2, int index1, int index2){}

ar1->["hello"]["bye"]["money"]["happy"]

ar2->["yes"]["no"]["maybe"]


return ar1[index1]+ar2[index2];
index1==2
index2==1
result: "moneyno"
in case any problem, return null;

 */