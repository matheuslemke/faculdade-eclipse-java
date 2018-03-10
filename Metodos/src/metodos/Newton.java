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
     *            é o x0
     * @param precisao
     *            precisão
     * @param f
     *            função quadrada, grau 2
     */
    public Newton(double x0, double precisao, FuncaoQuadrada f)
    {
        super();
        this.x0 = x0;
        this.precisao = precisao;
        this.f = f;
    }

    /**
     * Método principal do cálculo de Newton
     * 
     * @return resultado do cálculo
     */
    public double calcular()
    {
        double resultado, fx = f.aplicar(x0);

        /**
         * Primeiro critério de parada
         */
        if (Math.abs(fx) > precisao)
        {
            /**
             * Primeira iteração - OBS: fora do laço for
             */
            double fxl = f.derivada(x0), x1 = x0 - (fx / fxl);
            fx = f.aplicar(x1);

            /**
             * Iterações - partindo da segunda (i = 1)
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
