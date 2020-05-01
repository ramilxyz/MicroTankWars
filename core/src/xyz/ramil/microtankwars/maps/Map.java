package xyz.ramil.microtankwars.maps;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;
import java.util.Random;

import xyz.ramil.microtankwars.actor.BlockGreen;
import xyz.ramil.microtankwars.actor.BlockRespawn;
import xyz.ramil.microtankwars.actor.BlockRock;
import xyz.ramil.microtankwars.actor.BlockWood;
import xyz.ramil.microtankwars.actor.Flag;
import xyz.ramil.microtankwars.actor.Grid;
import xyz.ramil.microtankwars.actor.Tank;
import xyz.ramil.microtankwars.ai.Lee;
import xyz.ramil.microtankwars.screen.GameScreen;

public class Map {

    public static int RED_FLAG_POSITION;
    public static int BLUE_FLAG_POSITION;
    private static Grid grid;
    private Color ctr1, ctr2, ctr3, ctr4;
    private Color ctb1, ctb2, ctb3, ctb4;
    private int br1 = -1, br2 = -1, br3 = -1, br4 = -1, br5 = -1, br6 = -1,
            br7 = -1, br8 = -1, br9 = -1, br10 = -1, br11 = -1, br12 = -1,
            br13 = -1, br14 = -1, br15 = -1, br16 = -1, br17 = -1, br18 = -1,
            br19 = -1, br20 = -1, br21 = -1, br22 = -1, br23 = -1, br24 = -1,
            br25 = -1, br26 = -1, br27 = -1, br28 = -1, br29 = -1, br30 = -1,
            br31 = -1, br32 = -1, br33 = -1, br34 = -1, br35 = -1, br36 = -1,
            br37 = -1, br38 = -1, br39 = -1, br40 = -1, br41 = -1, br42 = -1,
            br43 = -1, br44 = -1, br45 = -1, br46 = -1, br47 = -1, br48 = -1,
            br49 = -1, br50 = -1, br51 = -1, br52 = -1, br53 = -1, br54 = -1;


    private int bw1 = -1, bw2 = -1, bw3 = -1, bw4 = -1, bw5 = -1, bw6 = -1,
            bw7 = -1, bw8 = -1, bw9 = -1, bw10 = -1, bw11 = -1, bw12 = -1,
            bw13 = -1, bw14 = -1, bw15 = -1, bw16 = -1, bw17 = -1, bw18 = -1,
            bw19 = -1, bw20 = -1, bw21 = -1, bw22 = -1;
    private Stage stage;
    private int[][] map;
    private int[][] mapMatrix = {{73, 78, 83, 88, 93, 98, 103, 108, 113, 118, 123, 128, 133, 138},
            {433, 438, 443, 448, 453, 458, 463, 468, 473, 478, 483, 488, 493, 498},
            {793, 798, 803, 808, 813, 818, 823, 828, 833, 838, 843, 848, 853, 858},
            {1153, 1158, 1163, 1168, 1173, 1178, 1183, 1188, 1193, 1198, 1203, 1208, 1213, 1218},
            {1513, 1518, 1523, 1528, 1533, 1538, 1543, 1548, 1553, 1558, 1563, 1568, 1573, 1578},
            {1873, 1878, 1883, 1888, 1893, 1898, 1903, 1908, 1913, 1918, 1923, 1928, 1933, 1938},
            {2233, 2238, 2243, 2248, 2253, 2258, 2263, 2268, 2273, 2278, 2283, 2288, 2293, 2298},
            {2593, 2598, 2603, 2608, 2613, 2618, 2623, 2628, 2633, 2638, 2643, 2648, 2653, 2658},
            {2953, 2958, 2963, 2968, 2973, 2978, 2983, 2988, 2993, 2998, 3003, 3008, 3013, 3018},
            {3313, 3318, 3323, 3328, 3333, 3338, 3343, 3348, 3353, 3358, 3363, 3368, 3373, 3378},
            {3673, 3678, 3683, 3688, 3693, 3698, 3703, 3708, 3713, 3718, 3723, 3728, 3733, 3738},
            {4033, 4038, 4043, 4048, 4053, 4058, 4063, 4068, 4073, 4078, 4083, 4088, 4093, 4098},
            {4393, 4398, 4403, 4408, 4413, 4418, 4423, 4428, 4433, 4438, 4443, 4448, 4453, 4458},
            {4753, 4758, 4763, 4768, 4773, 4778, 4783, 4788, 4793, 4798, 4803, 4808, 4813, 4818}};
    private Tank tankUser;
    private Tank tankRed1;
    private Tank tankRed2;
    private Tank tankRed3;
    private int tru, tr1, tr2, tr3;
    private Tank tankBlue1;
    private Tank tankBlue2;
    private Tank tankBlue3;
    private Tank tankBlue4;
    private int tbu, tb1, tb2, tb3;
    private BlockGreen blockGreen1;
    private BlockGreen blockGreen2;
    private BlockGreen blockGreen3;
    private BlockGreen blockGreen4;
    private BlockGreen blockGreen5;
    private BlockGreen blockGreen6;
    private BlockGreen blockGreen7;
    private BlockGreen blockGreen8;
    private BlockGreen blockGreen9;
    private BlockGreen blockGreen10;
    private BlockGreen blockGreen11;
    private BlockGreen blockGreen12;
    private BlockGreen blockGreen13;
    private BlockGreen blockGreen14;
    private BlockGreen blockGreen15;
    private BlockGreen blockGreen16;
    private BlockGreen blockGreen17;
    private BlockGreen blockGreen18;
    private BlockGreen blockGreen19;
    private BlockGreen blockGreen20;
    private BlockGreen blockGreen21;
    private BlockGreen blockGreen22;
    private BlockGreen blockGreen23;
    private BlockGreen blockGreen24;
    private int bg1 = -1, bg2 = -1, bg3 = -1, bg4 = -1, bg5 = -1,
            bg6 = -1, bg7 = -1, bg8 = -1, bg9 = -1, bg10 = -1,
            bg11 = -1, bg12 = -1,
            bg13 = -1, bg14 = -1, bg15 = -1, bg16 = -1, bg17 = -1,
            bg18 = -1, bg19 = -1, bg20 = -1, bg21 = -1, bg22 = -1,
            bg23 = -1, bg24 = -1;


