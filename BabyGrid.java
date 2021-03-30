import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BabyGrid {

    int[][] puzzle;
    int[] solutionSet;

    String solution = "";

    public BabyGrid(String fileName, int N) throws FileNotFoundException {
        
        Scanner in = new Scanner(new File(fileName));

        int sizeOfPuzzle = N;

        puzzle = new int[sizeOfPuzzle][sizeOfPuzzle];
        solutionSet = new int[sizeOfPuzzle];

        for (int i=0;i<N;i++){
            solutionSet[i] = in.nextInt();
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                puzzle[i][j] = in.nextInt();
            }
        }

        dFSPuzzle(puzzle, 0);
    }
    /*Backtracking algorithm*/
    
    
    private void dFSPuzzle(int[][] pz, int current){            
        int curr = current;  
        if(curr<9){
            for(int i=0; i<solutionSet.length;i++){
                if(promising(pz, current, solutionSet[i])){
                    pz[current / pz.length][current % pz.length] = solutionSet[i];
                    
                    System.out.println(curr);
                    System.out.println(toString());
                    
                    curr++;
                    dFSPuzzle(pz,curr);
                }
            }
        }
            
    }
    

    private boolean promising(int[][] pz, int current, int check){
        boolean decision = true;
         int rowIndex = current / pz.length;
         int colmIndex = current % pz.length;
         for(int i=0; i<pz.length;i++){
              if(check == pz[rowIndex][i]){
                 decision = false;
             }
             if(check ==pz[i][colmIndex]){
                decision = false;
            }
         }

        return decision;
        
    }



    /**Jargons at bottom**/

    public String solution() {
        String elem="|";
        for(int i=0;i<puzzle.length;i++){
            for(int j=0;j<puzzle[i].length;j++){
                elem+=String.valueOf(puzzle[i][j]);
            }
            elem+="|";
        }
        return elem;
    }

    public String toString() {
        String results= "";
        for(int i=0; i< puzzle.length; i++){
            results += Arrays.toString(puzzle[i])+"\n";
        }
        return results;
    }

}
