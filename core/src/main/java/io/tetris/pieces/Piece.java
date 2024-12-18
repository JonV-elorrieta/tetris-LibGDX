package io.tetris.pieces;

import com.badlogic.gdx.graphics.Texture;

public class Piece extends Texture{
	private int[][] position;
	
	public Piece(String path, int[][] position) {
		super(path);
		this.position = position;
	
	}
	
	public int[][] getPosition() {
        return position;
    }

}
