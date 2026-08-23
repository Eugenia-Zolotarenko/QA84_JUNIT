import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
    @CsvSource(nullValues = {"null"},
            value ={                 //negative tests
            "'' , 45",
            "767, ''",
            "null, -45",
            "-2147483648, null"
    })

    public void parsAndSumNull (String s1, String s2) {
        Integer actualResult = MethodsForTest.parsAndSum(s1, s2);
        assertNull(actualResult);
    }

    @ParameterizedTest
    // Формат: s1, s2
    @CsvSource({  //negative tests
            "2147483648, 2147483647",
            "8, 21434645737384384686487483647",
            "8, -2147483649",
            "hello, 45",
            "45, FIFA2026",
            "40years, 34",
            "8600, 3.4",
            "'8,600', 34"
    })
    public void parsAndSumNumberFormatException (String s1, String s2) {
       assertThrows(NumberFormatException.class, ()-> {MethodsForTest.parsAndSum(s1,s2);} );
    }


    //1. Метод-источник данных. Он должен быть static и возвращать Stream<Arguments>
    static Stream<Arguments> provideArraysAndIndices(){
        return Stream.of(
                // Формат: Arguments.of(массив, индекс_1, индекс_2, ожидаемый_результат)
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 0,4, -57),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 0, 3, 23),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 1, 3, 33),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 2, 5, 0),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 3, 1, 33),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 1, 1, 18),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 2, 3, 24),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 4, 5, -56),
                Arguments.of(new int[]{-1, 9,0, 24,-56,0, Integer.MAX_VALUE}, 4, 5, -56)
        );
    }
    // 2. Сам тест, который принимает массив, два индекса и ожидаемый результат
    @ParameterizedTest
    @MethodSource("provideArraysAndIndices")
    void sumElementsAray(int[] array,
                                int indexFirst,
                                int indexSecond,
                                int expectedSum){
        int res = MethodsForTest.sumElementsAray(array,indexFirst,indexSecond);
        assertTrue(res==expectedSum);
    }

    static Stream<Arguments> provideArraysNullAndIndices(){
        int[] arr = new int[] {-1, 9,0, 24,-56,0, Integer.MAX_VALUE};
        return Stream.of(
                // Формат: Arguments.of(массив, индекс_1)
                Arguments.of(new int[] {}, 4,5),
                Arguments.of(arr, 4,9),
                Arguments.of(arr, -4,5),
                Arguments.of(arr, 9,5),
                Arguments.of(arr, 4, arr.length),
                Arguments.of(arr, arr.length, 4)
        );
    }
    @ParameterizedTest
    @MethodSource("provideArraysNullAndIndices")
    void sumElementsArayNull(int[] array,
                         int indexFirst,
                         int indexSecond){
        Integer res = MethodsForTest.sumElementsAray(array, indexFirst, indexSecond);
        assertNull(res);
    }
}
