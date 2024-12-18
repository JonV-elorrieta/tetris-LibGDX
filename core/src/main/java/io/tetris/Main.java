package io.tetris;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.tetris.Utilities.Methods;
import io.tetris.Utilities.Textures;
import io.tetris.pieces.Piece;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	// SpriteBatch for drawing
    private SpriteBatch batch;
    
    // Textures object for getting textures
    private Textures textures;
    
    // Methods object for utilities
    private Methods m = new Methods();
    
    // Elapsed
    private float elapsed;
    
    // Input delay
    private float inputDelay = 0.5f; 
	private float inputTimer = 0;
	
	// Grid width and height
	private static final int GRID_WIDTH = 10;
	private static final int GRID_HEIGHT = 25;
	private Texture[][] grid;
  
    
    @Override
    public void create() {
    	// Create a new SpriteBatch
        batch = new SpriteBatch();
        // Create a new Textures object
        textures = new Textures();
        textures.initialize();
        
        // Initialize the grid
        grid = new Texture[GRID_WIDTH][GRID_HEIGHT];
        
        // We get the piece 
        Piece piece = textures.getPiece();
        // Get the position of the piece
        int[][] position = piece.getPosition();
        // Place it on the grid
		for (int i = 0; i < position.length; i++) {
			placePiece(position[i][0], position[i][1], piece);
		}
       

    }
    
    @Override
	public void resize(int width, int height) {
		
	}

    @Override
    public void render() {
    	// Call the input function
    	input();
    	// Call the logic function
    	logic();
    	// Call the draw function
    	draw();
        
    }
    
    private void input() {
    	float delta = Gdx.graphics.getDeltaTime();
        inputTimer += delta;
    	
        if (inputTimer >= inputDelay) {
            if (Gdx.input.isKeyPressed(Keys.ENTER)) {
            	textures.setPiece();
                textures.setNextPiece();
                // We get the piece 
                Piece piece = textures.getPiece();
                // Get the position of the piece
                int[][] position = piece.getPosition();
                // Place it on the grid
        		for (int i = 0; i < position.length; i++) {
        			placePiece(position[i][0], position[i][1], piece);
        		}
            }
        }
    	
    }
    
	private void logic() {
		
	}
	
	private void draw() {
		// Increase the elapsed time
	   	elapsed += Gdx.graphics.getDeltaTime();
	   	
	   	// Clear the screen
	    Gdx.gl.glClearColor(1, 0, 0, 0);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    // Begin the batch
	    batch.begin();
	    
	    // Get the width and height of the screen
	    final int width = Gdx.graphics.getWidth();
	    final int height = Gdx.graphics.getHeight();
	    // Set the width of the boxes
	    float BoxWidth = 150; 
	    
	    // Draw the background
	    // batch.draw(textures.getBackground().getKeyFrame(elapsed), 0, 0, width, height);
	    // Draw the table
	    batch.draw(textures.getTable(), 40, 75, width - 240, height - 250);
	    // Draw the title
	    batch.draw(textures.getTitle(), 40, height - 160, width - 240, 150);
	    // Draw the score box
	    batch.draw(textures.getScoreBox(), width - 200, height - 325, 200, BoxWidth);

    	// We get the score as a arraylist of textures
	    ArrayList<Texture> score = textures.getScore();
	    // Get the width of the scoreTitle and calculate the width of each number to fit the score inside the scoreTitle
	    float numberWidth = BoxWidth / score.size(); 
	    // Draw each number of the score
	    for (int i = 0; i < score.size(); i++) {
	        batch.draw(score.get(i), width - 180 + numberWidth * i, height - 250 - numberWidth, numberWidth, numberWidth);
	    }
	    
	    // Draw the level box
	    batch.draw(textures.getLevelBox(), width - 200, height - 475, 200, BoxWidth);
	    
		// We get the level as a arraylist of textures
	    ArrayList<Texture> level = textures.getLevel();
	    // Get the width of the levelBox and calculate the width of each number to fit the level inside the
	    numberWidth = BoxWidth / level.size();
	    // Draw each number of the score
	    for (int i = 0; i < level.size(); i++) {
	        batch.draw(level.get(i), width - 180 + numberWidth * i, height - 400 - numberWidth, numberWidth, numberWidth);
	    }
	    
	    // Draw the lines box
	    batch.draw(textures.getLinesBox(), width - 200, height - 625, 200, BoxWidth);
	    
		// We get the lines as a arraylist of textures
	    ArrayList<Texture> lines = textures.getLines();
	    // Get the width of the levelBox and calculate the width of each number to fit the level inside the
	    
	    numberWidth = BoxWidth / lines.size();
	    // Draw each number of the score
	    for (int i = 0; i < lines.size(); i++) {
	        batch.draw(lines.get(i), width - 180 + numberWidth * i, height - 550 - numberWidth, numberWidth, numberWidth);
	    }
	    
	    // Draw the piece box
	    batch.draw(textures.getPieceBox(), width - 200, height - 775, 200, BoxWidth);
	    
	    numberWidth = BoxWidth/2;
	    // Draw the piece
	    batch.draw(textures.getNextPiece(), width - 150, height - 750, numberWidth, numberWidth);
	    
	    // Draw the grid and pieces
	    float cellWidth = (width - 240) / GRID_WIDTH;
	    float cellHeight = (height - 250) / GRID_HEIGHT;
	    for (int x = 0; x < GRID_WIDTH; x++) {
	        for (int y = 0; y < GRID_HEIGHT; y++) {
	            if (grid[x][y] != null) {
	                batch.draw(grid[x][y], 40 + x * cellWidth, 75 + y * cellHeight, cellWidth, cellHeight);
	            }
	        }
	    }
	    
	    // End the batch
	    batch.end();
	}

    @Override
    public void dispose() {
    	// Dispose the batch and all the textures
        batch.dispose();
        textures.dispose();
        
    }
    
    private void placePiece(int x, int y, Texture pieceTexture) {
        if (x >= 0 && x < GRID_WIDTH && y >= 0 && y < GRID_HEIGHT) {
            grid[x][y] = pieceTexture;
        }
    }
}
