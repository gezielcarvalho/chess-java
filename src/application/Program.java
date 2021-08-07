package application;

import java.util.Scanner;

//import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello Chess!");
//		
//		Position pos = new Position(1,2);
//		System.out.println(pos);
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			UI.printBoard(chessMatch.getPieces());
			
			System.out.println();
			System.out.println("Origem");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.println("Destino");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			
		}
		
		//UI.printBoard(chessMatch.getPieces());
		
	}

}
