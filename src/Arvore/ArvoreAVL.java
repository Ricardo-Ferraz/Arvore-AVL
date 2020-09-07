package Arvore;

public class ArvoreAVL <T extends Comparable<T>>{

    private NoAVL<T> raiz;

    public ArvoreAVL(){
        this.raiz = null;
    }

    public void inserir(T elemento){
        this.raiz = inserirP(this.raiz, elemento);
    }

    private NoAVL<T> inserirP(NoAVL<T> raiz, T elemento){
        if(raiz == null){
            return new NoAVL<>(elemento);
        }
        int aux = elemento.compareTo(raiz.getElemento());

        if(aux < 0){
            raiz.setEsquerda(inserirP(raiz.getEsquerda(), elemento));
            balanceamento(raiz);
            raiz = defineRotacao(raiz);
        }

        else if(aux > 0){
            raiz.setDireita(inserirP(raiz.getDireita(), elemento));
            balanceamento(raiz);
            raiz = defineRotacao(raiz);
        }

        else{
            raiz.setElemento(elemento);
            balanceamento(raiz);
            raiz = defineRotacao(raiz);
        }
        return raiz;
    }

    public void remove(T elemento){
        removeP(this.raiz, elemento);
    }

    public NoAVL<T> removeP(NoAVL<T> raiz, T elemento){
        if(raiz == null){
            return null;
        }

        int aux = elemento.compareTo(raiz.getElemento());

        if(aux > 0){              // Numero de identificação maior
            raiz.setDireita(removeP(raiz.getDireita(), elemento));
            defineRotacao(raiz);
            balanceamento(raiz);
            return raiz;
        }

        if(aux < 0){              //Numero de idenitficação menor
            raiz.setEsquerda(removeP(raiz.getEsquerda(), elemento));
            defineRotacao(raiz);
            balanceamento(raiz);
            return raiz;
        }
        else{

            if(raiz.getDireita() == null && raiz.getEsquerda() == null){    //Não possui nem esquerda nem direita, só remove
                return null;
            }

            else{
                if(raiz.getDireita() != null && raiz.getEsquerda() != null){         //Tem esquerda e direita
                    raiz.setElemento(menorValor(raiz.getDireita()).getElemento());   //O novo elemento é o menor valor pela direita da raiz
                    raiz.setDireita(removeP(raiz.getDireita(), raiz.getElemento())); //Recursividade para remover o menor valor a direita para não deixar o novo elemento duplicado
                }

                else if(raiz.getDireita() != null){
                    raiz = raiz.getDireita();
                    balanceamento(raiz);
                    return raiz;
                }

                else{
                    raiz = raiz.getEsquerda();
                    balanceamento(raiz);
                    return raiz;
                }
            }
        }
        return raiz;
    }

    private NoAVL<T> menorValor(NoAVL<T> raiz){
        while(raiz.getEsquerda() != null){
            raiz = raiz.getEsquerda();
        }
        return raiz;
    }

    private NoAVL<T> defineRotacao(NoAVL<T> raiz){
        if(raiz.getBalanceamento() < -1){
            if(raiz.getDireita().getBalanceamento() < 0){
                System.out.println("Fez RR");
                raiz = rotacaoRR(raiz);
            }
            else{
                System.out.println("Fez RL");
                raiz = rotacaoRL(raiz);
            }
        }

        else if(raiz.getBalanceamento() > 1){
            if(raiz.getEsquerda().getBalanceamento() > 0){
                System.out.println("Fez LL");
                raiz = rotacaoLL(raiz);
            }
            else{
                System.out.println("Fez LR");
                raiz = rotacaoLR(raiz);
            }
        }
        return raiz;
    }

    private NoAVL<T> rotacaoLL(NoAVL<T> raiz){  // Rotação simples a direita
        NoAVL<T> aux;
        if(raiz == null){
            return null;
        }
            aux = raiz.getEsquerda();
            raiz.setEsquerda(aux.getDireita());
            aux.setDireita(raiz);
            balanceamento(aux);
            return aux;
    }

    private NoAVL<T> rotacaoRR(NoAVL<T> raiz){  // Rotação simples a esquerda
        NoAVL<T> aux;
        if(raiz == null){
            return null;
        }
            aux = raiz.getDireita();
            raiz.setDireita(aux.getEsquerda());
            aux.setEsquerda(raiz);
            balanceamento(aux);
            return aux;
    }

    private NoAVL<T> rotacaoLR(NoAVL<T> raiz){  // Rotação dupla esquerda e direita
        if(raiz == null){
            return null;
        }
            raiz.setEsquerda(rotacaoRR(raiz.getEsquerda()));
            return rotacaoLL(raiz);

    }


    private NoAVL<T> rotacaoRL(NoAVL<T> raiz){  // Rotação dupla direita e esquerda
        if(raiz == null){
            return null;
        }
            raiz.setDireita(rotacaoLL(raiz.getDireita()));
            return rotacaoRR(raiz);

    }

    public T busca(T elemento){
        return buscaP(this.raiz, elemento);
    }

    private T buscaP(NoAVL<T> raiz, T elemento){ // Busca simples
        if(raiz == null){
            return null;
        }

        int aux = elemento.compareTo(raiz.getElemento());
        if(aux < 0){
          return buscaP(raiz.getEsquerda(), elemento);
        }
        else if(aux > 0){
           return buscaP(raiz.getDireita(), elemento);
        }
        else{
            return raiz.getElemento();
        }
    }

    private void balanceamento(NoAVL<T> raiz){ // Coloca o coeficiente de balanceamento em toda uma subárvore
        int aux = acharAltura(raiz.getEsquerda())  -  acharAltura(raiz.getDireita());
        raiz.setBalanceamento(aux);

        if(raiz.getEsquerda() != null){
            balanceamento(raiz.getEsquerda());
        }
        if(raiz.getDireita() != null){
            balanceamento(raiz.getDireita());
        }

    }

    private int acharAltura(NoAVL<T> raiz) {  // Usado para achar a altura
        if(raiz == null){
            return -1;
        }

        if(raiz.getEsquerda() == null){
            return acharAltura(raiz.getDireita()) + 1; // Percorre toda a subárvore a direita retornando a devida altura
        }
        else if(raiz.getDireita() == null){
            return acharAltura(raiz.getEsquerda()) + 1; // Percorre toda a subárvore a esquerda retornando a devida altura
        }
        else if(raiz.getEsquerda() == null && raiz.getDireita() == null){
            return 0; // Não há nem esquerda nem direita, logo 0
        }
        else{ // Caso exista direita e esquerda, compara-se a altura e soma-se 1 a maior altura
            return maiorValorEntre((acharAltura(raiz.getDireita())), acharAltura(raiz.getEsquerda())) + 1;
        }

    }

    public void preOrdem(){
        preOrdemP(this.raiz);
    }

    private void preOrdemP(NoAVL<T> raiz){
        System.out.println(raiz+"");
        if (raiz.getEsquerda() != null) {
            preOrdemP(raiz.getEsquerda());
        }

         if (raiz.getDireita() != null) {
            preOrdemP(raiz.getDireita());
        }
    }

    private int maiorValorEntre(int a, int b){
        if(a > b){
            return a;
        }
        else {
            return b;
        }
    }
}

