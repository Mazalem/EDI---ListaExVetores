import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex4 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vetor = { 1, 2, 3, 4, 5, 6, 7, 0, 0, 0 }; // new int[10];
        apresentaOpcoes(vetor);
        teclado.close();
    }

    public static void apresentaOpcoes(int[] vetor) {
        int opcao;
        do {
            exibeVetor(vetor);
            System.out.println("1 - Incluir");
            System.out.println("2 - Excluir");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção (1-3): ");
            while (true) {
                try {
                    opcao = teclado.nextInt();
                    if (opcao >= 1 && opcao <= 3)
                        break;
                    System.err.print("Escolha uma opção válida (1-3): ");
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
                case 3:
                    System.exit(0);
            }
        } while (opcao != 3);
    }

    public static void inclusao(int[] vetor) {
        System.out.println("\n\n\n\n\n");
        int opcao;

        while (true) {
            exibeVetor(vetor);
            System.out.println("1 - Inserir no início");
            System.out.println("2 - Inserir no final");
            System.out.println("3 - Inserir no meio");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha uma opção (1-4): ");
            opcao = digitaInteiro();
            if (opcao > 0 && opcao < 5)
                break;
            System.err.println("\n\nDigite uma opção válida(1-4).");
        }

        switch (opcao) {
            case 1:
                System.out.print("Digite o número a ser inserido no início: ");
                int valorInicio = digitaInteiro();
                for (int i = vetor.length - 1; i > 0; i--) {
                    vetor[i] = vetor[i - 1];
                }
                vetor[0] = valorInicio;
                break;
            case 2:
                System.out.print("Digite o número a ser inserido no final: ");
                int valorFinal = digitaInteiro();
                for (int i = 0; i < vetor.length; i++) {
                    if (vetor[i] == 0) {
                        vetor[i] = valorFinal;
                        break;
                    }
                }
                break;
            case 3:
                int primeiroOcupado = 0, ultimoOcupado = vetor.length - 1;

                while (vetor[primeiroOcupado] == 0)
                    primeiroOcupado++;
                while (vetor[ultimoOcupado] == 0)
                    ultimoOcupado--;

                System.out.print("Você pode inserir entre as posições: ");
                for (int i = primeiroOcupado + 1; i < ultimoOcupado; i++) {
                    System.out.print((i + 1) + " ");
                }

                int posicaoInsercao;
                while (true) {
                    System.out.print("\nDigite a posição onde deseja inserir: ");
                    posicaoInsercao = digitaInteiro();
                    if (posicaoInsercao > primeiroOcupado + 1 && posicaoInsercao <= ultimoOcupado) {
                        break;
                    }
                    System.err.println("Digite uma posição válida dentro do intervalo.");
                }

                System.out.print("Digite o número a ser inserido: ");
                int valorMeio = digitaInteiro();
                for (int i = vetor.length - 1; i > posicaoInsercao - 1; i--) {
                    vetor[i] = vetor[i - 1];
                }
                vetor[posicaoInsercao - 1] = valorMeio;
                break;
        }

        System.out.println("\n\n\n\n\n");
    }

    public static void excluir(int[] vetor) {
        System.out.println("\n\n\n\n\n");
        int opcao;

        while (true) {
            exibeVetor(vetor);
            System.out.println("1 - Excluir o primeiro");
            System.out.println("2 - Excluir o último");
            System.out.println("3 - Excluir algum do meio");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha uma opção (1-4): ");
            opcao = digitaInteiro();
            if (opcao > 0 && opcao < 5)
                break;
            System.err.println("\n\nDigite uma opção válida(1-4).");
        }

        switch (opcao) {
            case 1:
                for (int i = 0; i < vetor.length - 1; i++) {
                    vetor[i] = vetor[i + 1];
                }
                vetor[vetor.length - 1] = 0;
                break;

            case 2:
                for (int i = vetor.length - 1; i >= 0; i--) {
                    if (vetor[i] != 0) {
                        vetor[i] = 0;
                        break;
                    }
                }
                break;
            case 3:
                int ultimo = vetor.length - 2, posicao;
                System.out.println("\n\n\n\n");
                exibeVetor(vetor);
                System.out.print("Você pode excluir as seguintes posições: ");
                for (int i = 1; i < vetor.length - 1; i++) {
                    System.out.print((i + 1) + " ");
                    if (i + 2 < vetor.length - 1 && vetor[i + 2] == 0) {
                        ultimo = i;
                        break;
                    }
                }

                while (true) {
                    System.out.print("\nDigite a posição que deseja excluir: ");
                    posicao = digitaInteiro();
                    if (posicao > 1 && posicao <= ultimo + 1) {
                        break;
                    }
                    System.err.println("\n\nDigite uma posição válida.");
                }

                for (int j = posicao - 1; j <= ultimo; j++) {
                    vetor[j] = vetor[j + 1];
                    if (j == ultimo) {
                        vetor[j + 1] = 0;
                        break;
                    }
                }
                break;
        }

        System.out.println("\n\n\n\n\n");
    }

    public static int digitaInteiro() {
        int inteiro;
        while (true) {
            try {
                inteiro = teclado.nextInt();
                if (inteiro > 0)
                    break;
                System.err.print("O valor deve ser maior que 0. Tente novamente: ");
            } catch (InputMismatchException ex) {
                System.err.print("Somente inteiros são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return inteiro;
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

    public static boolean temEspacoLivre(int[] vetor) {
        for (int num : vetor) {
            if (num == 0)
                return true;
        }
        return false;
    }

    public static boolean temPosicaoOcupada(int[] vetor) {
        for (int num : vetor) {
            if (num != 0)
                return true;
        }
        return false;
    }
}
