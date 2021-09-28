package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch; 

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getRows()];
		Position p = new Position(0,0);

		//top
		p.setValues(position.getRow()-1, position.getColumn());
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		//top right
		p.setValues(position.getRow()-1, position.getColumn()+1);
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn()+1);
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}	
		
		//bottom right
		p.setValues(position.getRow()+1, position.getColumn()+1);
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}		
		
		//bottom
		p.setValues(position.getRow()+1, position.getColumn());
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}	
		
		//bottom left
		p.setValues(position.getRow()+1, position.getColumn()-1);
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}		
		
		//left
		p.setValues(position.getRow(), position.getColumn()-1);
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		//top left
		p.setValues(position.getRow()-1, position.getColumn()-1);
		
		if (
				getBoard().positionExists(p) 
				&& 
				canMove(p)
			) 
		{
			mat[p.getRow()][p.getColumn()]=true;
		}	
		
		//castling 
		if (getMoveCount() == 0 && !chessMatch.isCheck()) {
			//kingside rook
			Position posT1 = new Position(position.getRow(),position.getColumn()+3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(),position.getColumn()+1);
				Position p2 = new Position(position.getRow(),position.getColumn()+2);
				if (getBoard().piece(p1)==null && getBoard().piece(p2)==null) {
					mat[position.getRow()][position.getColumn()+2]=true;
				}
			}
			//queenside rook
			Position posT2 = new Position(position.getRow(),position.getColumn()-4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(),position.getColumn()-1);
				Position p2 = new Position(position.getRow(),position.getColumn()-2);
				Position p3 = new Position(position.getRow(),position.getColumn()-3);
				if (getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null) {
					mat[position.getRow()][position.getColumn()-2]=true;
				}
			}			
		}
		
		return mat;
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p!= null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
}
