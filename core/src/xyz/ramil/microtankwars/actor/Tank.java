package xyz.ramil.microtankwars.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Random;

import xyz.ramil.microtankwars.MicroTankWarsGame;
import xyz.ramil.microtankwars.ai.ArtificialIntelligence;
import xyz.ramil.microtankwars.screen.GameScreen;

public class Tank {


    private ArtificialIntelligence artificialIntelligence_;

    private Bullet bullet;

    private Integer position;
    private String direction;
    private Color type;
    private Grid grid;
    private boolean left, right, upb, down;

    private int[] moveBuffer = new int[25];

    private boolean move = true;
    private float seconds = 0f;

    private boolean isIce = false;

    private boolean dispose = false;

    private boolean respawn = true;

    private float ping;

    private float respawn_time;

    private Sound firewav;
    private Sound tank_desposewav;

    private Tank tank = null;

    private String typeStr;

    public Tank(Stage stage, Integer position, String direction, Color type, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.type = type;
        this.grid = grid;

        firewav = Gdx.audio.newSound(Gdx.files.internal("sound/fire.wav"));
        tank_desposewav = Gdx.audio.newSound(Gdx.files.internal("sound/tank_despose.wav"));

        if (direction.equals("right")) {
            right = true;
            left = false;
            upb = false;
            down = false;
        }
        if (direction.equals("upb")) {
            right = false;
            left = false;
            upb = true;
            down = false;
        }
        if (direction.equals("left")) {
            right = false;
            left = true;
            upb = false;
            down = false;
        }
        if (direction.equals("down")) {
            right = false;
            left = false;
            upb = false;
            down = true;
        }

        typeStr = type.toString();

        if (type.equals(GameScreen.USER_TANK_COLOR_RED) || type.equals(GameScreen.USER_TANK_COLOR_BLUE)
                || type.equals(GameScreen.RESPAWN_USER_BLUE_COLOR) || type.equals(GameScreen.RESPAWN_USER_RED_COLOR)
        ) {
            move = false;
            GameScreen.userControl.setTankUser(this);
        }
        tankFactory();

    }


    public String getTypeStr() {
        return typeStr;
    }

