package xyz.ramil.microtankwars.actor;

import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;

import xyz.ramil.microtankwars.screen.GameScreen;

public class BlockWood {

    private Grid grid;

    private int position;

    private boolean aCollis = false;
    private boolean eCollis = false;
    private boolean dCollis = false;
    private boolean mCollis = false;

    private Color type;

    private ArrayList<Integer> moveBuffer = new ArrayList<>();
    private ArrayList<Integer> collisionArrayList = new ArrayList<>();

    public BlockWood(Grid grid, int position, Color type) {
        this.grid = grid;
        this.type = type;
        this.position = position;

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
        initColorBlock();
    }

    private void initColorBlock() {
        for (int i = 0; i < moveBuffer.size(); i++) {
            if (!grid.table[moveBuffer.get(i)].getColor().equals(Color.BROWN))
                grid.table[moveBuffer.get(i)].setColor(type);
        }
    }
}
