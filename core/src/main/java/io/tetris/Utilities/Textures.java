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
    // Texture for the score of the game
	private Texture scoreTitle;
    // Score Texture
    private ArrayList<Texture> scoreTexture = new ArrayList<Texture>();
	// Texture for the background of the game
	private Animation<TextureRegion> background;
	
	// Constructor for the Textures class
	public Textures() {
		// Initialize the title texture
		title = new Texture("tetrisTitle.png");
		
		// Initialize the table texture
		table = new Texture("tabla.jpg");
		
		// Initialize the score texture
		scoreTitle = new Texture("scoreTitle.png");
		
		// Initialize the score
		// Create a Integer aux arraylist and fill it with 0's
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			aux.add(0);
		}
		// Convert the aux arraylist to a texture
		scoreTexture = m.getNewScore(aux);
		
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
	public Texture getScoreTitle() {
		return scoreTitle;
	}
	
	// Getter for the score texture
	public Animation<TextureRegion> getBackground() {
		return background;
	}
	
	// Setter for the scoreInts
	public void setScore(ArrayList<Integer> scoreInts) {
		// Get the new score as a Integer arraylist and convert it to a texture
		scoreTexture = m.getNewScore(scoreInts);
	}
	
	// Getter for the scoreTexture
	public ArrayList<Texture> getScore() {
		return scoreTexture;
	}
	
	

	

	

}
