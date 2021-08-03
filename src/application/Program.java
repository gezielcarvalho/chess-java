package application;

import boardgame.Board;
import boardgame.Position;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Chess!");
		
		Position pos = new Position(1,2);
		System.out.println(pos);
		
		Board board = new Board(8,8);
		
	}

}
