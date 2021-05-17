package matem2.task_170;
import java.util.ArrayList;
import java.util.HashMap;

public class prog_170 {
    static HashMap<String, String> PhoneDict = new HashMap<>();


    public static void main(String[] args) {
//        Backtrack("", "23");

        PhoneDict.put("2", "abc");
        PhoneDict.put("3", "def");
        PhoneDict.put("4", "ghi");
        PhoneDict.put("5", "jkl");
        PhoneDict.put("6", "mno");
        PhoneDict.put("7", "pqrs");
        PhoneDict.put("8", "tuv");
        PhoneDict.put("9", "wxyz");

        //System.out.println(PhoneDict.get("2"));
        System.out.println( GetPasswordCombinations("23"));

//        Backtrack("", "23");

    }

    private static void Backtrack(String combination, String digits){
        if (digits.length() == 0){
            result.add(combination);
            return;
        }

        // берем буквы по 1й цифре числа
        String digit = digits.substring(0, 1);
    System.out.println(digit + " <");
        String letters = PhoneDict.get(digit);
    System.out.println(letters + " <<");

        // проходим по всем буквам соот-е текущей цифре
        for (int i1 = 0; i1 < letters.length(); i1++){
            char letter = letters.charAt(i1);
            // запускаем функцию Backtrack с нашим предположением и след.цифрой
            Backtrack(combination + letter, digits.substring(1));
        }
    }
    private static ArrayList<String> result;// = new ArrayList<>();
    public static ArrayList<String>  GetPasswordCombinations(String input){
        result = new ArrayList<>();

        if (input.length() == 0){
            return result;
//            System.out.println(result.toArray());
        }

        Backtrack("", input);
        return result;
    }


}


/*
        ArrayList<String> val = new ArrayList<>(map.values());
        System.out.println(">> " + val);

        ArrayList<HashMap.Entry> entries = new ArrayList<>(map.entrySet());
        System.out.println(">>> " +entries);

        for (HashMap.Entry entry : entries) {
//            System.out.println(entry.getKey());
        }*/