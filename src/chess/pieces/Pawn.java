package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getRows()];
		Position p = new Position(0,0);

		//white pawn
		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow()-1, position.getColumn());
			if (
					getBoard().positionExists(p) 
					&& 
					(!getBoard().thereIsAPiece(p))
				) 
			{
				mat[p.getRow()][p.getColumn()]=true;
				//first time
				if (getMoveCount()==0) {
					p.setValues(position.getRow()-2, position.getColumn());
					if (
							getBoard().positionExists(p) 
							&& 
							(!getBoard().thereIsAPiece(p))
						) 
					{
						mat[p.getRow()][p.getColumn()]=true;
					}			
				}
			}
			

			//capture diagonal right
			p.setValues(position.getRow()-1, position.getColumn()+1);
			if (
					getBoard().positionExists(p) 
					&& 
					isThereOpponentPiece(p)
				) 
			{
				mat[p.getRow()][p.getColumn()]=true;
			}
			//capture diagonal left
			p.setValues(position.getRow()-1, position.getColumn()-1);
			if (
					getBoard().positionExists(p) 
					&& 
					isThereOpponentPiece(p)
				) 
			{
				mat[p.getRow()][p.getColumn()]=true;
			}			
		}
		else {
			p.setValues(position.getRow()+1, position.getColumn());
			if (
					getBoard().positionExists(p) 
					&& 
					(!getBoard().thereIsAPiece(p))
				) 
			{
				mat[p.getRow()][p.getColumn()]=true;
				//first time
				if (getMoveCount()==0) {
					p.setValues(position.getRow()+2, position.getColumn());
					if (
							getBoard().positionExists(p) 
							&& 
							(!getBoard().thereIsAPiece(p))
						) 
					{
						mat[p.getRow()][p.getColumn()]=true;
					}			
				}
			}
			//capture diagonal right
			p.setValues(position.getRow()+1, position.getColumn()+1);
			if (
					getBoard().positionExists(p) 
					&& 
					isThereOpponentPiece(p)
				) 
			{
				mat[p.getRow()][p.getColumn()]=true;
			}
			//capture diagonal left
			p.setValues(position.getRow()+1, position.getColumn()-1);
			if (
					getBoard().positionExists(p) 
					&& 
					isThereOpponentPiece(p)
				) 
			{
				mat[p.getRow()][p.getColumn()]=true;
			}
		}

		return mat;
	}
}
