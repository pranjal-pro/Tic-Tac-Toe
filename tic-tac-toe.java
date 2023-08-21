import java.util.*;

public class TicTacToe {
    public static void print(char matrix[][]) {
        System.out.println(matrix[0][0] + "\t|\t" + matrix[0][1] + "\t|\t" + matrix[0][2]);
        System.out.println("--------|---------------|--------");
        System.out.println(matrix[1][0] + "\t|\t" + matrix[1][1] + "\t|\t" + matrix[1][2]);
        System.out.println("--------|---------------|--------");
        System.out.println(matrix[2][0] + "\t|\t" + matrix[2][1] + "\t|\t" + matrix[2][2]);
    }

    public static void input(char matrix[][], char player) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            int index = sc.nextInt();
            switch (index) {
                case 1:
                    if (matrix[0][0] == '1') {
                        matrix[0][0] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 2:
                    if (matrix[0][1] == '2') {
                        matrix[0][1] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 3:
                    if (matrix[0][2] == '3') {
                        matrix[0][2] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 4:
                    if (matrix[1][0] == '4') {
                        matrix[1][0] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 5:
                    if (matrix[1][1] == '5') {
                        matrix[1][1] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 6:
                    if (matrix[1][2] == '6') {
                        matrix[1][2] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 7:
                    if (matrix[2][0] == '7') {
                        matrix[2][0] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 8:
                    if (matrix[2][1] == '8') {
                        matrix[2][1] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                case 9:
                    if (matrix[2][2] == '9') {
                        matrix[2][2] = player;
                        return;
                    } else {
                        check = true;
                        System.out.print("Already taken Spot Re-Enter Value : ");
                    }
                    break;
                default:
                    System.out.print("INVALID INPUT Re-Enter Value : ");
                    check = true;
            }
        } while (check);
    }

    public static boolean end(char matrix[][]) {
        if (matrix[0][0] == matrix[0][1] && matrix[0][0] == matrix[0][2])
            return true;
        if (matrix[1][0] == matrix[1][1] && matrix[1][0] == matrix[1][2])
            return true;
        if (matrix[2][0] == matrix[2][1] && matrix[2][0] == matrix[2][2])
            return true;
        if (matrix[0][0] == matrix[1][0] && matrix[0][0] == matrix[2][0])
            return true;
        if (matrix[0][1] == matrix[1][1] && matrix[0][1] == matrix[2][1])
            return true;
        if (matrix[0][2] == matrix[1][2] && matrix[0][2] == matrix[2][2])
            return true;
        if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2])
            return true;
        if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0])
            return true;
        return false;
    }

    public static void play(char matrix[][]) {
        for (int i = 1; i <= 9; i++)
            if (i % 2 == 1) {
                print(matrix);
                System.out.print("Enter Index (Player 1) = ");
                input(matrix, 'X');
                if (end(matrix) == true) {
                    System.out.println();
                    print(matrix);
                    System.out.println("Player 1 Wins !!!!");
                    return;
                }
            } else {
                print(matrix);
                System.out.print("Enter Index (Player 2) = ");
                input(matrix, 'O');
                if (end(matrix) == true) {
                    System.out.println();
                    print(matrix);
                    System.out.println("Player 2 Wins !!!!");
                    return;
                }
            }
        System.out.println("DRAW !!!!!");
    }

    public static void main(String[] args) {

        System.out.println("\t\tTIC TAC TOE");
        System.out.println("Player 1 : X \t\t\tPlayer 2 : O");
        char matrix[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
        System.out.println("GET READY TO PLAY :");
        play(matrix);
    }
}
