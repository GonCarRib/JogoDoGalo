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

Foram utilizados dois algoritimos: **MinMax** e **AlphaBeta**

## MinMax

O algoritimo MinMax vai simular jogadas para ambos jogadores e atribuir um valor para cada jogada para conseguir definir o que seria uma jogada otima. Para isso primeiro o algoritimo verifica se alguma condição de vitoria foi atingida, atibuindo um 10 para vitorias, um -10 para derrotas e um 0 para empate.
Dependendo se o algoritimo esta procurando maximizar ou minimizar ele vai atribuir um valor impossivel de se atingir normalmente, exemplo: Caso o algoritimo esteja maximizando ele vai atribuir um valor de -11 como o melhor valor possivel. Agora qualquer valor que o algoritimo encontra vai sempre ser maior que -11 e ira subistituir o valor de bestscore com o novo valor score encontrado.
O valor de score é encontrado quando o algoritimo simula uma jogada e verifica se o jogo atual contém alguma condição de vitoria.

## AlphaBeta

AlphaBeta é uma forma do algoritimo conseguir filtrar jogadas que não vão conseguir influenciar o resultado final. Isso é possivel com a introdução de α que sera o maior valor que o algoritimo garantidamente consegue obter, e β que sera o menor valor que o algoritimo garantidamente consegue obter.

O codigo de AlphaBeta é muito parecido com o de MinMax com diferenças nos valores que são recebidos em quando o algoritimo recebe vitorias e o que faz com os valores recebidos.
Quando a condição de vitoria é verificada o algoritimo verifica dois novos campos alem do melhor jogada, Alpha e Beta. Alpha é um valor que sera maximizado então ele é instanciado com o valor de -11 e Beta, que vai ser o valor que sera minimizado, ira começar com o valor de 11.
Ao receber os valores melhor jogada o algoritimo ira, dependendo se o algoritimo esta maximizando ou minimizando, alterar o valor de score. 
Exemplo: Caso o algoritimo esteja maximizando, score ira se tornar o maior valor obtido pelo metodo que verifica vitorias, caso o valor de score seja maior que alpha, o valor de alpha sera o mesmo valor de score e finalmente, se o valor de Beta for menor ou igual o de alpha o algoritimo achou a melhor jogada.
Em contraste se o algoritimo estiver minimizando, score recebe o valor de bestscore caso o valor de bestscore seja menor que o de score, caso o valor de beta seja menor que o de score, beta ira receber o valor de score e finalmente caso beta seja menor ou igual a alpha, o algoritimo achou a melhor jogada.

# Testes de memoria 
# Jogador primeiro
## Ordem das jogadas: 4 2 3 1 8
### Min Max
```
O X X 
X X O
O O X

Empate!
Número de nodes: 56490
```
### AlphaBeta
```
O X X 
X X O
O O X

Empate!
Número de nodes: 6519
```

## Ordem das jogadas: 1 4 5 6 8
### Min Max
```
O X O 
O X X
X O X

Empate!
Número de nodes: 65008
```
### AlphaBeta
```
O X O 
O X X 
X O X 

Empate!
Número de nodes: 6476
```

# Ai primeiro
## Ordem das jogadas: 4 2 3 7
### Min Max
```
O O X 
X X O 
O X O 

Empate!
Número de nodes: 557487
```
### AlphaBeta
```
O O X 
X X O 
O X O 

Empate!
Número de nodes: 32339
```

## Ordem das jogadas: 3 2 7
### Min Max
```
O O X 
X O - 
- X O 

O Ganhou na diagonal!
Número de nodes: 558432
```
### AlphaBeta
```
O O X 
X O - 
- X O 

O Ganhou na diagonal!
Número de nodes: 32528
```


