package io.tetris.Utilities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Methods {

	public ArrayList<Texture> getNewScore(ArrayList<Integer> scores){
		ArrayList<Texture> newScore = new ArrayList<Texture>();
		for (int i = 0; i < scores.size(); i++) {
			Texture aux = new Texture("numbers/" + scores.get(i) + ".png");
			newScore.add(aux);
		}
		return newScore;
	}
}
