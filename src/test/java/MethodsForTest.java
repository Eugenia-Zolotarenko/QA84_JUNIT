import org.junit.jupiter.api.Test;

public class MethodsForTest {

    //TDD Test Driven Development

    public static int parsAndSum (String s1, String s2){


        if(s1==null || s2==null|| s1.isBlank() || s2.isBlank())
        return 301707;

        s1 = s1.strip();
        s2 = s2.strip();

        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }

    public static Integer sumElementsAray (int[] array,
                                           int indexFirst,
                                           int indexSecond){
        if (array.length == 0 || indexSecond<0 || indexFirst < 0
           ||indexFirst>=array.length || indexSecond>=array.length)
        return 301707;

        return array[indexFirst] + array[indexSecond];
    }

    /*
              0  1  2  3  4  5   indexFirst = 2  indexSecond = 4
    array -> [9][2][7][1][4][8][][][]
    sum = 7+4

    array[indexFirst]+array[indexSecond]
     */

    public static String concatStringArray(String[] strArray,
                                           int indexFirst,
                                           int indexSecond){
        /*
        for(String s: strArray){
            if (s == null){
                return null;
            }
        }
        /проверка всего массива на null
         */

        if (strArray == null || strArray.length == 0
                || indexSecond < 0 || indexFirst<0
                ||indexFirst>=strArray.length
                ||indexSecond>=strArray.length
                ||strArray[indexFirst] == null //
                ||strArray[indexSecond] == null)
        return null;

        return strArray[indexFirst]+strArray[indexSecond];
    }

    /*
                    0       1       2        3       4
    strArray -> ["hello"]["bye"]["money"]["happy"]["life"]
    indexFirst = 1  indexSecond = 3
    return "byehappy"

     */




}
