import java.util.Scanner;

public class Main {
    public static String operand;
    public static Scanner scanner;
    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("Вход");
        operand = scanner.nextLine();
        System.out.println("Выxoд");
        Converter converter = new Converter();
        String [] line = operand.split("[+\\-*/]");
       if (line.length >2){
           throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
       }
        if (line.length ==1){
            throw new RuntimeException("строка не является математической операцией");
        }
        if (converter.isRoman(line[0]) != converter.isRoman(line[1])){
            throw new Exception("используются одновременно разные системы счисления");
        }
         int a,b;
         boolean isRoman = converter.isRoman(line[0]);
         if (isRoman){
             a = converter.romanToInt(line[0]);
             b = converter.romanToInt(line[1]);
         }else {
             a = Integer.parseInt(line[0]);
             b = Integer.parseInt(line[1]);
         }if (a> 10 || b > 10 || a<1 || b<1){
             throw new RuntimeException("На вход больше 10 и меньше 1 нельзя ");
        }
          int result = 0;
        if (operand.contains("+")){
            result = a+b;
        }else if (operand.contains("-")){
            result = a-b;
        }else if (operand.contains("*")){
            result = a*b;
        }else if (operand.contains("/")){
            result = a/b;
        }
        if (isRoman && result<0){
            throw new RuntimeException("В римской системе нет отрицательных чисел ");
        }if (isRoman && result == 0){
            throw new RuntimeException("В римской системе нет числа 0");
        }if (isRoman){
            System.out.println(converter.intToRoman(result));
        }else {
            System.out.println(result);
        }

    }
}