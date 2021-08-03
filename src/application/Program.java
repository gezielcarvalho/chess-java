package application;

import boardgame.Position;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello Chess!");
//		
//		Position pos = new Position(1,2);
//		System.out.println(pos);
		
		ChessMatch chessMatch = new ChessMatch();
		
		UI.printBoard(chessMatch.getPieces());
		
	}

}
