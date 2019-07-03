package chess;

public class moveVerify {
	boolean white;
	boolean valid;
	boolean check;
	int checkMate=0;
	boolean checkM=false;
	Board out;
	public moveVerify()
	{
		
	}
	public moveVerify(int initLocX, int initLocY, int destLocX, int destLocY, boolean white, Board b)
	{
		valid=true;
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
	
		public boolean getValid()
		{
			return valid;
		}
		 public int valueFunction(Boolean p, Board b) {
				//int whatever=0;
				int Black_Pscore=0;
				int Black_inCheckScore=0;
				int White_Pscore=0;
				int White_inCheckScore=0;
				int value=0;
				int middle_Squares=0;
				for(int x=0; x<8;x++)
				{
					for(int z=0; z<8; z++)
					{
						if(b.getPiece(x, z)!=null)
						{
							if(b.getPiece(x, z).getColor()==true)
							{
								switch(b.getPiece(x, z).getType())
								{
								case"P":White_Pscore=White_Pscore+1;
								case"Q":White_Pscore=White_Pscore+10;
								case"R":White_Pscore=White_Pscore+5;
								case"B":White_Pscore=White_Pscore+3;
								case"k":White_Pscore=White_Pscore+3;
								}
							}
							if(b.getPiece(x, z).getColor()==false)
							{
								switch(b.getPiece(x, z).getType())
								{
								case"P":Black_Pscore=Black_Pscore+1;
								case"Q":Black_Pscore=Black_Pscore+10;
								case"R":Black_Pscore=Black_Pscore+5;
								case"B":Black_Pscore=Black_Pscore+3;
								case"k":Black_Pscore=Black_Pscore+3;
								}
							}	
						}
					}
				}
				if(b.getPiece(4, 3)!=null)
				{
					if(b.getPiece(4, 3).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(3, 3)!=null)
				{
					if(b.getPiece(3, 3).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(3, 4)!=null)
				{
					if(b.getPiece(3, 4).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(4, 4)!=null)
				{
					if(b.getPiece(4, 4).getColor()==p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(4, 3)!=null)
				{
					if(b.getPiece(4, 3).getColor()!=p)
					{
						middle_Squares=middle_Squares-1;
					}
				}
				if(b.getPiece(3, 3)!=null)
				{
					if(b.getPiece(3, 3).getColor()!=p)
					{
						middle_Squares=middle_Squares-1;
					}
				}
				if(b.getPiece(3, 4)!=null)
				{
					if(b.getPiece(3, 4).getColor()!=p)
					{
						middle_Squares=middle_Squares+1;
					}
				}
				if(b.getPiece(4, 4)!=null)
				{
					if(b.getPiece(4, 4).getColor()!=p)
					{
						middle_Squares=middle_Squares-1;
					}
				}
				if(check(true, b))
				{
					White_inCheckScore=50;
//					checkMate(true, b);
					
				}	
				if(check(false, b))
				{
					Black_inCheckScore=50;
//					checkMate(false, b);
				}
				
				if(p)
				{
					 value=(White_Pscore-Black_Pscore)+Black_inCheckScore-White_inCheckScore+middle_Squares;
				}
				if(!p)
				{
				     value=(Black_Pscore-White_Pscore)+White_inCheckScore-Black_inCheckScore+middle_Squares;
				}
				//System.out.printf("%nTHE CORRECT OUTPUT:%d%n:",value);
			    	b.setValue(value);
			    	return value;
			    }
//		public void checkMate(Boolean color,Board b)
//		{
////			System.out.printf("%nCheckWE!"+);
//			int checkMateDone=0;
////			System.out.printf("%nCheckWE!"+checkMateDone);
////			Board butt=b.boardDuplicate();
//			boolean color2 = color;
////			while(check(color, butt))	
////			{
//////				System.out.printf("%nCheckWE!"+checkMateDone);
//////				System.out.printf("%nCheckret!");
////				butt = MinMax.generateMove(b.boardDuplicate(),color,0);
////				checkMateDone++;
////				if(checkMateDone>100)
////				{
////					System.out.printf("%nCheckMate!");
////				}
////				System.out.printf("%nbeeper!");
////			}
//		}
		public Board changedBoard()
		{
			//System.out.printf("%nBoard has been changed");
			return out;	
		}
		public boolean check(Boolean color,Board b)
		{
			int a=0;
			int c=0;
			for(int x=0; x<8; x++)
			{
				for(int y=0; y<8; y++)
				{
					if(b.getPiece(x, y)!=null)
					{
						if(b.getPiece(x, y).getType()=="K"&&b.getPiece(x, y).getColor()==color)
						{
							a=x;
							c=y;
							//System.out.printf("%nFound king at(%d:%d)",a,c);
						}
					}
				}
			}
			if(color==false)
			{
				if(a+1<8 && c-1>=0 && a-1>=0)
				{
					if(b.getPiece(a+1, c-1)!=null)	
					{
						if(b.getPiece(a+1, c-1).getColor()!=color&&(b.getPiece(a+1, c-1).getType()=="P"||b.getPiece(a+1, c-1).getType()=="Q"))	
						{
							//System.out.printf("%nFound pawn in check");
							return true;
						}
					}
				if(b.getPiece(a-1, c-1)!=null)	
				{
					if(b.getPiece(a-1, c-1).getColor()!=color&&(b.getPiece(a-1, c-1).getType()=="P"||b.getPiece(a-1, c-1).getType()=="Q")	)	
					{
						//System.out.printf("%nFound pawn in check");
						return true;
					}
				}
					}
			}
			if(color==true)
			{
				if(a+1<8 && c+2<8 && a-1>=0)
				{
				if(b.getPiece(a+1, c+1)!=null)	
				{
					if(b.getPiece(a+1, c+1).getColor()!=color&&(b.getPiece(a+1, c+1).getType()=="P"&&b.getPiece(a+1, c+1).getType()=="Q"))	
					{
						//System.out.printf("%nFound pawn in check");
						return true;
					}
				}
				if(b.getPiece(a-1, c+1)!=null)	
				{
					if(b.getPiece(a-1, c+1).getColor()!=color&&(b.getPiece(a-1, c+1).getType()=="P"&&b.getPiece(a-1, c+1).getType()=="Q"))	
					{
						//System.out.printf("%nFound pawn in check");
						return true;
					}
				}
				}
			}
			for(int e=a+1; e<8;e++)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if(b.getPiece(e, c).getColor()==color&&(b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="Q"))
					{
						//System.out.printf("%nFound same color1");
						break;
					}
					if((b.getPiece(e, c).getType()=="R" && b.getPiece(e, c).getColor()!=color)||(b.getPiece(e, c).getType()=="Q" && b.getPiece(e, c).getColor()!=color))
					{
						//System.out.printf("%nFound rook in check");
						return true;
					}
				}
				
			}
			for(int e=a-1; e>=0;e--)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if(b.getPiece(e, c).getColor()==color&&(b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="Q"))
					{
						//System.out.printf("%nFound same color2");
						break;
					}
					if((b.getPiece(e, c).getType()=="R" && b.getPiece(e, c).getColor()!=color)||(b.getPiece(e, c).getType()=="Q" && b.getPiece(e, c).getColor()!=color))
					{
						//System.out.printf("%nFound rook in check");
						return true;
					}
				}
				
			}
			for(int e=c+1; e<8;e++)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if(b.getPiece(e, c).getColor()==color&&(b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="Q"))
					{
						//System.out.printf("%nFound same color3");
						break;
					}
					if((b.getPiece(e, c).getType()=="R" && b.getPiece(e, c).getColor()!=color)||(b.getPiece(e, c).getType()=="Q" && b.getPiece(e, c).getColor()!=color))
					{
						//System.out.printf("%nFound rook in check");
						return true;
					}
				}
				
			}
			for(int e=c-1; e>=0;e--)
			{
				
				if(b.getPiece(e, c)!=null)
				{
					if(b.getPiece(e, c).getColor()==color&&(b.getPiece(e, c).getType()!="R"||b.getPiece(e, c).getType()!="R"))
					{
						//System.out.printf("%nFound same color4");
						break;
					}
					if((b.getPiece(e, c).getType()=="R" && b.getPiece(e, c).getColor()!=color)||(b.getPiece(e, c).getType()=="Q" && b.getPiece(e, c).getColor()!=color))
					{
						//System.out.printf("%nFound rook in check");
						return true;
					}
				}
				
			}
			int check=c+1;
			for(int e=a+1; e<8;e++)
			{
				if(check==8)
				{
					break;
				}
				if(b.getPiece(e, check)!=null)
				{
					if(b.getPiece(e, check).getColor()==color&&(b.getPiece(e, check).getType()!="B" || b.getPiece(e, check).getType()!="Q"))
					{
						//System.out.printf("%nFound same color:"+b.getPiece(e, check).getType());
						break;
					}
					if((b.getPiece(e, check).getType()=="B" && b.getPiece(e, check).getColor()!=color)||(b.getPiece(e, check).getType()=="Q" && b.getPiece(e, check).getColor()!=color))
					{
						//System.out.printf("%nFound bishop in check");
						return true;
					}
				}
				check++;
				
			}
		    check=c-1;
			for(int e=a+1; e<8;e++)
			{
				if(check<0)
				{
					break;
				}
				if(b.getPiece(e, check)!=null)
				{
					if(b.getPiece(e, check).getColor()==color&&(b.getPiece(e, check).getType()!="B"|| b.getPiece(e, check).getType()!="Q"))
					{
						//System.out.printf("%nFound same color:"+b.getPiece(e, check).getType());
						break;
					}
					if((b.getPiece(e, check).getType()=="B" && b.getPiece(e, check).getColor()!=color)||(b.getPiece(e, check).getType()=="Q" && b.getPiece(e, check).getColor()!=color))
					{
						//System.out.printf("%nFound bishop in check");
						return true;
					}
				}
				check--;
				
			}
				check=c-1;
				for(int e=a-1; e>=0;e--)
				{
					if(check<0 || check>7 || e<0 || e>7 )
					{
						break;
					}
					if(b.getPiece(e, check)!=null && b.getPiece(e, c)!=null)
					{
						if(b.getPiece(e, check).getColor()==color&&(b.getPiece(e, check).getType()!="B" || b.getPiece(e, check).getType()!="Q"))
						{
							//System.out.printf("%nFound same color:"+b.getPiece(e, check).getType());
							break;
						}
						if((b.getPiece(e, check).getType()=="B" && b.getPiece(e, check).getColor()!=color)||(b.getPiece(e, check).getType()=="Q" && b.getPiece(e, c).getColor()!=color))
						{
							//System.out.printf("%nFound bishop in check");
							return true;
						}
					}
					check--;
					
				}
				check=c+1;
				for(int e=a-1; e>=0;e--)
				{
					if(check>7)
					{
						break;
					}
					if(b.getPiece(e, check)!=null)
					{
						if(b.getPiece(e, check).getColor()==color&&(b.getPiece(e, check).getType()!="B" || b.getPiece(e, check).getType()!="Q"))
						{
							//System.out.printf("%nFound same color:"+b.getPiece(e, check).getType());
							break;
						}
						if((b.getPiece(e, check).getType()=="B" && b.getPiece(e, check).getColor()!=color)||(b.getPiece(e, check).getType()=="Q" && b.getPiece(e, check).getColor()!=color))
						{
							//System.out.printf("%nFound bishop or queen in check");
							return true;
						}
					}
					check++;
					
				}
				check=a;
				int check2=c;
				if(check-2<8 && check+2<8 && check2+1<8 && check-2>=0 && check2+1>=0)
				{
					if(b.getPiece(check+2, check2+1)!=null)
					{
						if(b.getPiece(check+2, check2+1).getColor()!=color&&b.getPiece(check+2, check2+1).getType()=="k")
						{
							//System.out.printf("%nFound knight in check");
							return true;
						}
					}
				}
				if(check+2<8&check2-1>=0)
				{
				if(b.getPiece(check+2, check2-1)!=null)
				{
					if(b.getPiece(check+2, check2-1).getColor()!=color&&b.getPiece(check+2, check2-1).getType()=="k")
					{
						//System.out.printf("%nFound knight in check");
						return true;
					}
				}
				}
				if(check-2>=0&&check2+1<8)
				{
				if(b.getPiece(check-2, check2+1)!=null)
				{
					if(b.getPiece(check-2, check2+1).getColor()!=color&&b.getPiece(check-2, check2+1).getType()=="k")
					{
						//System.out.printf("%nFound knight in check");
						return true;
					}
				}
				}
				if(check-2>=0&&check2-1>=0)
				{
					
				if(b.getPiece(check-2, check2-1)!=null)
				{
					if(b.getPiece(check-2, check2-1).getColor()!=color&&b.getPiece(check-2, check2-1).getType()=="k")
					{
					//	System.out.printf("%nFound knight in check");
						return true;
					}
				}
				}
/////
				if(check2-2>=0 &&check+1<8)
				{
				if(b.getPiece(check2-2, check+1)!=null)
				{
					if(b.getPiece(check2-2, check+1).getColor()!=color&&b.getPiece(check2-2, check+1).getType()=="k")
					{
					//	System.out.printf("%nFound knight in check");
						return true;
					}
				}
				}
				if(check2+2<8&check-1>=0)
				{
				if(b.getPiece(check2+2, check-1)!=null)
				{
					if(b.getPiece(check2+2, check-1).getColor()!=color&&b.getPiece(check2+2, check-1).getType()=="k")
					{
						//System.out.printf("%nFound knight in check");
						return true;
					}
				}
				}
				if(check2-2>=0&&check+1<8)
				{
				if(b.getPiece(check2-2, check+1)!=null)
				{
					if(b.getPiece(check2-2, check+1).getColor()!=color&&b.getPiece(check2-2, check+1).getType()=="k")
					{
						//System.out.printf("%nFound knight in check");
						return true;
					}
				}
				}
				if(check2-2>=0&&check-1>=0)
				{
					
				if(b.getPiece(check2-2, check-1)!=null)
				{
					if(b.getPiece(check2-2, check-1).getColor()!=color&&b.getPiece(check2-2, check-1).getType()=="k")
					{
						//System.out.printf("%nFound knight in check");
						return true;
					}
				}
				}
				//System.out.printf("%nNOT IN CHECK");
				return false;
			
			
		}
		//provides universal validation for moves, non unique to pieces, and finalizes 
		public void Moved(int i, int j, int x, int z, Board a)
		{	
			
			//if another piece occupies this square check the color and capture if allowed 
			if(x<8 && z<8 && x>=0 && z>=0 && a.getPiece(x, z)!=null)
			{
				//System.out.printf("%n-aye Valid Move-%n");
				if(a.getPiece(i, j).getColor()==a.getPiece(x, z).getColor())
				{
			//		System.out.printf("%nCan't move onto square with same colored piece");
					valid=false;
					return;
				}
				if(a.getPiece(i, j).getColor()!=a.getPiece(x, z).getColor())
				{	
			//		System.out.printf("Captured Piece");
					Piece swap=a.getPiece(i, j);
					Piece hold=a.getPiece(x, z);
					a.setPiece(x, z, swap);
					a.setPiece(i, j, null);
					if(check(white,a)==true)
					{
//						checkMate(white, a);
				//		System.out.printf("Moving into check or not out");
					//	System.out.printf("%n IN CHECK BITCHa");
						valid = false;
						a.setPiece(x, z, hold);
						a.setPiece(i, j, swap);
						checkMate++;
						return;
					}
					if(check(white,a)==false)
					{
					//	System.out.printf("%nNO CHECK");
						return;
					}
					out=a;
					valid=true;
					checkMate=0;
					//valueFunction(white,a);
					return;
				}
				valid=false;
				return;
				
			}
			if(x<8 && z<8 && i<8 && j<8 && x>=0 && z>=0 && i>=0 && j>=0 && valid && a.getPiece(i, j)!=null && a.getPiece(x, z)==null)
			{
				//System.out.printf("%n-aye Valid Move-%n");
			//	System.out.printf("%nMove has been made");
				Piece swap=a.getPiece(i, j);
				//Piece hold=a.getPiece(x, z);
				a.setPiece(x, z, swap);
				a.setPiece(i, j, null);
				if(check(white,a)==true)
				{
//					checkMate(white, a);
					//System.out.printf("%n IN CHECK BITCHb");
			//		System.out.printf("Moving into check or not out");
					valid = false;
					a.setPiece(x, z, null);
					a.setPiece(i, j, swap);
					checkMate++;
					return;
				}
				if(check(white,a)==false)
				{
			//		System.out.printf("%nNO CHECK");
					out=a;
					valid=true;
					checkMate=0;
					valueFunction(white,a);
					return;
				}
				//valid=true;
				//Valid(out, valid);
			}
			valid=false;
			return;
		}
		
		//moveset for pawns. 
		public void movePawn(int i,int j, int x, int z, Board b){
			if(b.getPiece(i, j)==null)//need to make getter setter to access board
			{
				//System.out.printf("Non-Valid Move Piece in the way");
				valid=false;
				return;
				//Valid(out, valid);
			}
			if(white==true) {
				//System.out.printf("%nIn");
			if((b.getPiece(i, j).getFirst())==true)
			{
				//System.out.printf("In here");
				if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
				{
					if(b.getPiece(x, z)!=null)
					{
						//System.out.printf("Valid Moveaaaaaa");
						Moved(i,j,x,z,b);
						//System.out.printf("WHYYYYY");
						return;
					}
					
					if(b.getPiece(x, z)==null)
					{
						//System.out.printf("Non-Valid Move:");
						valid=false;
						return;
						//Valid(out, valid);
						//break;
					}
					
				}
				if((j-z<3 && j-z>0) && i-x==0 && b.getPiece(x, z)==null )
				{
					b.getPiece(i, j).setFirst();
					//System.out.printf("Valid Moveeeeeee");
					Moved(i,j,x,z,b);
					return;
				}
				else
					//System.out.printf("Non-Valid Move:");
					valid=false;
					return;
					//Valid(out, valid);
					//break;
			}
			if(b.getPiece(i, j).getFirst()==false)
			{
				if((x-i==1 && z-j==-1) || (x-i==-1 && z-j== -1) )
				{
					if(b.getPiece(x, z)!=null)
					{
						//System.out.printf("Valid Move");
						Moved(i,j,x,z,b);
						//System.out.printf("%nWHYYYY");
						return;
					}
					
					if(b.getPiece(x, z)==null)
					{
						//System.out.printf("Non-Valid Move:");
						//return;
						valid=false;
						return;
					//	Valid(out, valid);
						//break;
					}
					
				}
				if((j-z<2 && j-z>0) && i-x==0 && b.getPiece(x, z)==null)
					{
					//System.out.printf("Valid Move");
					Moved(i,j,x,z,b);
					//System.out.printf("%nWHYYYY");
					return;
					}
					else
					//	System.out.printf("Non-Valid Move blah:");
						valid=false;
						return;
						//valid=false;
						//Valid(out, valid);
						//break;
				}
			valid=false;
			return;
			}
			if(white!=true) {
				if((b.getPiece(i, j).getFirst())==true)
				{
					//System.out.printf("In here2");
					if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
					{
						if(b.getPiece(x, z)!=null)
						{
						//	System.out.printf("Valid Move");
							Moved(i,j,x,z,b);
							return;
						}
						
						if(b.getPiece(x, z)==null)
						{
						//	System.out.printf("Non-Valid Move a");
							valid=false;
							return;
						}
						
					}
					if((z-j<3 && z-j>0) && i-x==0 && x<7 && z<7 && x>=0 && z>=0 && b.getPiece(x, z)==null)
					{
						b.getPiece(i, j).setFirst();
						//System.out.printf("Valid Move");
						Moved(i,j,x,z,b);
						return;
					}
					else
						//System.out.printf("Non-Valid Move2xdxd");
						valid=false;
						return;
						
					
				}
				if(b.getPiece(i, j).getFirst()==false)
				{
					if((x-i==1 && z-j==1) || (x-i==1 && z-j== -1) )
					{
						if(b.getPiece(x, z)!=null)
						{
						//	System.out.printf("Valid Move");
							Moved(i,j,x,z,b);
							return;
						}
						
						if(b.getPiece(x, z)==null)
						{
						//	System.out.printf("Non-Valid Move a");
							valid=false;
							return;
						}
						
					if((z-j<2 && z-j>0) && i-x==0&& b.getPiece(x, z)==null)
					{
						//System.out.printf("Valid Move");
						Moved(i,j,x,z,b);
						return;
					}
					else
						//System.out.printf("Non-Valid Move3");
						valid=false;
						return;
						//Valid(out, valid);
						//break;
				}
				}
				valid=false;
				return;
			}
		}
			//moveset for rook
		public void moveRook(int i, int j, int x, int z, Board b)
		{
			//System.out.printf("balh");
			if(i-x!=0 && j-z==0)
			{
				//System.out.printf("%n aaabbb");
				for(int p=i+1; p<x;p++)
				{
					if(b.getPiece(p, j)!=null)
					{
						//System.out.printf("Non-Valid Move Piece in the way1");
						valid=false;
						return;
						
						//Valid(out, valid);
						//break;
					}
				}
				//System.out.printf("%nValid Move");
				valid=true;
				Moved(i,j,x,z,b);
				return;
				
			}
			if(i-x==0 && j-z<0)
				{
				//System.out.printf("%n aaabbb1");
				for(int p=j+1; p<z;p++)
				{
					if(b.getPiece(i, p)!=null)
					{
						//System.out.printf("Non-Valid Move Piece in the way3");
						valid=false;
						return;
						//break;
						//Valid(out, valid);
						//break;
					}
				}
					valid=true;
				//	System.out.printf("%nValid Move");
					Moved(i,j,x,z,b);
					return;
				}
			if(i-x==0 && j-z>0)
			{
			//System.out.printf("%n aaabbb3");
				
			for(int p=j-1; p>z;p--)
			{
				//System.out.printf("%npoop");
				if(b.getPiece(i, p)!=null)
				{
					//System.out.printf("Non-Valid Move Piece in the way2");
					valid=false;
					return;
					//break;
					//Valid(out, valid);
					//break;
				}
			}
				valid=true;
				//System.out.printf("%nValid Move");
				Moved(i,j,x,z,b);
				return;
			}
			valid=false;
			return;
			
			}
		public void moveKnight(int i, int j, int x, int z, Board b)
		{
			if((x-i==2 && (z-j==1 || z-j==-1))|| (x-i==-2 && (z-j==1 || z-j==-1))|| (z-j==2 && (x-i==1 || x-i==-1)) || (z-j==-2 && (x-i==1 || x-i==-1)))
			{
				valid=true;
				//System.out.printf("valid move");
				Moved(i,j,x,z,b);
				return;
			}
			else
			{
				//System.out.printf("Non-Valid Move");
				valid=false;
				return;
				//Valid(out, valid);
			}
		}

		//moveset for bishop
		public void moveBishop(int i, int j, int x, int z, Board b)
		{
			if(b.getPiece(i, j)==null)//need to make getter setter to access board
			{
				//System.out.printf("Non-Valid Move Piece in the way");
				valid=false;
				return;
				//Valid(out, valid);
			}
			
			if(i-x==j-z || x-i==z-j || i-x==(j-z)*-1 || x-i==(z-j)*-1)
			{
				//System.out.printf("%nThe inner shit");
				if(i-x>0&&j-z>0)
				{
					//System.out.printf("%nThe inner shit1");
					int check=j-1;
					for(int p=i-1; p>x;p--)
					{
						if(check>7 || check<0 || p>7 || p<0)
						{
//							System.out.printf("Non-Valid Move off board");
							valid=false;
							return;
							//Valid(out, valid);
						}
//						System.out.printf("%nThe inner shitee1");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
//							System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check--;
					}
					valid=true;
					//System.out.printf("%nValid Move");
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x>0&&j-z<0)
				{
					//System.out.printf("%nThe inner shit");
					int check=j-1;
					for(int p=i+1; p<x;p++)
					{
						//System.out.printf("%nThe inner shitee2");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
						//	System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check--;
					}
					//System.out.printf("%nValid Move?");
					valid=true;
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z>0)
				{
					int check=j-1;
					for(int p=i+1; p<x;p++)
					{
						//System.out.printf("%nThe inner shitee3");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
						//	System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check--;
					}
					valid=true;
					//System.out.printf("%nValid Move");
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z<0)
				{
					int check=j+1;
					for(int p=i+1; p<x;p++)
					{
						//System.out.printf("%nThe inner shitee4");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
						//	System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check++;
					}
					//System.out.printf("%nValid Move33");
					valid=true;
					Moved(i,j,x,z,b);
					return;
				}
				/*
				int check=j;
				for(int p=i; p<x;p++)
				{
					if(b.getPiece(p, check)!=null)//need to make getter setter to access board
					{
						System.out.printf("Non-Valid Move Piece in the way");
						valid=false;
						return;
						//Valid(out, valid);
					}
					check++;
				}
				for(int p=z; p<j;p++)
				{
					if(b.getPiece(p, check)!=null)//need to make getter setter to access board
					{
						System.out.printf("Non-Valid Move Piece in the way");
						valid=false;
						return;
						//Valid(out, valid);
					}
					check++;
				}
				System.out.printf("Valid Move");
				Moved(i,j,x,z,b);
			}
			*/
			}
			//System.out.printf("%nValid Move23");
			valid=false;
			return;
		}
	//The ruleset for the queen, combines rook and bishop moves.
		public void moveQueen(int i, int j, int x, int z, Board b)
		{
			if(b.getPiece(i, j)==null)//need to make getter setter to access board
			{
				//System.out.printf("Non-Valid Move Piece in the way");
				valid=false;
				return;
				//Valid(out, valid);
			}
			if(i-x==j-z || x-i==z-j || i-x==(j-z)*-1 || x-i==(z-j)*-1)
			{
				//System.out.printf("%nThe inner shit");
				if(i-x>0&&j-z>0)
				{
					//System.out.printf("%nThe inner shit1");
					int check=j-1;
					for(int p=i-1; p>x;p--)
					{
						if(check>7 || check<0 || p>7 || p<0)
						{
//							System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						//System.out.printf("%nThe inner shitee1");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
							//System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check--;
					}
					//valid=true;
				//	System.out.printf("%nValid Move");
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x>0&&j-z<0)
				{
					//System.out.printf("%nThe inner shit");
					int check=j-1;
					for(int p=i+1; p<x;p++)
					{
						//System.out.printf("%nThe inner shitee2");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
						//	System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check--;
					}
					//valid=true;
					//System.out.printf("%nValid Move");
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z>0)
				{
					int check=j+1;
					for(int p=i-1; p>x;p--)
					{
						//System.out.printf("%nThe inner shitee3");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
						//	System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check++;
					}
					//valid=true;
					//System.out.printf("%nValid Move");
					Moved(i,j,x,z,b);
					return;
				}
				if(i-x<0&&j-z<0)
				{
					int check=j+1;
					for(int p=i+1; p<x;p++)
					{
						//System.out.printf("%nThe inner shitee4");
						if(b.getPiece(p, check)!=null)//need to make getter setter to access board
						{
							//System.out.printf("Non-Valid Move Piece in the way");
							valid=false;
							return;
							//Valid(out, valid);
						}
						check++;
					}
					//System.out.printf("%nValid Move33");
					valid=true;
					Moved(i,j,x,z,b);
					return;
			}
			
			if(i-x==0 && j-z!=0)
			{
				for(int p=j; p<x;p++)
				{
					if(b.getPiece(i, p)!=null)
					{
						valid=false;
						return;
					}
				}
				for(int p=i; p<z;p++)
				{
					if(b.getPiece(p, j)!=null)
					{
						valid=false;
						return;
					}
				}
				
			Moved(i,j,x,z,b);
			return;
		}
			valid=false;
			return;
			}
			if(i-x!=0 && j-z==0)
			{
				for(int p=i+1; p<x;p++)
				{
					if(b.getPiece(p, j)!=null)
					{
						valid=false;
						return;
					}
				}
				Moved(i,j,x,z,b);
				return;
				
			}
			if(i-x==0 && j-z<0)
				{
				for(int p=j+1; p<z;p++)
				{
					if(b.getPiece(i, p)!=null)
					{
						valid=false;
						return;
					}
				}
					Moved(i,j,x,z,b);
					return;
				}
			if(i-x==0 && j-z>0)
			{				
			for(int p=j-1; p>z;p--)
			{
				if(b.getPiece(i, p)!=null)
				{
					valid=false;
					return;
				}
			}
				Moved(i,j,x,z,b);
				return;
			}
			valid=false;
			return;
			
		}
		public void moveKing(int i, int j, int x, int z, Board b)
		{
		
			if((i-x==1 && j-z==0) || (i-x==-1 && j-z==0) || (i-x==0 && j-z==1) || (i-x==0 && j-z==-1)|| (i-x==1 && j-z==1)|| (i-x==1 && j-z==-1)|| (i-x==-1 && j-z==1)|| (i-x==-1 && j-z==-1))
			{
				Moved(i,j,x,z,b);
				return;
				
			}
			else 
				valid=false;
				return;
		}
		
		
}
