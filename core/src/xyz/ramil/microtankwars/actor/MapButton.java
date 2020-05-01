package xyz.ramil.microtankwars.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

import xyz.ramil.microtankwars.screen.GameScreen;


class MapButton extends Pixmap {

    private int[][] map;

    MapButton(int[][] map) {
        super(14, 14, Pixmap.Format.RGBA8888);
        this.map = map;
        this.setColor(Color.BLACK);
        this.fill();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {

                if (map[j][i] == 1) {
                    this.setColor(Color.DARK_GRAY);
                    this.drawPixel(i, j);

                }

                if (map[j][i] == 2) {
                    this.setColor(Color.BROWN);
                    this.drawPixel(i, j);

                }

                if (map[j][i] == 3) {
                    this.setColor(Color.CYAN);
                    this.drawPixel(i, j);

                }

                if (map[j][i] == 4) {
                    this.setColor(Color.GREEN);
                    this.drawPixel(i, j);

                }


                if (map[j][i] == 50 || map[j][i] == 60 || map[j][i] == 70 || map[j][i] == 80 || map[j][i] == 100) {
                    this.setColor(GameScreen.COLORRED);
                    this.drawPixel(i, j);
                }

                if (map[j][i] == 10 || map[j][i] == 20 || map[j][i] == 30 || map[j][i] == 40 || map[j][i] == 200) {
                    this.setColor(GameScreen.COLORBLUE);
                    this.drawPixel(i, j);
                }


            }
        }


    }

}
