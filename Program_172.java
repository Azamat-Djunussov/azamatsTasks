package matem2.task_172;

public class Program_172 {
    static int total = 0;
    public static void main(String[] args) {
// смысл решения заключается в следующем;
// 1) создаем эталонный массив расположения ферзей размером 8х8;
// 2) в зависимости от размера доски присеваем в соответствии с заданными значениями эталонный массив новому массиву, который также является эталонным;
// 3) новый эталонный массив загружаем в массив-матрицу;
// 4) в массиве-матрице отсеиваем все варианты, которые имеют две и более единицы(Ферзя) по всем вертикальным линиям;
// 5) в массиве-матрице отсеиваем все варианты, которые имеют две и более единицы(Ферзя) по всем диагональным линиям;
// 6) делаем выборку вариантов отсеенного массива-матрицы в зависимости от количества единиц(ферзей) в матрице, на которых единицы не пересекаются.
// 7) подсчитываем уникальные случаи расположения непересекающихся ферзей, количество всевозможных различных решений для заданного N.

        System.out.println("Output: "+GetQueenCombination(1, "1x1", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(2, "2x2", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(3, "3x3", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(4, "4x4", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(5, "5x5", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(5, "7x7", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(7, "6x6", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(0, "7x7", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
        System.out.println("Output: "+GetQueenCombination(8, "8x8", "OFF"));// 3x3,4x4,5x5,6x6,7x7,8x8
//        System.out.println("Output: "+GetQueenCombination(5, "5x5", "ON"));// 3x3,4x4,5x5,6x6,7x7,8x8
//        System.out.println("Output: "+GetQueenCombination(8, "8x8", "ON"));// 3x3,4x4,5x5,6x6,7x7,8x8

    }//main

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static int GetQueenCombination(int n, String NxN, String monitoring){
        if (n <= 0  || n >8 )return 0;
        total=0;
        int number_of_queens = n;
        boolean flags[] = new boolean[8];
        int array[][];
        array = fun_reference_array(NxN,flags);


        if (false) {
            for (boolean i1 : flags) {
                System.out.println(i1);
            }
            show_array(array);
        }

        int matrix_array[][] = new int[array.length-1][array[0].length];
        fun_initiation_array_1(matrix_array,  0);
        if (false)show_array(matrix_array);

        int matrix_diagonal_array[][] = new int[array.length-1][array[0].length+array[0].length-1];
        //fun_initiation_array(matrix_diagonal_array,  0);
        //if (false)show_array(matrix_diagonal_array);

        if (true)
            if (flags[0])for (int i1 = 0; i1 < array.length; i1++) {
                if (!flags[1]) if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1)) continue;
            if (flags[1])for (int i2 = 0; i2 < array.length; i2++) {
                if (!flags[2])if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1,i2)) continue;
            if (flags[2])for (int i3 = 0; i3 < array.length; i3++) {
                if (!flags[3])if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1,i2,i3)) continue;
            if (flags[3])for (int i4 = 0; i4 < array.length; i4++) {
                if (!flags[4])if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1,i2,i3,i4)) continue;
            if (flags[4])for (int i5 = 0; i5 < array.length; i5++) {
                if (!flags[5]) if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1,i2,i3,i4,i5)) continue;
            if (flags[5])for (int i6 = 0; i6 < array.length; i6++) {
                if (!flags[6]) if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1,i2,i3,i4,i5,i6)) continue;
            if (flags[6])for (int i7 = 0; i7 < array.length; i7++) {
                if (!flags[7]) if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1,i2,i3,i4,i5,i6,i7)) continue;
            if (flags[7])for (int i8 = 0; i8 < array.length; i8++) {
                if (total_function(monitoring,number_of_queens,array,matrix_array,matrix_diagonal_array,i1,i2,i3,i4,i5,i6,i7,i8)) continue;
            }}}}}}}}
        //System.out.println(total);
        return total;

    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static int [][]fun_reference_array(String NxN,boolean flags[]){
        int buffer_array[][];
        int length_array = 0;
        int reference_array[][] = {
            {0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0},
            {0,0,0,1,0,0,0,0},
            {0,0,0,0,1,0,0,0},
            {0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,1},
        };

        for (int i1 = 0; i1 < flags.length; i1++) {
            flags[i1] = true;
        }

        switch (NxN){
            case "8x8":length_array = 8; break;
            case "7x7":length_array = 7; flags[7] = false; break;
            case "6x6":length_array = 6; flags[7] = false;flags[6] = false; break;
            case "5x5":length_array = 5; flags[7] = false;flags[6] = false;flags[5] = false; break;
            case "4x4":length_array = 4; flags[7] = false;flags[6] = false;flags[5] = false;flags[4] = false; break;
            case "3x3":length_array = 3; flags[7] = false;flags[6] = false;flags[5] = false;flags[4] = false;flags[3] = false; break;
            case "2x2":length_array = 2; flags[7] = false;flags[6] = false;flags[5] = false;flags[4] = false;flags[3] = false;flags[2] = false; break;
            case "1x1":length_array = 1; flags[7] = false;flags[6] = false;flags[5] = false;flags[4] = false;flags[3] = false;flags[2] = false;flags[1] = false; break;
        }

        buffer_array = new int[length_array+1][length_array];
        for (int i1 = 0; i1 < buffer_array.length; i1++) {
        for (int i2 = 0; i2 < buffer_array[i1].length; i2++) {
            buffer_array[i1][i2] = reference_array[i1][i2];
        }}

        return buffer_array;
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static boolean total_function(String monitoring, int number_of_queens,int array[][],int matrix_array[][],int matrix_diagonal_array[][], int ... i_x){
        int conuter=0;
        for (int i1 :i_x) {
            matrix_array[conuter++] = array[i1];
        }
        if (fun_compare_arrays_1(matrix_array,false))return true;//continue;// вертикальный поиск дубликатов единицы
        //----------------------
            fun_initiation_array_1(matrix_diagonal_array, 0);// инициализируем массив
            fun_diagonal_initiation_array(matrix_array, matrix_diagonal_array, "с_права_на_лево");//с_права_на_лево с_лево_на_право
            if (false) show_array(matrix_diagonal_array);
        if (fun_compare_arrays_1(matrix_diagonal_array,true)) return true; //continue;// если совпадение по диагноали, то продолжаем
        //----------------------
            fun_initiation_array_1(matrix_diagonal_array, 0);// заново инициализируем массив
            fun_diagonal_initiation_array(matrix_array, matrix_diagonal_array, "с_лево_на_право");//с_права_на_лево с_лево_на_право
            if (false) show_array(matrix_diagonal_array);
        if (fun_compare_arrays_1(matrix_diagonal_array,true)) return true;//continue;// если совпадение по диагноали, то продолжаем
        //----------------------
        if (!fun_count_number_of_queens(matrix_diagonal_array,number_of_queens))return true;//continue;//

        if (monitoring.equals("ON")) {
            show_array(matrix_array);
            System.out.println("----------------------------");
        }
            total++;
            return false;
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static boolean fun_count_number_of_queens(int matrix_diagonal_array[][], int number_of_queens){// ищем количество ферзей и сопоставляем с заданным значением
        int count = 0;
        for (int i1[]:matrix_diagonal_array) {
            for (int i2:i1) {
                if (i2==1)
                    count++;
            }
        }

        if (count == number_of_queens)
        return true;
        return false;
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static boolean fun_compare_arrays_1(int matrix_diagonal_array[][], boolean edges){
        int count = 0;
        int edge;
        if (edges){ edge = 1;
        }else {     edge = 0;}
        for (int i1 = edge; i1 < matrix_diagonal_array[0].length-edge; i1++) {// не трогаем края при поиске, так как выпадение ед. равна одному разу
            count = 0;
            for (int i2 = 0; i2 < matrix_diagonal_array.length; i2++) {
                if (matrix_diagonal_array[i2][i1] == 1){
                    count++;
                }
            }
            if (count>=2)// если по диагонали встретились хотя бы две и более единицы
            return true;
//            System.out.println(count);

        }
        return false;
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static void fun_diagonal_initiation_array(int matrix_array[][], int matrix_diagonal_array[][], String LR){
        boolean flag = false;
        int matrix_diagonal_array_length = matrix_diagonal_array[0].length;
        int matrix_array_length = matrix_array[0].length;
        int count = 0;

            for (int i1 = 0; i1 < matrix_diagonal_array.length; i1++) {
                if (LR.equals("с_права_на_лево")) {//с_лево_на_право
                    int count_2 = 0;
                    for (int i2 = matrix_diagonal_array_length - 1; matrix_array_length - 1 <= i2; i2--) {
                        matrix_diagonal_array[i1][i2 + count] = matrix_array[i1][i2-matrix_array_length+1];
//                        System.out.println(i2-matrix_array_length+1);
                    }
                    count--;
                }else {
                    for (int i2 = 0; i2 < matrix_array_length; i2++) {
                        matrix_diagonal_array[i1][i2+count] = matrix_array[i1][i2];
                    }
                    count++;
                }
            }
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static void fun_initiation_array_1(int array[][], int x1){
        for (int i1 = 0; i1 < array.length; i1++) {
        for (int i2 = 0; i2 < array[0].length; i2++) {
            array[i1][i2] = x1;
        }}
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    private static void show_array(int array[][]){
        for (int i1[]:array) {
            for (int i2:i1) {
                System.out.print(i2+ " ");
            }
            System.out.println();
        }
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}
