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

package xyz.ramil.microtankwars.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.ArrayList;

import xyz.ramil.microtankwars.MicroTankWarsGame;
import xyz.ramil.microtankwars.actor.Grid;
import xyz.ramil.microtankwars.actor.Menu;
import xyz.ramil.microtankwars.actor.Tank;
import xyz.ramil.microtankwars.maps.Map;
import xyz.ramil.microtankwars.usercontrol.Control;

public class GameScreen implements Screen {

    public static final int ARRAY_SIZE = 5184; // TABLE_ROW_SIZExTABLE_ROW_SIZE
    public static final int TABLE_ROW_SIZE = 72;
    public static Control userControl;
    public static int TEAM_TYPE = -1;
    public static int red = 0;
    public static int blue = 0;
    public static int WIN_SCORE = 20;
    public static boolean GAMEOVER = false;
    public static boolean OPENMENU = false;

    public static boolean ROUND_ONE = false;
    public static boolean ROUND_TWO = false;
    public static boolean ROUND_THREE = false;

    public static boolean CLOSE_VICTORY = false;

    public static boolean ROUND_SCORE_LABEL = false;

    public static ArrayList<Integer> borderArray = new ArrayList<>();
    public static ArrayList<Integer> lockElement = new ArrayList<>();
    public static ArrayList<Integer> border = new ArrayList<>();

    public static boolean FIRST_START = true;

    public static Color RESPAWN_BLOCK_COLOR0 = new Color(30 / 255f, 30 / 255f, 30 / 255f, 0.5f);
    public static Color RESPAWN_BLOCK_COLOR1 = new Color(80f / 255f, 80 / 255f, 80 / 255f, 0.5f);
    public static Color WOOD_COLOR = new Color(69 / 255f, 42 / 255f, 11 / 255f, 1);
    public static Color ICE_COLOR = new Color(58 / 255f, 115 / 255f, 240 / 255f, 1);
    public static Color BUSH_COLOR = new Color(20 / 255f, 107 / 255f, 23 / 255f, 1f);

    //   public static Color BRICK_COLOR = new Color(57/255f, 91/255f, 94/255f, 1);

    public static Color BRICK_COLOR = Color.GRAY;

    public static Color FLAG_BLUE = new Color(20 / 255f, 50 / 255f, 200 / 255f, 1f);
    public static Color FLAG_RED = new Color(200 / 255f, 0, 0f, 0.8f);

    public static Color FLAG_GREY = new Color(170 / 255f, 170 / 255f, 170 / 255f, 1f);
    public static Color FIELD_COLOR = new Color(24 / 255f, 158 / 255f, 33 / 255f, 1f);

    public static Color USER_TANK_COLOR_RED = new Color(230 / 255f, 100 / 255f, 45 / 255f, 1f);
    public static Color RESPAWN_USER_RED_COLOR = new Color(230 / 255f, 100 / 255f, 45 / 255f, 0.5f);


    public static Color USER_TANK_COLOR_BLUE = new Color(130 / 255f, 130 / 255f, 230 / 255f, 1f);
    public static Color RESPAWN_USER_BLUE_COLOR = new Color(130 / 255f, 130 / 255f, 230 / 255f, 0.5f);


    public static Color RESPAWN_BLUE_COLOR = new Color(74 / 255f, 65 / 255f, 209 / 255f, 0.5f);
    public static Color COLORBLUE = new Color(74 / 255f, 65 / 255f, 209 / 255f, 1);

    public static Color RESPAWN_RED_COLOR = new Color(169 / 255f, 20 / 255f, 20 / 255f, 0.5f);
    public static Color COLORRED = new Color(169 / 255f, 20 / 255f, 20 / 255f, 1);

    public static int RED_SCORE = 0;
    public static int BLUE_SCORE = 0;

    public static int HIGHSCORE = 0;

