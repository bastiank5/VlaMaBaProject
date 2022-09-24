package MainPackage;

import UtilityPackage.FileLoader;
import WorldPackage.TxtReader;

public class GameHandler implements Runnable {

    private int[][] MainMap;
    private final int FPS = 60;
    private final long MAX_LOOP_TIME = 1000 / FPS;

    public GameHandler() {
        MainMap = TxtReader.readTxt(FileLoader.ladeDatei("MainMap.txt"));
        for (int t = 0; t < MainMap[0].length; t++) {
            for (int i = 0; i < MainMap.length; i++) {
                System.out.print(MainMap[i][t]);
            }
            System.out.println("");
            System.out.println("TEst");
        }
    }

    public static void main(String[] arg) {
        GameHandler game = new GameHandler();
//    new Screen("Game", SCREEN_WIDTH, SCREEN_HEIGHT);
        new Thread(game).start();
    }

    boolean running = true;

    @Override
    public void run() {
        long timestamp;
        long oldTimestamp;
        while (running) {
            oldTimestamp = System.currentTimeMillis();
            update();
            timestamp = System.currentTimeMillis();
            if (timestamp - oldTimestamp > MAX_LOOP_TIME) {
                System.out.println("Wir sind zu spät!");
                continue;
            }
            render();
            timestamp = System.currentTimeMillis();
//            System.out.println(maxLoopTime + " : " + (timestamp - oldTimestamp));
            if (timestamp - oldTimestamp <= MAX_LOOP_TIME) {
                try {
                    Thread.sleep(MAX_LOOP_TIME - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void update() {
    }

    void render() {
    }
}