    private BlockRock blockRock1;
    private BlockRock blockRock2;
    private BlockRock blockRock3;
    private BlockRock blockRock4;
    private BlockRock blockRock5;
    private BlockRock blockRock6;
    private BlockRock blockRock7;
    private BlockRock blockRock8;
    private BlockRock blockRock9;
    private BlockRock blockRock10;
    private BlockRock blockRock11;
    private BlockRock blockRock12;
    private BlockRock blockRock13;
    private BlockRock blockRock14;
    private BlockRock blockRock15;
    private BlockRock blockRock16;
    private BlockRock blockRock17;
    private BlockRock blockRock18;
    private BlockRock blockRock19;
    private BlockRock blockRock20;
    private BlockRock blockRock21;
    private BlockRock blockRock22;
    private BlockRock blockRock23;
    private BlockRock blockRock24;
    private BlockRock blockRock25;
    private BlockRock blockRock26;
    private BlockRock blockRock27;
    private BlockRock blockRock28;
    private BlockRock blockRock29;
    private BlockRock blockRock30;
    private BlockRock blockRock31;
    private BlockRock blockRock32;
    private BlockRock blockRock33;
    private BlockRock blockRock34;
    private BlockRock blockRock35;
    private BlockRock blockRock36;
    private BlockRock blockRock37;
    private BlockRock blockRock38;
    private BlockRock blockRock39;
    private BlockRock blockRock40;
    private BlockRock blockRock41;
    private BlockRock blockRock42;
    private BlockRock blockRock43;
    private BlockRock blockRock44;
    private BlockRock blockRock45;
    private BlockRock blockRock46;
    private BlockRock blockRock47;
    private BlockRock blockRock48;
    private BlockRock blockRock49;
    private BlockRock blockRock50;
    private BlockRock blockRock51;
    private BlockRock blockRock52;
    private BlockRock blockRock53;
    private BlockRock blockRock54;
    private BlockRespawn blockRespawn;
    private BlockRespawn blockRespawn1;
    private BlockRespawn blockRespawn2;
    private BlockRespawn blockRespawn3;
    private BlockRespawn blockRespawn4;
    private BlockRespawn blockRespawn5;
    private BlockRespawn blockRespawn6;
    private BlockRespawn blockRespawn7;
    private Flag flagBlue;
    private Flag flagRed;
    private int bf1, bf2;

    public Map(Stage stage, Grid grid, int[][] map) {
        this.stage = stage;
        Map.grid = grid;
        this.map = map;
        initField();
        mapInit();
    }

