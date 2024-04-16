package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] jogo = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    static String[][] posicoes = {{"0","1","2"},{"3","4","5"},{"6","7","8"}};
    static boolean suavez;
    static int size = 2;
    static Scanner myObj = new Scanner(System.in);
    static int rown, coln;

    public static void main(String[] args){
        doisJogadores(jogo, posicoes, myObj);
    }

    static void doisJogadores(String[][] arr, String[][] pos, Scanner scan){
        printarr(pos);
        printarr(arr);
        while(!suavez){

            int jogada = scan.nextInt();
            encPos(jogada);
            if (!jaExiste()){
                jogo[rown][coln] = "X";
                printarr(pos);
                printarr(arr);
            }else
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

        System.out.println("Numero ja foi selecionado");
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
}