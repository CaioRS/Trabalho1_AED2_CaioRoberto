public class ListaEncadeada {

    private No inicio;   
    private No fim;     
    private int numElement;  

 

    public int getnumElement() {
        return numElement;
    }

   //retorna posição
    public No pegaNo(int posicao)
    {
        No atual = this.inicio;

        for (int i=0;i<this.numElement;i++)
        {
            if (i == posicao-1)
            {
                break;
            }
            else
            {
                atual = atual.getProximoPonteiro();
            }
        }
        return atual;
    }

// metodo de criação e primeiro preenchimento da lista 

    public void adicionaNoComeco(int codigo)
    {
        No novo = new No(this.inicio, codigo);
        this.inicio = novo;
        if (this.numElement == 0)
        {
            this.fim = this.inicio;
        }
        this.numElement++;
    }

// metodo de criação ao fim da lista

    public void adicionaNo(No elemento)
    {
        if (this.numElement == 0)
        {
            this.inicio = elemento;
            this.fim = this.inicio;
        }
        else
        {
            this.fim.setProximoPonteiro(elemento);
            this.fim = elemento;
        }
        this.numElement++;
    }

// remoção no inicio

    public void removerDoComeco()
    {
        this.inicio = this.inicio.getProximoPonteiro();
        this.numElement--;
        if (this.numElement == 0)
        {
            this.fim = null;
        }
    }

// remoção ao fim

    public void remover()
    {
        if (this.numElement == 1)
        {
            this.removerDoComeco();
        }
        else
        {
            No penultima = this.pegaNo(this.numElement-1);
            penultima.setProximoPonteiro(null);
            this.fim = penultima;
            this.numElement--;
        }
    }
}