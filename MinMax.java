package chess;

import java.util.Random;

public class MinMax {
int checker;
int branches;
boolean player;
int holder=0;
Board Final=null;
int max=0;
int min=0;
Boolean MinMax=true;
public MinMax (int levels, boolean playera, Board boarda) {
		player=playera;
		int value;
		
		if(levels==0)
		{
			value=valueFunction(boarda);
			boarda.setValue(value);
			holder=value;
		}
    		for(int x=0; branches>x; branches--)
    		{
    			Board Tree=new Board();
    			boolean check=false;
    			if(levels%2!=0)
    			{
    				Tree=generateMove(boarda,player);//need to change L and B to make it work correctly(rand num)
    			}
    			else
    			{
    				Tree=generateMove(boarda,!player);//need to change L and B to make it work correctly(rand num)
    			}
    			Tree=generateMove(boarda,player);//need to change L and B to make it work correctly(rand num)
    			MinMax r= new MinMax(levels-1,playera,Tree);
    			
    			if((max==0||holder>max)&&MinMax)
    			{
    				max=holder;
    				boarda.setValue(holder);
    			}
    			if((min==0||holder<min)&&MinMax)
    			{
    				min=holder;
    				boarda.setValue(holder);
    			}
    		}
    		min=0;
    		max=0;
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
				String piece=bMax.getPiece(l,w).getType();
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
									generateMove(bMax,player);
									break;
								}
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l, w+1,setter);
								bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{	
								verified=new moveVerify(l,w,l,w-2,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l, w-2, setter);
								bMax.setPiece(l, w, null);
								break;
							}
							
						}
						if(moved==1)
						{
							if(player==true)
							{
								verified=new moveVerify(l,w,l,w+1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l, w+1, setter);
								bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{
								verified=new moveVerify(l,w,l,w-1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l, w-1, setter);
								bMax.setPiece(l, w, null);
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
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l+1, w+1, setter);
								bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{
								verified=new moveVerify(l,w,l-1,w+1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l-1, w+1, setter);
								bMax.setPiece(l, w, null);
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
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l+1, w-1, setter);
								bMax.setPiece(l, w, null);
								break;
							}
							if(player==false)
							{
								verified=new moveVerify(l,w,l-1,w-1,player, bMax);
								if(verified.getValid()!=true)
								{
									generateMove(bMax,player);
									break;
								}
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l-1, w-1, setter);
								bMax.setPiece(l, w, null);
								break;
							}	
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
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l, w+1, setter);
								bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l, w-1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+1, w, setter);
							bMax.setPiece(l, w, null);
							break;
						}
						if(moved==3) {
							if(l+1>7 || l+1<0)
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-1, w, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+1, w+1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-1, w-1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+1, w-1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-1, w+1, setter);
							bMax.setPiece(l, w, null);
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
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l, w+distance, setter);
								bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l, w-distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+distance, w, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-distance, w, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+distance, w+distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-distance, w-distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+distance, w-distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-distance, w+distance, setter);
							bMax.setPiece(l, w, null);
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
								Piece setter=bMax.getPiece(l, w);
								bMax.setPiece(l, w+distance, setter);
								bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l, w-distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+distance, w, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-distance, w, setter);
							bMax.setPiece(l, w, null);
							break;
						}
						
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+2, w+1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+2, w-1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-2, w+1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+2, w-1, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+1, w+2, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+1, w-2, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-1, w+2, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-1, w-2, setter);
							bMax.setPiece(l, w, null);
							break;
						}
						break;
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+distance, w+distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-distance, w-distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l+distance, w-distance, setter);
							bMax.setPiece(l, w, null);
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
							Piece setter=bMax.getPiece(l, w);
							bMax.setPiece(l-distance, w+distance, setter);
							bMax.setPiece(l, w, null);
							break;
						}	
					}
					return bMax;
					
			
    }
    public void max(int max, int check) {
    		if(max<check)
    		{
    			max=check;
    		}
    }
    public void min(int min, int check) {
    		if(min<check)
    		{
    			min=check;
    		}
    }
    /*
     * need to incorporate a function that values the different variations of the board
     * might connect to DB with stored boards with assigned values
     */
    public int valueFunction(Board b) {
	int whatever=0;
    	return whatever;
    	
    }
    

}
