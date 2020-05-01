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

package xyz.ramil.microtankwars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import xyz.ramil.microtankwars.screen.GameScreen;

public class MicroTankWarsGame extends Game {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 480;
    public static Preferences preferences;
    public static Sound click;
    private static float X_ASPECT;
    private static float Y_ASPECT;
    //camera & stage init
    private Stage stage;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private StretchViewport viewp;

    public MicroTankWarsGame() {


    }

    @Override
    public void create() {
        preferences = Gdx.app.getPreferences("microtankwars");


        if (!preferences.contains("numberoftanksdestroyed")) {
            preferences.putInteger("numberoftanksdestroyed", 0);
            preferences.flush();
        }


        if (!preferences.contains("numberofflagsdestroyed")) {
            preferences.putInteger("numberofflagsdestroyed", 0);
            preferences.flush();
        }

        if (!preferences.contains("sound")) {
            preferences.putBoolean("sound", false);
            preferences.flush();
        }


        if (!preferences.contains("highscore")) {
            preferences.putInteger("highscore", 0);
            preferences.flush();
        }

        if (!preferences.contains("control")) {
            preferences.putBoolean("control", false);
            preferences.flush();
        }

        click = Gdx.audio.newSound(Gdx.files.internal("sound/select.wav"));


        initializeView();
        setScreen(new GameScreen(this, stage));

    }

    private void initializeView() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        batch = new SpriteBatch();
        viewp = new StretchViewport(WIDTH, HEIGHT, camera);
        batch = new SpriteBatch();
        stage = new Stage(viewp, batch);
        X_ASPECT = stage.getWidth() / Gdx.graphics.getWidth();
        Y_ASPECT = stage.getHeight() / Gdx.graphics.getHeight();


    }


    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewp.update(width, height);
        stage.getViewport().update(width, height, true);

    }
}
