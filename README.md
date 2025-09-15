# PPD

1. Média dos tempos de atendimento (1000 simulações): 5,000min
Desvio-padrão das medias: 0,050 min

2. Com 2 caixas, os clientes são distribuídos entre duas filas: enquanto um caixa atende um cliente, o outro pode atender outro simultaneamente, reduzindo o tempo médio percebido pelos clientes.
Com 3 caixas, essa divisão se intensifica ainda mais, diminuindo novamente o tempo médio de espera.

Em termos qualitativos, o tempo médio individual de atendimento de cada cliente não se altera (continua sendo em torno da média definida, por exemplo 5 minutos), mas o tempo total que os clientes passam esperando na fila diminui à medida que aumentamos o número de caixas, justamente porque os atendimentos passam a ocorrer em paralelo.

3. sigma = 0,25 -> Media (1000 sim): 4,9999 min; Desvio-padrao das medias: 0,0249 min
sigma = 1,00 -> Media (1000 sim): 4,9998 min; Desvio-padrao das medias: 0,0997 min
sigma = 2,00 -> Media (1000 sim): 5,0044 min; Desvio-padrao das medias: 0,1981 min

4. Este simulador é considerado estocástico porque seus resultados dependem de sorteios aleatórios (no caso, a função nextGaussian() que gera tempos de atendimento segundo uma distribuição normal). Isso significa que, mesmo mantendo os mesmos parâmetros de entrada (média, desvio-padrão, número de clientes), duas execuções podem produzir resultados diferentes. Esse comportamento é importante porque representa a variabilidade natural encontrada em situações reais: em um supermercado, o tempo de atendimento de cada cliente nunca é exatamente igual, pois pode variar conforme o tipo de compra, a experiência do atendente ou imprevistos. Assim, o modelo captura a incerteza e a aleatoriedade do mundo real, tornando a simulação mais realista.