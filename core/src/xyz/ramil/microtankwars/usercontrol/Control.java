package xyz.ramil.microtankwars.usercontrol;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;

import xyz.ramil.microtankwars.actor.Menu;
import xyz.ramil.microtankwars.actor.Tank;
import xyz.ramil.microtankwars.screen.GameScreen;

import static xyz.ramil.microtankwars.MicroTankWarsGame.preferences;

public class Control {

    private Image buttonLeft;
    private Image buttonRight;
    private Image buttonUp;
    private Image buttonDown;

    private Image buttonBack;

    private Image buttonSoundOn;
    private Image buttonSoundOff;

    private Image buttonTouchpad;
    private Image buttonControl;

    private Touchpad touchpad;
    private Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchSkin;

    private Image buttonAction;
    private Tank tankUser;

    private Stage stage;

    private Menu menu;


    private boolean downScroll = false;
    private boolean upScroll = false;

    public Control(Stage stage, Tank tankUser) {

        this.tankUser = tankUser;
        this.menu = null;
        this.stage = stage;

        //-----------------Touchpad------------------------
        touchSkin = new Skin();
        touchSkin.add("touchBackground", new Texture("touchpad_b.png"));
        touchSkin.add("touchKnob", new Texture("touchpad_k.png"));
        touchpadStyle = new Touchpad.TouchpadStyle();
        Drawable dtouchBackground = touchSkin.getDrawable("touchBackground");
        Drawable dtouchKnob = touchSkin.getDrawable("touchKnob");
        dtouchKnob.setMinHeight(90);
        dtouchKnob.setMinWidth(90);
        touchpadStyle.background = dtouchBackground;
        touchpadStyle.knob = dtouchKnob;
        touchpad = new Touchpad(20, touchpadStyle);
        touchpad.setBounds(47, 167, 150, 150);

        Pixmap pmap = new Pixmap(40, 40, Pixmap.Format.RGBA8888);
        pmap.setColor(Color.DARK_GRAY);
        pmap.fillRectangle(1, 1, 38, 38);

        Texture controlButtonTexture = new Texture("button_action.png");
        Texture actionButtonTexture = new Texture("button.png");
        Texture backTexture = new Texture("back.png");
        Texture soundOnTexture = new Texture("sound_on.png");
        Texture soundOffTexture = new Texture("sound_off.png");

        Texture touchpadTexture = new Texture("touchpad.png");
        Texture controlTexture = new Texture("control.png");

        buttonBack = new Image(backTexture);

        buttonSoundOn = new Image(soundOnTexture);
        buttonSoundOn.setName("sound_on");

        buttonSoundOff = new Image(soundOffTexture);
        buttonSoundOff.setName("sound_off");

        buttonTouchpad = new Image(touchpadTexture);
        buttonTouchpad.setName("touchpad");
        buttonTouchpad.setVisible(false);

        buttonControl = new Image(controlTexture);
        buttonControl.setName("control");
        buttonControl.setVisible(false);

        buttonBack.setBounds(13, 430, 40, 40);

        buttonControl.setBounds(100, 430, 40, 40);
        buttonTouchpad.setBounds(100, 430, 40, 40);

        buttonSoundOn.setBounds(188, 430, 40, 40);
        buttonSoundOn.setVisible(false);
        buttonSoundOff.setBounds(188, 430, 40, 40);
        buttonSoundOff.setVisible(false);

        if (preferences.getBoolean("sound")) {
            buttonSoundOn.setVisible(true);
        } else if (!preferences.getBoolean("sound")) {
            buttonSoundOff.setVisible(true);
        }

        buttonLeft = new Image(controlButtonTexture);

        buttonRight = new Image(controlButtonTexture);

        buttonUp = new Image(controlButtonTexture);

        buttonDown = new Image(controlButtonTexture);

        buttonAction = new Image(actionButtonTexture);

        buttonAction.setSize(100, 100);
        buttonAction.setPosition(690, 200);

        buttonLeft.setSize(72, 72);
        buttonRight.setSize(72, 72);
        buttonUp.setSize(72, 72);
        buttonDown.setSize(72, 72);

        buttonLeft.setOrigin(Align.center);
        buttonLeft.setRotation(90f);

        buttonDown.setOrigin(Align.center);
        buttonDown.setRotation(180f);

        buttonRight.setOrigin(Align.center);
        buttonRight.setRotation(270);

        buttonLeft.setPosition(13, 200);
        buttonRight.setPosition(157, 200);
        buttonUp.setPosition(85, 272);
        buttonDown.setPosition(85, 128);

        stage.addActor(buttonAction);
        stage.addActor(buttonLeft);
        stage.addActor(buttonRight);
        stage.addActor(buttonUp);
        stage.addActor(buttonDown);
        stage.addActor(buttonBack);
        stage.addActor(buttonTouchpad);
        stage.addActor(buttonControl);

        stage.addActor(buttonSoundOn);
        stage.addActor(buttonSoundOff);

        stage.addActor(touchpad);

        inputListener();

    }

