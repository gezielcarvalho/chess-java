package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	public String toString() {
		return "B";
	}

//	private boolean canMove(Position position) {
//		ChessPiece p = (ChessPiece) getBoard().piece(position);
//		return p == null || p.getColor() != getColor();
//	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getRows()];
		Position p = new Position(0,0);

		//top right
		p.setValues(position.getRow()-1, position.getColumn()+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()-1);
			p.setColumn(p.getColumn()+1);
		}
		
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		//top left
		p.setValues(position.getRow()-1, position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()-1);
			p.setColumn(p.getColumn()-1);
		}
		
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		// bottom left
		p.setValues(position.getRow()+1, position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()+1);
			p.setColumn(p.getColumn()-1);
		}
		
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}	
		
		//bottom right
		p.setValues(position.getRow()+1, position.getColumn()+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setRow(p.getRow()+1);
			p.setColumn(p.getColumn()+1);
		}
		
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		return mat;
	}
}
