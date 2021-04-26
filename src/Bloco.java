public class Bloco { // estrategia, definir oq é bloco separadamente dos ponteiros

    private int numCod;

    public Bloco(int codigo)
    {
        this.setnumCod(codigo);
    }

    public int getnumCod() {
        return numCod;
    }

    public void setnumCod(int codigo) {
        this.numCod = codigo;
    }
}
