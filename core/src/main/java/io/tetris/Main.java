package io.tetris;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import io.tetris.Utilities.GifDecoder;
import io.tetris.Utilities.Methods;
import io.tetris.Utilities.Textures;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	// SpriteBatch for drawing
    private SpriteBatch batch;
    
    // Textures object for getting textures
    private Textures textures;
    
    private Methods m = new Methods();
    
    // Elapsed
    private float elapsed;
    

    private float inputDelay = 0.5f; // Delay in seconds
	private float inputTimer = 0;
  
    
    @Override
    public void create() {
    	// Create a new SpriteBatch
        batch = new SpriteBatch();
        // Create a new Textures object
        textures = new Textures();
        textures.initialize();

        
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
                inputTimer = 0; // Reset the timer
                int randomNumber = (int) (Math.random() * 99) + 1;
                System.out.println("Random number: " + randomNumber);
                m.sumScore(randomNumber,textures);
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
	    
	    // End the batch
	    batch.end();
	}

    @Override
    public void dispose() {
    	// Dispose the batch and all the textures
        batch.dispose();
        textures.getTitle().dispose();
        textures.getTable().dispose();
        textures.getScoreBox().dispose();
        textures.getLevelBox().dispose();
        textures.getLinesBox().dispose();
        
        
        for (Object frame : textures.getBackground().getKeyFrames()) {
            ((TextureRegion) frame).getTexture().dispose();
        }
    }
}
