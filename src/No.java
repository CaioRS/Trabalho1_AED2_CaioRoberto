public class No {


    private Bloco elemento;     // derivar da classe bloco + um ponteiro, vide liguagem C
    private No ponteiro;    // apontador para o prox No

 
    public No(No proximoPonteiro, int codigo)
    {
        this.setProximoPonteiro(proximoPonteiro);
        this.setElemento(new Bloco(codigo));
    }

    public No(int codigo)
    {
        this.setElemento(new Bloco(codigo));
    }



    public Bloco getElemento() {
        return elemento;
    }
    public void setElemento(Bloco elemento) {
        this.elemento = elemento;
    }
    public No getProximoPonteiro() {
        return ponteiro;
    }
    public void setProximoPonteiro(No proximoPonteiro) {
        this.ponteiro = proximoPonteiro;
    }

    
}
