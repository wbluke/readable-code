package cleancode.minesweeper.asis;

import java.util.Random;
import java.util.Scanner;

public class MinesweeperGame {

    private static String[][] board = new String[8][10];
    private static Integer[][] landMineCounts = new Integer[8][10];
    private static boolean[][] landMines = new boolean[8][10];
    private static int gameStatus = 0; // 0: 게임 중, 1: 승리, -1: 패배

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("지뢰찾기 게임 시작!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "□";
            }
        }
        for (int i = 0; i < 10; i++) {
            int col = new Random().nextInt(10);
            int row = new Random().nextInt(8);
            landMines[row][col] = true;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                int count = 0;
                if (!landMines[i][j]) {
                    if (i - 1 >= 0 && j - 1 >= 0 && landMines[i - 1][j - 1]) {
                        count++;
                    }
                    if (i - 1 >= 0 && landMines[i - 1][j]) {
                        count++;
                    }
                    if (i - 1 >= 0 && j + 1 < 10 && landMines[i - 1][j + 1]) {
                        count++;
                    }
                    if (j - 1 >= 0 && landMines[i][j - 1]) {
                        count++;
                    }
                    if (j + 1 < 10 && landMines[i][j + 1]) {
                        count++;
                    }
                    if (i + 1 < 8 && j - 1 >= 0 && landMines[i + 1][j - 1]) {
                        count++;
                    }
                    if (i + 1 < 8 && landMines[i + 1][j]) {
                        count++;
                    }
                    if (i + 1 < 8 && j + 1 < 10 && landMines[i + 1][j + 1]) {
                        count++;
                    }
                    landMineCounts[i][j] = count;
                    continue;
                }
                landMineCounts[i][j] = 0;
            }
        }
        while (true) {
            System.out.println("   a b c d e f g h i j");
            for (int i = 0; i < 8; i++) {
                System.out.printf("%d  ", i + 1);
                for (int j = 0; j < 10; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            if (gameStatus == 1) {
                System.out.println("지뢰를 모두 찾았습니다. GAME CLEAR!");
                break;
            }
            if (gameStatus == -1) {
                System.out.println("지뢰를 밟았습니다. GAME OVER!");
                break;
            }
            System.out.println();
            System.out.println("선택할 좌표를 입력하세요. (예: a1)");
            String input = scanner.nextLine();
            System.out.println("선택한 셀에 대한 행위를 선택하세요. (1: 오픈, 2: 깃발 꽂기)");
            String input2 = scanner.nextLine();
            char c = input.charAt(0);
            char r = input.charAt(1);
            int col;
            switch (c) {
                case 'a':
                    col = 0;
                    break;
                case 'b':
                    col = 1;
                    break;
                case 'c':
                    col = 2;
                    break;
                case 'd':
                    col = 3;
                    break;
                case 'e':
                    col = 4;
                    break;
                case 'f':
                    col = 5;
                    break;
                case 'g':
                    col = 6;
                    break;
                case 'h':
                    col = 7;
                    break;
                case 'i':
                    col = 8;
                    break;
                case 'j':
                    col = 9;
                    break;
                default:
                    col = -1;
                    break;
            }
            int row = Character.getNumericValue(r) - 1;
            if (input2.equals("2")) {
                board[row][col] = "⚑";
                boolean open = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (board[i][j].equals("□")) {
                            open = false;
                        }
                    }
                }
                if (open) {
                    gameStatus = 1;
                }
            } else if (input2.equals("1")) {
                if (landMines[row][col]) {
                    board[row][col] = "☼";
                    gameStatus = -1;
                    continue;
                } else {
                    open(row, col);
                }
                boolean open = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (board[i][j].equals("□")) {
                            open = false;
                        }
                    }
                }
                if (open) {
                    gameStatus = 1;
                }
            } else {
                System.out.println("잘못된 번호를 선택하셨습니다.");
            }
        }
    }

    private static void open(int row, int col) {
        if (row < 0 || row >= 8 || col < 0 || col >= 10) {
            return;
        }
        if (!board[row][col].equals("□")) {
            return;
        }
        if (landMines[row][col]) {
            return;
        }
        if (landMineCounts[row][col] != 0) {
            board[row][col] = String.valueOf(landMineCounts[row][col]);
            return;
        } else {
            board[row][col] = "■";
        }
        open(row - 1, col - 1);
        open(row - 1, col);
        open(row - 1, col + 1);
        open(row, col - 1);
        open(row, col + 1);
        open(row + 1, col - 1);
        open(row + 1, col);
        open(row + 1, col + 1);
    }

}
