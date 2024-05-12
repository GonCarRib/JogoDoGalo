package org.example;
import java.util.LinkedList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String[][] jogo = {
            {"-", "-", "-"},
            {"-", "-", "-"},
            {"-", "-", "-"}
    };
    static String[][] posicoes = {
            {"0", "1", "2"},
            {"3", "4", "5"},
            {"6", "7", "8"}
    };
    static boolean vezX = false;

    static int size = 2;
    static Scanner myObj = new Scanner(System.in);
    static int rown, coln;
    static int turnos = 0;


    public static void main(String[] args) {
        //minMax(jogo);
        umJogador(jogo, posicoes, myObj);
    }

    static void doisJogadores(String[][] arr, String[][] pos, Scanner scan) {
        printarr(pos);
        System.out.println();
        printarr(arr);

        Integer temp = null;
        while (temp == null) {
            temp = fimDeJogo();
            int jogada = scan.nextInt();
            encPos(jogada);
            if (!jaExiste()) {
                if (vezX) {
                    jogo[rown][coln] = "X";
                    vezX = false;
                } else {
                    jogo[rown][coln] = "O";
                    vezX = true;
                }
                printarr(pos);
                System.out.println();
                printarr(arr);
            } else {
                System.out.println("Numero ja foi selecionado");
            }
        }
    }

    static void umJogador(String[][] arr, String[][] pos, Scanner scan) {
        Integer temp = null;
        while (temp == null) {

            printarr(pos);
            System.out.println();
            printarr(arr);
            System.out.println();

            temp = fimDeJogo();

            if (vezX) {
                int jogada = scan.nextInt();
                encPos(jogada);
                if (!jaExiste()) {
                    jogo[rown][coln] = "X";
                    vezX = false;
                } else {
                    System.out.println("Número já foi selecionado");
                }
            } else {
                bestMove();
                vezX = true;
            }
            turnos = turnos +1 ;
        }
    }

    static void printarr(String[][] arr) {
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean jaExiste() {
        if (jogo[rown][coln].equals("-")) {
            return false;
        }
        return true;
    }

    public static void encPos(int x) {
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (posicoes[i][j].equals(String.valueOf(x))) {
                    rown = i;
                    coln = j;
                }
            }
        }
    }
    /*private static String[][] transformar(String[][] jogo) {
        String[][] temp = {{"-", "-", "-"},{"-", "-", "-"},{"-", "-", "-"}};
        for (int i = 0; i <= 2; ++i) {
            for (int j = 0; j <= 2; ++j) {
                temp[i][j] = jogo[i][j];
            }
        }
        return temp;
    }*/

    public static Integer fimDeJogo() {
        // 1 = O ganhou
        // 0 = Empate
        // -1 = X ganhou
        for (int i = 0; i <= size; ++i) {
            if (jogo[0][i].equals("X") && jogo[1][i].equals("X") && jogo[2][i].equals("X")) {
                System.out.println("X Ganhou! na vertical");
                return -1;
            }
            if (jogo[0][i].equals("O") && jogo[1][i].equals("O") && jogo[2][i].equals("O")) {
                System.out.println("O Ganhou! na vertical");
                return 1;
            }
        }
        for (int i = 0; i <= size; ++i) {
            if (jogo[i][0].equals("X") && jogo[i][1].equals("X") && jogo[i][2].equals("X")) {
                System.out.println("X Ganhou! na horizontal");
                return -1;
            }
            if (jogo[i][0].equals("O") && jogo[i][1].equals("O") && jogo[i][2].equals("O")) {
                System.out.println("O Ganhou! na horizontal");
                return 1;
            }
        }

        if ((jogo[0][0].equals("X") && jogo[1][1].equals("X") && jogo[2][2].equals("X")) || (jogo[0][2].equals("X") && jogo[1][1].equals("X") && jogo[2][0].equals("X")) ){
            System.out.println("X Ganhou na diagonal!");
            return -1;
        }
        if ((jogo[0][0].equals("O") && jogo[1][1].equals("O") && jogo[2][2].equals("O")) || (jogo[0][2].equals("O") && jogo[1][1].equals("O") && jogo[2][0].equals("O"))){
            System.out.println("O Ganhou na diagonal!");
            return 1;
        }
        if (turnos > 8){
            System.out.println("Empate!");
            return 0;
        }
        return null;
    }



    public static void bestMove(){
        int bestScore = -10000;
        rown = -1;
        coln = -1;

        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (jogo[i][j].equals("-")){
                    jogo[i][j] = "O";
                    int score = minimax(jogo,0,false);
                    jogo[i][j] = "-";
                    if(score > bestScore){
                        bestScore = score;
                        rown = i;
                        coln = j;
                    }
                }
            }
        }
        jogo[rown][coln] = "O";
    }


    public static int minimax(String[][] atual, int depth, boolean isMaxi){
        Integer resultado = fimDeJogo();

        if (resultado != null) {
            return resultado;
        }

        int bestScore;
        if(isMaxi){
            bestScore = -11;
            for (int i = 0; i <= size; ++i) {
                for (int j = 0; j <= size; ++j) {
                    if (atual[i][j].equals("-")){
                        atual [i][j] = "O";
                        int score = minimax(atual,depth+1,false);
                        atual [i][j] = "-";
                        if (score > bestScore){
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }else {
            bestScore = 11;
            for (int i = 0; i <= size; ++i) {
                for (int j = 0; j <= size; ++j) {
                    if (atual[i][j].equals("-")){
                        atual [i][j] = "X";
                        int score = minimax(atual,depth+1,true);
                        atual [i][j] = "-";
                        if (score < bestScore){
                            bestScore = score;
                        }
                    }
                }
            }
        }
        return bestScore;
    }
/*
    public static int valorJogada(String[][] jogo) {
        if (aiX)
        {
            for (int i = 0; i <= size; ++i) {
                if (jogo[0][i].equals("X") && jogo[1][i].equals("X") && jogo[2][i].equals("X")) {
                    return 10;
                }
                if (jogo[0][i].equals("O") && jogo[1][i].equals("O") && jogo[2][i].equals("O")) {
                    return -10;
                }
            }
            for (int i = 0; i <= size; ++i) {
                if (jogo[i][0].equals("X") && jogo[i][1].equals("X") && jogo[i][2].equals("X")) {
                    return 10;
                }
                if (jogo[i][0].equals("O") && jogo[i][1].equals("O") && jogo[i][2].equals("O")) {
                    return -10;
                }
            }
            if ((jogo[0][0].equals("X") && jogo[1][1].equals("X") && jogo[2][2].equals("X")) || (jogo[0][2].equals("X") && jogo[1][1].equals("X") && jogo[2][0].equals("X")) ){
                return 10;
            }
            if ((jogo[0][0].equals("O") && jogo[1][1].equals("O") && jogo[2][2].equals("O")) || (jogo[0][2].equals("O") && jogo[1][1].equals("O") && jogo[2][0].equals("O"))){
                return -10;
            }
        }
        else
        {
            for (int i = 0; i <= size; ++i) {
                if (jogo[0][i].equals("X") && jogo[1][i].equals("X") && jogo[2][i].equals("X")) {
                    return -10;
                }
                if (jogo[0][i].equals("O") && jogo[1][i].equals("O") && jogo[2][i].equals("O")) {
                    return 10;
                }
            }
            for (int i = 0; i <= size; ++i) {
                if (jogo[i][0].equals("X") && jogo[i][1].equals("X") && jogo[i][2].equals("X")) {
                    return -10;
                }
                if (jogo[i][0].equals("O") && jogo[i][1].equals("O") && jogo[i][2].equals("O")) {
                    return 10;
                }
            }
            if ((jogo[0][0].equals("X") && jogo[1][1].equals("X") && jogo[2][2].equals("X")) || (jogo[0][2].equals("X") && jogo[1][1].equals("X") && jogo[2][0].equals("X")) ){
                return -10;
            }
            if ((jogo[0][0].equals("O") && jogo[1][1].equals("O") && jogo[2][2].equals("O")) || (jogo[0][2].equals("O") && jogo[1][1].equals("O") && jogo[2][0].equals("O"))){
                return 10;
            }
        }
        return 0;
    }


    public static void minMax(String[][] atual){
        LinkedList<String[][]> arvore = new LinkedList<>();
        String[][] temp;
        arvore.add(atual);
        boolean jogador; //vai saber se precisa minimizar ou maximizar
        int max = valorJogada(atual);
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                temp = transformar(atual);
                if (temp[i][j].equals("-") && vezX){
                    temp[i][j] = "x";
                    if (!arvore.contains(temp)){
                        arvore.add(temp);
                        printarr(temp);
                        vezX = false;

                    }
                }
                temp = transformar(atual);
                if (temp[i][j].equals("-") && !vezX) {
                    temp[i][j] = "O";
                    if (!arvore.contains(temp)){
                        arvore.add(temp);
                        printarr(temp);
                        vezX = true;
                    }
                }
            }
        }

    }
*/
}
