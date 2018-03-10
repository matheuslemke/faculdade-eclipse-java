package metodos;

public class LU
{
    private int ordem;
    private double a[][] = new double[ordem][ordem];
    private double L[][] = new double[ordem][ordem];
    private double U[][] = new double[ordem][ordem];

    public LU(int ordem, double[][] a, double[] b)
    {
        super();
        this.ordem = ordem;
        this.a = a;
        gerarL();
        gerarU();
    }

    private void gerarL()
    {
        for (int i = 0; i < ordem; i++)
        {
            for (int j = 0; j < ordem; j++)
            {
                if (i == j)
                    L[i][j] = 1;
                else
                    L[i][j] = 0;
            }
        }
    }

    private void gerarU()
    {
        for (int i = 0; i < ordem; i++)
        {
            for (int j = 0; j < ordem; j++)
            {
                if (i > j)
                    L[i][j] = 0;
                else
                    L[i][j] = 1;
            }
        }
    }

    private void gerarLinhaU(int i)
    {
        for (int j = 0; j < ordem; j++)
        {
            for (int k = 0; k < ordem; k++)
            {
                U[i][j] += L[i][k] * U[k][i];
            }
            U[i][j] = a[i][j] / U[i][j];
        }

    }

    private void gerarColuna(int i)
    {

    }

    public double[] calcular()
    {

        for (int i = 0; i < ordem - 1;)
        {
            if (i % 2 == 0)
            {
                gerarLinhaU(i);
            }
            else
            {
                gerarColuna(i);
                i++;
            }
        }
        return null;
    }

}
