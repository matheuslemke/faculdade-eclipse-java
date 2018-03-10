package metodos;

public class Bisseccao
{
    private double a;
    private double b;
    private double precisao;
    private FuncaoQuadrada f;

    public Bisseccao()
    {

    }

    /**
     * Construtor
     * 
     * @param a
     *            � o x0
     * @param b
     *            � o x1
     * @param precisao
     *            precis�o
     * @param f
     *            fun��o quadrada, grau 2
     */
    public Bisseccao(double a, double b, double precisao, FuncaoQuadrada f)
    {
        super();
        this.a = a;
        this.b = b;
        this.precisao = precisao;
        this.f = f;
    }

    /**
     * M�todo principal do c�lculo da bissec��o
     * 
     * @return resultado do c�lculo
     */
    public double calcular()
    {
        double resultado = a;

        /**
         * Primeiro crit�rio
         */
        if (Math.abs(b - a) > precisao)
        {
            double fInicio, meio, fMeio;

            /**
             * Itera��es
             */
            for (; Math.abs(b - a) > precisao;)
            {
                /**
                 * Aplica��es na fun��o
                 */
                fInicio = f.aplicar(a);
                meio = (a + b) / 2;
                fMeio = f.aplicar(meio);

                /**
                 * Verifica��o de qual ser� o novo meio do intervalo
                 */
                if (fInicio * fMeio < 0)
                    b = meio;
                else
                    a = meio;
            }
            resultado = a;
        }
        return resultado;
    }
}
