import java.util.Random;
public class Ex6 {
    public static void main(String[] args) {
        int[] vetor1 = {5,3,9,8,1};
        int[] vetor2 = {2,6,4,7,0};
        try{
            exibeVetor(preencheVetor(vetor1, vetor2));
        }catch(IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static int[] preencheVetor(int[] vetor1, int[] vetor2) throws IllegalArgumentException {
        if(vetor1.length != vetor2.length) {
            throw new IllegalArgumentException("Os dois vetores precisam ter o mesmo tamanho.");
        }

        int[] vetor3 = new int[vetor1.length];
        Random random = new Random();
        int aleatorio;
        int ultimoPar = 0, ultimoImpar = 0;
        for(int i = 0; i < vetor1.length; i++) {
            aleatorio = random.nextInt();
            if(aleatorio % 2 == 0) {
                vetor3[i] = vetor1[ultimoPar++];
            }
            else {
                vetor3[i] = vetor2[ultimoImpar++];
            }
        }
        return vetor3;
    }

    public static void exibeVetor(int[] vetor) {
        for(int numero : vetor) {
            System.out.print(numero + " ");
        }
    }
}
