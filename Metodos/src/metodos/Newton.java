package metodos;

public class Newton
{
    private double x0;
    private double precisao;
    private FuncaoQuadrada f;

    /**
     * Construtor
     * 
     * @param x0
     *            � o x0
     * @param precisao
     *            precis�o
     * @param f
     *            fun��o quadrada, grau 2
     */
    public Newton(double x0, double precisao, FuncaoQuadrada f)
    {
        super();
        this.x0 = x0;
        this.precisao = precisao;
        this.f = f;
    }

    /**
     * M�todo principal do c�lculo de Newton
     * 
     * @return resultado do c�lculo
     */
    public double calcular()
    {
        double resultado, fx = f.aplicar(x0);

        /**
         * Primeiro crit�rio de parada
         */
        if (Math.abs(fx) > precisao)
        {
            /**
             * Primeira itera��o - OBS: fora do la�o for
             */
            double fxl = f.derivada(x0), x1 = x0 - (fx / fxl);
            fx = f.aplicar(x1);

            /**
             * Itera��es - partindo da segunda (i = 1)
             */
            for (int i = 1; (Math.abs(fx) > precisao) && 
                    (Math.abs(x1 - x0) > precisao) && i < 100; i++)
            {
                x0 = x1;
                fxl = f.derivada(x0);
                x1 = x0 - (fx / fxl);
                fx = f.aplicar(x1);
            }
            resultado = x1;
        }
        else
            resultado = x0;

        return resultado;
    }
}