    private void tankFactory() {
        int z = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = position; j < position + 5; j++) {
                moveBuffer[z] = j;
                z++;
            }
            position = position + 72;
        }
        initTankColor(type);
    }

    private void initTankColor(Color type) {

        if (!respawn) {
            for (int i = 0; i < moveBuffer.length; i++) {
                if (right) {
                    if (i != 5 && i != 10 && i != 15 && i != 9 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }

                if (left) {
                    if (i != 5 && i != 15 && i != 9 && i != 14 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }

                if (upb) {
                    if (i != 1 && i != 3 && i != 21 && i != 22 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }

                if (down) {
                    if (i != 1 && i != 2 && i != 3 && i != 21 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }
            }
        } else {

            for (int i = 0; i < moveBuffer.length; i++) {
                if (right) {
                    if (i != 5 && i != 10 && i != 15 && i != 9 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }

                    }
                }

                if (left) {
                    if (i != 5 && i != 15 && i != 9 && i != 14 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }
                    }
                }

                if (upb) {
                    if (i != 1 && i != 3 && i != 21 && i != 22 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }
                    }
                }

                if (down) {
                    if (i != 1 && i != 2 && i != 3 && i != 21 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }
                    }
                }
            }

        }
    }

    private void tank(boolean movetank) {
        if (right && movetank) {
            position = position + 1;
        } else if (left && movetank) {
            position = position - 1;
        } else if (upb && movetank) {
            position = position - 72;
        } else if (down && movetank) {
            position = position + 72;
        }


        for (int value : moveBuffer) {
            if (value != 0) {
                grid.table[value].setColor(Color.CLEAR);
            }
        }

        if (right) {
            if ((!grid.table[moveBuffer[4] + 1].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[9] + 1].getColor().equals(Color.CLEAR)) &&
                    (!grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (!grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (grid.table[moveBuffer[24] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[24] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[23] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[22] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[22] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[22] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[21] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[20] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position + 72;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] + 72;
                }
            }
            if ((grid.table[moveBuffer[4] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (!grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (!grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[24] + 1].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[19] + 1].getColor().equals(Color.CLEAR)) &&
                    (grid.table[moveBuffer[4] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[3] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[2] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[2] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[2] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[1] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[0] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position - 72;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] - 72;
                }
            }
            if (!direction.equals("right")) {
                direction = "right";

                position = position - 72 * 5;
                int z = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = position; j < position + 5; j++) {
                        moveBuffer[z] = j;
                        z++;
                    }
                    position = position + 72;
                }
            } else {
                for (int i = 0; i < moveBuffer.length; i++) {
                    if (movetank)
                        moveBuffer[i] = moveBuffer[i] + 1;
                }
            }
        }

        if (upb) {
            if ((!grid.table[moveBuffer[0] - 72].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[1] - 72].getColor().equals(Color.CLEAR)) &&
                    (!grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (!grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (grid.table[moveBuffer[4] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[4] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[9] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[14] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[14] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[14] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[19] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[24] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position + 1;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] + 1;
                }
            }
            if ((grid.table[moveBuffer[0] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[4] - 72].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[3] - 72].getColor().equals(Color.CLEAR)) &&
                    (!grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (!grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (grid.table[moveBuffer[0] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[5] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[10] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[10] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[10] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[15] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[20] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position - 1;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] - 1;
                }
            }
            if (!direction.equals("upd")) {
                direction = "upd";
                position = position - 72 * 5;
                int z = 0;
                for (int i = 0; i < 5; i++) {

                    for (int j = position; j < position + 5; j++) {
                        moveBuffer[z] = j;
                        z++;

                    }
                    position = position + 72;
                }
            } else {
                for (int i = 0; i < moveBuffer.length; i++) {
                    if (movetank)
                        moveBuffer[i] = moveBuffer[i] - 72;
                }
            }
        }

        if (left) {

            if ((!grid.table[moveBuffer[0] - 1].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[5] - 1].getColor().equals(Color.CLEAR)) &&
                    (!grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (!grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (grid.table[moveBuffer[20] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[20] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[21] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[22] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[22] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[22] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[23] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[24] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position + 72;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] + 72;
                }
            }
            if ((grid.table[moveBuffer[0] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[0] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[0] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[1] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[1] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[2] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[2] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[2] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[3] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[3] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[4] - 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[4] - 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[20] - 1].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[15] - 1].getColor().equals(Color.CLEAR)) &&
                    (!grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (!grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (!grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position - 72;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] - 72;
                }
            }
            if (!direction.equals("left")) {
                direction = "left";
                //   moveBuffer.clear();
                position = position - 72 * 5;
                int z = 0;
                for (int i = 0; i < 5; i++) {

                    for (int j = position; j < position + 5; j++) {
                        moveBuffer[z] = j;
                        z++;

                    }
                    position = position + 72;
                }
            } else {

                for (int i = 0; i < moveBuffer.length; i++) {

                    if (movetank)
                        moveBuffer[i] = moveBuffer[i] - 1;
                }

            }
        }

        if (down) {

            if ((!grid.table[moveBuffer[20] + 72].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[21] + 72].getColor().equals(Color.CLEAR)) &&
                    (!grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (!grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[21] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (grid.table[moveBuffer[24] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[24] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[24] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[19] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[19] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[14] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[14] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[14] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[9] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[9] + 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[4] + 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[4] + 1].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position + 1;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] + 1;
                }
            }
            if ((grid.table[moveBuffer[20] + 72].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[20] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_RED) || !grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.FLAG_RED)) &&
                    (!grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.FLAG_BLUE) || !grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (!grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0) || !grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR0)) &&
                    (!grid.table[moveBuffer[24] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1) || !grid.table[moveBuffer[23] + 72].getColor().equals(GameScreen.RESPAWN_BLOCK_COLOR1)) &&
                    (!grid.table[moveBuffer[24] + 72].getColor().equals(Color.CLEAR) || !grid.table[moveBuffer[23] + 72].getColor().equals(Color.CLEAR)) &&
                    (grid.table[moveBuffer[20] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[20] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[15] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[15] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[10] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[10] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[10] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[5] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[5] - 1].getColor().equals(GameScreen.FLAG_BLUE)) &&
                    (grid.table[moveBuffer[0] - 1].getColor().equals(Color.CLEAR) || grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_RED) || grid.table[moveBuffer[0] - 1].getColor().equals(GameScreen.FLAG_BLUE))) {
                position = position - 1;
                for (int i = 0; i < moveBuffer.length; i++) {
                    moveBuffer[i] = moveBuffer[i] - 1;
                }
            }
            if (!direction.equals("down")) {
                direction = "down";
                position = position - 72 * 5;
                int z = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = position; j < position + 5; j++) {
                        moveBuffer[z] = j;
                        z++;
                    }
                    position = position + 72;
                }
            } else {
                for (int i = 0; i < moveBuffer.length; i++) {

                    if (movetank)
                        moveBuffer[i] = moveBuffer[i] + 72;
                }
            }
        }

        if (!respawn) {
            for (int i = 0; i < moveBuffer.length; i++) {
                if (right) {
                    if (i != 5 && i != 10 && i != 15 && i != 9 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }

                if (left) {
                    if (i != 5 && i != 15 && i != 9 && i != 14 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }

                if (upb) {
                    if (i != 1 && i != 3 && i != 21 && i != 22 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }

                if (down) {
                    if (i != 1 && i != 2 && i != 3 && i != 21 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN))
                            grid.table[(moveBuffer[i])].setColor(type);
                    }
                }
            }
        } else {

            for (int i = 0; i < moveBuffer.length; i++) {
                if (right) {
                    if (i != 5 && i != 10 && i != 15 && i != 9 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }

                    }
                }

                if (left) {
                    if (i != 5 && i != 15 && i != 9 && i != 14 && i != 19) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }
                    }
                }

                if (upb) {
                    if (i != 1 && i != 3 && i != 21 && i != 22 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }
                    }
                }

                if (down) {
                    if (i != 1 && i != 2 && i != 3 && i != 21 && i != 23) {
                        if (!grid.table[(moveBuffer[i])].getColor().equals(Color.BROWN)) {
                            if (type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.USER_TANK_COLOR_RED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_USER_RED_COLOR);
                            }
                            if (type.equals(GameScreen.COLORBLUE)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_BLUE_COLOR);
                            }
                            if (type.equals(GameScreen.COLORRED)) {
                                grid.table[(moveBuffer[i])].setColor(GameScreen.RESPAWN_RED_COLOR);
                            }
                        }
                    }
                }
            }
        }
    }

    public void render(float v) {

        if (bullet != null) {

            if (bullet.getDestory()) {
                bullet.clear();
                bullet = null;

            } else bullet.render(v);
        }

        if (!dispose) {

            if (respawn) {

                if (!move) {
                    initTankColor(type);
                }

                respawn_time += v;

                if (respawn_time > 3) {
                    respawn = false;

                }
            }


            float speed = 0.04f;


            if (!respawn) {

                initTankColor(type);

                for (int value : moveBuffer) {
                    if (grid.table[value].getColor().equals(Color.BROWN)) {
                        disposeSound();

                        move = false;

                        for (final int finalJ : moveBuffer) {

                            if (finalJ != 0) {
                                grid.table[(finalJ)].setColor(Color.CLEAR);
                            }
                            dispose = true;
                        }
                    }
                }

            }

            ping += v;
            if (artificialIntelligence_ != null) {
                artificialIntelligence_.control(v);
                if (ping >= 0.2) {
                    if (!respawn) {
                        if (bullet == null)
                            searchForEnemies(v);
                    }
                    ping = 0;
                }
            }

            if (move) {
                seconds += v;
                if (seconds >= speed) {
                    boolean isMove = false;
                    if (right) {
                        if ((moveBuffer[4] + 1) < GameScreen.ARRAY_SIZE && (moveBuffer[8] + 1) < GameScreen.ARRAY_SIZE && (moveBuffer[14] + 1) < GameScreen.ARRAY_SIZE &&
                                (moveBuffer[18] + 1) < GameScreen.ARRAY_SIZE && (moveBuffer[24] + 1) < GameScreen.ARRAY_SIZE)
                            if (grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.WOOD_COLOR) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.FLAG_BLUE) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.FLAG_RED) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.BRICK_COLOR) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.COLORRED) ||

                                    grid.table[(moveBuffer[4] + 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[8] + 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[18] + 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[24] + 1)].getColor().equals(GameScreen.COLORBLUE)) {
                                tank(false);
                                isMove = false;
                                random();
                            } else {
                                tank(true);
                                isMove = true;
                            }

                    }
                    if (left) {
                        if ((moveBuffer[0] - 1) > 0 && (moveBuffer[6] - 1) > 0 && (moveBuffer[10] - 1) > 0 &&
                                (moveBuffer[16] - 1) > 0 && (moveBuffer[20] - 1) > 0)

                            if (grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.WOOD_COLOR) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.FLAG_RED) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.FLAG_BLUE) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.BRICK_COLOR) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.COLORRED) ||

                                    grid.table[(moveBuffer[0] - 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[6] - 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[16] - 1)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[20] - 1)].getColor().equals(GameScreen.COLORBLUE)) {
                                tank(false);
                                isMove = false;
                                random();
                            } else {
                                tank(true);
                                isMove = true;
                            }
                    }

                    if (upb) {
                        if ((moveBuffer[0] - 72) > 0 && (moveBuffer[6] - 72) > 0 && (moveBuffer[2] - 72) > 0 &&
                                (moveBuffer[8] - 72) > 0 && (moveBuffer[4] - 72) > 0)
                            if (grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.WOOD_COLOR) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.FLAG_BLUE) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.FLAG_RED) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.BRICK_COLOR) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.COLORRED) ||

                                    grid.table[(moveBuffer[0] - 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[6] - 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[2] - 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[8] - 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[4] - 72)].getColor().equals(GameScreen.COLORBLUE)) {
                                tank(false);
                                isMove = false;
                                random();
                            } else {
                                tank(true);
                                isMove = true;
                            }
                    }
                    if (down) {
                        if ((moveBuffer[20] + 72) < GameScreen.ARRAY_SIZE && (moveBuffer[16] + 72) < GameScreen.ARRAY_SIZE && (moveBuffer[22] + 72) < GameScreen.ARRAY_SIZE &&
                                (moveBuffer[18] + 72) < GameScreen.ARRAY_SIZE && (moveBuffer[24] + 72) < GameScreen.ARRAY_SIZE)

                            if (grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.WOOD_COLOR) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.WOOD_COLOR) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_RED) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.RESPAWN_USER_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.RESPAWN_USER_RED_COLOR) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.RESPAWN_RED_COLOR) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.RESPAWN_BLUE_COLOR) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.FLAG_RED) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.FLAG_RED) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.FLAG_BLUE) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.FLAG_BLUE) ||


                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.BRICK_COLOR) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.BRICK_COLOR) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.COLORRED) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.COLORRED) ||

                                    grid.table[(moveBuffer[20] + 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[16] + 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[22] + 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[18] + 72)].getColor().equals(GameScreen.COLORBLUE) ||
                                    grid.table[(moveBuffer[24] + 72)].getColor().equals(GameScreen.COLORBLUE)) {
                                tank(false);
                                isMove = false;
                                random();
                            } else {
                                tank(true);
                                isMove = true;
                            }
                    }

                    seconds = 0;
                }
            }
        }
    }

    private void searchForEnemies(float v) {

        int up = moveBuffer[12];
        int down = moveBuffer[12];
        int left = moveBuffer[12];
        int right = moveBuffer[12];
        if (type.equals(GameScreen.COLORRED)) {

            for (int z = 0; z < 68; z++) {
                if (!grid.table[up].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_RED)) {

                    if (up > 72) {
                        up = up - 72;
                    }

                    if (up > 0) {

                        if (grid.table[up].getColor().equals(GameScreen.COLORBLUE) || grid.table[up].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) || grid.table[up].getColor().equals(GameScreen.FLAG_BLUE)) {

                            this.right = (false);
                            this.left = (false);
                            this.upb = (true);
                            this.down = (false);
                            tank(false);
                            fire();
                            break;
                        }
                    }
                }
                if (!grid.table[down].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_RED)) {

                    if (down < 5184 - 72) {
                        down = down + 72;
                    }

                    if (down < 5184) {

                        if (grid.table[down].getColor().equals(GameScreen.COLORBLUE) || grid.table[down].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) || grid.table[down].getColor().equals(GameScreen.FLAG_BLUE)) {

                            this.right = (false);
                            this.left = (false);
                            this.upb = (false);
                            this.down = (true);
                            tank(false);
                            fire();
                            break;
                        }
                    }
                }
                if (!grid.table[right].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_RED)) {

                    if (right < 5184 - 1) {
                        right = right + 1;
                    }
                    if (right < 5184) {

                        if (grid.table[right].getColor().equals(GameScreen.COLORBLUE) || grid.table[right].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) || grid.table[right].getColor().equals(GameScreen.FLAG_BLUE)) {

                            this.right = (true);
                            this.left = (false);
                            this.upb = (false);
                            this.down = (false);
                            tank(false);
                            fire();
                            break;
                        }
                    }
                }
                if (!grid.table[left].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_RED)) {
                    if (left > 1) {
                        left = left - 1;
                    }
                    if (left > 0) {

                        if (grid.table[left].getColor().equals(GameScreen.COLORBLUE) || grid.table[left].getColor().equals(GameScreen.USER_TANK_COLOR_BLUE) || grid.table[left].getColor().equals(GameScreen.FLAG_BLUE)) {

                            this.right = (false);
                            this.left = true;
                            this.upb = (false);
                            this.down = (false);
                            tank(false);
                            fire();

                            break;
                        }
                    }
                }
            }
        }


        if (type.equals(GameScreen.COLORBLUE)) {

            for (int z = 0; z < 68; z++) {
                if (!grid.table[up].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_BLUE)) {

                    if (up > 72) {
                        up = up - 72;
                    }

                    if (up > 0) {

                        if (grid.table[up].getColor().equals(GameScreen.COLORRED) || grid.table[up].getColor().equals(GameScreen.USER_TANK_COLOR_RED) || grid.table[up].getColor().equals(GameScreen.FLAG_RED)) {

                            this.right = (false);
                            this.left = (false);
                            this.upb = (true);
                            this.down = (false);
                            tank(false);
                            fire();
                            break;
                        }
                    }
                }
                if (!grid.table[down].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_BLUE)) {

                    if (down < 5184 - 72) {
                        down = down + 72;
                    }

                    if (down < 5184) {

                        if (grid.table[down].getColor().equals(GameScreen.COLORRED) || grid.table[down].getColor().equals(GameScreen.USER_TANK_COLOR_RED) || grid.table[down].getColor().equals(GameScreen.FLAG_RED)) {

                            this.right = (false);
                            this.left = (false);
                            this.upb = (false);
                            this.down = (true);
                            tank(false);
                            fire();
                            break;
                        }
                    }
                }
                if (!grid.table[right].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_BLUE)) {

                    if (right < 5184 - 1) {
                        right = right + 1;
                    }
                    if (right < 5184) {

                        if (grid.table[right].getColor().equals(GameScreen.COLORRED) || grid.table[right].getColor().equals(GameScreen.USER_TANK_COLOR_RED) || grid.table[right].getColor().equals(GameScreen.FLAG_RED)) {

                            this.right = (true);
                            this.left = (false);
                            this.upb = (false);
                            this.down = (false);
                            tank(false);
                            fire();
                            break;
                        }
                    }
                }
                if (!grid.table[left].getColor().equals(GameScreen.BRICK_COLOR) && !grid.table[up].getColor().equals(GameScreen.FLAG_BLUE)) {
                    if (left > 1) {
                        left = left - 1;
                    }
                    if (left > 0) {

                        if (grid.table[left].getColor().equals(GameScreen.COLORRED) || grid.table[left].getColor().equals(GameScreen.USER_TANK_COLOR_RED) || grid.table[left].getColor().equals(GameScreen.FLAG_RED)) {
                            this.right = (false);
                            this.left = true;
                            this.upb = (false);
                            this.down = (false);
                            tank(false);
                            fire();

                            break;
                        }
                    }
                }
            }
        }
    }

    public void fire() {


        if (right && bullet == null && !dispose) {
            if (!grid.table[(moveBuffer[14] + 1)].getColor().equals(GameScreen.BRICK_COLOR) &&
                    !grid.table[(moveBuffer[14] + 2)].getColor().equals(GameScreen.BRICK_COLOR) &&
                    !grid.table[(moveBuffer[14] + 3)].getColor().equals(GameScreen.BRICK_COLOR)) {

                bullet = new Bullet(moveBuffer[14] + 2, 1, type, grid);
                if (MicroTankWarsGame.preferences.getBoolean("sound"))
                    firewav.play();
            }
        }

        if (left && bullet == null && !dispose) {
            if ((moveBuffer[10] - 2) > 0) {
                if (!grid.table[(moveBuffer[10] - 1)].getColor().equals(GameScreen.BRICK_COLOR) &&
                        !grid.table[(moveBuffer[10] - 2)].getColor().equals(GameScreen.BRICK_COLOR) &&
                        !grid.table[(moveBuffer[10] - 3)].getColor().equals(GameScreen.BRICK_COLOR)) {
                    bullet = new Bullet(moveBuffer[10] - 2, 3, type, grid);
                    if (MicroTankWarsGame.preferences.getBoolean("sound"))
                        firewav.play();
                }
            }
        }
        if (down && bullet == null && !dispose) {
            if ((moveBuffer[22] + 72 * 3) < GameScreen.ARRAY_SIZE)
                if (!grid.table[(moveBuffer[22] + 1 * 72)].getColor().equals(GameScreen.BRICK_COLOR) &&
                        !grid.table[(moveBuffer[22] + 2 * 72)].getColor().equals(GameScreen.BRICK_COLOR) &&
                        !grid.table[(moveBuffer[22] + 3 * 72)].getColor().equals(GameScreen.BRICK_COLOR)) {
                    bullet = new Bullet(moveBuffer[22] + 72 * 2, 2, type, grid);
                    if (MicroTankWarsGame.preferences.getBoolean("sound"))
                        firewav.play();
                }
        }

        if (upb && bullet == null && !dispose) {
            if ((moveBuffer[2] - 72 * 3) > 0)
                if (!grid.table[(moveBuffer[2] - 1 * 72)].getColor().equals(GameScreen.BRICK_COLOR) &&
                        !grid.table[(moveBuffer[2] - 2 * 72)].getColor().equals(GameScreen.BRICK_COLOR) &&
                        !grid.table[(moveBuffer[2] - 3 * 72)].getColor().equals(GameScreen.BRICK_COLOR)) {
                    bullet = new Bullet(moveBuffer[2] - 72 * 2, 4, type, grid);
                    if (MicroTankWarsGame.preferences.getBoolean("sound"))
                        firewav.play();
                }
        }

    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setUpb(boolean upb) {
        this.upb = upb;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public int[] getMoveBuffer() {
        return moveBuffer;
    }

    public void clear() {

        for (int value : moveBuffer) {

            if (value != 0) {
                grid.table[value].setColor(Color.CLEAR);

            }
        }
    }

    public boolean getDispose() {
        return dispose;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public Color getType() {
        return type;
    }

    public boolean getRespawn() {
        return respawn;
    }

    private void random() {

        if (!type.equals(GameScreen.USER_TANK_COLOR_RED) && !type.equals(GameScreen.USER_TANK_COLOR_BLUE)) {

            Random random = new Random();
            int rnd = random.nextInt(9) + 1;

            if (rnd == 1 || rnd == 5) {
                this.right = (false);
                this.left = (false);
                this.upb = (true);
                this.down = (false);
            }

            if (rnd == 2 || rnd == 6) {
                this.right = (true);
                this.left = (false);
                this.upb = (false);
                this.down = (false);
            }

            if (rnd == 3 || rnd == 7) {
                this.right = (false);
                this.left = (false);
                this.upb = (false);
                this.down = (true);
            }
            if (rnd == 4 || rnd == 8) {
                this.right = (false);
                this.left = (true);
                this.upb = (false);
                this.down = (false);
            }

            if (rnd == 9) {


                tank = this;

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        final ArtificialIntelligence[] artificialIntelligence = {new ArtificialIntelligence(tank)};
                        Gdx.app.postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                artificialIntelligence_ = artificialIntelligence[0];
                                artificialIntelligence[0] = null;

                            }
                        });
                    }
                }).start();
            }
        }

    }

    private void disposeSound() {
        if (!dispose) {
            if (MicroTankWarsGame.preferences.getBoolean("sound"))
                tank_desposewav.play();
        }
    }
}
