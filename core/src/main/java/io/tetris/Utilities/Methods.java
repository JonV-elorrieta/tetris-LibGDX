package io.tetris.Utilities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Methods {

	// Method to get the new score arraylist of textures
	public ArrayList<Texture> getNewScore(ArrayList<Integer> scores){
		//  Create a new arraylist of textures
		ArrayList<Texture> newScore = new ArrayList<Texture>();
		// Iterate through the scores array
		for (int i = 0; i < scores.size(); i++) {
			// Create a new texture with the number
			Texture aux = new Texture("numbers/" + scores.get(i) + ".png");
			newScore.add(aux);
		}
		// Return the new arraylist of textures
		return newScore;
	}
	
	
	// Method to get the new level arraylist of textures
	public ArrayList<Texture> getNewLevel(ArrayList<Integer> lvls){
		// Create a new arraylist of textures
		ArrayList<Texture> newLvls = new ArrayList<Texture>();
		// Iterate through the levels array
		for (int i = 0; i < lvls.size(); i++) {
			// We check if the level is 0, if it is we add a null texture
			if (lvls.get(i) == 0) {
				Texture aux = new Texture("numbers/null.png");
				newLvls.add(aux);
			}else {
				// Create a new texture with the number
				Texture aux = new Texture("numbers/" + lvls.get(i) + ".png");
				newLvls.add(aux);
			}
	
		}
		// Return the new arraylist of textures
		return newLvls;
	}
	
	// Method to get the new lines arraylist of textures
	public ArrayList<Texture> getNewLines(ArrayList<Integer> lines) {
		// Create a new arraylist of textures
		ArrayList<Texture> newLines = new ArrayList<Texture>();
		// Iterate through the lines array
		for (int i = 0; i < lines.size(); i++) {
			// We check if the level is 0, if it is we add a null texture
			if (lines.get(i) == 0) {
				Texture aux = new Texture("numbers/null.png");
				newLines.add(aux);
			}else {
				// Create a new texture with the number
				Texture aux = new Texture("numbers/" + lines.get(i) + ".png");
				newLines.add(aux);
			}
		}
		return newLines;
	}
}
