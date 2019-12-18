/**
 * 
 */
package mx.com.bwl.mutation.service;

/**
 * @author claud
 *
 */
public class Mutation {

	private char[][] secuencia;
	
	public boolean hasMutation(String [] dna) {
        divide(dna);
        
        return MutacionOD(secuencia);
    }

    private void divide(String[] dna) {
        secuencia = new char[dna.length][dna.length];

        for (int i = 0; i < dna.length; i++) {

            for (int j = 0; j < dna.length; j++) {
                secuencia[i][j] = dna[i].charAt(j);
            }

        }
    }

    private boolean MutacionOD(char [][] matriz) {
        for (int i = 0; i <matriz.length/2 ; i++) {

            int j = 1, f = i+1;
            while( j < ((matriz[j].length-2) -i) )
            {
                if (matriz[j-1][f-1] == matriz[j][f] && matriz[j][f] == matriz[j+1][f+1] ){
                    if (matriz[j+1][f+1] == matriz[j+2][f+2] ){
                        return true;
                    }
                }

                if (matriz[f-1][j-1] == matriz[f][j] && matriz[f][j] == matriz[f+1][j+1] ){
                    if (matriz[f+1][j+1] == matriz[f+2][j+2] ){
                        return true;
                    }
                }

                j++;
                f++;
            }
        }

        return MutacionOI(matriz);
    }

    private boolean MutacionOI(char[][] matriz) {

        int k=0, l=0;
        for (int i = matriz.length; i >matriz.length/2 ; i--) {

            int j = 1, f = i-2;
            l = f;

            while ( j < l ){

                if (matriz[j-1][f+1] == matriz[j][f] && matriz[j][f] == matriz[j+1][f-1] ){
                    if (matriz[j+1][f-1] == matriz[j+2][f-2] ){
                        return true;
                    }
                }

                if (matriz[j-1+k][f+1+k] == matriz[j+k][f+k] && matriz[j+k][f+k] == matriz[j+1+k][f-1+k] ){
                    if (matriz[j+1+k][f-1+k] == matriz[j+2+k][f-2+k] ){
                        return true;
                    }
                }

                j++;
                f--;
            }

            k++;
        }


        return MutacionHV(matriz);
    }

    private boolean MutacionHV(char[][] matriz) {

        for (int i = 0; i < matriz.length ; i++) {
            int j = 1;

            while( j < matriz[j].length-2) {

                if (matriz[i][j-1] == matriz[i][j] && matriz[i][j] == matriz[i][j+1] ){
                    if (matriz[i][j+1] == matriz[i][j+2] ){
                        return true;
                    }
                }
                
                if (matriz[j-1][i] == matriz[j][i] && matriz[j][i] == matriz[j+1][i] ){

                    if (matriz[j+1][i] == matriz[j+2][i] ){
                        return true;
                    }
                }

                j++;
            }

        }

        return false;
    }
    
}
