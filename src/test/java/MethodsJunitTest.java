import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MethodsJunitTest {

    public static boolean isPalindrome(String s){
        if (s==null || s.isBlank())
            return false;

        s = s.replace(" ","");
        s = s.replace("!","");
        s = s.replace("?","");
        if(s.length() == 1)
            return false;

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();
        return s.equalsIgnoreCase(rev);
    }

    public static String insertFrom(String s, int index, String ins){
        StringBuilder sb = new StringBuilder(s);
        sb.insert(index,ins);
        return sb.toString();

    }

    @Test

    void testIsPalindrome(){

        //positive tests
        boolean res = MethodsJunitTest.isPalindrome("level");
        assertTrue(res);

        res = MethodsJunitTest.isPalindrome(" level  ");
        assertTrue(res);

        res = MethodsJunitTest.isPalindrome("LeVel");
        assertTrue(res);

        res = MethodsJunitTest.isPalindrome("242");
        assertTrue(res);

        res = MethodsJunitTest.isPalindrome("5level5");
        assertTrue(res);

        res = MethodsJunitTest.isPalindrome("Name now one man?");
        assertTrue(res);

        res = MethodsJunitTest.isPalindrome("Name now one man!");
        assertTrue(res);

        res = MethodsJunitTest.isPalindrome("\"Name now one man\"");
        assertTrue(res);

        //negative test

        res = MethodsJunitTest.isPalindrome(null);
        assertFalse(res);

        res = MethodsJunitTest.isPalindrome("");
        assertFalse(res);

        res = MethodsJunitTest.isPalindrome("   ");
        assertFalse(res);

        res = MethodsJunitTest.isPalindrome("hello");
        assertFalse(res);

        res = MethodsJunitTest.isPalindrome("1234");
        assertFalse(res);

        res = MethodsJunitTest.isPalindrome("Level_");
        assertFalse(res);
        res = MethodsJunitTest.isPalindrome("Level_");
        assertFalse(res);
    }

    @Test
    public void testInsertFrom(){
        String res =  MethodsJunitTest.insertFrom("Hello", 5, " world");
        assertEquals("Hello world", res);

        res =  MethodsJunitTest.insertFrom("world", 0, "Hello ");
        assertEquals("Hello world", res);

        //fail("Not yet implemented");
    }

}

/*
1. class MethodsForTest

public static int parsAndSum (String s1, String s2){
return 0}

s1-> "12";
s2-> "3"

s1 convert to int : Integer.parseInt(s1)
s2 convert to int : Integer.parseInt(s2)
12 + 3 = 15
return 15

in case any error:
null, empty string(spaces) or no numbers in s1/s2
return 0;

create tests!
than
create method


 */
