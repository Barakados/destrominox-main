package main;

import blocks.Block;
import blocks.Wall;

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
	private Block[][] sprite;
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
		layer = (TiledMapTileLayer)map.getLayers().get(0);
		column = layer.getWidth();
		row = layer.getHeight();
		sprite = new Block[column][row];
		for (int x = 0; x < column; x++){
			for (int y = 0; y < row; y++){
				Cell cell = layer.getCell(x,  y);
				if (cell.getTile().getId()==1){
					sprite[x][y] = new Wall(x*40,y*40);
				}else{
					sprite[x][y] = new Block(x*40,y*40);
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

		camera.update();
		camera.position.x=(Math.min(400,camera.position.x));
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (int x = 0; x < column; x++){
			for (int y = 0; y < row; y++){
		batch.draw(sprite[x][y].texture,sprite[x][y].getX(),sprite[x][y].getY());
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
