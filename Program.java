public class Program {

    static String arr_num_1[][] = {{"0",""},{"1","one"},{"2","two"},{"3","three"},{"4","four"},{"5","five"},{"6","six"},{"7","seven"},{"8","eight"},{"9","nine"},};
    static String arr_num_2[][] = {{"2","twenty"},{"3","thirty"},{"4","forty"},{"5","fifty"},{"6","sixty"},{"7","seventy"},{"8","eighty"},{"9","ninety"},};
    static String arr_num_3[][] = {{"11","eleven"},{"12","twelve"},{"13","thirteen"},{"14","fourteen"},{"15","fifteen"},{"16","sixteen"},{"17","seventeen"},{"18","eighteen"},{"19","nineteen"},};

	//Решение Джунусова Азамата.
	// под классами числа понимаются: класс миллиардов, класс миллионов, класс  тысяч, класс единиц.
	// под разрядом числа понимается: сотни, десятки, единицы. 

    public static void main(String[] args) {
        // 2_147_483_647 max int value
        int n = 0;
        n = 1_117_483_647;	// первый тест
        System.out.println(n +" -> "+ ConvertNumberToString(n));
        n = 17_483_647;		// второй тест
        System.out.println(n +" -> "+  ConvertNumberToString(n));
        n = 483_647;		// третий тест
        System.out.println(n +" -> "+  ConvertNumberToString(n));
        n = -2_117_483_647; // четвертый тест
        System.out.println(n +" -> "+  ConvertNumberToString(n));
	}// main
    //##################################################################################################
//##################################################################################################
    public static String ConvertNumberToString(int n){// формируем классы числа

        if (2_117_483_647 >=n && 1 <= n ) {
            String result = null;
            String str_num = String.valueOf(n); // переводим целочисленное значение в строку
            char array_ch[] = str_num.toCharArray();// сохраняем строку в массив типа char
            String array_classes[] = new String[12];// создаем строковый массив для хранения числовых значений
            // для последующего распределения по классам:  billion_class,million_class,thousand_class,unit_class
            int len_ch = array_ch.length;
            for (int i1 = 0; i1 < array_classes.length; i1++) {
                array_classes[i1] = "0";
            }// обнуляем строковый массив

            for (int i1 = array_classes.length - 1; i1 >= 0; i1--) {// присваем значения строковому массиву
                array_classes[i1] = String.valueOf(array_ch[--len_ch]);
                if (len_ch == 0) break;
            }

            String billion_class = ""; // класс миллиардов
            String million_class = ""; // класс миллионов
            String thousand_class = ""; // класс тысяч
            String unit_class = "";	// класс единиц

            int count_1 = 0;
            int count_2 = 0;
            for (String i1 : array_classes) {// формируем классы числа
//            System.out.print(i1 + " ");
                if (count_1 != 0 && count_1 % 3 == 0) {
                    count_2++;
                }
                if (count_2 == 0) {
                    billion_class += i1;
                } else if (count_2 == 1) {
                    million_class += i1;
                } else if (count_2 == 2) {
                    thousand_class += i1;
                } else if (count_2 == 3) {
                    unit_class += i1;
                }
                count_1++;
            }

            if (false) {// тест - проверка присвоения значений номеру класса 
                System.out.println(billion_class + " billion");
                System.out.println(million_class + " million");
                System.out.println(thousand_class + " thousand");
                System.out.println(unit_class + " unit");
            }

            StringBuffer sb = new StringBuffer();
            sb.append(digit_rank_fun(billion_class, "billion"));// класс миллиардов
            sb.append(digit_rank_fun(million_class, "million"));// класс миллионов
            sb.append(digit_rank_fun(thousand_class, "thousand"));// класс тысяч
            sb.append(digit_rank_fun(unit_class, ""));// класс единиц
//        System.out.println(sb.toString().trim());
            result = sb.toString().trim();
            sb.delete(0, sb.length());
            return result;
        }else
            return "введите положительное число от 1 до 2_117_483_647";
    }

    public static String digit_rank_fun(String str_1, String rank){// формируем разряды числа
        String result = null;
        char[] array_result = str_1.toCharArray();
        String st_1 = String.valueOf(array_result[0]);// сотни
        String st_2 = String.valueOf(array_result[1]);// десятки
        String st_3 = String.valueOf(array_result[2]);// единицы

        if (false){
            System.out.print(st_1);
            System.out.print(st_2);
            System.out.println(st_3);}

        StringBuffer SB = new StringBuffer(3);
        if (str_1.matches("[0-9][0][0-9]")){
            hundred_fun(st_1,SB);
            tens_and_units_fun(st_2, st_3, SB);
        }else
        if (str_1.matches("[0-9][1][0-9]")){
            hundred_fun(st_1,SB);
            tens_and_units_fun(st_2, st_3, SB);
        }else
        if (str_1.matches("[0-9][2-9][0-9]")) {
            hundred_fun(st_1,SB);
            tens_and_units_fun(st_2, st_3, SB);
        }
        SB.append(" ").append(rank);

        result = SB.toString();
        SB.delete(0,SB.length());

        if (st_1.equals("0") && st_2.equals("0") &&  st_3.equals("0")) // если разряды сотен, десятков и единиц равны нулю, то возвращаем пустую строку
            result = "";

        return result;
    }
    public static void hundred_fun(String st_1, StringBuffer SB){// формируем сотни разряда
        if(!st_1.equals("0"))
            for (int i1 = 0; i1 < arr_num_1.length; i1++) {
                if (st_1.equals(arr_num_1[i1][0])){
                    SB.append(" ").append(arr_num_1[i1][1]).append(" hundred");
                }
            }
    }
    public static void tens_and_units_fun(String st_2, String st_3, StringBuffer SB){// формируем десятки и единицы разряда
        if(st_2.equals("1")){// если в десятках разряда есть единица, то прогоняем по массиву arr_num_3[][] без присоединения единиц
            st_2 = st_2 + st_3;
            for (int i1 = 0; i1 < arr_num_3.length; i1++) {
                if (st_2.equals(arr_num_3[i1][0])){
                    SB.append(" ").append(arr_num_3[i1][1]);
                }
            }
        }else{// иначе прогоняем по массивам десятков и единиц: arr_num_2[][] и arr_num_1[][]
            for (int i1 = 0; i1 < arr_num_2.length; i1++) {
                if (st_2.equals(arr_num_2[i1][0])){
                    SB.append(" ").append(arr_num_2[i1][1]);
                }
            }
            for (int i1 = 0; i1 < arr_num_1.length; i1++) {
                if (st_3.equals(arr_num_1[i1][0])){
                    SB.append(" ").append(arr_num_1[i1][1]);
                }
            }
        }
    }
}
