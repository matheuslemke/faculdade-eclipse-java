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
     *            é o x0
     * @param b
     *            é o x1
     * @param precisao
     *            precisão
     * @param f
     *            função quadrada, grau 2
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
     * Método principal do cálculo da bissecção
     * 
     * @return resultado do cálculo
     */
    public double calcular()
    {
        double resultado = a;

        /**
         * Primeiro critério
         */
        if (Math.abs(b - a) > precisao)
        {
            double fInicio, meio, fMeio;

            /**
             * Iterações
             */
            for (; Math.abs(b - a) > precisao;)
            {
                /**
                 * Aplicações na função
                 */
                fInicio = f.aplicar(a);
                meio = (a + b) / 2;
                fMeio = f.aplicar(meio);

                /**
                 * Verificação de qual será o novo meio do intervalo
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
