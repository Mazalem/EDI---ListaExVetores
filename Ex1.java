import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        int[] vetor = geraVetor();
        exibeVetor(vetor);
        vetor = apagaPares(vetor);
        exibeVetor(vetor);
    }

    public static void exibeVetor(int[] vetor) {
        for(int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n");
    }

    public static int[] geraVetor() {
        Random aleatorio = new Random();
        int[] vetor = new int[10];
        for(int i = 0; i < 10; i++) {
            vetor[i] = aleatorio.nextInt(101);
        }
        return vetor;
    }

    public static int[] apagaPares(int[] vetor) {
        int tamanho = vetor.length;
        for(int i = 0; i < tamanho; i++) {
            if(vetor[i] % 2 == 0) {
                for(int j = i+1; j < tamanho; j++) {
                    vetor[j-1] = vetor[j];
                }
                i--;
                tamanho--;
            }
        }
        for(int j = tamanho; j < vetor.length; j++) {
            vetor[j] = 0;
        }
        return vetor;
    }
}