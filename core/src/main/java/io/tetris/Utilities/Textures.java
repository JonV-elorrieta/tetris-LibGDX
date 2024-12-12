package io.tetris.Utilities;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	// Methods object for utilities
	Methods m = new Methods();

	// Texture for the title of the game
	private Texture title;
	// Texture for the table of the game
	private Texture table;
    // Texture for the score box of the game
	private Texture scoreBox;
    // Texture for the score of the game
    private ArrayList<Texture> scoreTexture = new ArrayList<Texture>();
    // Texture for the level box of the game
    private Texture levelBox;
    // Texture for the level of the game
    private ArrayList<Texture> levelTexture = new ArrayList<Texture>();
    // Texture for the lines box of the game
    private Texture linesBox;
    // Texture for the lines of the game
    private ArrayList<Texture> linesTexture = new ArrayList<Texture>();
	// Texture for the background of the game
	private Animation<TextureRegion> background;
	
	// Constructor for the Textures class
	public Textures() {
		// Initialize the title texture
		title = new Texture("tetrisTitle.png");
		
		// Initialize the table texture
		table = new Texture("tabla.jpg");
		
		// Initialize the score texture
		scoreBox = new Texture("scoreBox.png");
		
		// Initialize the score
		// Create a Integer aux arraylist and fill it with 0's
		ArrayList<Integer> auxScore = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			auxScore.add(0);
		}
		// Convert the aux arraylist to a texture
		scoreTexture = m.getNewScore(auxScore);
		
		// Initialize the level box texture
		levelBox = new Texture("levelBox.png");
		
		// Initialize the level
		// Create a Integer aux arraylist and fill it with 1's
		ArrayList<Integer> auxLevel = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			auxLevel.add(0);
		}
		auxLevel.add(1);
		// Convert the aux arraylist to a texture
		levelTexture = m.getNewLevel(auxLevel);
		
		// Initialize the lines box texture
		linesBox = new Texture("linesBox.png");
		
		// Initialize the lines
		// Create a Integer aux arraylist and fill it with 1's
		ArrayList<Integer> auxLines = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			auxLines.add(0);
		}
		auxLines.add(1);
		// Convert the aux arraylist to a texture
		linesTexture = m.getNewLines(auxLines);
		
		// Initialize the background texture
		background = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("background.gif").read());
	}

	
	// Getter for the title texture
	public Texture getTitle() {
		return title;
	}

	// Getter for the table texture
	public Texture getTable() {
		return table;
	}
	// Getter for the score texture
	public Texture getScoreBox() {
		return scoreBox;
	}
	
	// Getter for the score texture
	public Animation<TextureRegion> getBackground() {
		return background;
	}
	
	// Setter for the score texture
	public void setScore(ArrayList<Integer> scoreInts) {
		// Get the new score as a Integer arraylist and convert it to a texture
		scoreTexture = m.getNewScore(scoreInts);
	}
	
	// Getter for the scoreTexture
	public ArrayList<Texture> getScore() {
		return scoreTexture;
	}
	
	// Getter for the levelBox texture
	public Texture getLevelBox() {
		return levelBox;
	}
	
	// Setter for the level texture
	public void setLevel(ArrayList<Integer> levelInts) {
		// Get the new score as a Integer arraylist and convert it to a texture
		scoreTexture = m.getNewLevel(levelInts);
	}
	
	// Getter for the levelTexture
	public ArrayList<Texture> getLevel() {
		return levelTexture;
	}
	
	// Getter for the linesBox texture
	public Texture getLinesBox() {
		return linesBox;
	}
	
	// Setter for the lines texture
	public void setLines(ArrayList<Integer> linesInts) {
		// Get the new score as a Integer arraylist and convert it to a texture
		scoreTexture = m.getNewLines(linesInts);
	}
	
	// Getter for the linesTexture
	public ArrayList<Texture> getLines() {
		return linesTexture;
	}
	
	

	

	

}
