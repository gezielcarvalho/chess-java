package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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
			
			//en passant white
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn()-1); 
				Position right = new Position(position.getRow(), position.getColumn()+1); 
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassanVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassanVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}				
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
			
			//en passant black
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn()-1); 
				Position right = new Position(position.getRow(), position.getColumn()+1); 
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassanVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassanVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}				
			}			
		}

		return mat;
	}
}
