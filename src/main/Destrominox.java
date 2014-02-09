package main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Destrominox implements ApplicationListener {
	
	private static Texture texture;
	private Sprite[][] sprite;
	public TiledMap map;
	public int column;
	public int move=0;
	OrthographicCamera camera;
	public int row;
	TiledMapTileLayer layer;
	public SpriteBatch batch;
	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		map = new TmxMapLoader().load("Maps/Level1.tmx");
		camera = new OrthographicCamera();
		camera.setToOrtho(false,400,400);
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("sprites.png"));
		layer = (TiledMapTileLayer)map.getLayers().get(0);
		column = layer.getWidth();
		row = layer.getHeight();
		sprite = new Sprite[column][row];
		for (int x = 0; x < column; x++){
			for (int y = 0; y < row; y++){
				Cell cell = layer.getCell(x,  y);
				if (cell.getTile().getId()==1){
					sprite[x][y] = new Sprite(texture, 0,0,40,40);
					sprite[x][y].translate(x*40, y*40);
				}else{
					sprite[x][y] = new Sprite(texture, 40,0,80,40);
					sprite[x][y].translate(x*40, y*40);
				}
			}
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {	
move=1;
if (camera.position.x>layer.getWidth()-400){
	move=1;
}
		camera.update();
		camera.translate(move, 0);
		camera.position.x=(Math.min(400,camera.position.x));
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (int x = 0; x < column; x++){
			for (int y = 0; y < row; y++){
		batch.draw(sprite[x][y],sprite[x][y].getX(),sprite[x][y].getY());
			}
		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
