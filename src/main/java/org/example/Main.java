package org.example;
import java.util.Scanner;

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
    static int memoriaNodeChamado;
    static boolean aiMinMax = false;

    public static void main(String[] args) {
        int var;
        while (true){
            System.out.println("[1] Um jogador" + '\n' + "[2] Dois Jogadores");
            var = myObj.nextInt();
            if (var == 1) {
                while (true){
                    System.out.println("[1] MinMax" + '\n' + "[2] AlphaBeta");
                    var = myObj.nextInt();
                    if (var == 1) {
                        aiMinMax = true;
                        break;
                    } else if (var == 2) {
                        aiMinMax = false;
                        break;
                    }else {
                        System.out.println("Comando Invalido");
                    }
                }
                while (true) {
                    System.out.println("[1] Jogador joga primeiro" + '\n' + "[2] Ai Joga primeiro");
                    var = myObj.nextInt();
                    if (var == 1) {
                        vezX = true;
                        break;
                    } else if (var == 2) {
                        vezX = false;
                        break;
                    }else {
                        System.out.println("Comando Invalido");
                    }
                }
                umJogador(jogo, posicoes, myObj);
                break;
            } else if (var == 2) {
                doisJogadores(jogo, posicoes, myObj);
                break;
            } else {
                System.out.println("Comando Invalido");
            }
        }
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
        Integer temp;
        do
        {
            temp = fimDeJogo();

            if (temp == null)
            {
                if (vezX)
                {
                    printarr(pos);
                    System.out.println();
                    printarr(arr);
                    System.out.println();
                int jogada = scan.nextInt();
                encPos(jogada);
                if (!jaExiste())
                {
                    jogo[rown][coln] = "X";
                    vezX = false;
                } else
                {
                    System.out.println("Número já foi selecionado");
                }
            } else
            {
                if (aiMinMax){bestMove();}
                else {moveAlpha();}
                vezX = true;
            }
                printarr(pos);
                System.out.println();
                printarr(arr);
                System.out.println();

            }
        }while (temp == null);
        System.out.println("Número de nodes: "+ memoriaNodeChamado);
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
        Integer count = 0;
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (!jogo[i][j].equals("-")){
                    count++;
                    if (count > 8){
                        System.out.println("Empate!");
                        return 0;
                    }
                }
            }
        }

        return null;
    }

    public static Integer verificarVitoria() {
        // 1 = O Ganhou
        // 0 = Empate
        // -1 = X Ganhou
        for (int i = 0; i <= size; ++i) {
            if (jogo[0][i].equals("X") && jogo[1][i].equals("X") && jogo[2][i].equals("X")) {
                return -1;
            }
            if (jogo[0][i].equals("O") && jogo[1][i].equals("O") && jogo[2][i].equals("O")) {
                return 1;
            }
        }

        for (int i = 0; i <= size; ++i) {
            if (jogo[i][0].equals("X") && jogo[i][1].equals("X") && jogo[i][2].equals("X")) {
                return -1;
            }
            if (jogo[i][0].equals("O") && jogo[i][1].equals("O") && jogo[i][2].equals("O")) {
                return 1;
            }
        }

        if ((jogo[0][0].equals("X") && jogo[1][1].equals("X") && jogo[2][2].equals("X")) || (jogo[0][2].equals("X") && jogo[1][1].equals("X") && jogo[2][0].equals("X")) ){
            return -1;
        }
        if ((jogo[0][0].equals("O") && jogo[1][1].equals("O") && jogo[2][2].equals("O")) || (jogo[0][2].equals("O") && jogo[1][1].equals("O") && jogo[2][0].equals("O"))){
            return 1;
        }

        Integer count = 0;
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (!jogo[i][j].equals("-")){
                    count++;
                    if (count > 8){
                        return 0;
                    }
                }
            }
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
                    int score = minmax(jogo,0,false);
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
    public static void moveAlpha(){
        int bestScore = -10000;
        rown = -1;
        coln = -1;

        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (jogo[i][j].equals("-")){
                    jogo[i][j] = "O";
                    int score = alphaBeta(jogo,0, -11, 11,false);
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

    public static int minmax(String[][] atual, int depth, boolean isMaxi){
        memoriaNodeChamado ++;
        Integer resultado = verificarVitoria();
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
                        int score = minmax(atual,depth+1,false);
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
                        int score = minmax(atual,depth+1,true);
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
    public static int alphaBeta(String[][] atual, int depth, Integer alpha, Integer beta,boolean isMaxi){
        memoriaNodeChamado ++;
        Integer resultado = verificarVitoria();

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
                        int score = alphaBeta(atual,depth+1,alpha, beta, false);
                        atual [i][j] = "-";
                        if (score > bestScore){
                            bestScore = score;

                        }
                        if(score > alpha){
                            alpha = score;

                        }
                        if (beta <= alpha){
                            return bestScore;

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
                        int score = alphaBeta(atual,depth+1,alpha, beta, true);
                        atual [i][j] = "-";
                        if (score < bestScore){
                            bestScore = score;
                        }
                        if(score < beta){
                            beta = score;
                        }
                        if (beta <= alpha){
                            return bestScore;
                        }
                    }
                }
            }
        }
        return bestScore;
    }
}
