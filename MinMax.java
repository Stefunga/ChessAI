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
public MinMax()
{
	
}
public void MiniMax (int levels, boolean playera, Board boarda, Boolean MinMax, int branches) {
		if(levels==0)
		{
		moveVerify a=new moveVerify();
		holder=a.valueFunction(MinMax, boarda);
//		boarda.printBoard();
//		System.out.printf("%nSet first%n");

		return;
		}
		int z=branches;	
		int y=levels;
    		for(int x=0; z>x; z--)
    		{
    			Board Tree=new Board();
    			boolean check=false;
    			if(MinMax)
    			{
    				Tree=generateMove(boarda.boardDuplicate(),player,0);
    				 MiniMax(levels-1,!playera,Tree.boardDuplicate(),!MinMax,branches);
    				if(max==-9999||(holder<max))
        			{
        				max=holder;
//        				System.out.printf("%nMAX:"+holder);
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
        						//return;
        					}
        					if(FinalBoard !=null && FinalBoard.getValue()>Tree.getValue())
        					{
        						FinalBoard=Tree;
        					}
            			}
        			}
    			}
    			}
    		min=-9999;
    		max=-9999;
    			
    		}
    		
    		
    
	public Board getFinalBoard()
	{
		return FinalBoard;
	}
    public static Board generateMove(Board bMax, boolean player,int count) {
    			count = count+1;
    			if(count > 500 && player==false)
    			{
    				System.out.printf("%n*********%n");
    				System.out.printf("%nCheckMate%n");
    				System.out.printf("%n*********%n");

    				Board newGame = new Board();
    				Game test = new Game();
    				return bMax;
    			}
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
					generateMove(bMax,player,count++);
					return bMax;
				}
				String piece=(bMax.getPiece(l, w)).getType();
    				switch(piece) {
					case"P":
						int moved=move.nextInt(3);
						if(moved==0)
						{
							if(player==true)
							{
								verified=new moveVerify(l,w,l,w+1,player,bMax);
								if(verified.getValid()==false)
								{
									generateMove(bMax,player,count++);
									break;
								}
								break;
							}
							if(player==false)
							{	

								verified=new moveVerify(l,w,l,w+2,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player,count++);
									break;
								}

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
									generateMove(bMax,player,count++);
									break;
								}

								break;
							}
							if(player==false)
							{

								verified=new moveVerify(l,w,l,w+1,player, bMax);
								
								if(verified.getValid()!=true)
								{

									generateMove(bMax,player,count++);
									break;
								}

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
									generateMove(bMax,player,count++);
									break;
								}

								break;
							}
							if(player==false)
							{
								verified=new moveVerify(l,w,l-1,w+1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player,count++);
									break;
								}

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
									generateMove(bMax,player,count++);
									break;
								}

								break;
							}
							if(player==false)
							{

								verified=new moveVerify(l,w,l-1,w-1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player,count++);
									break;
								}

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
									generateMove(bMax,player,count++);
									break;
								}
								verified=new moveVerify(l,w,l,w+1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player,count++);
									break;
								}

								break;
				
						}
						if(moved==1) {
							if(w-1>7 || w-1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==2) {
							if(l+1>7 || l+1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+1,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==3) {
							if(l-1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-1,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==4) {
							if(w+1>7 || w+1<0 || l+1>7 || l+1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+1,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==5) {
							if(w-1>7 || w-1<0 || l-1>7 || l-1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-1,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==6) {
							if(w-1>7 || w-1<0 || l+1>7 || l+1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+1,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
		
							break;
						}
						if(moved==7) {
							if(w+1>7 || w+1<0 || l-1>7 || l-1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-1,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}	
						break;
					case"Q":
						moved=move.nextInt(7);
						int distance=move.nextInt(6);
						if(moved==0) {
								if(distance+w>7 || distance+w<0)
								{
									generateMove(bMax,player,count++);
									break;
								}
								verified=new moveVerify(l,w,l,w+distance,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player,count++);
									break;
								}

								break;
						}
						if(moved==1) {
							if(w-distance>7 || w-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==2) {
							if(l+distance>7 || l+distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==3) {
							if(l-distance>7 || l-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==4) {
							if(l+distance>7 || w+distance>7)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==5) {
							if(l-distance<0 || l-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==6) {
							if(l+distance>7 || w-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==7) {
							if(w+distance>7 || l-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}	
						break;
					case"R":
						moved=move.nextInt(7);
					    distance=move.nextInt(6);
						if(moved==0) {
								if(distance+w>7 || distance+w<0)
								{
									generateMove(bMax,player,count++);
									break;
								}
								verified=new moveVerify(l,w,l,w+distance,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player,count++);
									break;
								}

								break;
						}
						if(moved==1) {
							if(w-distance>7 || w-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==2) {
							if(l+distance>7 || l+distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==3) {
							if(l-distance>7 || l-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							generateMove(bMax,player,count++);
							break;
						}
						break;
					case"k":
						moved=move.nextInt(7);
						if(moved==0) {
							if(l+2>7 || w+1>7)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+2,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
						if(moved==1) {
							if(l+2>7 || w-1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+2,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
						if(moved==2) {
							if(l-2<0 || w+1>7)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-2,w+1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
						if(moved==3) {
							if(l+2>7 || w-1<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+2,w-1,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
						if(moved==4) {
							if(l+1>7 || w+2>7)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+1,w+2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
						if(moved==5) {
							if(l+1>7 || w-2<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+1,w-2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
						if(moved==6) {
							if(l-1<0 || w+2>7)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-1,w+2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
						if(moved==7) {
							if(l-1>7 || w-2>7)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-1,w-2,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							break;
						}
					case"B":
						distance=move.nextInt(6);
						moved=move.nextInt(3);
						if(moved==0) {
							if(l+distance>7 || w+distance>7)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}

							break;
						}
						if(moved==1) {
							if(l-distance<0 || l-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							generateMove(bMax,player,count++);

							break;
						}
						if(moved==2) {
							if(l+distance>7 || w-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l+distance,w-distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							generateMove(bMax,player,count++);

							break;
						}
						if(moved==3) {
							if(w+distance>7 || l-distance<0)
							{
								generateMove(bMax,player,count++);
								break;
							}
							verified=new moveVerify(l,w,l-distance,w+distance,player, bMax);
							if(verified.getValid()!=true)
							{
								generateMove(bMax,player,count++);
								break;
							}
							generateMove(bMax,player,count++);
							break;
						}
						break;
							
    				}
					return bMax;
	
    }
}
