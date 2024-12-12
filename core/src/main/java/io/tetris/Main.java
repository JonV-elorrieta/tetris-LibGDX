package io.tetris;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import io.tetris.Utilities.GifDecoder;
import io.tetris.Utilities.Textures;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	// SpriteBatch for drawing
    private SpriteBatch batch;
    
    // Textures object for getting textures
    private Textures textures;
    
    // Elapsed
    private float elapsed;
  
    
    @Override
    public void create() {
    	// Create a new SpriteBatch
        batch = new SpriteBatch();
        // Create a new Textures object
        textures = new Textures();

        
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
	    

	    // Draw the background
	    batch.draw(textures.getBackground().getKeyFrame(elapsed), 0, 0, width, height);
	    // Draw the table
	    batch.draw(textures.getTable(), 40, 75, width - 240, height - 250);
	    // Draw the title
	    batch.draw(textures.getTitle(), 40, height - 160, width - 240, 150);
	    // Draw the scoreTitle
	    batch.draw(textures.getScoreTitle(), width - 180, height - 320, 150, 150);

    	// We get the score as a arraylist of textures
	    ArrayList<Texture> score = textures.getScore();
	    // Get the width of the scoreTitle and calculate the width of each number to fit the score inside the scoreTitle
	    float scoreTitleWidth = 150; 
	    float numberWidth = scoreTitleWidth / score.size(); 
	    // Draw each number of the score
	    for (int i = 0; i < score.size(); i++) {
	        batch.draw(score.get(i), width - 180 + numberWidth * i, height - 320 - numberWidth, numberWidth, numberWidth);
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
        textures.getScoreTitle().dispose();
        for (Object frame : textures.getBackground().getKeyFrames()) {
            ((TextureRegion) frame).getTexture().dispose();
        }
    }
}
