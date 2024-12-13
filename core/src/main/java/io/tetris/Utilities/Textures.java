package io.tetris.Utilities;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	// Methods object for utilities
	Methods m = new Methods();
	
	// Textures_pieces object for the pieces
	Textures_pieces tp = new Textures_pieces();

	// Texture for the title of the game
	private Texture title;
	// Texture for the table of the game
	private Texture table;
    // Texture for the score box of the game
	private Texture scoreBox;
    // Texture for the score of the game
	private String scoreInts;
    private ArrayList<Texture> scoreTexture = new ArrayList<Texture>();
    // Texture for the level box of the game
    private Texture levelBox;
    // Texture for the level of the game
    private String levelInts;
    private ArrayList<Texture> levelTexture = new ArrayList<Texture>();
    // Texture for the lines box of the game
    private Texture linesBox;
    // Texture for the lines of the game
    private String linesInts;
    private ArrayList<Texture> linesTexture = new ArrayList<Texture>();
    // Texture for the piece box of the game
    private Texture pieceBox;
    // Texture for the next piece of the game
    private Texture nextPiece;
	// Texture for the background of the game
	private Animation<TextureRegion> background;
	
	
	
	// Constructor for the Textures class
	public Textures() {

	}
	
	public void initialize() {
		// Initialize the title texture
		title = new Texture("tetrisTitle.png");
		
		// Initialize the table texture
		table = new Texture("tabla.jpg");
		
		// Initialize the score texture
		scoreBox = new Texture("scoreBox.png");
		
		// Initialize the score
		scoreInts = "000000";
		// Convert the score String to a texture
		scoreTexture = m.getScoreTextures(scoreInts);
		
		// Initialize the level box texture
		levelBox = new Texture("levelBox.png");
		
		// Initialize the level
		levelInts = "001";
		// Convert the aux arraylist to a texture
		levelTexture = m.getLevelTextures(levelInts);
		
		// Initialize the lines box texture
		linesBox = new Texture("linesBox.png");
		
		// Initialize the lines
		linesInts = "0001";
		// Convert the aux arraylist to a texture
		linesTexture = m.getLinesTextures(linesInts);
		
		// Initialize the piece box texture
		pieceBox = new Texture("pieceBox.png");
		
		// Initialize the pieces
		tp.initialize();
		
		// Initialize the next piece
		nextPiece = tp.getRandomPiece();
		
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
	public void setScore(String scoreInts) {
		// Set the scoreInts to the new scoreInt
		this.scoreInts = scoreInts;
		// Get the new score as a Integer arraylist and convert it to a texture
		scoreTexture = m.getScoreTextures(scoreInts);
	}
	
	// Getter for the scoreTexture
	public ArrayList<Texture> getScore() {
		return scoreTexture;
	}
	
	// Getter for the scoreInts
	public String getScoreInts() {
        return scoreInts;
    }
	
	// Getter for the levelBox texture
	public Texture getLevelBox() {
		return levelBox;
	}
	
	// Setter for the level texture
	public void setLevel(String levelInts) {
		// Set the levelInts to the new levelInt
		this.levelInts = levelInts;
		// Get the new score as a Integer arraylist and convert it to a texture
		scoreTexture = m.getLevelTextures(levelInts);
	}
	
	// Getter for the levelTexture
	public ArrayList<Texture> getLevel() {
		return levelTexture;
	}
	
	// Getter for the levelInts
	public String getLevelInts() {
        return levelInts;
    }
	
	// Getter for the linesBox texture
	public Texture getLinesBox() {
		return linesBox;
	}
	
	// Setter for the lines texture
	public void setLines(String linesInts) {
		// Set the linesInts to the new linesInt
		this.linesInts = linesInts;
		// Get the new score as a Integer arraylist and convert it to a texture
		scoreTexture = m.getLinesTextures(linesInts);
	}
	
	// Getter for the linesTexture
	public ArrayList<Texture> getLines() {
		return linesTexture;
	}
	
	// Getter for the linesInts
	public String getLinesInts() {
		return linesInts;
	}
	
	// Getter for the pieceBox texture
	public Texture getPieceBox() {
		return pieceBox;
	}
	
	// Getter for the nextPiece texture
	public Texture getNextPiece() {
		return nextPiece;
	}
	
	// Setter for the nextPiece texture
	public void setNextPiece() {
        // Set the nextPiece to a random piece
        nextPiece = tp.getRandomPiece();
	}
	
	// Dispose method for the textures
	public void dispose() {
		title.dispose();
		table.dispose();
		scoreBox.dispose();
		levelBox.dispose();
		linesBox.dispose();
		pieceBox.dispose();
		
		tp.dispose();

		for (Object frame : background.getKeyFrames()) {
			((TextureRegion) frame).getTexture().dispose();
		}
	}
	
	

	

	

}
