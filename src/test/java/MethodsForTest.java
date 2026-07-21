import org.junit.jupiter.api.Test;

public class MethodsForTest {

    //TDD Test Driven Development

    public static Integer parsAndSum (String s1, String s2){

        if(s1==null || s2==null|| s1.isBlank() || s2.isBlank())
        return null;

        s1 = s1.strip();
        s2 = s2.strip();

        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }

    public static Integer sumElementsAray (int[] array,
                                           int indexFirst,
                                           int indexSecond){
        if (array == null ||array.length == 0
                || indexSecond<0 || indexFirst < 0
                ||indexFirst>=array.length
                || indexSecond>=array.length)
            return null;

        if (array[indexFirst] == Integer.MAX_VALUE && array[indexSecond]>0)
            return null;

        if (array[indexSecond] == Integer.MAX_VALUE && array[indexFirst]>0)
            return null;

        if (array[indexFirst] == Integer.MIN_VALUE && array[indexSecond]<0)
            return null;

        if (array[indexSecond] == Integer.MIN_VALUE && array[indexFirst]<0)
            return null;

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

    public static String concatWithSym(String s1, String s2, char sym){

        if(s1==null || s2 == null)
        return null;

        return s1+sym+s2;
    }

    public static String concatStrs(String[] ar1, String[] ar2, int index1, int index2){
        if(ar1==null || ar2 == null //|| ar1.length == 0 || ar2.length == 0
                // || index1 < 0 || index2 < 0                       // check with Throws:	IndexOutOfBoundsException
          || index1 >= ar1.length || index2 >= ar2.length   //the order of conditions is important
          || ar1[index1] == null || ar2[index2] == null
        )                                                 // when || ar1.length == 0 || ar2.length == 0
                                                         // place at the end of if- these conditions are always false
        return null;                                     //because when ar1.length == 0, condition index1 >= ar1.length is true
                                                        //so we can omit this conditions
        return ar1[index1] + ar2[index2];
    }

/*
which test is correct: check with Throws:IndexOutOfBoundsException
or
assertNull(res);
which test should be written before method is implemented in case of TDDп
 */


}
