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
# Playing the game
![alt text](https://github.com/Stefunga/ChessAI/blob/master/Screen%20Shot%202019-07-06%20at%2012.30.12%20PM.png)

- Enter location of piece by submitting X press enter, then Y press enter. Next enter the destination location in the same order. X and Y cords can be seen along the sides of the board. The game continues until checkmate where it restarts. 
# Code Example
Program built from six main components 
 - ## Piece.
 Component used to set characterisics of pieces.

 Example of create pawn method.
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
   Board object, 2D array that generates pieces and places them on initial locations. This object gets manipulated 	throughout the game
  Example of board creation method.
  ```
  public void createBoard(){
		a= new Piece[8][8];
		//For loop to create and place both black and white pawns
		for(int x=0; x<8; x++ )
		{
			Piece c= new Piece();
			c.CreatePawn(false);
			a[x][1]=c;
			//Pawn made at [%d][1]
			Piece c2= new Piece();
			c2.CreatePawn(true);
			a[x][6]=c2;
			//Pawn made at [%d][6]
		}
		//create and place rook pieces
		Piece r= new Piece();
		r.CreateRook(false);
		a[7][0]=r;
		Piece r2= new Piece();
		r2.CreateRook(false);
		a[0][0]=r2;
		Piece r3= new Piece();
		r3.CreateRook(true);
		a[7][7]=r3;
		Piece r4= new Piece();
		r4.CreateRook(true);
		a[0][7]=r4;
		//create and place knight pieces
		Piece k= new Piece();
		k.CreateKnight(false);
		a[6][0]=k;
		Piece k2= new Piece();
		k2.CreateKnight(false);
		a[1][0]=k2;
		Piece k3= new Piece();
		k3.CreateKnight(true);
		a[6][7]=k3;
		Piece k4= new Piece();
		k4.CreateKnight(true);
		a[1][7]=k4;
		//create and place bishop pieces
		Piece b= new Piece();
		b.CreateBishop(false);
		a[5][0]=b;
		Piece b2= new Piece();
		b2.CreateBishop(false);
		a[2][0]=b2;
		Piece b3= new Piece();
		b3.CreateBishop(true);
		a[2][7]=b3;
		Piece b4= new Piece();
		b4.CreateBishop(true);
		a[5][7]=b4;
		//create and place Queens
		Piece q= new Piece();
		q.CreateQueen(false);
		a[3][0]=q;
		Piece q2= new Piece();
		q2.CreateQueen(true);
		a[3][7]=q2;
		//create and place Kings
		Piece K= new Piece();
		K.CreateKing(false);
		a[4][0]=K;
		Piece K2= new Piece();
		K2.CreateKing(true);
		a[4][7]=K2;	
	}
  ```
 - ## Game.
  Object that handles switching turns and inputs
  Example of game constructer.
 ```
 	public Game()
	{
		Board play= new Board();
		playGame(white, play);
	}
 ```
 - ## MoveVerify.
  Takes an inputed or computer generated move and makes sure it's valid.
  Example from moveVerify, takes input checks what piece it is then moves to piece method to check if valid.
 ```
 public moveVerify(int initLocX, int initLocY, int destLocX, int destLocY, boolean white, Board b)
	{
		valid=true;
		out=b;
		this.white=white;
	//Case statement that goes through possibilities of type
		if(b.getPiece(initLocX, initLocY).getType()=="P")	
		{
			movePawn(initLocX,initLocY,destLocX,destLocY,b);
			return;
		}
		if(b.getPiece(initLocX, initLocY).getType()=="R")	
		{
			moveRook(initLocX,initLocY,destLocX,destLocY,b);
			return;
		}
		if(b.getPiece(initLocX, initLocY).getType()=="k")	
		{
			moveKnight(initLocX,initLocY,destLocX,destLocY,b);
			return;
		}
		if(b.getPiece(initLocX, initLocY).getType()=="B")	
		{
			moveBishop(initLocX,initLocY,destLocX,destLocY,b);
			return;
		}
		if(b.getPiece(initLocX, initLocY).getType()=="Q")	
		{
			moveQueen(initLocX,initLocY,destLocX,destLocY,b);
			return;
		}
		if(b.getPiece(initLocX, initLocY).getType()=="K")	
		{
			moveKing(initLocX,initLocY,destLocX,destLocY,b);
			return;
		}

	}
 ```
 - ## MinMax.
  The AI Move generation.
  Example of part of minmax code that pushes down branches and finds best possible move.
 ```
 		int z=branches;	
		int y=levels;
    		for(int x=0; z>x; z--)
    		{
    			Board Tree=new Board();
    			boolean check=false;
    			if(MinMax)
    			{
    				Board dupe = boarda.boardDuplicate();
    				Tree=generateMove(boarda.boardDuplicate(),player,0);
    				 MiniMax(levels-1,!playera,Tree.boardDuplicate(),!MinMax,branches);
    				if(max==-9999||(holder<max))
        			{
        				max=holder;
        				Tree.setValue(holder);
        				if(levels==3)
            			{
        					if(FinalBoard==null)
        					{
        						FinalBoard=Tree;
        					}
        					if(FinalBoard !=null && FinalBoard.getValue()<Tree.getValue())
        					{
        						FinalBoard=Tree;
        					}
            			}
        			}
    			}
    			else
    			{
    				Tree=generateMove(boarda.boardDuplicate(),!player,0);
    				 MiniMax(levels-1,!playera,Tree.boardDuplicate(),!MinMax,branches);
    				
    				if(min==-9999||(holder>min))
        			{
        				min=holder;
        				Tree.setValue(holder);
        				//MinMax=true;
        				if(levels==3)
            			{
        					if(FinalBoard==null)
        					{
        						FinalBoard=Tree;
        					}
        					if(FinalBoard !=null && FinalBoard.getValue()>Tree.getValue())
        					{
        						FinalBoard=Tree;
        					}
            			}
        			}
    			}
    			}
 
 ```
 - ## Test.
  Starts the program.

