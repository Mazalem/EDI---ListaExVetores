import java.util.NoSuchElementException;

public class Ex5 {
    public static void main(String[] args) {
        int[] vetor = {23, 45, 12, 78, 34, 67, 89, 10, 56, 90};
        try{
            imprimeOrdenado(vetor);
        }catch(NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void imprimeOrdenado(int[] desordenado) {
        if(desordenado[0] == 0) {
            throw new NoSuchElementException("O vetor não pode ser vazio.");
        }
        int menor = desordenado[0], posMaior = 0, anterior = 0;

        for(int i = 0; i < desordenado.length; i++) {
            if(menor < desordenado[i]){
                posMaior = i;
            }
        }

        for(int i = 0; i < desordenado.length; i++) {
            menor = desordenado[posMaior];
            for(int j = 0; j < desordenado.length; j++) {
                if(desordenado[j] > anterior && desordenado[j] < menor) {
                    menor = desordenado[j];
                }
            }
            anterior = menor;
            System.out.print(menor + " ");
        }
    }
}