    private void initField() {
        for (int i = 0; i < mapMatrix.length; i++) {
            for (int j = 0; j < mapMatrix.length; j++) {
                //-----------flag--------------
                if (map[i][j] == 100) {
                    bf1 = mapMatrix[i][j];
                    if (GameScreen.TEAM_TYPE == 1)
                        RED_FLAG_POSITION = mapMatrix[i][j];
                    else BLUE_FLAG_POSITION = mapMatrix[i][j];
                }
                if (map[i][j] == 200) {
                    bf2 = mapMatrix[i][j];
                    if (GameScreen.TEAM_TYPE == 1)
                        BLUE_FLAG_POSITION = mapMatrix[i][j];
                    else RED_FLAG_POSITION = mapMatrix[i][j];
                }
                //-----------tank------------
                if (map[i][j] == 10) {
                    tbu = mapMatrix[i][j];
                }
                if (map[i][j] == 20) {
                    tb1 = mapMatrix[i][j];
                }
                if (map[i][j] == 30) {
                    tb2 = mapMatrix[i][j];
                }
                if (map[i][j] == 40) {
                    tb3 = mapMatrix[i][j];
                }
                if (map[i][j] == 50) {
                    tru = mapMatrix[i][j];
                }
                if (map[i][j] == 60) {
                    tr1 = mapMatrix[i][j];
                }
                if (map[i][j] == 70) {
                    tr2 = mapMatrix[i][j];
                }
                if (map[i][j] == 80) {
                    tr3 = mapMatrix[i][j];
                }
                //-----------green-----------
                if (map[i][j] == 4) {
                    if (bg1 == -1) {
                        bg1 = mapMatrix[i][j];
                    } else if (bg2 == -1) {
                        bg2 = mapMatrix[i][j];
                    } else if (bg3 == -1) {
                        bg3 = mapMatrix[i][j];
                    } else if (bg4 == -1) {
                        bg4 = mapMatrix[i][j];
                    } else if (bg5 == -1) {
                        bg5 = mapMatrix[i][j];
                    } else if (bg6 == -1) {
                        bg6 = mapMatrix[i][j];
                    } else if (bg7 == -1) {
                        bg7 = mapMatrix[i][j];
                    } else if (bg8 == -1) {
                        bg8 = mapMatrix[i][j];
                    } else if (bg9 == -1) {
                        bg9 = mapMatrix[i][j];
                    } else if (bg10 == -1) {
                        bg10 = mapMatrix[i][j];
                    } else if (bg11 == -1) {
                        bg11 = mapMatrix[i][j];
                    } else if (bg12 == -1) {
                        bg12 = mapMatrix[i][j];
                    } else if (bg13 == -1) {
                        bg13 = mapMatrix[i][j];
                    } else if (bg14 == -1) {
                        bg14 = mapMatrix[i][j];
                    } else if (bg15 == -1) {
                        bg15 = mapMatrix[i][j];
                    } else if (bg16 == -1) {
                        bg16 = mapMatrix[i][j];
                    } else if (bg17 == -1) {
                        bg17 = mapMatrix[i][j];
                    } else if (bg18 == -1) {
                        bg18 = mapMatrix[i][j];
                    } else if (bg19 == -1) {
                        bg19 = mapMatrix[i][j];
                    } else if (bg20 == -1) {
                        bg20 = mapMatrix[i][j];
                    } else if (bg21 == -1) {
                        bg21 = mapMatrix[i][j];
                    } else if (bg22 == -1) {
                        bg22 = mapMatrix[i][j];
                    } else if (bg23 == -1) {
                        bg23 = mapMatrix[i][j];
                    } else if (bg24 == -1) {
                        bg24 = mapMatrix[i][j];
                    }
                }
                //--------------ice--------------


                //-----------rock---------------
                if (map[i][j] == 1) {
                    if (br1 == -1) {
                        br1 = mapMatrix[i][j];
                    } else if (br2 == -1) {
                        br2 = mapMatrix[i][j];
                    } else if (br3 == -1) {
                        br3 = mapMatrix[i][j];
                    } else if (br4 == -1) {
                        br4 = mapMatrix[i][j];
                    } else if (br5 == -1) {
                        br5 = mapMatrix[i][j];
                    } else if (br6 == -1) {
                        br6 = mapMatrix[i][j];
                    } else if (br7 == -1) {
                        br7 = mapMatrix[i][j];
                    } else if (br8 == -1) {
                        br8 = mapMatrix[i][j];
                    } else if (br9 == -1) {
                        br9 = mapMatrix[i][j];
                    } else if (br10 == -1) {
                        br10 = mapMatrix[i][j];
                    } else if (br11 == -1) {
                        br11 = mapMatrix[i][j];
                    } else if (br12 == -1) {
                        br12 = mapMatrix[i][j];
                    } else if (br13 == -1) {
                        br13 = mapMatrix[i][j];
                    } else if (br14 == -1) {
                        br14 = mapMatrix[i][j];
                    } else if (br15 == -1) {
                        br15 = mapMatrix[i][j];
                    } else if (br16 == -1) {
                        br16 = mapMatrix[i][j];
                    } else if (br17 == -1) {
                        br17 = mapMatrix[i][j];
                    } else if (br18 == -1) {
                        br18 = mapMatrix[i][j];
                    } else if (br19 == -1) {
                        br19 = mapMatrix[i][j];
                    } else if (br20 == -1) {
                        br20 = mapMatrix[i][j];
                    } else if (br21 == -1) {
                        br21 = mapMatrix[i][j];
                    } else if (br22 == -1) {
                        br22 = mapMatrix[i][j];
                    } else if (br23 == -1) {
                        br23 = mapMatrix[i][j];
                    } else if (br24 == -1) {
                        br24 = mapMatrix[i][j];
                    } else if (br25 == -1) {
                        br25 = mapMatrix[i][j];
                    } else if (br26 == -1) {
                        br26 = mapMatrix[i][j];
                    } else if (br27 == -1) {
                        br27 = mapMatrix[i][j];
                    } else if (br28 == -1) {
                        br28 = mapMatrix[i][j];
                    } else if (br29 == -1) {
                        br29 = mapMatrix[i][j];
                    } else if (br30 == -1) {
                        br30 = mapMatrix[i][j];
                    } else if (br31 == -1) {
                        br31 = mapMatrix[i][j];
                    } else if (br32 == -1) {
                        br32 = mapMatrix[i][j];
                    } else if (br33 == -1) {
                        br33 = mapMatrix[i][j];
                    } else if (br34 == -1) {
                        br34 = mapMatrix[i][j];
                    } else if (br35 == -1) {
                        br35 = mapMatrix[i][j];
                    } else if (br36 == -1) {
                        br36 = mapMatrix[i][j];
                    } else if (br37 == -1) {
                        br37 = mapMatrix[i][j];
                    } else if (br38 == -1) {
                        br38 = mapMatrix[i][j];
                    } else if (br39 == -1) {
                        br39 = mapMatrix[i][j];
                    } else if (br40 == -1) {
                        br40 = mapMatrix[i][j];
                    } else if (br41 == -1) {
                        br41 = mapMatrix[i][j];
                    } else if (br42 == -1) {
                        br42 = mapMatrix[i][j];
                    } else if (br43 == -1) {
                        br43 = mapMatrix[i][j];
                    } else if (br44 == -1) {
                        br44 = mapMatrix[i][j];
                    } else if (br45 == -1) {
                        br45 = mapMatrix[i][j];
                    } else if (br46 == -1) {
                        br46 = mapMatrix[i][j];
                    } else if (br47 == -1) {
                        br47 = mapMatrix[i][j];
                    } else if (br48 == -1) {
                        br48 = mapMatrix[i][j];
                    } else if (br49 == -1) {
                        br49 = mapMatrix[i][j];
                    } else if (br50 == -1) {
                        br50 = mapMatrix[i][j];
                    } else if (br51 == -1) {
                        br51 = mapMatrix[i][j];
                    } else if (br52 == -1) {
                        br52 = mapMatrix[i][j];
                    } else if (br53 == -1) {
                        br53 = mapMatrix[i][j];
                    } else if (br54 == -1) {
                        br54 = mapMatrix[i][j];
                    }
                }

                //-----------wood---------------
                if (map[i][j] == 2) {
                    if (bw1 == -1) {
                        bw1 = mapMatrix[i][j];
                    } else if (bw2 == -1) {
                        bw2 = mapMatrix[i][j];
                    } else if (bw3 == -1) {
                        bw3 = mapMatrix[i][j];
                    } else if (bw4 == -1) {
                        bw4 = mapMatrix[i][j];
                    } else if (bw5 == -1) {
                        bw5 = mapMatrix[i][j];
                    } else if (bw6 == -1) {
                        bw6 = mapMatrix[i][j];
                    } else if (bw7 == -1) {
                        bw7 = mapMatrix[i][j];
                    } else if (bw8 == -1) {
                        bw8 = mapMatrix[i][j];
                    } else if (bw9 == -1) {
                        bw9 = mapMatrix[i][j];
                    } else if (bw10 == -1) {
                        bw10 = mapMatrix[i][j];
                    } else if (bw11 == -1) {
                        bw11 = mapMatrix[i][j];
                    } else if (bw12 == -1) {
                        bw12 = mapMatrix[i][j];
                    } else if (bw13 == -1) {
                        bw13 = mapMatrix[i][j];
                    } else if (bw14 == -1) {
                        bw14 = mapMatrix[i][j];
                    } else if (bw15 == -1) {
                        bw15 = mapMatrix[i][j];
                    } else if (bw16 == -1) {
                        bw16 = mapMatrix[i][j];
                    } else if (bw17 == -1) {
                        bw17 = mapMatrix[i][j];
                    } else if (bw18 == -1) {
                        bw18 = mapMatrix[i][j];
                    } else if (bw19 == -1) {
                        bw19 = mapMatrix[i][j];
                    } else if (bw20 == -1) {
                        bw20 = mapMatrix[i][j];
                    } else if (bw21 == -1) {
                        bw21 = mapMatrix[i][j];
                    } else if (bw22 == -1) {
                        bw22 = mapMatrix[i][j];
                    }
                }

            }
        }

    }


