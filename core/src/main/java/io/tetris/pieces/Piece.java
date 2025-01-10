package io.tetris.pieces;

import com.badlogic.gdx.graphics.Texture;

public class Piece extends Texture {
	private int[][] position;
	
	public Piece(String path, int[][] position) {
		super(path);
		this.position = position;
	}
	
	public int[][] getPosition() {
        return position;
    }
	
	public void moveLeft() {
		if (position[0][0] == 0 || position[1][0] == 0 || position[2][0] == 0 || position[3][0] == 0 ||
            position[0][1] == 0 || position[1][1] == 0 || position[2][1] == 0 || position[3][1] == 0) {
            return;
		}
		for (int i = 0; i < position.length; i++) {
			position[i][0]--;
		}
	}
	
	public void moveRight() {
		if (position[0][0] == 9 || position[1][0] == 9 || position[2][0] == 9 || position[3][0] == 9
		|| position[0][1] == 9 || position[1][1] == 9 || position[2][1] == 9 || position[3][1] == 9) {
			return;
		}
		
		for (int i = 0; i < position.length; i++) {
			position[i][0]++;
		}
	}
	
	public boolean moveDown() {
		if (position[0][0] == 0 || position[1][0] == 0 || position[2][0] == 0 || position[3][0] == 0
		|| position[0][1] == 0 || position[1][1] == 0 || position[2][1] == 0 || position[3][1] == 0) {
			return false;
		}
		
		for (int i = 0; i < position.length; i++) {
			position[i][1]--;
			
		}
		return true;
	}
	


}
