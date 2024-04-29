package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    Map<String[][],Integer> arvore = new HashMap<>();
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
    static boolean suavez;
    static int size = 2;
    static Scanner myObj = new Scanner(System.in);
    static int rown, coln;
    static int turnos = 0;

    public static void main(String[] args) {
        umJogador(jogo, posicoes, myObj);
    }

    static void doisJogadores(String[][] arr, String[][] pos, Scanner scan) {
        printarr(pos);
        System.out.println();
        printarr(arr);

        while (!fimDeJogo()) {
            int jogada = scan.nextInt();
            encPos(jogada);
            if (!jaExiste()) {
                if (suavez) {
                    jogo[rown][coln] = "X";
                    suavez = false;
                } else {
                    jogo[rown][coln] = "O";
                    suavez = true;
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
        printarr(pos);
        System.out.println();
        printarr(arr);

        while (!fimDeJogo()) {
            int jogada = scan.nextInt();
            encPos(jogada);
            if (!jaExiste()) {
                if (suavez) {
                    jogo[rown][coln] = "X";
                    suavez = false;
                } else {
                    jogo[rown][coln] = "O";
                    suavez = true;
                }
                printarr(pos);
                System.out.println();
                printarr(arr);
                turnos +=1;
            } else {
                System.out.println("Numero ja foi selecionado");
            }
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

    public static boolean fimDeJogo() {
        for (int i = 0; i <= size; ++i) {
            if (jogo[i][0].equals("X") && jogo[i][1].equals("X") && jogo[i][2].equals("X")) {
                System.out.println("X Ganhou! na vertical");
                return true;
            }
            if (jogo[i][0].equals("O") && jogo[i][1].equals("O") && jogo[i][2].equals("O")) {
                System.out.println("O Ganhou! na vertical");
                return true;
            }
        }
        for (int i = 0; i <= size; ++i) {
                if (jogo[0][i].equals("X") && jogo[1][i].equals("X") && jogo[2][i].equals("X")) {
                    System.out.println("X Ganhou! na vertical");
                    return true;
                }
                if (jogo[0][i].equals("O") && jogo[1][i].equals("O") && jogo[2][i].equals("O")) {
                    System.out.println("O Ganhou! na vertical");
                    return true;
                }
        }
        if ((jogo[0][0].equals("X") && jogo[1][1].equals("X") && jogo[2][2].equals("X")) || (jogo[0][2].equals("X") && jogo[1][1].equals("X") && jogo[2][0].equals("X")) ){
            System.out.println("X Ganhou na Diagonal!");
            return true;
        }
        if ((jogo[0][0].equals("O") && jogo[1][1].equals("O") && jogo[2][2].equals("O")) || (jogo[0][2].equals("O") && jogo[1][1].equals("O") && jogo[2][0].equals("O"))){
            System.out.println("O Ganhou na Diagonal!");
            return true;
        }
        if (turnos > 8){
            System.out.println("Empate!");
            return true;
        }
        return false;
    }

    public static int valorJogada() {
        //AI = X
        for (int i = 0; i <= size; ++i) {
            if (jogo[i][0].equals("X") && jogo[i][1].equals("X") && jogo[i][2].equals("X")) {
                System.out.println("X Ganhou! na vertical");
                return 10;
            }
            if (jogo[i][0].equals("O") && jogo[i][1].equals("O") && jogo[i][2].equals("O")) {
                System.out.println("O Ganhou! na vertical");
                return -10;
            }
        }
        for (int i = 0; i <= size; ++i) {
            if (jogo[0][i].equals("X") && jogo[1][i].equals("X") && jogo[2][i].equals("X")) {
                return 10;
            }
            if (jogo[0][i].equals("O") && jogo[1][i].equals("O") && jogo[2][i].equals("O")) {
                return -10;
            }
        }
        if ((jogo[0][0].equals("X") && jogo[1][1].equals("X") && jogo[2][2].equals("X")) || (jogo[0][2].equals("X") && jogo[1][1].equals("X") && jogo[2][0].equals("X")) ){
            return 10;
        }
        if ((jogo[0][0].equals("O") && jogo[1][1].equals("O") && jogo[2][2].equals("O")) || (jogo[0][2].equals("O") && jogo[1][1].equals("O") && jogo[2][0].equals("O"))){
            return -10;
        }
        return 0;
    }

}
