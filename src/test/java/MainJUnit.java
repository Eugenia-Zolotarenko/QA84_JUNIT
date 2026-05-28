import static org.junit.jupiter.api.Assertions.*;

public class MainJUnit {
    public static void main(String[] args) {
        int a = 5, b = 5;
        assertTrue(a==b);
        assertFalse(a!=b);

        String s1 = "Hello", s2 = "Hello";
        assertEquals(s2, s1);

        String s3=null;
        assertNull(s3);

        fail("failed");

//        assertNotEquals(s2,s1);
//        assertNotNull(s3);




        System.out.println("the end");
    }

}


//        int a = 5, b = 3;
//        assertFalse(a == b);
//
//        System.out.println("the end");