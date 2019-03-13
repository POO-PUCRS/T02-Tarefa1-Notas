public class Notas{
    private static final int MAXNOTAS = 10;
    private int notas[];
    private int qtdade;
    private boolean calculoOk;

    public Notas(){
        notas = new int[MAXNOTAS];
        qtdade = 0; 
        calculoOk = false;
    }

    public int getQtdade(){
        return qtdade;
    }

    public int getNota(int indice){
        if (indice < 0 || indice >= MAXNOTAS){
            return -1;
        }else{
            return notas[indice];
        }
    }

    public int getNotaFinal(){
        if (!calculoOk){
            return -1;
        }else{
            return notas[qtdade];
        }
    }

    public boolean infoNota(int nota){
        if (qtdade == MAXNOTAS-1){
            return false;
        }else{
            notas[qtdade] = nota;
            qtdade++;
            calculoOk = false;
            return true;
        }
    }

    public boolean calculaNotaFinal(){
        if (calculoOk || qtdade <= 1){
            return false;
        }
        // Procura indice do menor valor
        int menor = notas[0];
        int indiceMenor = 0;
        for(int i=0;i<qtdade;i++){
            if (menor > notas[i]){
                menor = notas[i];
                indiceMenor = i;
            }
        }
        // Remove o menor valor do vetor
        for(int i=indiceMenor;i<qtdade-1;i++){
            notas[i] = notas[i+1];
        }
        qtdade--;
        // Calcula o somatório do vetor
        int somatorio = 0;
        for(int i=0;i<qtdade;i++){
            somatorio += notas[i];
        }
        // Armazena a nota final na última posicao ocupada do vetor
        notas[qtdade] = somatorio;
        calculoOk = true;
        return true;
    }
}