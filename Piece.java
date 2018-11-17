package chess;

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
	public void CreateRook(Boolean b)
	{
		black=b;
		setType("R");
		//Rook p = new Rook(black);
	}
	public void CreateKnight(Boolean b)
	{
		black=b;
		setType("k");
	//	Knight p = new Knight(black);
	}
	public void CreateQueen(Boolean b)
	{
		black=b;
		setType("Q");
		//Queen p = new Queen(black);
	}
	public void CreateKing(Boolean b)
	{
		black=b;
		setType("K");
		//King p = new King(black);
	}
	public void CreateBishop(boolean b) 
	{
		black=b;
		setType("B");
		//Bishop b = new Bishop(black);
		
	}
	public Boolean getColor(){
		return black;
	}
	public Boolean getFirst()
	{
		return first;
	}
	public void setFirst()
	{
			first=false;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String pieceType)
	{
		type=pieceType;
	}

}
