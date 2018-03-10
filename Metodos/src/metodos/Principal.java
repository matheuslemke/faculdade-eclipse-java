package metodos;

public class Principal
{

    public static void main(String[] args)
    {
        // double a[][] =
        // {
        // { 1, 4, 6, 20 },
        // { 0, 2, 5, 30 },
        // { 0, 0, 3, 30 } };
        //
        // Gauss g = new Gauss(3, a);
        //
        // double resultado[] = g.calcular();
        //
        // for (int i = 0; i < resultado.length; i++)
        // {
        // System.out.println("x" + i + ": " + resultado[i]);
        // }

        // FuncaoQuadrada f = new FuncaoQuadrada(1, 1, -6);

        // Newton n = new Newton(1.5, 2, f);
        // System.out.println(n.calcular());

        // double a[][] = new double[][]
        // {
        // { 3, -2, 5, 20 },
        // { 6, -9, 12, 51 },
        // { -5, 0, 2, 1 } };
        // Gauss g = new Gauss(3, a);

        // double resultado[] = g.calcular();
        // for (int i = 0; i < resultado.length; i++)
        // {
        // System.out.println("x" + i + ": " + resultado[i]);
        // }

        // Bisseccao b = new Bisseccao(a, b, precisao, f);

        // Bisseccao b = new Bisseccao(1, 2, 0.01, new FuncaoQuadrada(-2, 0, 6));
        // System.out.println(b.calcular());

        // Newton n = new Newton(0.02, 0.00001, new FuncaoQuadrada(1, 1, -6));
        // System.out.println(n.calcular());

        // Newton n = new Newton(1.5, 2, new FuncaoQuadrada(1, 1, -6));
        // System.out.println(n.calcular());
        //

//        double m[][] =
//        {
//        { 2, 3, -1, 5 },
//        { 4, 4, -3, 3 },
//        { 2, -3, 1, -1 } };
//
//        Gauss g = new Gauss(3, m);
//        double resultado[] = g.calcular();
//
//        for (int i = 0; i < resultado.length; i++)
//        {
//            System.out.println("x" + i + ": " + resultado[i]);
//        }
        
        Bisseccao b = new Bisseccao(2, 3, 0.01, new FuncaoQuadrada(1, 0, -5));
        System.out.println(b.calcular());

    }
}
