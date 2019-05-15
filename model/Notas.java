
package model;


public class Notas {
    
    // ATRIBUTOS
    private Nota np1;
    private Nota np2;
    private Nota reposicao;
    private Nota exame;
    
    // METODOS ESPECIAIS
    // METODOS CONTRUTORES
    public Notas(double aValorNp1, double aValorNp2, double aValorReposicao, double aValorExame)
    {
        this.np1 = new Nota(aValorNp1);
        this.np2 = new Nota(aValorNp2);
        this.reposicao = new Nota(aValorReposicao);
        this.exame = new Nota(aValorExame);
    }
    
    // GETTERS AND SETTERS
    public Nota getNp1() 
    {
        return np1;
    }

    public void setNp1(Nota np1) 
    {
        this.np1 = np1;
    }

    public Nota getNp2() 
    {
        return np2;
    }

    public void setNp2(Nota np2) 
    {
        this.np2 = np2;
    }

    public Nota getReposicao() 
    {
        return reposicao;
    }

    public void setReposicao(Nota reposicao) 
    {
        this.reposicao = reposicao;
    }

    public Nota getExame() 
    {
        return exame;
    }

    public void setExame(Nota exame) 
    {
        this.exame = exame;
    }
    
}
