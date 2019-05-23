package Java1.lesson4;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int SIZE = 3;
    //    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победитель!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }


    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("input koord X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
//        if(map[y][x]==DOT_EMPTY){
//            return true;
//        }else{
//            return false;
//        }
    }

    public static void aiTurn() {
        int x, y;

        do {

            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        int k = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    k++;
                }
            }
        }
        return k == 0;
    }

    public static boolean checkWin(char symbol) {
        int vertical, horizontal;
        int diagonal = 0;
        int pobochnayaDiagonal = 0;


        for (int i = 0; i < SIZE; i++) {
            horizontal = 0;
            vertical = 0;
            for (int j = 0; j < SIZE; j++) {
                //tested horizontal check
                if (map[i][j] == symbol) {
                    horizontal++;
                    if (horizontal == SIZE) return true;
                }

                //tested vertical check
                if (map[j][i] == symbol) {
                    vertical++;
                    if (vertical == SIZE) return true;
                }
            }

            // tested diagonal A "\" check
            if (map[i][i] == symbol) {
                diagonal++;
                if (diagonal == SIZE) return true;
            } else diagonal = 0;

            // tested diagonal B "/" check
            if (map[i][SIZE - 1 - i] == symbol) {
                pobochnayaDiagonal++;
                if (pobochnayaDiagonal == SIZE) return true;
            } else pobochnayaDiagonal = 0;
        }
        return false;

    }

}