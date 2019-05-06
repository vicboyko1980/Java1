package Java1.lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class javaOneLessonTwo {

    public static void main(String[] args) {
        // lessTwoPointOne();
        //  lessTwoPointTwo ();
        //lessTwoPointThree();
        //lessTwoPointFour();
       // lessTwoPointFive();
        int[] arr = {100,200,300,400,500};
        modifyArray(arr, -2);

    }

    public static void lessTwoPointOne() {
        System.out.println("Задать целочисленный массив, состоящий из элементов 0 и 1.\nС помощью цикла и условия заменить 0 на 1, 1 на 0");
        System.out.println();
        int arr[] = {1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1};
        System.out.println("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");

        }

        System.out.println();

        System.out.println("Массив после замены '0 на 1' : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;

            System.out.print(arr[i] + " ");

        }
        System.out.println();

    }

    public static void lessTwoPointTwo() {
        System.out.println();
        System.out.println("Задать пустой целочисленный массив размером 8.\nС помощью цикла заполнить его значениями");
        System.out.println();
        int arr[] = new int[8];
        int j = 0;
        for (int i = 0; i < 8; i++) {
            arr[i] = j;
            j = j + 3;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            //System.out.println(Arrays.toString(arr[i]));
        }

    }

    public static void lessTwoPointThree() {
        System.out.println();
        System.out.println("Задать массив пройти по нему циклом, и числа меньшие 6 умножить на 2");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void lessTwoPointFour() {
        System.out.println();
        System.out.println("Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),\n и с помощью цикла(-ов) заполнить его диагональные элементы единицами");
        int arr[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if((i==j) || (i==4-1-j)) {
                  arr [i][j]=1;

                }

            }

        }
        printArr(arr);

       // System.out.println(Arrays.toString(arr));
    }

    public static void  lessTwoPointFive () {
        System.out.println();
        System.out.println("Задать одномерный массив и найти в нем минимальный и максимальный элементы");
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n =sc.nextInt();
        int[] arr = new int[n];

        Random rand = new Random();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] =rand.nextInt()/1000000;

        }
        int min  = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }

        for (int i = 0; i <arr.length ; i++) {
        if (arr[i]> max) max=arr[i];
        if (arr[i]<min) min=arr[i];
        }
        System.out.println();
        System.out.print("min: " + min);
        System.out.print(" max: " + max);
        System.out.println();
    }


    public static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }
    }

    static void modifyArray(int[] arr, int n) {
        System.out.print("BEFORE: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.print("(n = " + n + ")");

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                // Right
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                // Left
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }

        System.out.print("\nAFTER:  ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
