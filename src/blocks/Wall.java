package blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Wall extends Block {

	public Wall(float x, float y) {
		super(x, y);
		Texture.setEnforcePotImages(false);
		texture = new Texture(Gdx.files.internal("tiles/wall.png"));
		translate(x,  y);
	}
}
