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

import java.util.ArrayList;

import xyz.ramil.microtankwars.screen.GameScreen;

public class BlockRespawn {
    Grid grid;
    int position;

    float ping;
    String direction;

    ArrayList<Integer> moveBuffer = new ArrayList<>();

    public BlockRespawn(Grid gird, int position, String direction) {
        this.grid = gird;
        this.position = position;
        this.direction = direction;

        initBlock();
    }

    private void initBlock() {

        for (int i = 0; i < 5; i++) {
            for (int j = position; j < position + 5; j++) {
                moveBuffer.add(j);
            }
            position = position + 72;
        }
        initColorBlock();
    }

    private void initColorBlock() {
        for (int i = 0; i < moveBuffer.size(); i++) {

            if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 9 && i != 14 && i != 19 && i != 24 && i != 23 && i != 22 && i != 21 && i != 20 && i != 15 && i != 10 && i != 5) {
                if (direction.equals("down") || direction.equals("upb")) {

                    if (i != 1 && i != 6 && i != 11 && i != 16 && i != 21 &&
                            i != 3 && i != 8 && i != 13 && i != 18 && i != 23)
                        grid.table[moveBuffer.get(i)].setColor(GameScreen.RESPAWN_BLOCK_COLOR1);
                    else
                        grid.table[moveBuffer.get(i)].setColor(GameScreen.RESPAWN_BLOCK_COLOR0);
                }

                if (direction.equals("left") || direction.equals("right")) {
                    if (i != 5 && i != 6 && i != 7 && i != 8 && i != 9 &&
                            i != 15 && i != 16 && i != 17 && i != 18 && i != 19)
                        grid.table[moveBuffer.get(i)].setColor(GameScreen.RESPAWN_BLOCK_COLOR1);
                    else
                        grid.table[moveBuffer.get(i)].setColor(GameScreen.RESPAWN_BLOCK_COLOR0);
                }
            }
        }
    }

    public void render(float v) {


        initColorBlock();


    }
}
