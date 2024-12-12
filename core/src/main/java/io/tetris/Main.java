package io.tetris;

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

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Texture title;
    private Texture table;
    private Texture score;
    
    Animation<TextureRegion> animation;
    float elapsed;

    @Override
    public void create() {
        batch = new SpriteBatch();
        title = new Texture("tetrisTitle.png");
        table = new Texture("tabla.jpg");
        score = new Texture("score.png");
        background = new Texture("background.jpg");

        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("test.gif").read());
     
       
    }

    @Override
    public void render() {
        // ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
    	 elapsed += Gdx.graphics.getDeltaTime();
         Gdx.gl.glClearColor(1, 0, 0, 0);
         Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        final int width = Gdx.graphics.getWidth();
        final int height = Gdx.graphics.getHeight();
        
        batch.draw(animation.getKeyFrame(elapsed), 20.0f, 20.0f);
        // batch.draw(background, 0, 0, width, height);
        batch.draw(table, 40, 75, width - 240, height - 250);
        batch.draw(title, 40, height - 160, width - 240, 150);
        batch.draw(score, width - 180, height - 320, 150, 150);
        batch.end();
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        title.dispose();
        table.dispose();
        score.dispose();
        background.dispose();
    }
}
