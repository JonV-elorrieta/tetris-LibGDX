package io.tetris.Utilities;

import com.badlogic.gdx.graphics.Texture;

public class Textures_pieces {
	// Create the textures for the pieces
	private Texture piece_I;
	private Texture piece_J;
	private Texture piece_L;
	private Texture piece_O;
	private Texture piece_S;
	private Texture piece_T;
	private Texture piece_Z;
	
	public Textures_pieces() {
		
	}
	
	public void initialize() {
		// Initialize the textures for the pieces
		piece_I = new Texture("pieces/piece_I.png");
		piece_J = new Texture("pieces/piece_J.png");
		piece_L = new Texture("pieces/piece_L.png");
		piece_O = new Texture("pieces/piece_O.png");
		piece_S = new Texture("pieces/piece_S.png");
		piece_T = new Texture("pieces/piece_T.png");
		piece_Z = new Texture("pieces/piece_Z.png");
	}
	
	// Getter for the piece I
	public Texture getPiece_I() {
		return piece_I;
	}
	
	// Getter for the piece J
	public Texture getPiece_J() {
		return piece_J;
	}
	
	// Getter for the piece L
	public Texture getPiece_L() {
		return piece_L;
	}
	
	// Getter for the piece O
	public Texture getPiece_O() {
		return piece_O;
	}
	
	// Getter for the piece S
	public Texture getPiece_S() {
		return piece_S;
	}
	
	// Getter for the piece T
	public Texture getPiece_T() {
		return piece_T;
	}
	
	// Getter for the piece Z
	public Texture getPiece_Z() {
		return piece_Z;
	}
	
	// Dispose of the textures
	public void dispose() {
		piece_I.dispose();
		piece_J.dispose();
		piece_L.dispose();
		piece_O.dispose();
		piece_S.dispose();
		piece_T.dispose();
		piece_Z.dispose();
	}
	
	public Texture getRandomPiece() {
		// Get a random piece
		int random = (int) (Math.random() * 7);
		// Return the random piece
		switch (random) {
		case 0:
			return getPiece_I();
		case 1:
			return getPiece_J();
		case 2:
			return getPiece_L();
		case 3:
			return getPiece_O();
		case 4:
			return getPiece_S();
		case 5:
			return getPiece_T();
		case 6:
			return getPiece_Z();
		}
		return null;
	}
	
	
}
