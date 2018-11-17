package chess;

public class MinMax {

    private static double maxPly;

    private MinMax() {}


    static void run (boolean player, Board board, double maxPly) {
        if (maxPly < 1) {
            throw new IllegalArgumentException("Maximum depth must be greater than 0.");
        }

        MinMax.maxPly = maxPly;
        miniMax(player, board, 0);
    }
    
    private static int miniMax (boolean player, Board board, int currentPly) {
		return currentPly;
        
    }

    private static int getMax (boolean white, Board board, int currentPly) {
		return currentPly;
      
    }

    private static int getMin (boolean white, Board board, int currentPly) {
		return currentPly;
     
    }
    
    private static int score (boolean white, Board board) {
		return 0;
    
    }


}
