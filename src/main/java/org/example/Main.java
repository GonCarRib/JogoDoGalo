package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] jogo = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    static String[][] posicoes = {{"0", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"}};
    static boolean suavez;
    static int size = 2;
    static Scanner myObj = new Scanner(System.in);
    static int rown, coln;

    public static void main(String[] args) {
        doisJogadores(jogo, posicoes, myObj);
    }

    static void doisJogadores(String[][] arr, String[][] pos, Scanner scan) {
        printarr(pos);
        System.out.println();
        printarr(arr);

        while (!vitoriaH() || !vitoriaV() ) {
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

    public static boolean vitoriaH() {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (jogo[i][j].equals("X")) {
                    countX = countX + 1;
                }
                if (jogo[i][j].equals("O")) {
                    countO = countO + 1;
                }
            }
            if (countX == 3) {
                System.out.println("X Ganhou!");
                return true;
            }else if (countO == 3){
                System.out.println("O Ganhou!");
                return true;
            }else{
            countX = 0;
            countO = 0;
            }
        }
        return false;
    }

    public static boolean vitoriaV() {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (jogo[j][i].equals("X")) {
                    countX = countX + 1;
                }
                if (jogo[j][i].equals("O")) {
                    countO = countO + 1;
                }
            }
        }
        if (countX == 3) {
            System.out.println("X Ganhou!");
            return true;
        }else if (countO == 3){
            System.out.println("O Ganhou!");
            return true;
        }else{
            countX = 0;
            countO = 0;
        }
        return false;
    }
}