package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
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
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				
				System.out.println();
				System.out.println("Origem");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(),possibleMoves);
				
				System.out.println();
				System.out.println("Destino");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch(ChessException ce) {
				System.out.println(ce.getMessage());
				sc.nextLine();			
			} catch(InputMismatchException ime) {
				System.out.println(ime.getMessage());
				sc.nextLine();				
			}
			
		}
		
		//UI.printBoard(chessMatch.getPieces());
		
	}

}
