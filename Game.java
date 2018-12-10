package chess;

import java.util.Scanner;

public class Game {
	Board play;
	boolean white=true;
	boolean checkmate=false;
	boolean aiColor;
	
	public Game()
	{
		Board play= new Board();
		playGame(white, play);
	}
	
	
	public void playGame(boolean white, Board b){
		Scanner in= new Scanner(System.in);
		
		if(checkmate == false)
		{
			if(white==true)
			{
			
				System.out.println("White Player make move");
				b.printBoard();
				System.out.printf("%nEnter piece initial location:ex 0 1 ");
				int initLocX=in.nextInt();
				int initLocY=in.nextInt();
				
				
				if(b.getPiece(initLocX, initLocY)==null||b.getPiece(initLocX, initLocY).getColor()!=true)
				{
					System.out.println("Invalid piece try again!");
					playGame(white, b);
					return;
				}
				System.out.println("Enter piece destination:ex 0 1 ");
				int destLocX=in.nextInt();
				int destLocY=in.nextInt();
				moveVerify v= new moveVerify(initLocX, initLocY, destLocX, destLocY, white, b);
				Board check=v.changedBoard();
				if(b.getPiece(initLocX, initLocY)!=null)
				{
					System.out.printf("%nMove was not made due to invalid input");
					playGame(true,b);
					return;
				}
				else
				{
					System.out.printf("%nMove was made next player");
				//	System.out.printf("%nThe board score:%s",check.getValue());
					playGame(false,b);
					return;
				}	
			}
			if(white==false)
			{
				System.out.printf("%nBlack Player make move%n");
				b.printBoard();
				MinMax a=new MinMax();
				a.MiniMax(3,false, b,true,20);
				a.getFinalBoard();
				//a.getFinalBoard().printBoard();
				//a.getFinalBoard().printBoard();
				playGame(true,a.getFinalBoard());
				return;
				/**
				System.out.printf("%nEnter piece initial location:ex 0 1 ");
				int initLocX=in.nextInt();
				int initLocY=in.nextInt();
				if(b.getPiece(initLocX, initLocY)==null || b.getPiece(initLocX, initLocY).getColor()==true)
				{
					System.out.println("Invalid piece try again!");
					playGame(false, b);
				}
				System.out.println("Enter piece destination:ex 0 1 ");
				int destLocX=in.nextInt();
				int destLocY=in.nextInt();
				moveVerify v= new moveVerify(initLocX, initLocY, destLocX, destLocY, white, b);
				Board check=v.changedBoard();
				if(b.getPiece(initLocX, initLocY)!=null)
				{
					System.out.printf("%nMove was not made due to invalid input");
					playGame(false,b);
				}
				else
				{
					System.out.printf("%nMove was made next player");
					playGame(true,b);
				}
				*/
			}
		}
	}
}
