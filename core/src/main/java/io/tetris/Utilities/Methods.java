package io.tetris.Utilities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

import io.tetris.Main;
import io.tetris.pieces.*;

public class Methods {

	// Method to get the new score arraylist of textures
	public ArrayList<Texture> getScoreTextures(String scores){
		//  Create a new arraylist of textures
		ArrayList<Texture> newScore = new ArrayList<Texture>();
		// Split the score string
		String[] scoreSplit = scores.split("");
		// Iterate through the scores array
		for (int i = 0; i < scoreSplit.length; i++) {
			// Create a new texture with the number
			Texture aux = new Texture("numbers/" + scoreSplit[i] + ".png");
			newScore.add(aux);
		}
		// Return the new arraylist of textures
		return newScore;
	}
	
	
	// Method to get the new level arraylist of textures
	public ArrayList<Texture> getLevelTextures(String lvls){
		// Create a new arraylist of textures
		ArrayList<Texture> newLvls = new ArrayList<Texture>();
		// Split the levels string
		String[] lvlSplit = lvls.split("");
		// Iterate through the levels array
		for (int i = 0; i < lvlSplit.length; i++) {
			// We check if the level is 0, if it is we add a null texture
			if (lvlSplit[i].equals("0")) {
				Texture aux = new Texture("numbers/null.png");
				newLvls.add(aux);
			}else {
				// Create a new texture with the number
				Texture aux = new Texture("numbers/" + lvlSplit[i] + ".png");
				newLvls.add(aux);
			}
	
		}
		// Return the new arraylist of textures
		return newLvls;
	}
	
	// Method to get the new lines arraylist of textures
	public ArrayList<Texture> getLinesTextures(String lines) {
		// Create a new arraylist of textures
		ArrayList<Texture> newLines = new ArrayList<Texture>();
		// Split the lines string
		String[] linesSplit = lines.split("");
		// Iterate through the lines array
		for (int i = 0; i < linesSplit.length; i++) {
			// We check if the level is 0, if it is we add a null texture
			if (linesSplit[i].equals("0")) {
				
				
				Texture aux = new Texture("numbers/null.png");
				newLines.add(aux);
			}else {
				// Create a new texture with the number
				Texture aux = new Texture("numbers/" + linesSplit[i] + ".png");
				newLines.add(aux);
			}
		}
		return newLines;
	}
	
	public void sumScore(int sumScore, Textures textures) {
		// Get the old score as a int
		int newScore = Integer.parseInt(textures.getScoreInts());
		// Sum the new score to the old score
		newScore += sumScore;
		// Convert the new score to a string
		String newScoreString = String.valueOf(newScore);
		// Split the new score string to know how many numbers we have
		String[] newScoreSplit = newScoreString.split("");
		// Fill all score with 0's to have 6 numbers
		if (newScoreSplit.length < 6) {
			// Create a new aux string 
			String aux = "";
			// Iterate through the numbers we need
			for (int i = 0; i < 6 - newScoreSplit.length; i++) {
				// Add a 0 to the aux string
				aux += "0";
			}
			// Concatenate the aux string to the new score string
			newScoreString = aux + newScoreString;
		}
		
		// Set the new score
		textures.setScore(newScoreString);
	}
	
	public Piece getRandomPiece() {
		// Get a random piece
		int random = (int) (Math.random() * 7);
		// Instantiate a return piece
		Piece randomPiece = null;
		// Return the random piece
		switch (random) {
		case 0:
			randomPiece = new Piece_I();
			break;
		case 1:
			randomPiece = new Piece_J();
			break;
		case 2:
			randomPiece = new Piece_L();
			break;
		case 3:
			randomPiece = new Piece_O();
			break;
		case 4:
			randomPiece = new Piece_S();
			break;
		case 5:
			randomPiece	= new Piece_T();
			break;
		case 6:
			randomPiece = new Piece_Z();
			break;
		}
		return randomPiece;
	}
	
	public Piece getNextPiece(Texture texture) {
		// Instantiate a return piece
		Piece randomPiece = null;
		// Check which piece we have to return
		switch (texture.toString()) {
			case "pieces/piece_I.png":
				randomPiece = new Piece_I();
				break;
			case "pieces/piece_J.png":
				randomPiece = new Piece_J();
				break;
			case "pieces/piece_L.png":
				randomPiece = new Piece_L();
				break;
			case "pieces/piece_O.png":
				randomPiece = new Piece_O();
				break;
			case "pieces/piece_S.png":
				randomPiece = new Piece_S();
				break;
			case "pieces/piece_T.png":
				randomPiece = new Piece_T();
				break;
			case "pieces/piece_Z.png":
				randomPiece = new Piece_Z();
				break;
		}
		// Return the piece
		return randomPiece;
	}
	


}
