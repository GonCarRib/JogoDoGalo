package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String[][] jogo = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    static String[][] posicoes = {{"0","1","2"},{"3","4","5"},{"6","7","8"}};
    static boolean suavez;
    static int size = 2;
    static Scanner myObj = new Scanner(System.in);

    public static void main(String[] args){
        doisJogadores(jogo, posicoes, myObj);
    }

    static void doisJogadores(String[][] arr, String[][] pos, Scanner scan){
        while(suavez){
            printarr(pos);
            printarr(arr);
            int jogada = scan.nextInt();
            if (!jaExiste()){
                jogo.
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
        for (int i = 0; i <= 2; ++i) {
            for (int j = 0; j <= 2; ++j) {
                if (jogo[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        System.out.println("Numero ja foi selecionado");
        return true;
    }
}