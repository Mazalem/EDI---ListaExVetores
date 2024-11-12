import java.util.Random;

public class Ex2 {
    public static void main(String[] args) {
        int[] vetor = new int[100];
        preencheVetor(vetor);
        System.out.print("Vetor Final:  ");
        exibeVetor(vetor);
    }

    public static int[] preencheVetor(int[] vetor) {
        int mod = 0;
        int uPosPreenchida = 0;
        for (int i = 0; i < vetor.length; i++) {
            mod = geraAleatorio(3);
            if (mod == 1) {
                if (i == 0) {
                    vetor[i] = geraAleatorio(10);
                } else {
                    uPosPreenchida = insereAntesDe(vetor, 0);
                }

            } else if (mod == 2) {
                if (i == 0) {
                    vetor[i] = geraAleatorio(10);
                }
                else {
                    for(int j = 0; j < vetor.length; j++) {
                        if(vetor[j] == 0) {
                            vetor[j] = geraAleatorio(10);
                            uPosPreenchida = j;
                            break;
                        }
                    }
                }
            } else {
                if (i == 0) {
                    vetor[i] = geraAleatorio(10);
                }
                else {
                    uPosPreenchida = insereAntesDe(vetor, uPosPreenchida);
                }
            }
            System.out.println("Opção: " + mod + "\n");
            exibeVetor(vetor);
        }
        return vetor;
    }

    public static int insereAntesDe(int[] vetor, int x) {
        for (int j = vetor.length - 1; j > x; j--) {
            if (vetor[j - 1] != 0) {
                vetor[j] = vetor[j - 1];
            }
        }
        vetor[x] = geraAleatorio(10);
        return x;
    }

    public static int geraAleatorio(int fim) {
        return 1 + new Random().nextInt(fim);
    }

    public static void exibeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n\n");
    }

}
