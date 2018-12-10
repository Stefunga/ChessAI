package chess;

public class Board {
	//Creating arrays to make board(A-H, 1-8)

	Piece[][] a;
	int value;
	
	public Board(){
		a=new Piece[7][7];
		createBoard();
		
	}
	public Board boardDuplicate()
	{
		Board copy=new Board();
		for(int x=0; x<8;x++)
		{
			for(int y=0; y<8; y++)
			{
				if(getPiece(x,y)!=null)
				{
				Piece next=new Piece();
				next.setType(getPiece(x,y).getType());
				next.setterFirst(getPiece(x,y).getFirst());
				next.setColor(getPiece(x,y).getColor());
				copy.setPiece(x, y, next);
				}
				else
				{
					copy.setPiece(x, y, null);
				}
			}
		}
		return copy;
	}
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
	
	public void printBoard()//a way to visualize the chess board, iterates through the matrix returns contents, with some extra visual help.
	{
		for(int x=7; x>=0; x--)
		{
			System.out.printf("--%d--",x);
		}
		for(int y=0; y<=7; y++ )
		{
			System.out.printf("%n");
			for(int x=7; x>=0; x--)
			{
				if(a[x][y]==null)
				{
					System.out.printf("|   |");
				}
				if(a[x][y]!=null)
				{
					if(a[x][y].getColor()==true)
					{
						System.out.printf("|%s:W|", a[x][y].getType());//prints out piece type and its color(WHITE)
					}
					if(a[x][y].getColor()==false)
					{
						System.out.printf("|%s:B|", a[x][y].getType());//prints out piece type and its color(BLACK)
					}
				}
			}
			System.out.printf("%d",y);
		}
	}
	
	public Piece getPiece(int x, int z)//returns piece from spot on the matrix
	{
		return a[x][z];
	}
	public void setPiece(int x, int z, Piece w)//sets piece for a spot on the matrix. 
	{
		a[x][z]=w;
	}
	public int getValue()//returns piece from spot on the matrix
	{
		return value;
	}
	public void setValue(int valuea)//sets piece for a spot on the matrix. 
	{
		value=valuea;
	}
	public void copyBoard(Board b)//need to review if this returns entirely new object or if i need to read in.
	{
		Board out=new Board();
		out=b;
	}
}
