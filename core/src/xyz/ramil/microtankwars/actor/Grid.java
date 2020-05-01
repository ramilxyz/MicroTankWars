package xyz.ramil.microtankwars.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Grid {

    private static final int WIDTH = 72;
    private static final int HEIGHT = 72;
    static float GRID_W = 440;
    static float GRID_H = 440;
    static float GRID_X = 240, GRID_Y = 15;
    public Vector2Color[] table = new Vector2Color[HEIGHT * WIDTH];
    private int[][] realMatrix = new int[WIDTH][HEIGHT];
    private Stage stage;
    private Color color = Color.CLEAR;
    private int click = 0;
    private Image grid;
    private Image mashka = new Image(new Texture("mashka.png"));
    private Texture texture;
    private Pixmap pixmap;
    private Sprite sprite;


    public Grid(Stage stage) {
        this.stage = stage;

        grid = new Image(new Texture("grid.png"));
        grid.setSize(440, 440);
        grid.setPosition(240, 15);
        grid.setColor(grid.getColor().r, grid.getColor().g, grid.getColor().b, 0.15f);
        stage.addActor(grid);


        mashka.setPosition(682, 25);

        mashka.setScale(0.4f);
        mashka.setColor(new Color(mashka.getColor().r, mashka.getColor().g, mashka.getColor().b, 0f));
        mashka.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                click++;
                if (click > 3) {
                    mashka.setColor(new Color(mashka.getColor().r, mashka.getColor().g, mashka.getColor().b, 1));
                    click = 0;
                }

                return super.touchDown(event, x, y, pointer, button);
            }
        });


        stage.addActor(mashka);

        pixmap = new Pixmap(WIDTH, HEIGHT, Pixmap.Format.RGBA8888);
        texture = new Texture(pixmap);

        sprite = new Sprite(texture);
        sprite.setSize(440, 440);
        sprite.setPosition(240, 15);

        pixmap.setColor(Color.CLEAR);
        pixmap.fill();

        initMatrix();

    }

    private void initMatrix() {
        int z = 0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                table[z] = new Vector2Color(i, j, color);
                realMatrix[i][j] = z++;
            }
        }
    }

    public void render(float v) {


        grid.setSize(440, 440);
        sprite.setSize(440, 440);
        grid.setPosition(240, 15);
        sprite.setPosition(240, 15);

        GRID_W = 440;
        GRID_H = 440;
        GRID_X = 240;
        GRID_Y = 15;

        for (Vector2Color vector2Color : table) {
            //   pixmap.setColor(new Color(200/255f, 200/255f, 200/255f, 1));
            pixmap.setColor(Color.BLACK);
            pixmap.drawPixel(vector2Color.y, vector2Color.x);
            pixmap.setColor(vector2Color.color);
            pixmap.drawPixel(vector2Color.y, vector2Color.x);
        }

        texture.draw(pixmap, 0, 0);

        stage.getBatch().begin();
        sprite.draw(stage.getBatch());
        stage.getBatch().end();

    }
}
