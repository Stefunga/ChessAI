# Java Chess
Play chess in your terminal vs simple MinMax Algorithm.

# Motivation
Was interested in different components of making a chess game, beginning with the core engine. Afterwards added an AI player to compete with.

# How to use?
  - ## Install the package.
    ```
    git clone https://github.com/Stefunga/ChessAI
    ```
  - ## Run jar file

    ```
    java -jar chess.jar
    ```
Code Example
- # Program built from six main components 
 - ## Piece.
 -Component used to set characterisics of pieces.
 -Ex.
 ```
 public class Piece {
	Boolean black;
	Boolean first;
	String type;
	
	public Piece()
	{
		black=null;
		first=null;
	}
	public void CreatePawn(Boolean b)
	{
		black=b;
		first=true;
		setType("P");
		//Pawn p = new Pawn(black);
		
	}
}
 ```
 - ## Board.
 - ## Game.
 - ## MoveVerify.
 - ## MinMax.
 - ## Test.

