package blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Block extends Sprite {
public Texture texture;
	public Block(float x, float y) {
		Texture.setEnforcePotImages(false);
		texture = new Texture(Gdx.files.internal("tiles/floor.png"));
		this.translate(x,  y);
	}
}
