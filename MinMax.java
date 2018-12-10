package chess;

import java.util.Random;

public class MinMax {
Board FinalBoard;
int checker;
int branches=20;
boolean player;
int holder=0;
Board Final=null;
int max=-9999;
int min=-9999;
//Boolean MinMax=false;]
public MinMax()
{
	
}
public void MiniMax (int levels, boolean playera, Board boarda, Boolean MinMax, int branches) {
		if(levels==0)
		{
		//value=valueFunction(boarda);
		//boarda.setValue(value);
		moveVerify a=new moveVerify();
		//a.valueFunction(MinMax, boarda);
		holder=a.valueFunction(MinMax, boarda);
		boarda.printBoard();
		System.out.printf("%nSet first"+holder);

		return;
		}
		//player=playera;
		//int value;
		//System.out.printf("The Piece checker:"+boarda.getPiece(0, 1).getType());
		//Board Tree=new Board();
		//Tree=generateMove(boarda,player);
		//FinalBoard=Tree;
		//System.out.printf("%nThe board score:  "+FinalBoard.getValue());
		//return;
		int z=branches;	
		int y=levels;
    		for(int x=0; z>x; z--)
    		{
    			Board Tree=new Board();
    			boolean check=false;
    			if(MinMax)
    			{
    				System.out.printf("%nhere:"+holder);
    				
    				Tree=generateMove(boarda.boardDuplicate(),player);//need to change L and B to make it work correctly(rand num)
    				//Tree.printBoard();
    				 MiniMax(levels-1,!playera,Tree.boardDuplicate(),!MinMax,branches);
    				// System.out.printf("%nREJECT");
    				if(max==-9999||(holder<max))
        			{
        				max=holder;
        				System.out.printf("%nMAX:"+holder);
        				Tree.setValue(holder);
        				//MinMax=false;
        				if(levels==3)
            			{
        					System.out.printf("%n in this stuff");
        					if(FinalBoard==null)
        					{
        						System.out.printf("%n in this stuff2");
        						FinalBoard=Tree;
        						//return;
        					}
        					if(FinalBoard !=null && FinalBoard.getValue()<Tree.getValue())
        					{
        						FinalBoard=Tree;
        						System.out.printf("%nANOTHER THING");
        						//return;
        					}
            			}
        				//return;
        			}
    			}
    			else
    			{
    				Tree=generateMove(boarda.boardDuplicate(),!player);//need to change L and B to make it work correctly(rand num)
    				//Tree.printBoard();
    				 MiniMax(levels-1,!playera,Tree.boardDuplicate(),!MinMax,branches);
    				
    				if(min==-9999||(holder>min))
        			{
        				min=holder;
        				System.out.printf("%nMIN:"+holder);
        				Tree.setValue(holder);
        				//MinMax=true;
        				if(levels==3)
            			{
        					System.out.printf("%n in this stuff");
        					if(FinalBoard==null)
        					{
        						System.out.printf("%n in this stuff2");
        						FinalBoard=Tree;
        						//return;
        					}
        					if(FinalBoard !=null && FinalBoard.getValue()>Tree.getValue())
        					{
        						FinalBoard=Tree;
        						System.out.printf("%nANOTHER THING");
        						//return;
        					}
            			}
        				//return;
        			}
    			}
    			}
    		min=-9999;
    		max=-9999;
    			
    		}
    		
    		
    		//min=0;
    		//max=0;
    		
    
	public Board getFinalBoard()
	{
		return FinalBoard;
	}
    public Board generateMove(Board bMax, boolean player) {
    				Random move=new Random();
    				moveVerify verified;
				int l=move.nextInt(7);
				int w=move.nextInt(7);
				while(bMax.getPiece(l, w)==null)
				{
					l=move.nextInt(7);
					w=move.nextInt(7);
				}
				if(bMax.getPiece(l, w).getColor()!=player)
				{
					generateMove(bMax,player);
					return bMax;
				}
				String piece="P";
						//bMax.getPiece(l,w).getType();
    				switch(piece) {
					case"P":
						int moved=move.nextInt(3);
						if(moved==0)
						{
							if(player==true)
							{
								//System.out.printf("This is a white pawn");
								verified=new moveVerify(l,w,l,w+1,player,bMax);
								if(verified.getValid()==false)
								{
									generateMove(bMax,player);
									break;
								}
								
							//	bMax.setPiece(l, w+1,bMax.getPiece(l, w));
							//	bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{	
								//System.out.printf("%nThis is a black pawn");
								verified=new moveVerify(l,w,l,w+2,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								//Piece setter=bMax.getPiece(l, w);
								//bMax.setPiece(l, w+2, bMax.getPiece(l, w));
								//System.out.printf("The Piece checker:"+bMax.getPiece(l, w).getType());
								//bMax.setPiece(l, w, null);
								break;
							}
							
						}
						if(moved==1)
						{
							if(player==true)
							{
								verified=new moveVerify(l,w,l,w-1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								//Piece setter=bMax.getPiece(l, w);
								//bMax.setPiece(l, w-1, bMax.getPiece(l, w));
								//bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{
								//System.out.printf("%nThis is a black pawn1");
								verified=new moveVerify(l,w,l,w+1,player, bMax);
								
								if(verified.getValid()!=true)
								{
								//	System.out.printf("%nThis is a black pawn");
									generateMove(bMax,player);
									break;
								}
								//Piece setter=bMax.getPiece(l, w);
								//bMax.setPiece(l, w+1, bMax.getPiece(l, w));
								//System.out.printf("The Piece checker:"+bMax.getPiece(l, w).getType());
								//System.out.printf("%nSET1"+setter.getType());
								//bMax.setPiece(l, w, null);
								break;
							}
						}
						if(moved==2)
						{
							if(player==true)
							{
								verified=new moveVerify(l,w,l+1,w+1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								//Piece setter=bMax.getPiece(l, w);
								//bMax.setPiece(l+1, w+1, bMax.getPiece(l, w));
								//bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{
								//System.out.printf("%nThis is a black pawn2");
								verified=new moveVerify(l,w,l-1,w+1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								//Piece setter=bMax.getPiece(l, w);
								//bMax.setPiece(l-1, w+1, bMax.getPiece(l, w));
								//System.out.printf("%nSET2");
								//System.out.printf("The Piece checker:"+bMax.getPiece(l, w).getType());
								//bMax.setPiece(l, w, null);
								break;
							}
						}
						if(moved==3)
						{
							if(player==true)
							{
								verified=new moveVerify(l,w,l+1,w-1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								//Piece setter=bMax.getPiece(l, w);
								//bMax.setPiece(l+1, w-1, bMax.getPiece(l, w));
								//System.out.printf("%nSET3");
								//System.out.printf("The Piece checker:"+bMax.getPiece(l, w).getType());
								//bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{
								//System.out.printf("%nThis is a black pawn3");
								verified=new moveVerify(l,w,l-1,w-1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								//Piece setter=bMax.getPiece(l, w);
								//System.out.printf("The Piece checker:"+bMax.getPiece(l, w).getType());
								//bMax.setPiece(l-1, w-1, bMax.getPiece(l, w));
								//System.out.printf("%nSET3");
							//	System.out.printf("The Piece checker:"+bMax.getPiece(0, 1).getType());
								//bMax.setPiece(l, w, null);
								break;
							}	
							break;
						}
					break;
					
					case"K":
						moved=move.nextInt(7);
						if(moved==0) {
								if(w+1>7)
								{
									generateMove(bMax,player);
									break;
								}
								verified=new moveVerify(l,w,l,w+1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
						//		Piece setter=bMax.getPiece(l, w);
						//		bMax.setPiece(l, w+1, setter);
						//		bMax.setPiece(l, w, null);
								break;
				
						}
						if(moved==1) {
							if(w-1>7 || w-1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l, w-1, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==2) {
							if(l+1>7 || l+1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+1,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+1, w, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==3) {
							if(l-1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-1,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l-1, w, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==4) {
							if(w+1>7 || w+1<0 || l+1>7 || l+1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+1,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+1, w+1, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==5) {
							if(w-1>7 || w-1<0 || l-1>7 || l-1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-1,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l-1, w-1, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==6) {
							if(w-1>7 || w-1<0 || l+1>7 || l+1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+1,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+1, w-1, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==7) {
							if(w+1>7 || w+1<0 || l-1>7 || l-1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-1,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l-1, w+1, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}	
						break;
					case"Q":
						moved=move.nextInt(7);
						int distance=move.nextInt(6);
						if(moved==0) {
								if(distance+w>7 || distance+w<0)
								{
									generateMove(bMax,player);
									break;
								}
								verified=new moveVerify(l,w,l,w+distance,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
						//		Piece setter=bMax.getPiece(l, w);
						//		bMax.setPiece(l, w+distance, setter);
						//		bMax.setPiece(l, w, null);
								break;
						}
						if(moved==1) {
							if(w-distance>7 || w-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l, w-distance, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==2) {
							if(l+distance>7 || l+distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+distance, w, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==3) {
							if(l-distance>7 || l-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						///	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l-distance, w, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==4) {
							if(l+distance>7 || w+distance>7)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+distance, w+distance, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==5) {
							if(l-distance<0 || l-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l-distance, w-distance, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==6) {
							if(l+distance>7 || w-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+distance, w-distance, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==7) {
							if(w+distance>7 || l-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l-distance, w+distance, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}	
						break;
					case"R":
						moved=move.nextInt(7);
					    distance=move.nextInt(6);
						if(moved==0) {
								if(distance+w>7 || distance+w<0)
								{
									generateMove(bMax,player);
									break;
								}
								verified=new moveVerify(l,w,l,w+distance,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
						//		Piece setter=bMax.getPiece(l, w);
						//		bMax.setPiece(l, w+distance, setter);
						//		bMax.setPiece(l, w, null);
								break;
						}
						if(moved==1) {
							if(w-distance>7 || w-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//  Piece setter=bMax.getPiece(l, w);
						///	bMax.setPiece(l, w-distance, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==2) {
							if(l+distance>7 || l+distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+distance, w, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==3) {
							if(l-distance>7 || l-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l-distance, w, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						generateMove(bMax,player);
						break;
					case"k":
						moved=move.nextInt(7);
						if(moved==0) {
							if(l+2>7 || w+1>7)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+2,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
						//	Piece setter=bMax.getPiece(l, w);
						//	bMax.setPiece(l+2, w+1, setter);
						//	bMax.setPiece(l, w, null);
							break;
						}
						if(moved==1) {
							if(l+2>7 || w-1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+2,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l+2, w-1, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==2) {
							if(l-2<0 || w+1>7)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-2,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l-2, w+1, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==3) {
							if(l+2>7 || w-1<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+2,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l+2, w-1, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==4) {
							if(l+1>7 || w+2>7)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+1,w+2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l+1, w+2, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==5) {
							if(l+1>7 || w-2<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+1,w-2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l+1, w-2, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==6) {
							if(l-1<0 || w+2>7)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-1,w+2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l-1, w+2, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==7) {
							if(l-1>7 || w-2>7)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-1,w-2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l-1, w-2, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
					case"B":
						distance=move.nextInt(6);
						moved=move.nextInt(3);
						if(moved==0) {
							if(l+distance>7 || w+distance>7)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l+distance, w+distance, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==1) {
							if(l-distance<0 || l-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l-distance, w-distance, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==2) {
							if(l+distance>7 || w-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l+distance, w-distance, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						if(moved==3) {
							if(w+distance>7 || l-distance<0)
							{
								generateMove(bMax,player);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player);
								break;
							}
							generateMove(bMax,player);
							//Piece setter=bMax.getPiece(l, w);
							//bMax.setPiece(l-distance, w+distance, setter);
							//bMax.setPiece(l, w, null);
							break;
						}
						break;
							
    				}
					return bMax;
	
    }
}
