package chess;

import java.util.Scanner;

public class Game {
	Board play;
	boolean white=true;
	boolean checkmate=false;
	
	public Game()
	{
		Board play= new Board();
		playGame(white, play);
	}
	
	
	public void playGame(boolean white, Board b){
		//b.getPiece(0, 1).getType();
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
				}
				System.out.println("Enter piece destination:ex 0 1 ");
				int destLocX=in.nextInt();
				int destLocY=in.nextInt();
				if(b.getPiece(initLocX, initLocY).getType()=="P")	
				{
					System.out.printf("%nMove pawn%n");
					movePawn(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="R")	
				{
					moveRook(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="k")	
				{
					moveKnight(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="B")	
				{
					moveBishop(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="Q")	
				{
					moveQueen(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="K")	
				{
					moveKing(initLocX,initLocY,destLocX,destLocY,b);
				}
			}
			if(white==false)
			{
				System.out.printf("%nBlack Player make move%n");
				b.printBoard();
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
				if(b.getPiece(initLocX, initLocY).getType()=="P")	
				{
					System.out.printf("%nMove pawn%n");
					movePawn(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="R")	
				{
					moveRook(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="k")	
				{
					moveKnight(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="B")	
				{
					moveBishop(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="Q")	
				{
					moveQueen(initLocX,initLocY,destLocX,destLocY,b);
				}
				if(b.getPiece(initLocX, initLocY).getType()=="K")	
				{
					moveKing(initLocX,initLocY,destLocX,destLocY,b);
				}
			}
		}
	}
//provides universal validation for moves, non unique to pieces, and finalizes 
	public void Moved(int i, int j, int x, int z, Board a)
	{
		//if another piece occupies this square check the color and capture if allowed 
		if(a.getPiece(x, z)!=null)
		{
			if(a.getPiece(i, j).getColor()==a.getPiece(x, z).getColor())
			{
				System.out.printf("%nCan't move onto square with same colored piece");
			}
			if(a.getPiece(i, j).getColor()!=a.getPiece(x, z).getColor())
			{
				System.out.printf("Captured Piece");
				//a[x][z]=a[i][j];
				Piece swap=a.getPiece(i, j);
				a.setPiece(x, z, swap);
				a.setPiece(i, j, null);
				playGame(white, a);
			}
			
		}
		if(a.getPiece(x, z)==null)
		{
			System.out.printf("valid move");
			Piece swap=a.getPiece(i, j);
			a.setPiece(x, z, swap);
			a.setPiece(i, j, null);	
			out:
			if(white==true || white==false)
				{
					if(white==true)
					{
						System.out.printf("Next user");
						white=false;
						break out;
					}	
					if(white!=true)
					{
						System.out.printf("Next user");
						white=true;
						break out;
					}
				}
			
			playGame(white, a);
		}
		
	}
	//moveset for pawns. 
		public void movePawn(int i,int j, int x, int z, Board b){
		if(white==true) {
		if((b.getPiece(i, j).getFirst())==true)
		{
			System.out.printf("In here");
			if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
			{
				if(b.getPiece(x, z)!=null)
				{
					System.out.printf("Valid Move");
					Moved(i,j,x,z,b);
				}
				
				if(b.getPiece(x, z)==null)
				{
					System.out.printf("Non-Valid Move:");
					playGame(white,b);
					//break;
				}
				
			}
			if((j-z>2 || j-z>0) && i-x==0)
			{
				b.getPiece(i, j).setFirst();
				System.out.printf("Valid Move");
				Moved(i,j,x,z,b);
			}
			else
				System.out.printf("Non-Valid Move:");
				playGame(white,b);
				//break;
		}
		if(b.getPiece(i, j).getFirst()==false)
		{
			if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
			{
				if(b.getPiece(x, z)!=null)
				{
					System.out.printf("Valid Move");
					Moved(i,j,x,z,b);
				}
				
				if(b.getPiece(x, z)==null)
				{
					System.out.printf("Non-Valid Move:");
					playGame(white,b);
					//break;
				}
				
			}
			if((j-z>1 || j-z>0) && i-x==0)
			{
				System.out.printf("Valid Move");
				Moved(i,j,x,z,b);
			}
			else
				System.out.printf("Non-Valid Move blah:");
				playGame(white,b);
				//break;
			}
		}
		if(white!=true) {
			if((b.getPiece(i, j).getFirst())==true)
			{
				System.out.printf("In here2");
				if((x+i==1 && z-j==1) || (x+i==1 && z-j== -1) )
				{
					if(b.getPiece(x, z)!=null)
					{
						System.out.printf("Valid Move");
						Moved(i,j,x,z,b);
					}
					
					if(b.getPiece(x, z)==null)
					{
						System.out.printf("Non-Valid Move a");
						playGame(white,b);
					}
					
				}
				if((z-j>2 || z-j>0) && i-x==0)
				{
					b.getPiece(i, j).setFirst();
					System.out.printf("Valid Move");
					Moved(i,j,x,z,b);
				}
				else
					System.out.printf("Non-Valid Move2xdxd");
					playGame(white,b);
					
				
			}
			if(b.getPiece(i, j).getFirst()==false)
			{
				if((z-j>1 || z-j>0) && i-x==0)
				{
					System.out.printf("Valid Move");
					Moved(i,j,x,z,b);
				}
				else
					System.out.printf("Non-Valid Move3");
					playGame(white,b);
					//break;
			}
			}
	}
		//moveset for rook
	public void moveRook(int i, int j, int x, int z, Board b)
	{
		//System.out.printf("in da shit");
		if(i-x!=0 && j-z==0)
		{
			for(int p=i; p<x;p++)
			{
				if(b.getPiece(p, j)!=null)
				{
					System.out.printf("Non-Valid Move Piece in the way");
					playGame(white,b);
					//break;
				}
			}
		}
		if(i-x==0 && j-z!=0)
			{
				for(int p=j; p<x;p++)
				{
					if(b.getPiece(i, p)!=null)
					{
						System.out.printf("Non-Valid Move Piece in the way");
						playGame(white,b);
						//break;
					}
				}
			}
		System.out.printf("%nValid Move");
		Moved(i,j,x,z,b);
		
		}
	public void moveKnight(int i, int j, int x, int z, Board b)
	{
		if(x-i==2 && (z-j==1 || z-j==-1) || x-i==-2 && (z-j==1 || z-j==-1) || z-j==2 && (x-i==1 || x-i==-1) || z-j==-2 && (x-i==1 || x-i==-1))
		{
			System.out.printf("valid move");
			Moved(i,j,x,z,b);
		}
		else
		{
			System.out.printf("Non-Valid Move");
			playGame(white,b);
		}
	}

		//moveset for bishop
	public void moveBishop(int i, int j, int x, int z, Board b)
	{
		if(i-x==j-z)
		{
			int check=j;
			for(int p=i; p<x;p++)
			{
				if(b.getPiece(p, check)!=null)//need to make getter setter to access board
				{
					System.out.printf("Non-Valid Move Piece in the way");
					playGame(white,b);
				}
				check++;
			}
			System.out.printf("Valid Move");
			Moved(i,j,x,z,b);
		}
	}
//The ruleset for the queen, combines rook and bishop moves.
	public void moveQueen(int i, int j, int x, int z, Board b)
	{
		if(i-x==j-z)
		{
			int check=j;
			for(int p=i; p<x;p++)
			{
				if(b.getPiece(p, check)!=null)//need to make getter setter to access board
				{
					System.out.printf("Non-Valid Move Piece in the way");
					playGame(white,b);
				}
				check++;
			}
		}
		if(i-x!=0 && j-z==0)
		{
			for(int p=i; p<x;p++)
			{
				if(b.getPiece(p, j)!=null)
				{
					System.out.printf("Non-Valid Move Piece in the way");
					playGame(white,b);
					break;
				}

				System.out.printf("Valid Move");
				Moved(i,j,x,z,b);
			}
	}
		if(i-x==0 && j-z!=0)
		{
			for(int p=j; p<x;p++)
			{
				if(b.getPiece(i, p)!=null)
				{
					System.out.printf("Non-Valid Move Piece in the way");
					playGame(white,b);
				}
			}
		
		System.out.printf("Valid Move");
		Moved(i,j,x,z,b);
	}
	}
	public void moveKing(int i, int j, int x, int z, Board b)
	{
		if((i-x==1 || i-x==-1 || i-x==0) && (j-z==1 || j-z==-1 || i-x==0) )
		{
			System.out.printf("Valid Move");
			Moved(i,j,x,z,b);
		}
		else 
			System.out.printf("Non-Valid");
			playGame(white,b);		
	}
	
}
