package matem2.task_174;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Program_174 {

    static int count_1=0;
    static int count_2=0;
    public static void main(String[] args) {


//        String str = "zero one two three four five six seven eight nine";
        String
            str = "niseveieiszeovroesetthrfothreeurzeeewofivenneroixghtghtenne";//
            convert_to_digits(str);
            str = "zero one three four six seven nine";//
            convert_to_digits(str);
            str = "zothsfoseninevenurreeixneero";// zero one three four six seven nine
            convert_to_digits(str);
            str = "niseveieiszeovroesetthrfothreeurzeeewofivenneroixghtghtenneniseveieiszeovroesetthrfothreeurzeeewofivenneroixghtghtenne";//
            convert_to_digits(str);

    }// main
//###########################################################################################################
//###########################################################################################################
//###########################################################################################################
//###########################################################################################################
    public static String convert_to_digits(String ss){
        String output = "";
        boolean flag_1;
        ArrayList <Integer> arrayList = new ArrayList<>(20);
        // создаем массив для подсвета повтора букв из строки.
        String array_str[] = {"z","e","r","o","s","i","x","t","w","v","n","h","f","u","g",};
        String universal_array[][] = {
                // распределяем прописные цифры в соотвествии с уникальностью
                // букв в каждом слове. То есть необ-мо разграничить конкуренцию между словаами в соответсвии с приритетностью
                // по уникальности каждой буквы в слове
                // z 1 zero<-
                // x 1 six<-
                // u 1 four<-
                // g 1 eight<-
                // w 1 two<-
                //-------------------------------
                // s 2 seven<-- six   <-
                // h 2 three<-- eight <-
                // f 2 five<--  four  <-
                // v 2 five<--  seven <--
                //-------------------------------
                // r 3 zero<-   three<--    four<-
                // t 3 two<-    three<--    eight<-
                // n 3 one<---  seven<--    nine<---
                //-------------------------------
                // o 4 zero<-   one<---     two<-       four<-
                // i 4 five<--  six<-       eight<-     nine<---
                //-------------------------------
                // e 9 zero one two three five six seven eight nine/ e - худший ориентир
                //наивысший приоритет сравнения
                {"0","zero","z",null},
                {"6","six","x",null},
                {"4","four","u",null},
                {"8","eight","g",null},
                {"2","two","w",null},
                //средний приоритет сравнения
                {"7","seven","s",null},
                {"3","three","h",null},
                {"5","five","f",null},
                //низший приоритет сравнения
                {"1","one","o","n"},
                {"9","nine","n","i"},
        };

        String array_str_compare[];
        int array_int[] = new int[array_str.length];

        array_str_compare = fun_return_str_array(ss);
        //в массиве прибавляем в каждом индексе  по одной ед. в случае совпадения первого символа в строке
        // в соотвествии с последовательностями букв в массиве array_str:{"z","e","r","o","s","i","x","t","w","v","n","h","f","u","g",};
        for (int i1 = 0; i1 < array_str.length; i1++) {
            for (int i2 = 0; i2 < array_str_compare.length; i2++) {
                if (array_str[i1].equals(array_str_compare[i2])){
                    array_int[i1]+=1;
                }
            }
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//array_str = {"z","e","r","o","s","i","x","t","w","v","n","h","f","u","g",};
        String str_small_array[] = new String[0];
        if (true)
        z0:do {
            z1: for (int i1 = 0; i1 < universal_array.length; i1++) {
                count_1=0;count_2=0;
                //----------------
                flag_1 = false;
                for (int i2:array_int) {
                    if (i2 > 0) flag_1 = true;
                }
                if (!flag_1)break z1;
                fun_str_match(array_int,array_str,universal_array,i1);// сопоставляем буквы из universal_array с array_str
/////////////////////////////////////////////////////////////////////////////////////////////////////////
                flag_1 = false;
                if (count_2 == 2){
                    str_small_array = fun_return_str_array(universal_array[i1][1]);
                    flag_1=true;
                }else
                if (count_1 == 1){
                    str_small_array = fun_return_str_array(universal_array[i1][1]);
                    flag_1=true;
                }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
                if (flag_1)
                    arrayList.add(Integer.valueOf(universal_array[i1][0]));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//array_str = {"z","e","r","o","s","i","x","t","w","v","n","h","f","u","g",};

                if (flag_1){
                int index = 0;
                //индексированный поиск
                    for (int i3 = 0; i3 < str_small_array.length; i3++) {
                        index = 0;
                        switch (str_small_array[i3]){
                            case "z": index = 0;break ;
                            case "e": index = 1;break ;
                            case "r": index = 2;break ;
                            case "o": index = 3;break ;
                            case "s": index = 4;break ;
                            case "i": index = 5;break ;
                            case "x": index = 6;break ;
                            case "t": index = 7;break ;
                            case "w": index = 8;break ;
                            case "v": index = 9;break ;
                            case "n": index = 10;break ;
                            case "h": index = 11;break ;
                            case "f": index = 12;break ;
                            case "u": index = 13;break ;
                            case "g": index = 14;break ;
                        }

                        if (array_str[index].equals(str_small_array[i3])) {
                            array_int[index] -= 1;
                        }
                    }
                }

/////////////////////////////////////////////////////////////////////////////////////////////////////////
            }// i1
            flag_1 = true;
            for (int i1:array_int) {
                if (i1 > 0) flag_1 = false;
            }

        }while (!flag_1);
            Integer arr_sort[] = new Integer[arrayList.size()];
            arr_sort = arrayList.toArray(arr_sort);
            arrayList.clear();
            Arrays.sort(arr_sort);
            for (int i1:arr_sort) {
                output += i1;
            }
            System.out.println(output);
            return output;
    }

    public static void fun_str_match(int array_int[], String array_str[],String universal_array[][], int i1){
        for (int i2 = 0; i2 < array_str.length; i2++) { //
//                System.out.println(array_int[i2] + " <> "+ array_str[i2]);
            if (array_int[i2] == 0)continue;
            if (universal_array[i1][3] != null ) {
                if (universal_array[i1][2].equals(array_str[i2]) || universal_array[i1][3].equals(array_str[i2])) {
                    count_2++;
                }
            }else{
                if (universal_array[i1][2].equals(array_str[i2])){
                    count_1++;
                }
            }
            if (count_1 == 1 || count_2 == 2) break;
        }
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public static String[] fun_return_str_array(String ss){
        int count = 0;
        char ch[] = ss.toCharArray();
        ArrayList<Character> AL = new ArrayList();
        for (char i1:ch){AL.add(i1);}

        String array_buffer[] = new String[AL.size()];
        for (char i1:AL) {
            array_buffer[count++] =  String.valueOf(i1);;
        }
        AL.clear();
        if (false)for (String i1:array_buffer) {
            System.out.println(i1);
        }
        return array_buffer;
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}

         /* if (false)// линейный поиск
                z3:for (int i2 = 0; i2 < array_int.length; i2++) {
                    if (array_int[i2] == 0)continue;
                    for (int i3 = 0; i3 < str_small_array.length; i3++) {
                        flag_1 = false;
                        for (String i4:str_small_array) {
                            if (i4 != null)flag_1 = true;
                        }
                        if (!flag_1)break z3;
                        if (str_small_array[i3] == null)continue;
                        System.out.println(array_int[i2]+" "+array_str[i2]+" {"+str_small_array[i3]+"} **");
                        if (array_str[i2].equals(str_small_array[i3])) {
                            array_int[i2] -= 1;
                            System.out.println(array_int[i2] + " " + array_str[i2] + " {" + str_small_array[i3] + "} *Bingo*");
                            str_small_array[i3] = null;
                        }
                        System.out.println("=================================");
                        if (array_int[i2] == 0)continue z3;
                    }// i3
                }// i2*/