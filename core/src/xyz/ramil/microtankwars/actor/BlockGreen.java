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


