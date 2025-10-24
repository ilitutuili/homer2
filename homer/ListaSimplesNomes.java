public class ListaSimplesNomes {

    class No {
        String nome;
        No prox;

        public No(String nome) {
            this.nome = nome;
            this.prox = null;
        }
    }

    private No cabeca;
    private int tamanho;

    public ListaSimplesNomes() {
        cabeca = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return cabeca == null;
    }

    public int tamanho() {
        return tamanho;
    }

    // Inserir no início
    public void inserirInicio(String nome) {
        No novo = new No(nome);
        novo.prox = cabeca;
        cabeca = novo;
        tamanho++;
    }

    // Inserir no fim
    public void inserirFim(String nome) {
        No novo = new No(nome);
        if (estaVazia()) {
            cabeca = novo;
        } else {
            No atual = cabeca;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            atual.prox = novo;
        }
        tamanho++;
    }

    // Inserir em uma posição específica (0-based)
    public void inserirPosicao(int pos, String nome) {
        if (pos < 0 || pos > tamanho) {
            System.out.println("Posição inválida!");
            return;
        }

        if (pos == 0) {
            inserirInicio(nome);
            return;
        }

        if (pos == tamanho) {
            inserirFim(nome);
            return;
        }

        No novo = new No(nome);
        No atual = cabeca;
        for (int i = 0; i < pos - 1; i++) {
            atual = atual.prox;
        }
        novo.prox = atual.prox;
        atual.prox = novo;
        tamanho++;
    }

    // Remover do início
    public void removerInicio() {
        if (estaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        cabeca = cabeca.prox;
        tamanho--;
    }

    // Remover do fim
    public void removerFim() {
        if (estaVazia()) {
            System.out.println("Lista vazia!");
            return;
        }
        if (cabeca.prox == null) {
            cabeca = null;
        } else {
            No atual = cabeca;
            while (atual.prox.prox != null) {
                atual = atual.prox;
            }
            atual.prox = null;
        }
        tamanho--;
    }

    // Remover por posição
    public void removerPosicao(int pos) {
        if (pos < 0 || pos >= tamanho || estaVazia()) {
            System.out.println("Posição inválida!");
            return;
        }

        if (pos == 0) {
            removerInicio();
            return;
        }

        No atual = cabeca;
        for (int i = 0; i < pos - 1; i++) {
            atual = atual.prox;
        }
        atual.prox = atual.prox.prox;
        tamanho--;
    }

    // Buscar por nome
    public boolean buscar(String nome) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.nome.equals(nome))
                return true;
            atual = atual.prox;
        }
        return false;
    }

    // Imprimir lista
    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Lista vazia.");
            return;
        }
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.nome + " -> ");
            atual = atual.prox;
        }
        System.out.println("null");
    }

    // Limpar a lista
    public void limpar() {
        cabeca = null;
        tamanho = 0;
    }
}