package Java1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        guessTheNum();
        guessTheWord();
    }


    //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    public static void guessTheNum() {
        System.out.println("Угадайте число от 0 до 10: ");
        int x,y;
        Random rand = new Random();
        y = rand.nextInt(10);
        System.out.println(y);
        int i=1;
            do {

                System.out.print("Введите число: ");
                    x = sc.nextInt();
                    if (x == y) {
                        System.out.println("Вы угадали!");
                        break;
                    } else if (x < y) {
                        System.out.println("Загаданное число больше!");
                        i++;
                    } else {
                        System.out.println("Загаданное число меньше!");
                        i++;
                    }
                    ;
                    if (1<i && i < 4) {

                        System.out.println("Продолжаем (1 - да, 0 - нет)? ");
                        int z = sc.nextInt();
                        System.out.println("Попытка " +i);
                        System.out.println();
                        if (z == 0) break;

                    };
            } while (i!=4);


            System.out.println("Игра завершена. ");


    }
    public static void guessTheWord ()
    {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

String i = getRandom(words);
        System.out.println(i);
        System.out.print("Введите слово: ");
        String j = sc.next();
        if (i.equals(j)){
            System.out.println("Вы угадали. ");
        }
        else {equalString(i,j);};




    }
    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static void equalString (String s1, String s2) {
        int minLen= Math.min(s1.length(),s2.length());
        for (int i = 0; i <minLen ; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                System.out.print(s1.charAt(i));}
                        else {
                System.out.print("*");
            }
        }

       for (int k = minLen; k <20; k++) {
           System.out.print("*");
       }
    }

}
