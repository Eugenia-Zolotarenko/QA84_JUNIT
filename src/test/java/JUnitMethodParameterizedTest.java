import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitMethodParameterizedTest {
    @ParameterizedTest
    // Формат: s1, s2, expectedResult
    @CsvSource({
            //positive tests
            "1, 22, 23",
            "-1, 0, -1",
            "78, -033, 45",
            "0, 0, 0",
            "000001, 90, 91",
            "2147483647, 0, 2147483647",
            "0, -2147483648, -2147483648",
            "2147483647, 2147483647, -2",
            "7624, 766, 8390",
            "767, -678, 89"
    })

    public void parsAndSum (String s1, String s2, Integer expectedResult) {
        Integer actualResult = MethodsForTest.parsAndSum(s1, s2);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    // Формат: s1, s2
    @CsvSource({  //negative tests
            " , 45",
            "767, "
    })

    public void parsAndSum (String s1, String s2) {
        Integer actualResult = MethodsForTest.parsAndSum(s1, s2);
        assertNull(actualResult);
    }

}