    public static boolean SELECT_MAP = false;
    public static int[][] MAP_ONE =
            {{0, 0, 0, 0, 2, 1, 1, 1, 1, 80, 0, 0, 0, 2,},
                    {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0,},
                    {0, 40, 1, 1, 4, 4, 2, 2, 1, 4, 4, 2, 70, 0,},
                    {0, 1, 1, 0, 0, 0, 0, 0, 4, 4, 4, 2, 2, 0,},
                    {0, 0, 0, 0, 0, 10, 1, 1, 1, 4, 4, 4, 0, 0,},
                    {0, 2, 1, 1, 4, 1, 0, 0, 0, 0, 1, 1, 2, 0,},
                    {0, 0, 200, 1, 4, 1, 0, 1, 0, 0, 1, 100, 0, 0,},
                    {0, 2, 1, 1, 4, 4, 4, 1, 0, 0, 1, 1, 2, 0,},
                    {0, 0, 0, 0, 4, 4, 4, 1, 60, 0, 0, 0, 0, 0,},
                    {0, 2, 2, 0, 4, 4, 4, 1, 1, 1, 1, 4, 4, 0,},
                    {0, 30, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 2, 4, 4, 1, 2, 2, 4, 4, 1, 1, 2, 0,},
                    {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 1, 50, 0,},
                    {2, 0, 0, 0, 20, 1, 1, 1, 1, 0, 0, 0, 0, 0,}};
    public static int[][]
            MAP_TWO = {{0, 0, 0, 0, 0, 0, 70, 1, 0, 0, 0, 0, 0, 0,},
            {0, 100, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 60, 0,},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0,},
            {80, 1, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 50,},
            {1, 1, 4, 0, 0, 2, 4, 4, 2, 0, 0, 4, 1, 1,},
            {1, 1, 4, 0, 0, 2, 4, 4, 2, 0, 0, 4, 1, 1,},
            {10, 1, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 40,},
            {0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0,},
            {0, 20, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 200, 0,},
            {0, 0, 0, 0, 0, 0, 1, 30, 0, 0, 0, 0, 0, 0,}};
    public static int[][] MAP_THREE =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 1, 100, 1, 0, 0, 0, 0, 0, 70, 1, 80, 1, 0,},
                    {4, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0,},
                    {2, 1, 60, 1, 0, 1, 0, 0, 0, 0, 1, 50, 1, 0,},
                    {0, 0, 0, 0, 4, 1, 0, 0, 1, 0, 0, 0, 0, 0,},
                    {0, 2, 2, 2, 0, 0, 2, 2, 0, 0, 2, 0, 0, 0,},
                    {4, 1, 1, 1, 0, 4, 4, 4, 0, 4, 1, 0, 1, 0,},
                    {0, 1, 0, 1, 4, 4, 0, 4, 4, 4, 1, 1, 1, 4,},
                    {0, 0, 0, 2, 0, 0, 2, 2, 0, 0, 2, 2, 2, 0,},
                    {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0,},
                    {0, 1, 20, 1, 0, 0, 0, 0, 1, 0, 1, 40, 1, 2,},
                    {0, 0, 1, 1, 1, 1, 0, 0, 1, 4, 0, 1, 0, 4,},
                    {0, 1, 10, 1, 30, 0, 0, 0, 0, 0, 1, 200, 1, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};
    public static int[][] MAP_FOUR =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 1, 60, 1, 0, 2, 2, 2, 2, 0, 1, 100, 1, 0,},
                    {0, 50, 1, 70, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0,},
                    {0, 1, 1, 1, 4, 4, 1, 1, 80, 0, 0, 0, 0, 0,},
                    {0, 0, 4, 0, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2,},
                    {0, 0, 4, 4, 4, 4, 1, 1, 1, 1, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 1, 1, 1, 1, 4, 4, 4, 4, 0, 0,},
                    {2, 2, 2, 0, 0, 1, 1, 1, 0, 0, 0, 4, 0, 0,},
                    {0, 0, 0, 0, 0, 10, 1, 1, 4, 4, 1, 1, 1, 0,},
                    {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 20, 1, 40, 0,},
                    {0, 1, 200, 1, 0, 2, 2, 2, 2, 0, 1, 30, 1, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};
    public static int[][] MAP_FIVE =
            {{2, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {70, 2, 2, 2, 2, 2, 0, 2, 0, 1, 0, 0, 0, 0,},
                    {0, 2, 0, 0, 0, 0, 0, 4, 0, 1, 100, 0, 0, 0,},
                    {0, 2, 0, 60, 0, 1, 0, 4, 50, 1, 1, 1, 1, 0,},
                    {0, 2, 0, 1, 0, 1, 0, 4, 1, 0, 0, 0, 0, 0,},
                    {0, 4, 0, 0, 0, 1, 0, 4, 4, 4, 4, 4, 0, 0,},
                    {2, 4, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 4, 2,},
                    {0, 0, 4, 4, 4, 4, 4, 0, 1, 0, 0, 0, 4, 0,},
                    {0, 0, 0, 0, 0, 1, 4, 0, 1, 0, 1, 0, 2, 0,},
                    {0, 1, 1, 1, 1, 10, 4, 0, 1, 0, 20, 0, 2, 0,},
                    {0, 0, 0, 200, 1, 0, 4, 0, 0, 0, 0, 0, 2, 0,},
                    {0, 0, 0, 0, 1, 0, 2, 0, 2, 2, 2, 2, 2, 30,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 2,}};

    public static int[][] MAP_SIX =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 2, 2, 0,},
                    {0, 0, 2, 0, 0, 1, 0, 0, 4, 4, 0, 2, 0, 0,},
                    {0, 0, 2, 0, 0, 1, 0, 0, 4, 4, 0, 2, 0, 0,},
                    {0, 10, 2, 0, 0, 0, 0, 0, 1, 60, 0, 2, 0, 0,},
                    {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,},
                    {0, 0, 1, 20, 0, 1, 4, 4, 50, 0, 0, 1, 100, 0,},
                    {0, 200, 1, 0, 0, 30, 4, 4, 1, 0, 70, 1, 0, 0,},
                    {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0,},
                    {0, 0, 2, 0, 40, 1, 0, 0, 0, 0, 0, 2, 80, 0,},
                    {0, 0, 2, 0, 4, 4, 0, 0, 1, 0, 0, 2, 0, 0,},
                    {0, 0, 2, 0, 4, 4, 0, 0, 1, 0, 0, 2, 0, 0,},
                    {0, 2, 2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};

    public static int[][] MAP_SEVEN =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0,},
                    {0, 2, 10, 0, 0, 0, 1, 4, 1, 0, 0, 80, 2, 0,},
                    {0, 4, 1, 0, 0, 1, 4, 1, 50, 0, 0, 1, 4, 0,},
                    {0, 0, 30, 2, 0, 20, 1, 4, 1, 0, 2, 60, 0, 0,},
                    {0, 0, 0, 4, 0, 1, 1, 4, 0, 0, 4, 0, 0, 0,},
                    {0, 2, 0, 0, 0, 200, 1, 1, 1, 0, 0, 0, 2, 0,},
                    {0, 4, 0, 0, 0, 1, 1, 1, 100, 0, 0, 0, 4, 0,},
                    {0, 0, 0, 2, 0, 40, 4, 1, 1, 0, 2, 0, 0, 0,},
                    {0, 0, 0, 4, 0, 0, 1, 4, 1, 0, 4, 0, 0, 0,},
                    {0, 2, 1, 0, 0, 0, 4, 1, 70, 0, 0, 1, 2, 0,},
                    {0, 4, 0, 0, 0, 0, 1, 4, 0, 0, 0, 0, 4, 0,},
                    {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};

    public static int[][] MAP_EIGHT =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 2, 60, 0, 0, 1, 100, 1, 0, 0, 0, 0, 0,},
                    {0, 0, 2, 2, 0, 0, 70, 1, 0, 0, 2, 2, 0, 0,},
                    {0, 0, 2, 2, 50, 0, 0, 2, 0, 80, 2, 2, 0, 0,},
                    {0, 0, 0, 0, 1, 1, 4, 4, 1, 1, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 1, 4, 4, 4, 4, 1, 0, 0, 0, 0,},
                    {1, 1, 0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 1, 1,},
                    {1, 1, 0, 0, 4, 4, 0, 0, 4, 4, 0, 0, 1, 1,},
                    {0, 0, 0, 0, 1, 4, 4, 4, 4, 1, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 1, 1, 4, 4, 1, 1, 0, 0, 0, 0,},
                    {0, 0, 2, 2, 10, 0, 2, 0, 20, 0, 2, 2, 0, 0,},
                    {0, 0, 2, 2, 0, 0, 1, 30, 0, 0, 2, 2, 0, 0,},
                    {0, 0, 0, 0, 0, 1, 200, 1, 0, 0, 40, 2, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};


    public static int[][] MAP_NINE =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 1, 1, 0, 4, 4, 4, 4, 4, 1, 100, 0, 0,},
                    {0, 0, 1, 1, 50, 0, 0, 0, 0, 0, 1, 1, 0, 0,},
                    {0, 0, 0, 10, 1, 1, 0, 0, 0, 0, 0, 4, 0, 0,},
                    {0, 0, 4, 0, 1, 1, 60, 0, 0, 0, 0, 4, 2, 2,},
                    {2, 2, 4, 0, 0, 20, 1, 1, 0, 0, 0, 4, 2, 2,},
                    {2, 2, 4, 0, 0, 0, 1, 1, 70, 0, 0, 4, 2, 2,},
                    {2, 2, 4, 0, 0, 0, 0, 30, 1, 1, 0, 4, 0, 0,},
                    {0, 0, 4, 0, 0, 0, 0, 0, 1, 1, 80, 0, 0, 0,},
                    {0, 0, 1, 1, 0, 0, 0, 0, 0, 40, 1, 1, 0, 0,},
                    {0, 0, 200, 1, 4, 4, 4, 4, 4, 0, 1, 1, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}};


    public static int[][] MAP_TEN =
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,},
                    {0, 1, 70, 0, 0, 0, 0, 0, 0, 0, 1, 60, 0, 0,},
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0,},
                    {0, 1, 1, 1, 0, 1, 100, 0, 1, 0, 0, 1, 1, 0,},
                    {0, 1, 80, 0, 0, 2, 1, 0, 1, 0, 1, 50, 0, 0,},
                    {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0,},
                    {4, 4, 4, 2, 2, 2, 2, 1, 1, 2, 2, 4, 4, 4,},
                    {4, 4, 4, 2, 2, 2, 2, 1, 1, 2, 2, 4, 4, 4,},
                    {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 1, 10, 0, 0, 2, 1, 0, 1, 0, 1, 30, 0, 0,},
                    {0, 1, 1, 1, 0, 1, 200, 0, 1, 0, 0, 1, 1, 0,},
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0,},
                    {0, 1, 20, 0, 0, 0, 0, 0, 0, 0, 1, 40, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,}};


    public static int[][] MAP_ELEVEN =
            {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                    {0, 0, 50, 2, 4, 4, 0, 4, 4, 2, 60, 0, 0, 0,},
                    {0, 0, 2, 2, 4, 4, 0, 4, 4, 2, 2, 0, 0, 0,},
                    {0, 0, 0, 1, 80, 0, 0, 0, 70, 1, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 1, 0, 100, 0, 1, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 0, 1, 0, 200, 0, 1, 0, 0, 0, 0, 0,},
                    {0, 0, 0, 1, 10, 0, 0, 0, 20, 1, 0, 0, 0, 0,},
                    {0, 0, 2, 2, 4, 4, 0, 4, 4, 2, 2, 0, 0, 0,},
                    {0, 0, 30, 2, 4, 4, 0, 4, 4, 2, 40, 0, 0, 0,},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                    {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,}};


    public static int[][] MAP_TWELVE =
            {{0, 0, 0, 0, 60, 1, 0, 0, 1, 70, 0, 0, 0, 0,},
                    {0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0,},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,},
                    {0, 1, 0, 50, 1, 0, 4, 4, 4, 0, 1, 100, 1, 0,},
                    {0, 1, 0, 1, 1, 0, 4, 4, 4, 0, 1, 1, 1, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 2, 0, 2, 2, 2, 80, 2, 2, 2, 0, 2, 2, 0,},
                    {0, 2, 2, 2, 0, 2, 2, 2, 20, 2, 2, 2, 0, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                    {0, 1, 1, 1, 0, 4, 4, 4, 0, 1, 1, 0, 1, 0,},
                    {0, 1, 200, 1, 0, 4, 4, 4, 0, 1, 10, 0, 1, 0,},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,},
                    {0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0,},
                    {0, 0, 0, 0, 40, 1, 0, 0, 1, 30, 0, 0, 0, 0,}};


    public static int[][] MAP = null;
    public static Label labelGold;
    public static Label roundOneBlueLabel;
    public static Label roundOneRedLabel;
    public static Label roundTwoBlueLabel;
    public static Label roundTwoRedLabel;
    public static Label roundThreeBlueLabel;
    public static Label roundThreeRedLabel;

    public static Label numberoftanksdestroyedText;

    public static Label numberoftanksdestroyed;

    public static Label numberofflagsdestroyedText;

    public static Label numberofflagsdestroyed;

    public static float tvictory = 0;
    private static Map map;
    float t = 0;
    float loadingAnimation_t;
    Menu menu;
    private boolean round = false;
    private Game game;
    private GameScreen gameScreen;
    private AssetManager manager = new AssetManager();
    private Stage stage;
    private Tank tank = null;
    private Label.LabelStyle labelStyleBlueBig;
    private Label.LabelStyle labelStyleRedBig;
    private Label.LabelStyle labelStyleGoldBig;
    private Label.LabelStyle labelStyleBlue;
    private Label.LabelStyle labelStyleRed;
    private Label.LabelStyle labelStyleGold;


    private Grid grid;
    private Label labelBlueVictory;
    private Label labelRedVictory;
    private Label labelTie;
    private float victory_t;
    private Label labelBlue;
    private Label labelRed;


    public GameScreen(Game game, Stage stage) {
        this.game = game;
        gameScreen = this;
        this.stage = stage;
        userControl = new Control(stage, tank);

        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchKey(Input.Keys.BACK, true);
        initActor();
    }

    private void initActor() {

        grid = new Grid(stage);

        BitmapFont font = new BitmapFont();
        font.getData().setScale(1.6f);

        BitmapFont fontBig = new BitmapFont();
        fontBig.getData().setScale(7f);

        labelStyleBlueBig = new Label.LabelStyle(fontBig, GameScreen.COLORBLUE);
        labelStyleRedBig = new Label.LabelStyle(fontBig, GameScreen.COLORRED);
        labelStyleGoldBig = new Label.LabelStyle(fontBig, Color.GOLD);


        labelStyleBlue = new Label.LabelStyle(font, GameScreen.COLORBLUE);
        labelStyleRed = new Label.LabelStyle(font, GameScreen.COLORRED);
        labelStyleGold = new Label.LabelStyle(font, Color.GOLD);

        creatWorld();
    }

    private void creatWorld() {


        labelBlueVictory = new Label("victory", labelStyleBlueBig);
        labelBlueVictory.setName("label");
        labelBlueVictory.setPosition(312, 180);
        labelBlueVictory.setVisible(false);
        stage.addActor(labelBlueVictory);


        labelRedVictory = new Label("victory", labelStyleRedBig);
        labelRedVictory.setName("label");
        labelRedVictory.setPosition(312, 180);
        labelRedVictory.setVisible(false);
        stage.addActor(labelRedVictory);

        labelTie = new Label("   Tie", labelStyleGoldBig);
        labelTie.setName("label");
        labelTie.setPosition(312, 180);
        labelTie.setVisible(false);
        stage.addActor(labelTie);

        labelBlue = new Label("", labelStyleBlue);
        labelBlue.setName("label");
        labelBlue.setPosition(245, 468);
        stage.addActor(labelBlue);

        labelRed = new Label("", labelStyleRed);
        labelRed.setName("label");
        labelRed.setPosition(663, 468);
        stage.addActor(labelRed);

        labelGold = new Label("", labelStyleGold);
        labelGold.setName("label");
        labelGold.setPosition(380, 468);
        stage.addActor(labelGold);

        //----------------------One------------------------------

        Label roundOneLabel = new Label("1.", labelStyleGold);
        roundOneLabel.setName("label");
        roundOneLabel.setPosition(690, 420);

        roundOneBlueLabel = new Label(" --", labelStyleBlue);
        roundOneBlueLabel.setName("label");
        roundOneBlueLabel.setPosition(710, 420);

        Label roundOneLabelDiff = new Label("/", labelStyleGold);
        roundOneLabelDiff.setName("label");
        roundOneLabelDiff.setPosition(745, 420);

        roundOneRedLabel = new Label(" --", labelStyleRed);
        roundOneRedLabel.setName("label");
        roundOneRedLabel.setPosition(760, 420);

        stage.addActor(roundOneLabel);
        stage.addActor(roundOneRedLabel);
        stage.addActor(roundOneBlueLabel);
        stage.addActor(roundOneLabelDiff);

        //----------------------Two------------------------------

        Label roundTwoLabel = new Label("2.", labelStyleGold);
        roundTwoLabel.setName("label");
        roundTwoLabel.setPosition(690, 390);

        roundTwoBlueLabel = new Label(" --", labelStyleBlue);
        roundTwoBlueLabel.setName("label");
        roundTwoBlueLabel.setPosition(710, 390);

        Label roundTwoLabelDiff = new Label("/", labelStyleGold);
        roundTwoLabelDiff.setName("label");
        roundTwoLabelDiff.setPosition(745, 390);

        roundTwoRedLabel = new Label(" --", labelStyleRed);
        roundTwoRedLabel.setName("label");
        roundTwoRedLabel.setPosition(760, 390);

        stage.addActor(roundTwoLabel);
        stage.addActor(roundTwoRedLabel);
        stage.addActor(roundTwoBlueLabel);
        stage.addActor(roundTwoLabelDiff);

        //----------------------Three------------------------------

        Label roundThreeLabel = new Label("3.", labelStyleGold);
        roundThreeLabel.setName("label");
        roundThreeLabel.setPosition(690, 360);

        roundThreeBlueLabel = new Label(" --", labelStyleBlue);
        roundThreeBlueLabel.setName("label");
        roundThreeBlueLabel.setPosition(710, 360);

        Label roundThreeLabelDiff = new Label("/", labelStyleGold);
        roundThreeLabelDiff.setName("label");
        roundThreeLabelDiff.setPosition(745, 360);

        roundThreeRedLabel = new Label(" --", labelStyleRed);
        roundThreeRedLabel.setName("label");
        roundThreeRedLabel.setPosition(760, 360);

        numberoftanksdestroyedText = new Label(" Tanks destroyed ", labelStyleGold);
        numberoftanksdestroyedText.setName("label");
        numberoftanksdestroyedText.setPosition(30, 115);
        stage.addActor(numberoftanksdestroyedText);

        numberoftanksdestroyed = new Label(" --", labelStyleGold);
        numberoftanksdestroyed.setName("label");
        numberoftanksdestroyed.setPosition(110, 85);
        stage.addActor(numberoftanksdestroyed);

        numberofflagsdestroyedText = new Label(" Flags destroyed ", labelStyleGold);
        numberofflagsdestroyedText.setName("label");
        numberofflagsdestroyedText.setPosition(30, 55);
        stage.addActor(numberofflagsdestroyedText);

        numberofflagsdestroyed = new Label(" --", labelStyleGold);
        numberofflagsdestroyed.setName("label");
        numberofflagsdestroyed.setPosition(110, 25);
        stage.addActor(numberofflagsdestroyed);


        stage.addActor(roundThreeLabel);
        stage.addActor(roundThreeRedLabel);
        stage.addActor(roundThreeBlueLabel);
        stage.addActor(roundThreeLabelDiff);


        int horizontalPointCount = 0;

        for (int i = 0; i < ARRAY_SIZE; i++) {

            horizontalPointCount++;


            if (i <= TABLE_ROW_SIZE) {
                borderArray.add(i);
                border.add(i);
            }

            if (i <= TABLE_ROW_SIZE * 3) {
                lockElement.add(i);
            }

            if (i > ARRAY_SIZE - TABLE_ROW_SIZE) {
                border.add(i);
            }

            if (i > ARRAY_SIZE - TABLE_ROW_SIZE * 3) {
                lockElement.add(i);
            }

            if (horizontalPointCount == TABLE_ROW_SIZE) {

                lockElement.add(i);
                lockElement.add(i - 1);
                lockElement.add(i - 2);
                lockElement.add(i - 71);
                lockElement.add(i - 70);
                lockElement.add(i - 69);
                border.add(i);
                border.add(i - 71);
                horizontalPointCount = 0;
            }
        }

        start();

        menu = new Menu(this, stage);
        stage.addActor(menu);

    }

    private void initColorBorderLock() {
        for (int i = 0; i < border.size(); i++) {
            grid.table[border.get(i)].setColor(GameScreen.BRICK_COLOR);

        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {


        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {

            if (GameScreen.MAP != null && GameScreen.TEAM_TYPE == -1) {
                GameScreen.MAP = null;
                GameScreen.labelGold.setText("");
            }

            if (!GameScreen.SELECT_MAP) {

                GameScreen.OPENMENU = !GameScreen.OPENMENU;

            } else {
                GameScreen.SELECT_MAP = false;
                GameScreen.labelGold.setText("");
            }

            if (!GameScreen.GAMEOVER && GameScreen.MAP != null) {
                GameScreen.labelGold.setText("        Pause");
            }
        }

        t += v;

        if (t < 0.1) {
            RESPAWN_USER_RED_COLOR = new Color(230 / 255f, 100 / 255f, 45 / 255f, 0.5f);
            RESPAWN_USER_BLUE_COLOR = new Color(130 / 255f, 130 / 255f, 230 / 255f, 0.5f);

        }
        if (t > 0.1) {
            RESPAWN_USER_RED_COLOR = new Color(230 / 255f, 100 / 255f, 45 / 255f, 1f);
            RESPAWN_USER_BLUE_COLOR = new Color(130 / 255f, 130 / 255f, 230 / 255f, 1f);
        }

        if (t > 0.2) {
            t = 0;
        }

        Gdx.gl.glClearColor(42 / 255f, 115 / 255f, 67 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        userControl.render();

        menu.render(v);

        initColorBorderLock();

        if (map != null) {
            if (!GAMEOVER && !OPENMENU) {
                map.mapRender(v);
                menu.setVisible(false);
                victory_t = 0;

                if (!GameScreen.GAMEOVER)
                    if (!ROUND_ONE && !ROUND_TWO && !ROUND_THREE) {
                        labelGold.setText("      Round 1");
                    } else if (ROUND_ONE && !ROUND_TWO && !ROUND_THREE) {
                        labelGold.setText("      Round 2");
                    } else if (ROUND_ONE && ROUND_TWO && !ROUND_THREE) {
                        labelGold.setText("      Round 3");
                    }

            } else {

                if (!round && red >= WIN_SCORE || !round && blue >= WIN_SCORE) {

                    if (!ROUND_ONE && !ROUND_TWO && !ROUND_THREE) {
                        ROUND_ONE = true;
                    } else if (ROUND_ONE && !ROUND_TWO && !ROUND_THREE) {
                        ROUND_TWO = true;
                    } else if (ROUND_ONE && ROUND_TWO && !ROUND_THREE) {
                        ROUND_THREE = true;
                    }

                    round = true;
                }


                if (victory_t < 2) {
                    victory_t += v;
                    if (red >= WIN_SCORE && red > blue) {
                        labelRedVictory.setVisible(true);
                        labelRedVictory.setColor(new Color(labelRedVictory.getColor().r, labelRedVictory.getColor().g, labelRedVictory.getColor().b, 1 - t * 1.5f));
                    } else {
                        labelRedVictory.setVisible(false);
                    }
                    if (blue >= WIN_SCORE && red < blue) {
                        labelBlueVictory.setVisible(true);
                        labelBlueVictory.setColor(new Color(labelBlueVictory.getColor().r, labelBlueVictory.getColor().g, labelBlueVictory.getColor().b, 1 - t * 1.5f));
                    } else {
                        labelBlueVictory.setVisible(false);
                    }

                    if (blue >= WIN_SCORE && red >= WIN_SCORE) {
                        if (blue == red) {
                            labelRedVictory.setVisible(false);
                            labelBlueVictory.setVisible(false);
                            labelTie.setVisible(true);
                            labelTie.setColor(new Color(labelTie.getColor().r, labelTie.getColor().g, labelTie.getColor().b, 1 - t * 1.5f));
                        }
                    } else {
                        labelTie.setVisible(false);
                    }


                } else {

                    labelRedVictory.setVisible(false);
                    labelBlueVictory.setVisible(false);
                    labelTie.setVisible(false);

                }

                if (!OPENMENU) {
                    if (!(labelBlueVictory.isVisible() || labelRedVictory.isVisible() || labelTie.isVisible())) {
                        menu.setVisible(true);
                        menu.setVisibleButton(true);
                        if (GameScreen.ROUND_ONE && !GameScreen.ROUND_TWO && !GameScreen.ROUND_THREE) {
                            roundOneRedLabel.setText("" + red);
                            roundOneBlueLabel.setText("" + blue);
                            BLUE_SCORE = BLUE_SCORE + blue;
                            RED_SCORE = RED_SCORE + red;

                            start();
                        }
                        if (GameScreen.ROUND_ONE && GameScreen.ROUND_TWO && !GameScreen.ROUND_THREE) {
                            roundTwoRedLabel.setText("" + red);
                            roundTwoBlueLabel.setText("" + blue);
                            BLUE_SCORE = BLUE_SCORE + blue;
                            RED_SCORE = RED_SCORE + red;
                            start();
                        }
                        if (GameScreen.ROUND_ONE && GameScreen.ROUND_TWO && GameScreen.ROUND_THREE) {
                            roundThreeRedLabel.setText("" + red);
                            roundThreeBlueLabel.setText("" + blue);


                            menu.setVisible(true);
                            menu.setVisibleButton(true);
                            labelGold.setText("");
                            GameScreen.GAMEOVER = true;
                            menu.initVictory();

                            if (tvictory > 20) {
                                GameScreen.ROUND_ONE = false;
                                GameScreen.ROUND_TWO = false;
                                GameScreen.ROUND_THREE = false;

                                GameScreen.roundOneBlueLabel.setText("--");
                                GameScreen.roundOneRedLabel.setText("--");
                                GameScreen.roundTwoBlueLabel.setText("--");
                                GameScreen.roundTwoRedLabel.setText("--");
                                GameScreen.roundThreeBlueLabel.setText("--");
                                GameScreen.roundThreeRedLabel.setText("--");

                                red = 0;
                                blue = 0;
                                menu.disposeVictory();
                            } else {
                                menu.setVisibleButton(false);

                                if (tvictory < 20)
                                    tvictory += v;
                            }

                        }
                    }
                } else {
                    menu.setVisibleButton(true);
                    menu.setVisible(true);
                }
            }
        } else {
            if (GameScreen.TEAM_TYPE != -1 && !GameScreen.SELECT_MAP) {
                menu.setVisibleButton(false);
                loadingAnimation_t += v;
                if (loadingAnimation_t < 0.05)
                    labelGold.setText("     Loading");
                if (loadingAnimation_t > 0.1)
                    labelGold.setText("     Loading...");
                if (loadingAnimation_t > 0.15)
                    loadingAnimation_t = 0;
            }
        }
        if (GameScreen.TEAM_TYPE != -1 && FIRST_START) {

            start();
            Gdx.app.log("START", "!");
            FIRST_START = false;
        }
        grid.render(v);

        labelBlue.setText("" + blue);
        labelRed.setText("" + red);

        if (red > 9) {
            labelRed.setPosition(663 - 12, 468);
        }

        if (CLOSE_VICTORY) {
            if (GameScreen.ROUND_ONE && GameScreen.ROUND_TWO && GameScreen.ROUND_THREE) {
                tvictory = 21;

                GameScreen.ROUND_ONE = false;
                GameScreen.ROUND_TWO = false;
                GameScreen.ROUND_THREE = false;

                GameScreen.roundOneBlueLabel.setText("--");
                GameScreen.roundOneRedLabel.setText("--");
                GameScreen.roundTwoBlueLabel.setText("--");
                GameScreen.roundTwoRedLabel.setText("--");
                GameScreen.roundThreeBlueLabel.setText("--");
                GameScreen.roundThreeRedLabel.setText("--");
                Gdx.app.log("ADS", "SHOW+");

                red = 0;
                blue = 0;

//                if(playServices.)

//                playServices.submitScore(MicroTankWarsGame.preferences.getInteger("highscore"));

                menu.disposeVictory();

            }
            CLOSE_VICTORY = false;
        }

        if (GameScreen.GAMEOVER || GameScreen.MAP == null) {
            labelRed.setVisible(false);
            labelBlue.setVisible(false);
        } else {
            labelRed.setVisible(true);
            labelBlue.setVisible(true);
        }

        numberoftanksdestroyed.setText(MicroTankWarsGame.preferences.getInteger("numberoftanksdestroyed"));

        numberofflagsdestroyed.setText(MicroTankWarsGame.preferences.getInteger("numberofflagsdestroyed"));
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void start() {

        round = false;

        for (int i = 0; i < grid.table.length; i++) {
            grid.table[i].setColor(Color.CLEAR);
        }
        if (GameScreen.TEAM_TYPE != -1) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final Map[] map = {new Map(stage, grid, GameScreen.MAP)};
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            GameScreen.map = map[0];
                            map[0] = null;
                        }
                    });
                }
            }).start();

        }

        GameScreen.GAMEOVER = false;
        GameScreen.OPENMENU = false;
        GameScreen.blue = 0;
        GameScreen.red = 0;
        GameScreen.map = null;

        tvictory = 0;


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {
        Gdx.app.log("PAUSE", "+");

    }

    @Override
    public void resume() {
        //    playServices.signInSilently();

    }

    @Override
    public void hide() {
        Gdx.app.log("HIDE", "+");

    }

    @Override
    public void dispose() {

    }
}