    private void mapInit() {
        if (bg1 != -1)
            blockGreen1 = new BlockGreen(grid, bg1, GameScreen.BUSH_COLOR);
        if (bg2 != -1)
            blockGreen2 = new BlockGreen(grid, bg2, GameScreen.BUSH_COLOR);
        if (bg3 != -1)
            blockGreen3 = new BlockGreen(grid, bg3, GameScreen.BUSH_COLOR);
        if (bg4 != -1)
            blockGreen4 = new BlockGreen(grid, bg4, GameScreen.BUSH_COLOR);
        if (bg5 != -1)
            blockGreen5 = new BlockGreen(grid, bg5, GameScreen.BUSH_COLOR);
        if (bg6 != -1)
            blockGreen6 = new BlockGreen(grid, bg6, GameScreen.BUSH_COLOR);
        if (bg7 != -1)
            blockGreen7 = new BlockGreen(grid, bg7, GameScreen.BUSH_COLOR);
        if (bg8 != -1)
            blockGreen8 = new BlockGreen(grid, bg8, GameScreen.BUSH_COLOR);
        if (bg9 != -1)
            blockGreen9 = new BlockGreen(grid, bg9, GameScreen.BUSH_COLOR);
        if (bg10 != -1)
            blockGreen10 = new BlockGreen(grid, bg10, GameScreen.BUSH_COLOR);
        if (bg11 != -1)
            blockGreen11 = new BlockGreen(grid, bg11, GameScreen.BUSH_COLOR);
        if (bg12 != -1)
            blockGreen12 = new BlockGreen(grid, bg12, GameScreen.BUSH_COLOR);

        if (bg13 != -1)
            blockGreen13 = new BlockGreen(grid, bg13, GameScreen.BUSH_COLOR);
        if (bg14 != -1)
            blockGreen14 = new BlockGreen(grid, bg14, GameScreen.BUSH_COLOR);
        if (bg15 != -1)
            blockGreen15 = new BlockGreen(grid, bg15, GameScreen.BUSH_COLOR);
        if (bg16 != -1)
            blockGreen16 = new BlockGreen(grid, bg16, GameScreen.BUSH_COLOR);
        if (bg17 != -1)
            blockGreen17 = new BlockGreen(grid, bg17, GameScreen.BUSH_COLOR);
        if (bg18 != -1)
            blockGreen18 = new BlockGreen(grid, bg18, GameScreen.BUSH_COLOR);
        if (bg19 != -1)
            blockGreen19 = new BlockGreen(grid, bg19, GameScreen.BUSH_COLOR);
        if (bg20 != -1)
            blockGreen20 = new BlockGreen(grid, bg20, GameScreen.BUSH_COLOR);
        if (bg21 != -1)
            blockGreen21 = new BlockGreen(grid, bg21, GameScreen.BUSH_COLOR);
        if (bg22 != -1)
            blockGreen22 = new BlockGreen(grid, bg22, GameScreen.BUSH_COLOR);
        if (bg23 != -1)
            blockGreen23 = new BlockGreen(grid, bg23, GameScreen.BUSH_COLOR);
        if (bg24 != -1)
            blockGreen24 = new BlockGreen(grid, bg24, GameScreen.BUSH_COLOR);


        if (br1 != -1)
            blockRock1 = new BlockRock(grid, br1
                    , new Color(GameScreen.BRICK_COLOR));
        if (br2 != -1)
            blockRock2 = new BlockRock(grid, br2
                    , new Color(GameScreen.BRICK_COLOR));
        if (br3 != -1)
            blockRock3 = new BlockRock(grid, br3
                    , new Color(GameScreen.BRICK_COLOR));
        if (br4 != -1)
            blockRock4 = new BlockRock(grid, br4
                    , new Color(GameScreen.BRICK_COLOR));
        if (br5 != -1)
            blockRock5 = new BlockRock(grid, br5
                    , new Color(GameScreen.BRICK_COLOR));
        if (br6 != -1)
            blockRock6 = new BlockRock(grid, br6
                    , new Color(GameScreen.BRICK_COLOR));
        if (br7 != -1)
            blockRock7 = new BlockRock(grid, br7
                    , new Color(GameScreen.BRICK_COLOR));
        if (br8 != -1)
            blockRock8 = new BlockRock(grid, br8
                    , new Color(GameScreen.BRICK_COLOR));
        if (br9 != -1)
            blockRock9 = new BlockRock(grid, br9
                    , new Color(GameScreen.BRICK_COLOR));
        if (br10 != -1)
            blockRock10 = new BlockRock(grid, br10
                    , new Color(GameScreen.BRICK_COLOR));
        if (br11 != -1)
            blockRock11 = new BlockRock(grid, br11
                    , new Color(GameScreen.BRICK_COLOR));
        if (br12 != -1)
            blockRock12 = new BlockRock(grid, br12
                    , new Color(GameScreen.BRICK_COLOR));
        if (br13 != -1)
            blockRock13 = new BlockRock(grid, br13
                    , new Color(GameScreen.BRICK_COLOR));
        if (br14 != -1)
            blockRock14 = new BlockRock(grid, br14
                    , new Color(GameScreen.BRICK_COLOR));
        if (br15 != -1)
            blockRock15 = new BlockRock(grid, br15
                    , new Color(GameScreen.BRICK_COLOR));
        if (br16 != -1)
            blockRock16 = new BlockRock(grid, br16
                    , new Color(GameScreen.BRICK_COLOR));
        if (br17 != -1)
            blockRock17 = new BlockRock(grid, br17
                    , new Color(GameScreen.BRICK_COLOR));
        if (br18 != -1)
            blockRock18 = new BlockRock(grid, br18
                    , new Color(GameScreen.BRICK_COLOR));
        if (br19 != -1)
            blockRock19 = new BlockRock(grid, br19
                    , new Color(GameScreen.BRICK_COLOR));
        if (br20 != -1)
            blockRock20 = new BlockRock(grid, br20
                    , new Color(GameScreen.BRICK_COLOR));
        if (br21 != -1)
            blockRock21 = new BlockRock(grid, br21
                    , new Color(GameScreen.BRICK_COLOR));
        if (br22 != -1)
            blockRock22 = new BlockRock(grid, br22
                    , new Color(GameScreen.BRICK_COLOR));
        if (br23 != -1)
            blockRock23 = new BlockRock(grid, br23
                    , new Color(GameScreen.BRICK_COLOR));
        if (br24 != -1)
            blockRock24 = new BlockRock(grid, br24
                    , new Color(GameScreen.BRICK_COLOR));
        if (br25 != -1)
            blockRock25 = new BlockRock(grid, br25
                    , new Color(GameScreen.BRICK_COLOR));
        if (br26 != -1)
            blockRock26 = new BlockRock(grid, br26
                    , new Color(GameScreen.BRICK_COLOR));
        if (br27 != -1)
            blockRock27 = new BlockRock(grid, br27
                    , new Color(GameScreen.BRICK_COLOR));
        if (br28 != -1)
            blockRock28 = new BlockRock(grid, br28
                    , new Color(GameScreen.BRICK_COLOR));
        if (br29 != -1)
            blockRock29 = new BlockRock(grid, br29
                    , new Color(GameScreen.BRICK_COLOR));
        if (br30 != -1)
            blockRock30 = new BlockRock(grid, br30
                    , new Color(GameScreen.BRICK_COLOR));
        if (br31 != -1)
            blockRock31 = new BlockRock(grid, br31
                    , new Color(GameScreen.BRICK_COLOR));
        if (br32 != -1)
            blockRock32 = new BlockRock(grid, br32
                    , new Color(GameScreen.BRICK_COLOR));
        if (br33 != -1)
            blockRock33 = new BlockRock(grid, br33
                    , new Color(GameScreen.BRICK_COLOR));
        if (br34 != -1)
            blockRock34 = new BlockRock(grid, br34
                    , new Color(GameScreen.BRICK_COLOR));
        if (br35 != -1)
            blockRock35 = new BlockRock(grid, br35
                    , new Color(GameScreen.BRICK_COLOR));
        if (br36 != -1)
            blockRock36 = new BlockRock(grid, br36
                    , new Color(GameScreen.BRICK_COLOR));
        if (br37 != -1)
            blockRock37 = new BlockRock(grid, br37
                    , new Color(GameScreen.BRICK_COLOR));
        if (br38 != -1)
            blockRock38 = new BlockRock(grid, br38
                    , new Color(GameScreen.BRICK_COLOR));
        if (br39 != -1)
            blockRock39 = new BlockRock(grid, br39
                    , new Color(GameScreen.BRICK_COLOR));
        if (br40 != -1)
            blockRock40 = new BlockRock(grid, br40
                    , new Color(GameScreen.BRICK_COLOR));
        if (br41 != -1)
            blockRock41 = new BlockRock(grid, br41
                    , new Color(GameScreen.BRICK_COLOR));
        if (br42 != -1)
            blockRock42 = new BlockRock(grid, br42
                    , new Color(GameScreen.BRICK_COLOR));
        if (br43 != -1)
            blockRock43 = new BlockRock(grid, br43
                    , new Color(GameScreen.BRICK_COLOR));
        if (br44 != -1)
            blockRock44 = new BlockRock(grid, br44
                    , new Color(GameScreen.BRICK_COLOR));
        if (br45 != -1)
            blockRock45 = new BlockRock(grid, br45
                    , new Color(GameScreen.BRICK_COLOR));
        if (br46 != -1)
            blockRock46 = new BlockRock(grid, br46
                    , new Color(GameScreen.BRICK_COLOR));
        if (br47 != -1)
            blockRock47 = new BlockRock(grid, br47
                    , new Color(GameScreen.BRICK_COLOR));
        if (br48 != -1)
            blockRock48 = new BlockRock(grid, br48
                    , new Color(GameScreen.BRICK_COLOR));
        if (br49 != -1)
            blockRock49 = new BlockRock(grid, br49
                    , new Color(GameScreen.BRICK_COLOR));
        if (br50 != -1)
            blockRock50 = new BlockRock(grid, br50
                    , new Color(GameScreen.BRICK_COLOR));
        if (br51 != -1)
            blockRock51 = new BlockRock(grid, br51
                    , new Color(GameScreen.BRICK_COLOR));
        if (br52 != -1)
            blockRock52 = new BlockRock(grid, br52
                    , new Color(GameScreen.BRICK_COLOR));
        if (br53 != -1)
            blockRock53 = new BlockRock(grid, br53
                    , new Color(GameScreen.BRICK_COLOR));
        if (br54 != -1)
            blockRock54 = new BlockRock(grid, br54
                    , new Color(GameScreen.BRICK_COLOR));

        BlockWood blockWood1;
        if (bw1 != -1)
            blockWood1 = new BlockWood(grid, bw1, GameScreen.WOOD_COLOR);
        BlockWood blockWood2;
        if (bw2 != -1)
            blockWood2 = new BlockWood(grid, bw2, GameScreen.WOOD_COLOR);
        BlockWood blockWood3;
        if (bw3 != -1)
            blockWood3 = new BlockWood(grid, bw3, GameScreen.WOOD_COLOR);
        BlockWood blockWood4;
        if (bw4 != -1)
            blockWood4 = new BlockWood(grid, bw4, GameScreen.WOOD_COLOR);
        BlockWood blockWood5;
        if (bw5 != -1)
            blockWood5 = new BlockWood(grid, bw5, GameScreen.WOOD_COLOR);
        BlockWood blockWood6;
        if (bw6 != -1)
            blockWood6 = new BlockWood(grid, bw6, GameScreen.WOOD_COLOR);
        BlockWood blockWood7;
        if (bw7 != -1)
            blockWood7 = new BlockWood(grid, bw7, GameScreen.WOOD_COLOR);
        BlockWood blockWood8;
        if (bw8 != -1)
            blockWood8 = new BlockWood(grid, bw8, GameScreen.WOOD_COLOR);
        BlockWood blockWood9;
        if (bw9 != -1)
            blockWood9 = new BlockWood(grid, bw9, GameScreen.WOOD_COLOR);
        BlockWood blockWood10;
        if (bw10 != -1)
            blockWood10 = new BlockWood(grid, bw10, GameScreen.WOOD_COLOR);
        BlockWood blockWood11;
        if (bw11 != -1)
            blockWood11 = new BlockWood(grid, bw11, GameScreen.WOOD_COLOR);
        BlockWood blockWood12;
        if (bw12 != -1)
            blockWood12 = new BlockWood(grid, bw12, GameScreen.WOOD_COLOR);
        BlockWood blockWood13;
        if (bw13 != -1)
            blockWood13 = new BlockWood(grid, bw13, GameScreen.WOOD_COLOR);
        BlockWood blockWood14;
        if (bw14 != -1)
            blockWood14 = new BlockWood(grid, bw14, GameScreen.WOOD_COLOR);
        BlockWood blockWood15;
        if (bw15 != -1)
            blockWood15 = new BlockWood(grid, bw15, GameScreen.WOOD_COLOR);
        BlockWood blockWood16;
        if (bw16 != -1)
            blockWood16 = new BlockWood(grid, bw16, GameScreen.WOOD_COLOR);
        BlockWood blockWood17;
        if (bw17 != -1)
            blockWood17 = new BlockWood(grid, bw17, GameScreen.WOOD_COLOR);
        BlockWood blockWood18;
        if (bw18 != -1)
            blockWood18 = new BlockWood(grid, bw18, GameScreen.WOOD_COLOR);
        BlockWood blockWood19;
        if (bw19 != -1)
            blockWood19 = new BlockWood(grid, bw19, GameScreen.WOOD_COLOR);
        BlockWood blockWood20;
        if (bw20 != -1)
            blockWood20 = new BlockWood(grid, bw20, GameScreen.WOOD_COLOR);
        BlockWood blockWood21;
        if (bw21 != -1)
            blockWood21 = new BlockWood(grid, bw21, GameScreen.WOOD_COLOR);
        BlockWood blockWood22;
        if (bw22 != -1)
            blockWood22 = new BlockWood(grid, bw22, GameScreen.WOOD_COLOR);


        Lee lee = new Lee(grid);


        blockRespawn = new BlockRespawn(grid, tru, "left");
        blockRespawn1 = new BlockRespawn(grid, tr1, "left");
        blockRespawn2 = new BlockRespawn(grid, tr2, "down");
        blockRespawn3 = new BlockRespawn(grid, tr3, "down");

        blockRespawn4 = new BlockRespawn(grid, tbu, "right");
        blockRespawn5 = new BlockRespawn(grid, tb1, "right");
        blockRespawn6 = new BlockRespawn(grid, tb2, "upb");
        blockRespawn7 = new BlockRespawn(grid, tb3, "upb");


        if (GameScreen.TEAM_TYPE == 0) {

            flagBlue = new Flag(grid, bf1
                    , new Color(GameScreen.FLAG_BLUE));

            flagRed = new Flag(grid, bf2
                    , new Color(GameScreen.FLAG_RED));

            Random random = new Random();

            int rnd = random.nextInt(4);

            ArrayList<Color> arrayList = new ArrayList<>();
            arrayList.add(GameScreen.COLORRED);
            arrayList.add(GameScreen.COLORRED);
            arrayList.add(GameScreen.COLORRED);
            arrayList.add(GameScreen.COLORRED);

            arrayList.set(rnd, GameScreen.USER_TANK_COLOR_RED);

            ctr1 = arrayList.get(0);
            ctr2 = arrayList.get(1);
            ctr3 = arrayList.get(2);
            ctr4 = arrayList.get(3);

            ctb1 = GameScreen.COLORBLUE;
            ctb2 = GameScreen.COLORBLUE;
            ctb3 = GameScreen.COLORBLUE;
            ctb4 = GameScreen.COLORBLUE;


            tankUser = new Tank(stage, tbu, "left", ctr1, grid);
            tankRed1 = new Tank(stage, tb1, "left", ctr2, grid);
            tankRed2 = new Tank(stage, tb2, "down", ctr3, grid);
            tankRed3 = new Tank(stage, tb3, "down", ctr4, grid);

            tankBlue1 = new Tank(stage, tru, "right", ctb1, grid);
            tankBlue2 = new Tank(stage, tr1, "right", ctb2, grid);
            tankBlue3 = new Tank(stage, tr2, "upb", ctb3, grid);
            tankBlue4 = new Tank(stage, tr3, "upb", ctb4, grid);
        }
        if (GameScreen.TEAM_TYPE == 1) {

            flagBlue = new Flag(grid, bf2
                    , new Color(GameScreen.FLAG_BLUE));

            flagRed = new Flag(grid, bf1
                    , new Color(GameScreen.FLAG_RED));

            Random random = new Random();

            int rnd = random.nextInt(4);

            ArrayList<Color> arrayList = new ArrayList<>();
            arrayList.add(GameScreen.COLORBLUE);
            arrayList.add(GameScreen.COLORBLUE);
            arrayList.add(GameScreen.COLORBLUE);
            arrayList.add(GameScreen.COLORBLUE);

            arrayList.set(rnd, GameScreen.USER_TANK_COLOR_BLUE);

            ctb1 = arrayList.get(0);
            ctb2 = arrayList.get(1);
            ctb3 = arrayList.get(2);
            ctb4 = arrayList.get(3);

            ctr1 = GameScreen.COLORRED;
            ctr2 = GameScreen.COLORRED;
            ctr3 = GameScreen.COLORRED;
            ctr4 = GameScreen.COLORRED;


            tankUser = new Tank(stage, tru, "left", ctr1, grid);
            tankRed1 = new Tank(stage, tr1, "left", ctr2, grid);
            tankRed2 = new Tank(stage, tr2, "down", ctr3, grid);
            tankRed3 = new Tank(stage, tr3, "down", ctr4, grid);

            tankBlue1 = new Tank(stage, tbu, "right", ctb1, grid);
            tankBlue2 = new Tank(stage, tb1, "right", ctb2, grid);
            tankBlue3 = new Tank(stage, tb2, "upb", ctb3, grid);
            tankBlue4 = new Tank(stage, tb3, "upb", ctb4, grid);
        }


    }


