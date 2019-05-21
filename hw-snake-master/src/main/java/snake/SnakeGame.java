package snake;

import engine.Difficulty;
import engine.GameWorld;

import java.util.Scanner;

import javafx.animation.AnimationTimer;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import javafx.stage.Stage;

import model.Direction;

/**
 * The main entry point for the snake program. This class handles all graphics
 * not related to the actual game (i.e the start screen and score screen), user
 * input for each screen, etc. Also handles the updating of world on a timed
 * interval.
 *
 * @author  Susanna Dong, Jim Harris
 * @version 1.0
 */
public class SnakeGame extends Application {

    private Stage window;
    private Scene startScene;
    private Scene gameScene;
    private Scene scoreScene;
    private ToggleGroup gameMode;
    private int finalScore;
    private GameWorld world;
    private long lastUpdateTime;

    public static final int SCREEN_WIDTH = 512;
    public static final int TILE_WIDTH = 32;

    @Override
    public void start(Stage stage) {
        finalScore = 0;
        window = stage;
        gameMode = new ToggleGroup();
        setupStartScene();
        window.setScene(startScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Sets startScene and adds elements to it. startScene is composed of:
     *     1) A title label
     *     2) A group of radio buttons for setting the game mode
     *     3) A button that when pressed will call setupGameScene and call play
     */
    private void setupStartScene() {
        Label label = new Label("SNAKE");
        label.setFont(new Font(54));

        RadioButton easy = new RadioButton("Easy");
        easy.setUserData(Difficulty.EASY);
        easy.setToggleGroup(gameMode);

        RadioButton normal = new RadioButton("Normal");
        normal.setUserData(Difficulty.NORMAL);
        normal.setToggleGroup(gameMode);
        normal.setSelected(true);

        RadioButton hard = new RadioButton("Hard");
        hard.setUserData(Difficulty.HARD);
        hard.setToggleGroup(gameMode);

        HBox hbox = new HBox(100);
        hbox.getChildren().addAll(easy, normal, hard);
        hbox.setAlignment(Pos.CENTER);

        Button start = new Button("Start");
        start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                setupGameScene();
                window.setScene(gameScene);
                play();
            }
        });

        VBox vbox = new VBox(150);
        vbox.getChildren().addAll(label, hbox, start);
        vbox.setAlignment(Pos.TOP_CENTER);

        StackPane stack = new StackPane();
        stack.getChildren().add(vbox);

        startScene = new Scene(stack, SnakeGame.SCREEN_WIDTH,
                                                        SnakeGame.SCREEN_WIDTH);
    }

    /**
     * Sets the gameScene and adds elements to it. gameScene is composed of:
     *     1) A Rectangle for the background
     *     2) All of the elements from world
     * world handles the addition of all the game graphics to the screen with
     * the exception of the background, which you must add to gameScene
     * manually. You will need to set world in this method as well. Also, this
     * method must add an event to gameScene such that when WASD or the arrow
     * keys are pressed the snake will change direction.
     */
    private void setupGameScene() {
        Group group = new Group();

        gameScene = new Scene(group, SnakeGame.SCREEN_WIDTH,
                                                        SnakeGame.SCREEN_WIDTH);

        Rectangle rect = new Rectangle(SnakeGame.SCREEN_WIDTH,
                                           SnakeGame.SCREEN_WIDTH, Color.BLACK);
        rect.setX(0);
        rect.setY(0);

        group.getChildren().add(rect);

        gameScene.setOnKeyPressed((KeyEvent event) -> {
                if (event.getCode().equals(KeyCode.W)
                                        || event.getCode().equals(KeyCode.UP)) {
                    world.setDirection(Direction.UP);
                }
                if (event.getCode().equals(KeyCode.A)
                                      || event.getCode().equals(KeyCode.LEFT)) {
                    world.setDirection(Direction.LEFT);
                }
                if (event.getCode().equals(KeyCode.S)
                                      || event.getCode().equals(KeyCode.DOWN)) {
                    world.setDirection(Direction.DOWN);
                }
                if (event.getCode().equals(KeyCode.D)
                                     || event.getCode().equals(KeyCode.RIGHT)) {
                    world.setDirection(Direction.RIGHT);
                }
            });

        world = new GameWorld(rect, gameScene,
                       (Difficulty) gameMode.getSelectedToggle().getUserData());
    }

    /**
     * Sets the scoreScene and adds elements to it. scoreScene is composed of:
     *     1) A label that shows the user's score from world.
     *     2) A highscore list of the top 10 scores that is composed of:
     *         a) A ListView of Nodes for player usernames.
     *             - If the player makes it into the top 10, they need to be
     *             able to set their username, so a TextField should be at the
     *             point in the list where they belong. All other fields can
     *             just be labels for existing users.
     *         b) A ListView of Integers for player scores.
     *             - If the player makes it into the top 10, they're score
     *             should be displayed at the proper place in the list.
     *         * Existing high scores can be found in highScores.csv in the
     *         resources folder.
     *     3) A button that when pressed will write the high scores in the list
     *     to highScores.csv in the resources folder in the same format in which
     *     you originally accessed them. The button should also change the scene
     *     for window to startScene.
     */
    private void setupScoreScene() {
        Label scoreLabel = new Label("Score: " + world.getScore());
        scoreLabel.setFont(new Font(36));

        ListView<Node> usernameView = new ListView<Node>();
        ListView<Integer> scoreView = new ListView<Integer>();

        HBox scoreBox = new HBox(usernameView, scoreView);
        scoreBox.setAlignment(Pos.CENTER);

        try {
            Scanner scoreFile = new Scanner(new File("src/main/resources/highSc"
                                                                 + "ores.csv"));
            int numHighScores = 1;
            boolean newHighScore = true;
            while (scoreFile.hasNext() && numHighScores <= 10) {
                String line = scoreFile.nextLine();
                int comma = line.indexOf(",");
                String username = line.substring(0, comma);
                String score = line.substring(comma + 1, line.length()).trim();
                if (Integer.parseInt(score) > world.getScore()) {
                    usernameView.getItems().add(new Label(username));
                    scoreView.getItems().add(Integer.parseInt(score));
                } else if (world.getScore() > Integer.parseInt(score)
                                                              && newHighScore) {
                    usernameView.getItems().add(new TextField());
                    scoreView.getItems().add(world.getScore());
                    newHighScore = false;
                } else {
                    usernameView.getItems().add(new Label(username));
                    scoreView.getItems().add(Integer.parseInt(score));
                }
                numHighScores++;
            }
            if (numHighScores <= 10 && newHighScore) {
                usernameView.getItems().add(new TextField());
                scoreView.getItems().add(world.getScore());
                numHighScores++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Button save = new Button("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    PrintWriter printWriter = new PrintWriter(new File("src/mai"
                                               + "n/resources/highScores.csv"));
                    int counter = 0;
                    for (Node item : usernameView.getItems()) {
                        if (item instanceof Label) {
                            Label itemLabel = (Label) item;
                            printWriter.println(itemLabel.getText()
                                + "," + scoreView.getItems().get(counter));
                        }
                        if (item instanceof TextField) {
                            TextField itemTextField = (TextField) item;
                            printWriter.println(itemTextField.getText()
                                + "," + scoreView.getItems().get(counter));
                        }
                        printWriter.flush();
                        counter++;
                    }
                    printWriter.close();

                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                window.setScene(startScene);
            }
        });

        VBox scoreboard = new VBox(scoreLabel, scoreBox, save);
        scoreboard.setAlignment(Pos.TOP_CENTER);

        StackPane scorePane = new StackPane(scoreboard);

        scoreScene = new Scene(scorePane, SnakeGame.SCREEN_WIDTH,
                                                        SnakeGame.SCREEN_WIDTH);
    }

    /**
     * Starts the game loop. Assumes that the scene for window has been set to
     * gameScene and that world has been properly reset to the starting game
     * state.
     */
    public void play() {
        AnimationTimer timey = new AnimationTimer() {
            @Override
            public void handle(long currentTime) {
                if (System.currentTimeMillis()
                    - lastUpdateTime > world.getDelayTime()) {
                    world.update();
                    // DO NOT MODIFY ABOVE THIS LINE

                    if (world.isGameOver()) {
                        setupScoreScene();
                        window.setScene(scoreScene);
                        stop();
                    }

                    // DO NOT MODIFY BELOW THIS LINE
                    lastUpdateTime = System.currentTimeMillis();
                }
            }
        };
        lastUpdateTime = System.currentTimeMillis();
        timey.start();
    }
}
