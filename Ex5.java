import java.util.ArrayList;

public class Ex5 {
    public static void main(String[] args) {
        int[] vetor = {5, 3, 8, 1, 2};
        imprimeOrdenado(vetor);
    }

    public static void imprimeOrdenado(int[] desordenado) {
        int posicaoMaior = 0;
        int maiorValor = desordenado[posicaoMaior];
        for(int i = 0; i < desordenado.length; i++)
            if(maiorValor < desordenado[i]){
                posicaoMaior = i;
                maiorValor = desordenado[i];
            }

        int menor;
        int anterior = posicaoMaior;
        ArrayList<Integer> anteriores = new ArrayList<>();

        for(int i = 0; i < desordenado.length; i++) {
            menor = maiorValor;
            for (int j = 0; j < desordenado.length; j++) {
                if(menor > desordenado[j] && !anteriores.contains(j)) {
                    menor = desordenado[j];
                    anterior = j;
                }
            }
            anteriores.add(anterior);
            System.out.print(menor + " ");
        }
    }
}