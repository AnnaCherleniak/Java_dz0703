package lesson0703;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String s = inputString("Введите строку символов: ");
        System.out.println(palindromeString(s));

        writeStringToFile(createdString("TEST"));

        String nameFile = inputString("Введите полное название файла: ");
        System.out.println(typeFile(nameFile));
    }



    private static String inputString(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(s);
        String str = scanner.nextLine();
        return str;
    }


    //    Напишите метод, который принимает на вход строку (String) и
//    определяет является ли строка палиндромом (возвращает boolean значение)
    private static String palindromeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        String sInvert = sb.reverse().toString();
        if (s.equals(sInvert)) {
            return "Строка является палиндромом";
        } else {
            return "Строка НЕ является палиндромом";
        }
    }

//     Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
//     который запишет эту строку в простой текстовый файл, обработайте исключения.

    private static String createdString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(s);
        }
        String str = sb.toString();
        return str;
    }
    private static void writeStringToFile(String s) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("src/main/resources/Task2.txt");
            pw.print(s);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            pw.close();
        }
    }


//    Напишите метод, который определит тип (расширение) файлов из текущей папки и
//    выведет в консоль результат вида:
//        1 Расширение файла: txt
//        2 Расширение файла: pdf
//        3 Расширение файла:
//        4 Расширение файла: jpg

    private static String typeFile(String s) {
        String[] res = s.split("\\.");
        return res[1];
    }
}
