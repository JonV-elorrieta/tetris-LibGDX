package io.tetris.pieces;

import io.tetris.Utilities.Constants;
import io.tetris.Utilities.Textures;
import io.tetris.Main;

public class PieceThread extends Thread{
	private Piece piece;
	private Textures textures;
	
	public PieceThread(Piece piece, Textures textures) {
		this.piece = piece;
		this.textures = textures;
		this.start();
	}
	
	@Override
	public void run() {
		boolean isMoved = true;
		do {
			try {
				Thread.sleep(Constants.DELAY_I);
				int[][] oldPosition = piece.getPosition();
				
				for (int i = 0; i < oldPosition.length; i++) {
					Main.removePiece(oldPosition[i][0], oldPosition[i][1]);
				}
				
				isMoved = piece.moveDown();
				
				int[][] newPosition = piece.getPosition();
				
				for (int i = 0; i < newPosition.length; i++) {
					Main.placePiece(newPosition[i][0], newPosition[i][1], piece);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (isMoved);
		
		textures.setPiece();
		textures.setNextPiece();

	}
}
