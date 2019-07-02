package chess;

import java.util.InputMismatchException;
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
			
				System.out.printf("%nWhite Player make move%n");
				b.printBoard();
				System.out.printf("%nEnter piece initial location:ex 0 1 ");
				int initLocX=0;
				int initLocY=0;
				int ch1;
		        try {
		        	initLocX=in.nextInt();
					initLocY=in.nextInt();
		        } catch (InputMismatchException e) {
					System.out.printf("%nPlease enter int%n");
					playGame(true,b);
		        }

				if(initLocX>8 || initLocY>8 || initLocX<0 || initLocY<0 )
				{
					System.out.printf("%nMove was not made due to invalid input");
					playGame(true,b);
					return;
				}
				
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
				playGame(true,a.getFinalBoard());
				return;
			}
		}
	}
}
