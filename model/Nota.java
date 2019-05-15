
package model;


public class Nota {
    
    // ATRIBUTOS
    private double valor;
    
    // METODOS ESPECIAIS
    // METODO CONTRUTOR
    public Nota(double aValor)
    {
        if(aValor >=0 && aValor <=10)
            this.valor = aValor;
    }
    
    // GETTERS AND SETTERS
    public double getValor()
    {
        return this.valor;
    }
    
    public void setValor(double aValor)
    {
        if(aValor >=0 && aValor <=10)
            this.valor = aValor;
    }
    
}
