package View;

import Arvore.ArvoreAVL;
import Entidades.Carro;

public class Main {

    static Carro[] carros = {new Carro("Gol", "70", "ABC1234"), //Tipo RL
            new Carro("Uno", "50", "DEF5678"),
            new Carro("Palio", "80", "GHI4156"),
            new Carro("CrossFox", "71", "JKL9879"),
            new Carro("Siena", "90", "MNO6572"),
            new Carro("Celta", "75", "PQR6129"),
    };

    static Carro[] carros2 = {new Carro("Gol", "50", "ABC1234"), //Tipo LR
            new Carro("Uno", "70", "DEF5678"),
            new Carro("Palio", "30", "GHI4156"),
            new Carro("CrossFox", "10", "JKL9879"),
            new Carro("Siena", "40", "MNO6572"),
            new Carro("Celta", "35", "PQR6129"),
    };

    static Carro[] carros3 = {new Carro("Gol", "50", "ABC1234"), //Tipo RR
            new Carro("Uno", "30", "DEF5678"),
            new Carro("Palio", "70", "GHI4156"),
            new Carro("CrossFox", "60", "JKL9879"),
            new Carro("Siena", "80", "MNO6572"),
            new Carro("Celta", "90", "PQR6129"),
    };

    static Carro[] carros4 = {new Carro("Gol", "50", "ABC1234"), //Tipo LL
            new Carro("Uno", "70", "DEF5678"),
            new Carro("Palio", "20", "GHI4156"),
            new Carro("CrossFox", "30", "JKL9879"),
            new Carro("Siena", "10", "MNO6572"),
            new Carro("Celta", "5", "PQR6129"),
    };

    static Carro[] carros5 = {new Carro("Gol", "100", "ABC1234"), //Para teste de um dos piores casos
            new Carro("Uno", "101", "DEF5678"),
            new Carro("Palio", "102", "GHI4156"),
            new Carro("CrossFox", "103", "JKL9879"),
            new Carro("Siena", "104", "MNO6572"),
            new Carro("Celta", "105", "PQR6129"),
    };



    public static void main(String[] args){
        ArvoreAVL arvore = new ArvoreAVL();  // Para teste da rotação RL
        ArvoreAVL arvore2 = new ArvoreAVL(); // Para teste da rotação LR
        ArvoreAVL arvore3 = new ArvoreAVL(); // Para teste da rotação RR
        ArvoreAVL arvore4 = new ArvoreAVL(); // Para teste da rotação LL
        ArvoreAVL arvore5 = new ArvoreAVL(); // Para teste de um dos piores casos com 6 elementos

        System.out.println("Árvore Balanceada exibida em Pré Ordem: ");
        arvore.inserir(carros[0]);
        arvore.inserir(carros[1]);
        arvore.inserir(carros[2]);
        arvore.inserir(carros[3]);
        arvore.inserir(carros[4]);
        arvore.inserir(carros[5]);
        arvore.preOrdem();
        System.out.println();

        System.out.println("Árvore Balanceada exibida em Pré Ordem: ");
        arvore2.inserir(carros2[0]);
        arvore2.inserir(carros2[1]);
        arvore2.inserir(carros2[2]);
        arvore2.inserir(carros2[3]);
        arvore2.inserir(carros2[4]);
        arvore2.inserir(carros2[5]);
        arvore2.preOrdem();
        System.out.println();

        System.out.println("Árvore Balanceada exibida em Pré Ordem: ");
        arvore3.inserir(carros3[0]);
        arvore3.inserir(carros3[1]);
        arvore3.inserir(carros3[2]);
        arvore3.inserir(carros3[3]);
        arvore3.inserir(carros3[4]);
        arvore3.inserir(carros3[5]);
        arvore3.preOrdem();
        System.out.println();

        System.out.println("Árvore Balanceada exibida em Pré Ordem: ");
        arvore4.inserir(carros4[0]);
        arvore4.inserir(carros4[1]);
        arvore4.inserir(carros4[2]);
        arvore4.inserir(carros4[3]);
        arvore4.inserir(carros4[4]);
        arvore4.inserir(carros4[5]);
        arvore4.preOrdem();
        System.out.println();

        System.out.println("Árvore Balanceada exibida em Pré Ordem: ");
        arvore5.inserir(carros5[0]);
        arvore5.inserir(carros5[1]);
        arvore5.inserir(carros5[2]);
        arvore5.inserir(carros5[3]);
        arvore5.inserir(carros5[4]);
        arvore5.inserir(carros5[5]);
        arvore5.preOrdem();
        System.out.println();

    }

}
