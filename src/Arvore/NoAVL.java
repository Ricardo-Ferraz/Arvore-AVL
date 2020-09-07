package Arvore;

public class NoAVL <T extends Comparable<T>>{

    private NoAVL<T> esquerda;
    private NoAVL<T> direita;
    private int balanceamento; // Pode ser susbtituido por Coeficiente de Balanceamento
    private T elemento;

    public NoAVL(T carro){
        this.esquerda = null;
        this.direita = null;
        this.balanceamento = 0;
        this.elemento = carro;
    }

    public NoAVL<T> getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(NoAVL<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoAVL<T> getDireita() {
        return this.direita;
    }

    public void setDireita(NoAVL<T> direita) {
        this.direita = direita;
    }

    public int getBalanceamento() {
        return this.balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public T getElemento() {
        return this.elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public int compareTo(T elemento){
        return this.elemento.compareTo(elemento);
    }

    @Override
    public String toString(){
        return this.elemento.toString() + " / Coeficiente: "+this.balanceamento;
    }
}
