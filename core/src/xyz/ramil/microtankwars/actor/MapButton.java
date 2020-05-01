/*******************************************************************************
 * Copyright 2020 Abdrakhmanov R.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

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
