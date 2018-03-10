package metodos;

public class Gauss
{
    private int ordem;
    private double a[][] = new double[ordem][ordem + 1];

    public Gauss()
    {

    }

    /**
     * Construtor
     * 
     * @param ordem
     *            ordem da matriz
     * @param a
     *            matriz aumentada
     */
    public Gauss(int ordem, double[][] a)
    {
        super();
        this.ordem = ordem;
        this.a = a;
    }

    /**
     * Troca duas linhas da matriz
     * 
     * @param linhaa
     * @param linhab
     */
    public void trocarLinhas(int linhaa, int linhab)
    {
        /**
         * Variável auxiliar que guarda uma das linhas
         */
        double aux[] = new double[ordem + 1];

        for (int c = 0; c <= ordem; c++)
        {
            aux[c] = a[linhaa][c];
        }
        for (int c = 0; c <= ordem; c++)
        {
            a[linhaa][c] = a[linhab][c];
        }
        for (int c = 0; c <= ordem; c++)
        {
            a[linhab][c] = aux[c];
        }
    }

    /**
     * Pivoteamento parcial
     * 
     * @param i
     *            linha
     * @return valor do pivo para a linha
     */
    private double pivoParcial(int i)
    {
        double maior = a[i][i];
        int linhaMaior = -1;

        /**
         * Iterações até encontrar o maior da coluna, abaixo da linha
         */
        for (int c = i; c < ordem; c++)
        {
            if (Math.abs(a[c][i]) > Math.abs(maior))
            {
                maior = a[c][i];
                linhaMaior = c;
            }
        }
        /**
         * Chamada da função trocar linhas se houver um número maior que o antigo
         */
        if (linhaMaior != -1)
            trocarLinhas(i, linhaMaior);
        return maior;
    }

    // public double[] multiplicadores(double pivo, int i)// colunaPivo é sempre i+1
    // {
    // double multiplicadores[] = new double[ordem - i - 1];
    //
    // for (int c = i + 1, j = 0; c < ordem; c++, j++)
    // {
    // multiplicadores[j] = a[c][i] / pivo;
    // }
    // return multiplicadores;
    // }

    /**
     * Multiplica a matriz para zerar todos os elementos abaixo do pivo
     * 
     * @param pivo
     *            pivo
     * @param i
     *            linha do pivo
     */
    private void multiplicar(double pivo, int i)// coluna do pivo é sempre i+1
    {
        double multiplicador;

        /**
         * Encontra o multiplicador para cada linha
         */
        for (int c = i + 1; c < ordem; c++)
        {
            multiplicador = a[c][i] / pivo;

            /**
             * Multiplica o multiplicador pelas colunas da matriz naquela linha
             */
            for (int k = 0; k < ordem - 1; k++)
            {
                a[c][k] -= multiplicador * a[i][k];
            }
        }
    }

    /**
     * Retira a matriz b da matriz aumentada a
     * 
     * @return matriz b
     */
    public double[] b()
    {
        double b[] = new double[ordem];
        for (int i = 0; i < ordem; i++)
        {
            b[i] = a[i][ordem];
        }
        return b;
    }

    /**
     * Método que faz o cálculo ax = b
     * 
     * @return vetor x
     */
    private double[] resolverSistema()
    {
        double x[] = new double[ordem + 1];
        double b[] = b();
        int k;
        /**
         * Encontra o valor referente a x[n-1] ou x[ordem-1]
         */
        x[ordem - 1] = b[ordem - 1] / a[ordem - 1][ordem - 1];

        /**
         * Encontra os valores iniciando em x[n-2] até x[0]
         */
        for (k = ordem - 2; k >= 0; k--)
        {
            double r = 0;
            for (int j = (k + 1); j < ordem; j++)
            {
                r = r + a[k][j] * x[j];
                x[k] = (b[k] - r) / a[k][k];
            }
        }
        x[ordem] = k;
        return x;
    }

    /**
     * Verifica se é necessário triangular
     * 
     * @param i
     *            indice indicando a linha
     * @return true se a coluna está pronta para o cálculo
     */
    private boolean estaColunaPronta(int i)
    {
        /**
         * Se estiver na última linha, não há como triangular
         */
        if (i == ordem - 1)
            return true;

        /**
         * Verifica se os valores abaixo de a[i][i] são iguais a 0
         */
        for (int j = i; j < ordem - 1; j++)
        {
            /**
             * Se houver ao menos um valor diferente de 0, é necessário triangular
             */
            if (a[i][j] != 0)
                return false;
        }
        return true;
    }

    /**
     * Mostra a matriz
     */
    public void mostrarMatriz()
    {
        for (int i = 0; i < ordem; i++)
        {
            System.out.print("|");
            for (int j = 0; j < ordem + 1; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    /**
     * Método principal do método de eliminação de Gauss
     * 
     * @return vetor com os valores de x
     */
    public double[] calcular()
    {
        int i;

        /**
         * Iteração para percorrer linhas de a
         */
        for (i = 0; i < ordem; i++)
        {
            /**
             * Verifica se é necessário triangular a coluna i
             */
            if (!estaColunaPronta(i))
                multiplicar(pivoParcial(i), i);
        }

        return resolverSistema();
    }

}
