/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic2;


/**
 *
 * @author toshi
 */
public class Aresta {

    private double peso, alfa;
    private Object vertice1, vertice2;
    public static int numTotalVertices;

    public Aresta(double peso, Object vertice1, Object vertice2, double alfa) {
        this.peso = peso;
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        if ((alfa >= 0) && (alfa <= 1)) {
            this.alfa = alfa;
        }
        numTotalVertices++;
    }

    public Aresta() {
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the vertice1
     */
    public Object getVertice1() {
        return vertice1;
    }

    /**
     * @param vertice1 the vertice1 to set
     */
    public void setVertice1(Object vertice1) {
        this.vertice1 = vertice1;
    }

    /**
     * @return the vertice2
     */
    public Object getVertice2() {
        return vertice2;
    }

    /**
     * @param vertice2 the vertice2 to set
     */
    public void setVertice2(Object vertice2) {
        this.vertice2 = vertice2;
    }

    /**
     * @return the alfa
     */
    public double getAlfa() {
        return alfa;
    }
    
    @Override
    public String toString() {
        return (new StringBuilder())
                .append("(" + getPeso() + ", ")
                .append(vertice1 + ", ")
                .append(vertice2 + ", ")
                .append(getAlfa() + ")")
                .toString();
    }
   
}
