package blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Block extends Sprite {

	public Block() {
		// TODO Auto-generated constructor stub
	}

	public Block(Texture texture) {
		super(texture);
		// TODO Auto-generated constructor stub
	}

	public Block(TextureRegion region) {
		super(region);
		// TODO Auto-generated constructor stub
	}

	public Block(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public Block(Texture texture, int srcWidth, int srcHeight) {
		super(texture, srcWidth, srcHeight);
		// TODO Auto-generated constructor stub
	}

	public Block(Texture texture, int srcX, int srcY, int srcWidth,
			int srcHeight) {
		super(texture, srcX, srcY, srcWidth, srcHeight);
		// TODO Auto-generated constructor stub
	}

	public Block(TextureRegion region, int srcX, int srcY, int srcWidth,
			int srcHeight) {
		super(region, srcX, srcY, srcWidth, srcHeight);
		// TODO Auto-generated constructor stub
	}

}
