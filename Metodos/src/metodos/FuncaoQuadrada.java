package metodos;

public class FuncaoQuadrada
{
    private double a;
    private double b;
    private double c;

    public FuncaoQuadrada()
    {

    }

    /**
     * Construtor
     * 
     * @param a
     *            valor que multiplica x^2
     * @param b
     *            valor que multiplica x^1
     * @param c
     *            valor que multiplica x^0
     */
    public FuncaoQuadrada(double a, double b, double c)
    {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Aplica na função
     * 
     * @param x
     *            valor a ser aplicado
     * @return f(x), ou seja, o resultado da aplicação
     */
    public double aplicar(double x)
    {
        return a * x * x + b * x + c;
    }

    /**
     * Deriva a função
     * 
     * @param x
     *            valor a ser aplicado após a derivação
     * @return f'(x), ou seja, o resultado da derivada em x
     */
    public double derivada(double x)
    {
        return 2 * a * x * +x * b + c;
    }

}
