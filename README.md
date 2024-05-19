# Jogo do Galo

Jogo do galo é um jogo onde dois jogadores preenchem uma matriz 3x3 com um X ou um O, aquele que conseguir preencher 3 espaços adjacentes na horizontal, vertical ou diagonal ganha.

No nosso codigo usamos uma matriz de strings com 9 possiveis posições

```
0 1 2
3 4 5
6 7 8
```

Cada jogador pode fazer uma jogada de cada vez preenchendo qualquer lugar vazio, caso todos os espaços sejam preenchidos e nenhuma condição de vitoria seja atingida o jogo declara um empate.

# Algorítimos

Foram utilizados dois algorítimos: **MinMax** e **AlphaBeta**

## MinMax

O algorítimo MinMax vai simular jogadas para ambos jogadores e atribuir um valor para cada jogada para conseguir definir o que seria uma jogada optima. Para isso primeiro o algorítimo verifica se alguma condição de vitoria foi atingida, atribuindo um 1 para vitorias, um -1 para derrotas e um 0 para empate.  
Dependendo se o algorítimo esta procurando maximizar ou minimizar ele vai atribuir um valor impossível de se atingir normalmente, exemplo: Caso o algorítimo esteja maximizando ele vai atribuir um valor de -11 como o melhor valor possível. Agora qualquer valor que o algorítimo encontra vai sempre ser maior que -11 e ira substituir o valor de bestscore com o novo valor score encontrado.  
O valor de score é encontrado quando o algorítimo simula uma jogada e verifica se o jogo atual contém alguma condição de vitoria.

## AlphaBeta

AlphaBeta é uma forma do algorítimo conseguir filtrar jogadas que não vão conseguir influenciar o resultado final. Isso é possível com a introdução de α que sera o maior valor que o algorítimo garantidamente consegue obter, e β que sera o menor valor que o algorítimo garantidamente consegue obter.

O código de AlphaBeta é muito parecido com o de MinMax com diferenças nos valores que são recebidos em quando o algorítimo recebe vitorias e o que faz com os valores recebidos.  
Quando a condição de vitoria é verificada o algorítimo verifica dois novos campos alem do melhor jogada, Alpha e Beta. Alpha é um valor que sera maximizado então ele é instanciado com o valor de -11 e Beta, que vai ser o valor que sera minimizado, ira começar com o valor de 11.  
Ao receber os valores melhor jogada o algorítimo ira, dependendo se o algorítimo esta maximizando ou minimizando, alterar o valor de score.  
Exemplo: Caso o algorítimo esteja maximizando, score ira se tornar o maior valor obtido pelo método que verifica vitorias, caso o valor de score seja maior que alpha, o valor de alpha sera o mesmo valor de score e finalmente, se o valor de Beta for menor ou igual o de alpha o algorítimo achou a melhor jogada.  
Em contraste se o algorítimo estiver minimizando, score recebe o valor de bestscore caso o valor de bestscore seja menor que o de score, caso o valor de beta seja menor que o de score, beta ira receber o valor de score e finalmente caso beta seja menor ou igual a alpha, o algorítimo achou a melhor jogada.

# Testes de memoria

## Jogador primeiro

### Ordem das jogadas: 4 2 3 1 8

#### Min Max

```
O X X 
X X O
O O X

Empate!
Número de nodes: 56490
```

#### AlphaBeta

```
O X X 
X X O
O O X

Empate!
Número de nodes: 6519
```

### Ordem das jogadas: 1 4 5 6 8

#### Min Max

```
O X O 
O X X
X O X

Empate!
Número de nodes: 65008
```

#### AlphaBeta

```
O X O 
O X X 
X O X 

Empate!
Número de nodes: 6476
```

## Ai primeiro

### Ordem das jogadas: 4 2 3 7

#### Min Max

```
O O X 
X X O 
O X O 

Empate!
Número de nodes: 557487
```

#### AlphaBeta

```
O O X 
X X O 
O X O 

Empate!
Número de nodes: 32339
```

### Ordem das jogadas: 3 2 7

#### Min Max

```
O O X 
X O - 
- X O 

O Ganhou na diagonal!
Número de nodes: 558432
```

#### AlphaBeta

```
O O X 
X O - 
- X O 

O Ganhou na diagonal!
Número de nodes: 32528
```

# Conclusões

Dentre os dois códigos o alpha-beta acaba sendo o melhor por conseguir filtrar os movimentos, gastando muito menos nodes que o min max. O algorítimo também acabou bastante simples já que o jogo do galo tem apenas 3 condições de fim de jogo (vitoria, derrota e empate). Os valores que ambos algorítimos recebem são apenas -1 0 e 1, em um jogo mais complexo como xadrez, outras condições podem afetar o score de uma jogada.

Fontes utilizadas:  
https://www.youtube.com/watch?v=trKjYdBASyQ  
https://www.geeksforgeeks.org/finding-optimal-move-in-tic-tac-toe-using-minimax-algorithm-in-game-theory/
