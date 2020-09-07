package Entidades;

public class Carro implements Comparable<Carro>{

    private String modelo;
    private String numIden; // Número de identificação(Apenas um número qualquer para servir de ordenação)
    private String placa;

    public Carro(String modelo, String numIden, String placa){
        this.modelo = modelo;
        this.numIden = numIden;
        this.placa = placa;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getNumIden(){
        return this.numIden;
    }

    public void setNumIden(String numIden){
        this.numIden = numIden;
    }

    public String getPlaca(){
        return this.placa;
    }

    public void setPlaca(){
        this.placa = placa;
    }

    @Override
    public int compareTo(Carro carro){
        return this.numIden.compareTo(carro.numIden);
    }

    @Override
    public String toString(){
        return "Placa : " +this.placa+" / Modelo: "+this.modelo+" / Numero de Identificação: "+this.numIden;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Carro)){
            return false;
        }
        Carro c = (Carro) o;
        return this.numIden.equalsIgnoreCase(c.numIden);
    }
}
