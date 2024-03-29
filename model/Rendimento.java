
package model;

public class Rendimento {
    
    private Aluno aluno;
    private Curso curso;
    private Notas notas;
    private double media;
    private boolean aprovado;
    
    public Rendimento(Aluno aAluno, Curso aCurso, Notas aNotas)
    {
        this.aluno = aAluno;
        this.curso = aCurso;
        this.notas = aNotas;
        
        this.calculaMedia();
    }

    public Aluno getAluno() 
    {
        return this.aluno;
    }

    public void setAluno(Aluno aAluno) 
    {
        this.aluno = aAluno;
    }

    public Curso getCurso() 
    {
        return this.curso;
    }

    public void setCurso(Curso aCurso) 
    {
        this.curso = aCurso;
    }

    public Notas getNotas() 
    {
        return this.notas;
    }

    public void setNotas(Notas aNotas) 
    {
        this.notas = aNotas;
        this.calculaMedia();
    }
    
    public double getMedia() 
    {
        return this.media;
    }
    
    public void setMedia(double aMedia) 
    {
        this.media = aMedia;
    }
    
    public boolean isAprovado()
    {  
        return this.aprovado;
    }
    
    public void setAprovado(boolean isAprovado) 
    {
        this.aprovado = isAprovado;
    }
    
    // METODOS
   
    
    public final void calculaMedia()
    {
        double tempMedia;
        
        if(this.getNotas().getReposicao().getValor() > this.getNotas().getNp1().getValor() ||
           this.getNotas().getReposicao().getValor() > this.getNotas().getNp2().getValor())
        {
            if(this.getNotas().getNp1().getValor() > this.getNotas().getNp2().getValor())
                tempMedia = (this.getNotas().getNp1().getValor() + this.getNotas().getReposicao().getValor())/2;
            
            else
                tempMedia = (this.getNotas().getNp2().getValor() + this.getNotas().getReposicao().getValor())/2;                
        }
        else 
        {
            tempMedia = (this.getNotas().getNp1().getValor() + this.getNotas().getNp2().getValor())/2;
        }
        
        if(this.getCurso().getNivel() == "GRADUACAO")
        {
            if(tempMedia >= 7)
            {
                this.setMedia(tempMedia);
                this.setAprovado(true);
            }
            else
            {
                tempMedia = (tempMedia+this.getNotas().getExame().getValor())/2;
                if(tempMedia >= 5)
                {
                    this.setMedia(tempMedia);
                    this.setAprovado(true);
                }
                else
                {
                    this.setMedia(tempMedia);
                    this.setAprovado(false);
                }
            }
        }
        else
        {
            if(tempMedia >= 5)
            {
                this.setMedia(tempMedia);
                this.setAprovado(true);
            }
            else
            {
                tempMedia = (tempMedia+this.getNotas().getExame().getValor())/2;
                if(tempMedia >= 5)
                {
                    this.setMedia(tempMedia);
                    this.setAprovado(true);
                }
                else
                {
                    this.setMedia(tempMedia);
                    this.setAprovado(false);
                }
            }
        }
            
    }
    
    public String toCSVString() {
		String r = "";
		r = this.getAluno().getId() + ";" + this.notas.getNp1().getValor() + ";" + this.notas.getNp2().getValor() + ";" +
			this.notas.getReposicao().getValor() + ";" + this.notas.getExame().getValor();
		return r;
	}
    
    @Override
    public String toString() {
    	String r = "";
    	r += "ID: " + this.getAluno().getId() + "\n";
    	r += "Nome: " + this.getAluno().getNome() + "\n";
    	r += "Curso: " + this.getCurso().getNome() + "\n";
    	r += "Ano: " + this.getCurso().getAno() + "\n";
    	r += "Tipo: " + this.getCurso().getNivel() + "\n";
    	r += "NP1: " + this.getNotas().getNp1().getValor() + "\n";
    	r += "NP2: " + this.getNotas().getNp2().getValor() + "\n";
    	r += "Rep: " + this.getNotas().getReposicao().getValor() + "\n";
    	r += "Exm: " + this.getNotas().getExame().getValor() + "\n";
    	r += "Média: " + this.getMedia() + "\n";
    	if(this.isAprovado()) {
    		r += "Aprovado: SIM\n";
    	} else {
    		r += "Aprovado: NAO\n";
    	}
    	return r;
    }
}
