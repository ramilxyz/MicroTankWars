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

import xyz.ramil.microtankwars.screen.GameScreen;

public class BlockRock {
    private Grid grid;

    private int position;

    private boolean aCollis = false;
    private boolean eCollis = false;
    private boolean dCollis = false;
    private boolean mCollis = false;

    private Color type;

    private ArrayList<Integer> moveBuffer = new ArrayList<>();
    private ArrayList<Integer> collisionArrayList = new ArrayList<>();

    public BlockRock(Grid grid, int position, Color type) {
        this.grid = grid;
        this.position = position;
        this.type = type;
        initBlockCollision();
        initBlock();
    }

    private void initBlockCollision() {

        int xCollisionPosition = position;
        int xCollisionPositionS = position - 1 - 1;
        int collisionPositionA = position - 72 - 72 - 1 - 1;
        int collisionPositionB = position - 72 - 72;
        int collisionPositionC = position - 72 - 72 + 1 + 1 + 1 + 1;
        int collisionPositionD = position - 72 - 72 + 1 + 1 + 1 + 1 + 1 + 1;

        int collisionPositionE = collisionPositionA + 72 * 8;
        int collisionPositionF = collisionPositionB + 72 * 8;
        int collisionPositionG = collisionPositionC + 72 * 8;
        int collisionPositionM = collisionPositionD + 72 * 8;

        for (int i = 0; i < GameScreen.borderArray.size(); i++) {

            int ii = GameScreen.borderArray.get(i);

            if (collisionPositionA == ii) {
                aCollis = true;
            }
            if (collisionPositionE == ii) {
                eCollis = true;
            }
            if (collisionPositionD == ii) {
                dCollis = true;
            }
            if (collisionPositionM == ii) {
                mCollis = true;
            }
        }

        //        _____
        //        |0

        if (xCollisionPosition == 73) {
            for (int i = 0; i < 7; i++) {
                for (int j = xCollisionPosition; j < xCollisionPosition + 7; j++) {
                    collisionArrayList.add(j);
                }
                xCollisionPosition = xCollisionPosition + 72;
            }

        }
        //             |
        //             |0
        //             |
        else if (aCollis && eCollis && collisionPositionB > 0 && collisionPositionF > 0 && xCollisionPosition != 73 && xCollisionPosition != 4753 && xCollisionPosition != 4818 && xCollisionPosition != 138) {
            for (int i = 0; i < 9; i++) {
                for (int j = collisionPositionB; j < collisionPositionB + 7; j++) {
                    collisionArrayList.add(j);
                }
                collisionPositionB = collisionPositionB + 72;
            }

        }
        //         |0
        //         -----
        else if (xCollisionPosition == 4753) {

            for (int i = 0; i < 7; i++) {
                for (int j = collisionPositionB; j < collisionPositionB + 7; j++) {
                    collisionArrayList.add(j);
                }
                collisionPositionB = collisionPositionB + 72;
            }

        }
        //              0
        //         ------------
        else if (collisionPositionE > GameScreen.ARRAY_SIZE && collisionPositionM > GameScreen.ARRAY_SIZE && collisionPositionA > 0 && collisionPositionD > 0 & xCollisionPosition != 73 && xCollisionPosition != 4753 && xCollisionPosition != 4818 && xCollisionPosition != 138) {
            for (int i = 0; i < 7; i++) {
                for (int j = collisionPositionA; j < collisionPositionA + 9; j++) {
                    collisionArrayList.add(j);
                }
                collisionPositionA = collisionPositionA + 72;
            }

        }
        //               0|
        //          -------
        else if (xCollisionPosition == 4818) {
            for (int i = 0; i < 7; i++) {
                for (int j = collisionPositionA; j < collisionPositionA + 7; j++) {
                    collisionArrayList.add(j);
                }
                collisionPositionA = collisionPositionA + 72;
            }

        }
        //          |
        //         0|
        //          |
        else if (mCollis && dCollis & xCollisionPosition != 73 && xCollisionPosition != 4753 && xCollisionPosition != 4818 && xCollisionPosition != 138) {
            for (int i = 0; i < 9; i++) {
                for (int j = collisionPositionA; j < collisionPositionA + 7; j++) {
                    collisionArrayList.add(j);
                }
                collisionPositionA = collisionPositionA + 72;
            }

        }
        //         ________
        //                0|
        //                 |
        //                 |
        else if (xCollisionPosition == 138) {
            for (int i = 0; i < 7; i++) {
                for (int j = xCollisionPositionS; j < xCollisionPositionS + 7; j++) {
                    collisionArrayList.add(j);
                }
                xCollisionPositionS = xCollisionPositionS + 72;
            }

        }
        //        ___________
        //             0
        else if (collisionPositionA < 0 && collisionPositionD < 0 && collisionPositionE > 0 && collisionPositionM > 0) {
            for (int i = 0; i < 7; i++) {
                for (int j = xCollisionPositionS; j < xCollisionPositionS + 9; j++) {
                    collisionArrayList.add(j);
                }
                xCollisionPositionS = xCollisionPositionS + 72;
            }

        } else {

            for (int i = 0; i < 9; i++) {
                for (int j = collisionPositionA; j < collisionPositionA + 9; j++) {
                    collisionArrayList.add(j);
                }
                collisionPositionA = collisionPositionA + 72;
            }
        }
        GameScreen.lockElement.addAll(collisionArrayList);
    }

    private void initBlock() {

        for (int i = 0; i < 5; i++) {
            for (int j = position; j < position + 5; j++) {
                moveBuffer.add(j);
            }
            position = position + 72;
        }
    }

    private void initColorBlock() {
        for (int i = 0; i < moveBuffer.size(); i++) {
            if (!grid.table[moveBuffer.get(i)].getColor().equals(Color.BROWN))

                if (i % 2 == 0)
                    grid.table[moveBuffer.get(i)].setColor(type);
                else
                    grid.table[moveBuffer.get(i)].setColor(new Color(57 / 255f, 91 / 255f, 94 / 255f, 1));
        }
    }

    public void render(float v) {
        initColorBlock();
    }
}
