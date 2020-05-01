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

package xyz.ramil.microtankwars.ai;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import xyz.ramil.microtankwars.actor.Grid;
import xyz.ramil.microtankwars.actor.Tank;
import xyz.ramil.microtankwars.maps.Map;
import xyz.ramil.microtankwars.screen.GameScreen;

public class Lee {

    public static ArrayList<Integer> searchArray = new ArrayList<>();
    private static int[][] matrix = new int[72][72];
    private static int[][] realMatrix = new int[72][72];
    private static ArrayList<Integer> wayArray = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();
    private static ArrayList<Integer> lockElement = new ArrayList<>();
    private static int startPosX;
    private static int startPosY;
    private static Grid grid;

    public Lee(Grid grid) {
        wayArray.clear();
        searchArray.clear();
        lockElement.clear();
        set.addAll(GameScreen.lockElement);


        Lee.grid = grid;

        lockElement.addAll(set);

        Collections.sort(lockElement);

        for (int i = 0; i < GameScreen.ARRAY_SIZE; i++) {
            searchArray.add(i);
        }

        searchArray.removeAll(lockElement);


        initMatrix();

    }

    private static void initMatrix() {
        int z = 0;
        int k = 0;
        for (int i = 0; i < GameScreen.TABLE_ROW_SIZE; i++) {
            for (int j = 0; j < GameScreen.TABLE_ROW_SIZE; j++) {
                realMatrix[i][j] = z++;
            }
        }
    }

    public static ArrayList<Integer> wayArray(int centerPosition, Tank tank) {
        initLeeMatrix(centerPosition, tank);

        return wayArray;
    }

    private static void initLeeMatrix(int centerPosition, Tank tank) {

        int z = 0;
        int k = 0;
        for (int i = 0; i < GameScreen.TABLE_ROW_SIZE; i++) {
            for (int j = 0; j < GameScreen.TABLE_ROW_SIZE; j++) {
                matrix[i][j] = z++;
                if (centerPosition == matrix[i][j]) {

                    startPosX = j;
                    startPosY = i;

                }

                if (lockElement.get(k) == matrix[i][j]) {
                    matrix[i][j] = -1;
                    k++;
                } else {
                    matrix[i][j] = -2;
                }
            }
        }


        if (tank.getType().equals(GameScreen.COLORBLUE) || tank.getType().equals(GameScreen.RESPAWN_BLUE_COLOR)) {
            for (int i = 0; i < GameScreen.TABLE_ROW_SIZE; i++) {
                for (int j = 0; j < GameScreen.TABLE_ROW_SIZE; j++) {
                    if (realMatrix[i][j] == Map.RED_FLAG_POSITION) {
                        //    Gdx.app.log("Map.RED_FLAG_POSITION", "" + Map.RED_FLAG_POSITION);
                        //    grid.table[realMatrix[i + 2][j + 2]].setColor(Color.CYAN);

                        lee(startPosX, startPosY, j + 2, i + 2);
                    }
                }
            }
        }


        if (tank.getType().equals(GameScreen.COLORRED) || tank.getType().equals(GameScreen.RESPAWN_RED_COLOR)) {
            for (int i = 0; i < GameScreen.TABLE_ROW_SIZE; i++) {
                for (int j = 0; j < GameScreen.TABLE_ROW_SIZE; j++) {
                    if (realMatrix[i][j] == Map.BLUE_FLAG_POSITION) {
                        //   Gdx.app.log("Map.BLUE_FLAG_POSITION", "" + Map.BLUE_FLAG_POSITION);
                        //   grid.table[realMatrix[i + 2][j + 2]].setColor(Color.CYAN);
                        lee(startPosX, startPosY, j + 2, i + 2);
                    }
                }
            }
        }
    }

    private static boolean lee(int ax, int ay, int bx, int by) {
        wayArray.clear();
        int W = GameScreen.TABLE_ROW_SIZE;
        int H = GameScreen.TABLE_ROW_SIZE;
        int WALL = -1;
        int BLANK = -2;

        int[] px = new int[W * H];
        int[] py = new int[W * H];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int d, x, y, k;
        boolean stop;

        if (matrix[ay][ax] == WALL || matrix[by][bx] == WALL)
            return false;

        d = 0;
        matrix[ay][ax] = 0;
        do {
            stop = true;
            for (y = 0; y < H; ++y)
                for (x = 0; x < W; ++x)
                    if (matrix[y][x] == d) {
                        for (k = 0; k < 4; ++k) {
                            int iy = y + dy[k], ix = x + dx[k];
                            if (iy >= 0 && iy < H && ix >= 0 && ix < W &&
                                    matrix[iy][ix] == BLANK) {
                                stop = false;
                                matrix[iy][ix] = d + 1;
                            }
                        }
                    }
            d++;
        } while (!stop && matrix[by][bx] == BLANK);

        if (matrix[by][bx] == BLANK) return false;

        int len = matrix[by][bx];
        x = bx;
        y = by;
        d = len;
        while (d > 0) {
            px[d] = x;
            py[d] = y;

            try {
                wayArray.add(realMatrix[y][x]);
            } catch (Exception e) {
                Gdx.app.log("ERROR::LEE", "" + e.getMessage());
            }


            //   grid.table[realMatrix[y][x]].setColor(Color.CYAN);

            d--;
            for (k = 0; k < 4; ++k) {
                int iy = y + dy[k], ix = x + dx[k];
                if (iy >= 0 && iy < H && ix >= 0 && ix < W &&
                        matrix[iy][ix] == d) {
                    x = x + dx[k];
                    y = y + dy[k];
                    break;
                }
            }
        }

        return true;
    }

}
