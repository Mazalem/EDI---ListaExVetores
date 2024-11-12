import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex4 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vetor = new int[10];
        apresentaOpcoes(vetor);
        teclado.close();
    }

    public static void apresentaOpcoes(int[] vetor) {
        int opcao;
        do {
            exibeVetor(vetor);
            exibePosicoesLivres(vetor);
            exibePosicoesOcupadas(vetor);
            System.out.println("1 - Incluir");
            System.out.println("2 - Excluir");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção (1-3): ");
            while (true) {
                try {
                    opcao = teclado.nextInt();
                    if (opcao >= 1 && opcao <= 3) break;
                    System.err.println("Escolha uma opção válida (1-3): ");
                } catch (InputMismatchException ex) {
                    System.err.println("Somente inteiros de 1-3 são permitidos.");
                    teclado.next();
                }
            }

            switch (opcao) {
                case 1: 
                    if (temEspacoLivre(vetor)) {
                        inclusao(vetor);
                    } else {
                        System.out.println("\n\n\n\n\n");
                        System.out.println("Não há posições livres para inclusão.");
                    }
                    break;
                case 2:
                    if (temPosicaoOcupada(vetor)) {
                        excluir(vetor);
                    } else {
                        System.out.println("\n\n\n\n\n");
                        System.out.println("Não há posições ocupadas para exclusão.");
                    }
                    break;
                case 3: System.exit(1);
            }
        } while (opcao != 3);
    }

    public static void inclusao(int[] vetor) {
        System.out.println("\n\n\n\n\n");
        exibeVetor(vetor);
        exibePosicoesLivres(vetor);
        System.out.print("Digite a posição a ser inserida: ");
        int posicao;
        while (true) {
            posicao = digitaPosicao();
            if (vetor[posicao - 1] == 0) break;
            System.err.print("Posição já ocupada. Tente outra posição:");
        }
        System.out.print("Digite o valor desejado: ");
        vetor[posicao - 1] = digitaInteiro();
        System.out.println("\n\n\n\n\n");
    }

    public static void excluir(int[] vetor) {
        System.out.println("\n\n\n\n\n");
        exibeVetor(vetor);
        exibePosicoesOcupadas(vetor);
        System.out.print("Digite a posição a ser excluída: ");
        int posicao;
        while (true) {
            posicao = digitaPosicao();
            if (vetor[posicao - 1] != 0) break;
            System.err.print("Posição vazia. Tente uma posição ocupada:");
        }
        vetor[posicao - 1] = 0;
        System.out.println("\n\n\n\n\n");
    }

    public static int digitaInteiro() {
        int inteiro;
        while (true) {
            try {
                inteiro = teclado.nextInt();
                if (inteiro != 0) break;
                System.err.println("O valor deve ser maior que 0.");
            } catch (InputMismatchException ex) {
                System.err.println("Somente inteiros são permitidos.");
                teclado.next();
            }
        }
        return inteiro;
    }

    public static int digitaPosicao() {
        int posicao;
        while (true) {
            posicao = digitaInteiro();
            if (posicao >= 1 && posicao <= 10) break;
            System.err.print("Posição fora do intervalo (1-10). Tente novamente:");
        }
        return posicao;
    }

    public static void exibeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != 0)
                System.out.print(vetor[i] + " ");
            else
                System.out.print("_ ");
        }
        System.out.println();
    }
    
    public static void exibePosicoesLivres(int[] vetor) {
        ArrayList<Integer> livres = new ArrayList<>();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == 0) {
                livres.add(i + 1);
            }
        }
        System.out.print("Posições livres: ");
        for (Integer pos : livres) {
            System.out.print(pos + " ");
        }
        System.out.println();
    }

    public static void exibePosicoesOcupadas(int[] vetor) {
        ArrayList<Integer> ocupadas = new ArrayList<>();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != 0) {
                ocupadas.add(i + 1);
            }
        }
        System.out.print("Posições ocupadas: ");
        for (Integer pos : ocupadas) {
            System.out.print(pos + " ");
        }
        System.out.println();
    }

    public static boolean temEspacoLivre(int[] vetor) {
        for (int num : vetor) {
            if (num == 0) return true;
        }
        return false;
    }

    public static boolean temPosicaoOcupada(int[] vetor) {
        for (int num : vetor) {
            if (num != 0) return true;
        }
        return false;
    }
}
