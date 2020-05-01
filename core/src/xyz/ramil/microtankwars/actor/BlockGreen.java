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

import java.util.ArrayList;

public class BlockGreen {

    ArrayList<Integer> moveBuffer = new ArrayList<>();
    private Grid grid;
    private int position;
    private Color type;
    private boolean anim = true;
    private float animation_time = 0;

    public BlockGreen(Grid grid, int position, Color type) {
        this.grid = grid;
        this.position = position;
        this.type = type;
        initBlock();
    }

    private void initBlock() {
        for (int i = 0; i < 5; i++) {
            for (int j = position; j < position + 5; j++) {
                moveBuffer.add(j);
            }
            position = position + 72;
        }
    }

    private void initColorBlock(boolean anim) {

        for (int i = 0; i < moveBuffer.size(); i++) {
            grid.table[moveBuffer.get(i)].setColor(Color.CLEAR);

            if (i % 2 == 0) {
                if (!grid.table[moveBuffer.get(i)].getColor().equals(Color.BROWN))
                    if (anim)
                        grid.table[moveBuffer.get(i)].setColor(type);
            } else {

                if (!anim) {
                    grid.table[moveBuffer.get(i)].setColor(type);
                }
            }
        }

    }


    public void render(float v) {
        animation_time += v;
        if (animation_time < 1) {
            anim = false;
        } else if (animation_time < 2) {
            anim = true;
        } else if (animation_time > 2) {
            animation_time = 0;
        }
        initColorBlock(anim);
    }
}


