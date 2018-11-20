package chess;

public class moveVerify {
	boolean white;
	boolean valid;
	Board out;
	
	public moveVerify(int initLocX, int initLocY, int destLocX, int destLocY, boolean white, Board b)
	{
		out=b;
		this.white=white;
	//Case statement that goes through possibilities of type
		if(b.getPiece(initLocX, initLocY).getType()=="P")	
		{
//			System.out.printf("%nMove pawn%n");
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
	
		public Board changedBoard()
		{
			System.out.printf("%nBoard has been changed");
			return out;	
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
					//valid=true;
					//Valid(a, valid);
					out=a;
					return;
				}
				
			}
			if(a.getPiece(x, z)==null)
			{
				System.out.printf("%nMove has been made");
				Piece swap=a.getPiece(i, j);
				a.setPiece(x, z, swap);
				a.setPiece(i, j, null);
				out=a;
				return;
				//valid=true;
				//Valid(out, valid);
			}
			
		}
		//moveset for pawns. 
			public void movePawn(int i,int j, int x, int z, Board b){
			if(white==true) {
				System.out.printf("%nIn");
			if((b.getPiece(i, j).getFirst())==true)
			{
				System.out.printf("In here");
				if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
				{
					if(b.getPiece(x, z)!=null)
					{
						System.out.printf("Valid Moveaaaaaa");
						Moved(i,j,x,z,b);
						return;
					}
					
					if(b.getPiece(x, z)==null)
					{
						System.out.printf("Non-Valid Move:");
						//valid=false;
						//Valid(out, valid);
						//break;
					}
					
				}
				if((j-z<3 && j-z>0) && i-x==0)
				{
					b.getPiece(i, j).setFirst();
					System.out.printf("Valid Moveeeeeee");
					Moved(i,j,x,z,b);
					return;
				}
				else
					System.out.printf("Non-Valid Move:");
					return;
					//valid=false;
					//Valid(out, valid);
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
						return;
					}
					
					if(b.getPiece(x, z)==null)
					{
						System.out.printf("Non-Valid Move:");
						return;
					//	valid=false;
					//	Valid(out, valid);
						//break;
					}
					
				}
				if((j-z>1 || j-z>0) && i-x==0)
				{
					System.out.printf("Valid Move");
					Moved(i,j,x,z,b);
					return;
				}
				else
					System.out.printf("Non-Valid Move blah:");
					return;
					//valid=false;
					//Valid(out, valid);
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
							return;
						}
						
						if(b.getPiece(x, z)==null)
						{
							System.out.printf("Non-Valid Move a");
							//valid=false;
							//Valid(out, valid);
						}
						
					}
					if((z-j>2 || z-j>0) && i-x==0)
					{
						b.getPiece(i, j).setFirst();
						System.out.printf("Valid Move");
						Moved(i,j,x,z,b);
						return;
					}
					else
						System.out.printf("Non-Valid Move2xdxd");
						//valid=false;
						//Valid(out, valid);
						
					
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
						//valid=false;
						//Valid(out, valid);
						//break;
				}
				}
		}
			//moveset for rook
		public void moveRook(int i, int j, int x, int z, Board b)
		{
			if(i-x!=0 && j-z==0)
			{
				for(int p=i; p<x;p++)
				{
					if(b.getPiece(p, j)!=null)
					{
						System.out.printf("Non-Valid Move Piece in the way");
						//valid=false;
						//Valid(out, valid);
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
							//valid=false;
							//Valid(out, valid);
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
				//valid=false;
				//Valid(out, valid);
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
						//valid=false;
						//Valid(out, valid);
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
						//valid=false;
						//Valid(out, valid);
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
						//valid=false;
						//Valid(out, valid);
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
						//valid=false;
						//Valid(out, valid);
						//break;
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
				//valid=false;
				//Valid(out, valid);	
		}
		
}
