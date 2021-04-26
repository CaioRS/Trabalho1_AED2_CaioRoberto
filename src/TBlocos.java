public class TBlocos 
{


    private ListaEncadeada[] vetorListaEncadeada;


// criação do vetor das listas a partir do numero int informado na primeira linha da arquivo txt
    public TBlocos(int totalDeBlocos)
    {

        this.vetorListaEncadeada = new ListaEncadeada[totalDeBlocos];
        for (int i=0;i<totalDeBlocos;i++)
        {
            this.vetorListaEncadeada[i] = new ListaEncadeada();
            this.vetorListaEncadeada[i].adicionaNoComeco(i);
        }
    }



    private void blocosParaRealocar(int posicaoDosBlocos)
    {
        do
        {
            No ultimaNo = this.vetorListaEncadeada[posicaoDosBlocos].pegaNo(this.vetorListaEncadeada[posicaoDosBlocos].getnumElement());
            this.vetorListaEncadeada[posicaoDosBlocos].remover();
            this.vetorListaEncadeada[ultimaNo.getElemento().getnumCod()].adicionaNo(ultimaNo);
        }
        while (this.vetorListaEncadeada[posicaoDosBlocos].getnumElement() > 1);
    }

  
    public void MoveOnto(int blocoMovido, int posPM)
    {
        this.blocosParaRealocar(blocoMovido);
        this.blocosParaRealocar(posPM);
        No blocoParaMover = this.vetorListaEncadeada[blocoMovido].pegaNo(1);
        this.vetorListaEncadeada[blocoMovido].remover();
        this.vetorListaEncadeada[posPM].adicionaNo(blocoParaMover);
    }



    public void MoveOver(int blocoMovido, int posPM)
    {
        this.blocosParaRealocar(blocoMovido);
        No blocoParaMover = this.vetorListaEncadeada[blocoMovido].pegaNo(1);
        this.vetorListaEncadeada[blocoMovido].remover();
        this.vetorListaEncadeada[posPM].adicionaNo(blocoParaMover);
    }



    public void PileOnto(int posMov, int posPM)
    {
        this.blocosParaRealocar(posPM);
        No[] NosParaMover = new No[this.vetorListaEncadeada[posMov].getnumElement()];
        for (int i=this.vetorListaEncadeada[posMov].getnumElement();i>0;i--)
        {
            NosParaMover[i-1] = this.vetorListaEncadeada[posMov].pegaNo(i);
            this.vetorListaEncadeada[posMov].remover();
        }
        for (int l=0;l<NosParaMover.length;l++)
        {
            this.vetorListaEncadeada[posPM].adicionaNo(NosParaMover[l]);
        }
    }



    public void PileOver(int posMov, int posPM)
    {
        No[] NosParaMover = new No[this.vetorListaEncadeada[posMov].getnumElement()];
        for (int i=this.vetorListaEncadeada[posMov].getnumElement();i>0;i--)
        {
            NosParaMover[i-1] = this.vetorListaEncadeada[posMov].pegaNo(i);
            this.vetorListaEncadeada[posMov].remover();
        }
        for (int l=0;l<NosParaMover.length;l++)
        {
            this.vetorListaEncadeada[posPM].adicionaNo(NosParaMover[l]);
        }
    }

// retorno de uma string para facilitar impressão

    public String ToString()
    {
        String saida = "";
        for (int i=0;i<this.vetorListaEncadeada.length;i++)
        {
            saida += String.valueOf(i) + ": ";
            if (this.vetorListaEncadeada[i].getnumElement() != 0)
            {
                No atual = this.vetorListaEncadeada[i].pegaNo(1);
                for (int l=0;l<this.vetorListaEncadeada[i].getnumElement();l++)
                {   
                    if (l == this.vetorListaEncadeada[i].getnumElement()-1)
                    {
                        saida += String.valueOf(this.vetorListaEncadeada[i].pegaNo(l+1).getElemento().getnumCod()) + "\n";
                    }
                    else
                    {
                        saida += String.valueOf(this.vetorListaEncadeada[i].pegaNo(l+1).getElemento().getnumCod()) + " ";
                        atual = atual.getProximoPonteiro();
                    }
                }
            }
            else
            {
                saida += "\n";
            }
        }
        return saida;
    }
}