    private void inputListener() {

        InputListener buttonSoundOnOfInputListener = new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);

                for (int i = 0; i < stage.getActors().size; i++) {
                    if (stage.getActors().get(i).getName() != null) {
                        if (stage.getActors().get(i).getName().equals("sound_off")) {
                            if (stage.getActors().get(i).isVisible()) {
                                stage.getActors().get(i).setVisible(false);
                                preferences.putBoolean("sound", true);
                                preferences.flush();

                            } else {
                                stage.getActors().get(i).setVisible(true);
                                preferences.putBoolean("sound", false);
                                preferences.flush();
                            }

                        }
                        if (stage.getActors().get(i).getName().equals("sound_on")) {
                            if (stage.getActors().get(i).isVisible()) {
                                stage.getActors().get(i).setVisible(false);
                                preferences.putBoolean("sound", false);
                                preferences.flush();
                            } else {
                                stage.getActors().get(i).setVisible(true);
                                preferences.putBoolean("sound", true);
                                preferences.flush();
                            }

                        }
                    }
                }
                buttonSoundOff.setColor(buttonSoundOff.getColor().r, buttonSoundOff.getColor().g, buttonSoundOff.getColor().b, 1);
                buttonSoundOn.setColor(buttonSoundOn.getColor().r, buttonSoundOn.getColor().g, buttonSoundOn.getColor().b, 1);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                buttonSoundOff.setColor(buttonSoundOff.getColor().r, buttonSoundOff.getColor().g, buttonSoundOff.getColor().b, 0.5f);
                buttonSoundOn.setColor(buttonSoundOn.getColor().r, buttonSoundOn.getColor().g, buttonSoundOn.getColor().b, 0.5f);
                return true;
            }
        };

        InputListener buttonControlOnOfInputListener = new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);

                for (int i = 0; i < stage.getActors().size; i++) {
                    if (stage.getActors().get(i).getName() != null) {
                        if (stage.getActors().get(i).getName().equals("control")) {
                            if (stage.getActors().get(i).isVisible()) {
                                stage.getActors().get(i).setVisible(false);
                                preferences.putBoolean("control", true);
                                preferences.flush();

                            } else {
                                stage.getActors().get(i).setVisible(true);
                                preferences.putBoolean("control", false);
                                preferences.flush();
                            }

                        }
                        if (stage.getActors().get(i).getName().equals("touchpad")) {
                            if (stage.getActors().get(i).isVisible()) {
                                stage.getActors().get(i).setVisible(false);
                                preferences.putBoolean("control", false);
                                preferences.flush();
                            } else {
                                stage.getActors().get(i).setVisible(true);
                                preferences.putBoolean("control", true);
                                preferences.flush();
                            }

                        }
                    }
                }
                buttonControl.setColor(buttonControl.getColor().r, buttonControl.getColor().g, buttonControl.getColor().b, 1);
                buttonTouchpad.setColor(buttonTouchpad.getColor().r, buttonTouchpad.getColor().g, buttonTouchpad.getColor().b, 1f);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                buttonControl.setColor(buttonControl.getColor().r, buttonControl.getColor().g, buttonControl.getColor().b, 0.5f);
                buttonTouchpad.setColor(buttonTouchpad.getColor().r, buttonTouchpad.getColor().g, buttonTouchpad.getColor().b, 0.5f);
                return true;
            }
        };

        buttonSoundOff.addListener(buttonSoundOnOfInputListener);
        buttonSoundOn.addListener(buttonSoundOnOfInputListener);

        buttonControl.addListener(buttonControlOnOfInputListener);
        buttonTouchpad.addListener(buttonControlOnOfInputListener);

        buttonBack.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);

                GameScreen.CLOSE_VICTORY = true;

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

                buttonBack.setColor(buttonBack.getColor().r, buttonBack.getColor().g, buttonBack.getColor().b, 1);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                buttonBack.setColor(buttonBack.getColor().r, buttonBack.getColor().g, buttonBack.getColor().b, 0.5f);
                return true;
            }
        });

        buttonRight.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (tankUser != null)
                    tankUser.setMove(false);
                buttonRight.setColor(buttonRight.getColor().r, buttonRight.getColor().g, buttonRight.getColor().b, 1);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                if (tankUser != null) {
                    tankUser.setMove(true);
                    tankUser.setRight(true);
                    tankUser.setLeft(false);
                    tankUser.setUpb(false);
                    tankUser.setDown(false);
                }
                buttonRight.setColor(buttonRight.getColor().r, buttonRight.getColor().g, buttonRight.getColor().b, 0.5f);
                return true;
            }
        });
        buttonLeft.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (tankUser != null)
                    tankUser.setMove(false);
                buttonLeft.setColor(buttonLeft.getColor().r, buttonLeft.getColor().g, buttonLeft.getColor().b, 1);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (tankUser != null) {
                    tankUser.setMove(true);
                    tankUser.setRight(false);
                    tankUser.setLeft(true);
                    tankUser.setUpb(false);
                    tankUser.setDown(false);
                }
                buttonLeft.setColor(buttonLeft.getColor().r, buttonLeft.getColor().g, buttonLeft.getColor().b, 0.5f);
                return true;
            }
        });
        buttonUp.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (tankUser != null)
                    tankUser.setMove(false);
                buttonUp.setColor(buttonUp.getColor().r, buttonUp.getColor().g, buttonUp.getColor().b, 1f);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (tankUser != null) {
                    tankUser.setMove(true);
                    tankUser.setRight(false);
                    tankUser.setLeft(false);
                    tankUser.setUpb(true);
                    tankUser.setDown(false);
                }

                buttonUp.setColor(buttonUp.getColor().r, buttonUp.getColor().g, buttonUp.getColor().b, 0.5f);
                return true;
            }
        });
        buttonDown.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (tankUser != null)
                    tankUser.setMove(false);
                buttonDown.setColor(buttonDown.getColor().r, buttonDown.getColor().g, buttonDown.getColor().b, 1f);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (tankUser != null) {
                    tankUser.setMove(true);
                    tankUser.setRight(false);
                    tankUser.setLeft(false);
                    tankUser.setUpb(false);
                    tankUser.setDown(true);
                }

                buttonDown.setColor(buttonDown.getColor().r, buttonDown.getColor().g, buttonDown.getColor().b, 0.5f);
                return true;
            }

        });

        buttonAction.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);

                buttonAction.setColor(buttonAction.getColor().r, buttonAction.getColor().g, buttonAction.getColor().b, 1f);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (tankUser != null)
                    if (!tankUser.getRespawn())
                        tankUser.fire();
                buttonAction.setColor(buttonAction.getColor().r, buttonAction.getColor().g, buttonAction.getColor().b, 0.5f);
                return true;

            }
        });
    }

    public void render() {


        if (preferences.getBoolean("control")) {
            buttonTouchpad.setVisible(true);
            buttonControl.setVisible(false);

            buttonDown.setVisible(true);
            buttonUp.setVisible(true);
            buttonLeft.setVisible(true);
            buttonRight.setVisible(true);

            touchpad.setVisible(false);

        } else if (!preferences.getBoolean("control")) {
            buttonTouchpad.setVisible(false);
            buttonControl.setVisible(true);

            buttonDown.setVisible(false);
            buttonUp.setVisible(false);
            buttonLeft.setVisible(false);
            buttonRight.setVisible(false);

            touchpad.setVisible(true);
        }

        if (!buttonRight.isVisible()) {


            if (tankUser != null) {

                if (touchpad.getKnobPercentY() < -0.6f) {

                    tankUser.setMove(true);
                    tankUser.setRight(false);
                    tankUser.setLeft(false);
                    tankUser.setUpb(false);
                    tankUser.setDown(true);
                } else if (touchpad.getKnobPercentY() > 0.6f) {

                    tankUser.setMove(true);
                    tankUser.setRight(false);
                    tankUser.setLeft(false);
                    tankUser.setUpb(true);
                    tankUser.setDown(false);

                } else if (touchpad.getKnobPercentX() > 0.4f) {

                    tankUser.setMove(true);
                    tankUser.setRight(true);
                    tankUser.setLeft(false);
                    tankUser.setUpb(false);
                    tankUser.setDown(false);

                } else if (touchpad.getKnobPercentX() < -0.4f) {

                    tankUser.setMove(true);
                    tankUser.setRight(false);
                    tankUser.setLeft(true);
                    tankUser.setUpb(false);
                    tankUser.setDown(false);

                } else {
                    tankUser.setMove(false);

                }
            }

        }

//        if(tankUser != null)
//        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//            tankUser.setMove(true);
//            tankUser.setRight(false);
//            tankUser.setLeft(false);
//            tankUser.setUpb(true);
//            tankUser.setDown(false);
//        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//            tankUser.setMove(true);
//            tankUser.setRight(false);
//            tankUser.setLeft(false);
//            tankUser.setUpb(false);
//            tankUser.setDown(true);
//        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            tankUser.setMove(true);
//            tankUser.setRight(false);
//            tankUser.setLeft(true);
//            tankUser.setUpb(false);
//            tankUser.setDown(false);
//        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            tankUser.setMove(true);
//            tankUser.setRight(true);
//            tankUser.setLeft(false);
//            tankUser.setUpb(false);
//            tankUser.setDown(false);
//        } else {
//            tankUser.setMove(false);
//        }
//
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            if(!tankUser.getRespawn())
//            tankUser.fire();
//        }
    }

    public void setTankUser(Tank tankUser) {
        this.tankUser = tankUser;
    }


}