    public void mapRender(float v) {

        flagBlue.render(v);
        flagRed.render(v);

        if (bg1 != -1)
            blockGreen1.render(v);
        if (bg2 != -1)
            blockGreen2.render(v);
        if (bg3 != -1)
            blockGreen3.render(v);
        if (bg4 != -1)
            blockGreen4.render(v);
        if (bg5 != -1)
            blockGreen5.render(v);
        if (bg6 != -1)
            blockGreen6.render(v);
        if (bg7 != -1)
            blockGreen7.render(v);
        if (bg8 != -1)
            blockGreen8.render(v);
        if (bg9 != -1)
            blockGreen9.render(v);
        if (bg10 != -1)
            blockGreen10.render(v);
        if (bg11 != -1)
            blockGreen11.render(v);
        if (bg12 != -1)
            blockGreen12.render(v);

        if (bg13 != -1)
            blockGreen13.render(v);
        if (bg14 != -1)
            blockGreen14.render(v);
        if (bg15 != -1)
            blockGreen15.render(v);
        if (bg16 != -1)
            blockGreen16.render(v);
        if (bg17 != -1)
            blockGreen17.render(v);
        if (bg18 != -1)
            blockGreen18.render(v);
        if (bg19 != -1)
            blockGreen19.render(v);
        if (bg20 != -1)
            blockGreen20.render(v);
        if (bg21 != -1)
            blockGreen21.render(v);
        if (bg22 != -1)
            blockGreen22.render(v);
        if (bg23 != -1)
            blockGreen23.render(v);
        if (bg24 != -1)
            blockGreen24.render(v);


        if (br1 != -1)
            blockRock1.render(v);
        if (br2 != -1)
            blockRock2.render(v);
        if (br3 != -1)
            blockRock3.render(v);
        if (br4 != -1)
            blockRock4.render(v);
        if (br5 != -1)
            blockRock5.render(v);
        if (br6 != -1)
            blockRock6.render(v);
        if (br7 != -1)
            blockRock7.render(v);
        if (br8 != -1)
            blockRock8.render(v);
        if (br9 != -1)
            blockRock9.render(v);
        if (br10 != -1)
            blockRock10.render(v);
        if (br11 != -1)
            blockRock11.render(v);
        if (br12 != -1)
            blockRock12.render(v);
        if (br13 != -1)
            blockRock13.render(v);
        if (br14 != -1)
            blockRock14.render(v);
        if (br15 != -1)
            blockRock15.render(v);
        if (br16 != -1)
            blockRock16.render(v);
        if (br17 != -1)
            blockRock17.render(v);
        if (br18 != -1)
            blockRock18.render(v);
        if (br19 != -1)
            blockRock19.render(v);
        if (br20 != -1)
            blockRock20.render(v);
        if (br21 != -1)
            blockRock21.render(v);
        if (br22 != -1)
            blockRock22.render(v);
        if (br23 != -1)
            blockRock23.render(v);
        if (br24 != -1)
            blockRock24.render(v);
        if (br25 != -1)
            blockRock25.render(v);
        if (br26 != -1)
            blockRock26.render(v);
        if (br27 != -1)
            blockRock27.render(v);
        if (br28 != -1)
            blockRock28.render(v);
        if (br29 != -1)
            blockRock29.render(v);
        if (br30 != -1)
            blockRock30.render(v);
        if (br31 != -1)
            blockRock31.render(v);
        if (br32 != -1)
            blockRock32.render(v);
        if (br33 != -1)
            blockRock33.render(v);
        if (br34 != -1)
            blockRock34.render(v);
        if (br35 != -1)
            blockRock35.render(v);
        if (br36 != -1)
            blockRock36.render(v);
        if (br37 != -1)
            blockRock37.render(v);
        if (br38 != -1)
            blockRock38.render(v);
        if (br39 != -1)
            blockRock39.render(v);
        if (br40 != -1)
            blockRock40.render(v);
        if (br41 != -1)
            blockRock41.render(v);
        if (br42 != -1)
            blockRock42.render(v);
        if (br43 != -1)
            blockRock43.render(v);
        if (br44 != -1)
            blockRock44.render(v);
        if (br45 != -1)
            blockRock45.render(v);
        if (br46 != -1)
            blockRock46.render(v);
        if (br47 != -1)
            blockRock47.render(v);
        if (br48 != -1)
            blockRock48.render(v);
        if (br49 != -1)
            blockRock49.render(v);
        if (br50 != -1)
            blockRock50.render(v);
        if (br51 != -1)
            blockRock51.render(v);
        if (br52 != -1)
            blockRock52.render(v);
        if (br53 != -1)
            blockRock53.render(v);
        if (br54 != -1)
            blockRock54.render(v);

        blockRespawn.render(v);
        blockRespawn1.render(v);
        blockRespawn2.render(v);
        blockRespawn3.render(v);
        blockRespawn4.render(v);
        blockRespawn5.render(v);
        blockRespawn6.render(v);
        blockRespawn7.render(v);


        if (GameScreen.TEAM_TYPE == 1) {
            if (tankBlue1 != null)
                if (tankBlue1.getDispose() && tankBlue1.getBullet() == null) {
                    tankBlue1.clear();
                    if (tankBlue1.getBullet() == null)
                        tankBlue1 = new Tank(stage, tbu, "right", ctb1, grid);
                } else {
                    tankBlue1.render(v);
                }
            if (tankBlue2 != null)
                if (tankBlue2.getDispose() && tankBlue2.getBullet() == null) {
                    tankBlue2.clear();
                    if (tankBlue2.getBullet() == null)
                        tankBlue2 = new Tank(stage, tb1, "right", ctb2, grid);
                } else {
                    tankBlue2.render(v);
                }
            if (tankBlue3 != null)
                if (tankBlue3.getDispose() && tankBlue3.getBullet() == null) {
                    tankBlue3.clear();
                    if (tankBlue3.getBullet() == null)
                        tankBlue3 = new Tank(stage, tb2, "upb", ctb3, grid);
                } else {
                    tankBlue3.render(v);
                }
            if (tankBlue4 != null)
                if (tankBlue4.getDispose() && tankBlue4.getBullet() == null) {
                    tankBlue4.clear();
                    if (tankBlue4.getBullet() == null)
                        tankBlue4 = new Tank(stage, tb3, "upb", ctb4, grid);
                } else {
                    tankBlue4.render(v);
                }


            if (tankRed1 != null)
                if (tankRed1.getDispose() && tankRed1.getBullet() == null) {
                    tankRed1.clear();
                    if (tankRed1.getBullet() == null)
                        tankRed1 = new Tank(stage, tr1, "left", ctr2, grid);
                } else {
                    tankRed1.render(v);
                }
            if (tankRed2 != null)
                if (tankRed2.getDispose() && tankRed2.getBullet() == null) {
                    tankRed2.clear();
                    if (tankRed2.getBullet() == null)
                        tankRed2 = new Tank(stage, tr2, "down", ctr3, grid);
                } else {
                    tankRed2.render(v);
                }
            if (tankRed3 != null)
                if (tankRed3.getDispose() && tankRed3.getBullet() == null) {
                    tankRed3.clear();
                    if (tankRed3.getBullet() == null)
                        tankRed3 = new Tank(stage, tr3, "down", ctr4, grid);
                } else {
                    tankRed3.render(v);
                }

            if (tankUser != null)
                if (tankUser.getDispose() && tankUser.getBullet() == null) {
                    tankUser.clear();
                    if (tankUser.getBullet() == null)
                        tankUser = new Tank(stage, tru, "left", ctr1, grid);
                } else {
                    tankUser.render(v);
                }
        }
        if (GameScreen.TEAM_TYPE == 0) {
            if (tankBlue1 != null)
                if (tankBlue1.getDispose() && tankBlue1.getBullet() == null) {
                    tankBlue1.clear();
                    if (tankBlue1.getBullet() == null)
                        tankBlue1 = new Tank(stage, tru, "right", ctb1, grid);
                } else {
                    tankBlue1.render(v);
                }
            if (tankBlue2 != null)
                if (tankBlue2.getDispose() && tankBlue2.getBullet() == null) {
                    tankBlue2.clear();
                    if (tankBlue2.getBullet() == null)
                        tankBlue2 = new Tank(stage, tr1, "right", ctb2, grid);
                } else {
                    tankBlue2.render(v);
                }
            if (tankBlue3 != null)
                if (tankBlue3.getDispose() && tankBlue3.getBullet() == null) {
                    tankBlue3.clear();
                    if (tankBlue3.getBullet() == null)
                        tankBlue3 = new Tank(stage, tr2, "upb", ctb3, grid);
                } else {
                    tankBlue3.render(v);
                }
            if (tankBlue4 != null)
                if (tankBlue4.getDispose() && tankBlue4.getBullet() == null) {
                    tankBlue4.clear();
                    if (tankBlue4.getBullet() == null)
                        tankBlue4 = new Tank(stage, tr3, "upb", ctb4, grid);
                } else {
                    tankBlue4.render(v);
                }


            if (tankRed1 != null)
                if (tankRed1.getDispose() && tankRed1.getBullet() == null) {
                    tankRed1.clear();
                    if (tankRed1.getBullet() == null)
                        tankRed1 = new Tank(stage, tb1, "left", ctr2, grid);
                } else {
                    tankRed1.render(v);
                }
            if (tankRed2 != null)
                if (tankRed2.getDispose() && tankRed2.getBullet() == null) {
                    tankRed2.clear();
                    if (tankRed2.getBullet() == null)
                        tankRed2 = new Tank(stage, tb2, "down", ctr3, grid);
                } else {
                    tankRed2.render(v);
                }
            if (tankRed3 != null)
                if (tankRed3.getDispose() && tankRed3.getBullet() == null) {
                    tankRed3.clear();
                    if (tankRed3.getBullet() == null)
                        tankRed3 = new Tank(stage, tb3, "down", ctr4, grid);
                } else {
                    tankRed3.render(v);
                }

            if (tankUser != null)
                if (tankUser.getDispose() && tankUser.getBullet() == null) {
                    tankUser.clear();
                    if (tankUser.getBullet() == null)
                        tankUser = new Tank(stage, tbu, "left", ctr1, grid);
                } else {
                    tankUser.render(v);
                }
        }

    }
}



