package com.example.byktwd_2019;

import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Paint;
import android.view.SurfaceView;


// this class is currently not being used

public class NOTGameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    //    private int screenX, screenY;
//    public static float screenRatioX, screenRatioY;
//    private Paint paint;

////////////    private Background background;

////////////    private Background background1, background2;

//////    private GameActivity gameActivity;

////    public NOTGameView(Context context) {
  public NOTGameView(Context context, int screenX, int screenY) {
        super(context);

        /*this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioX = 1080f / screenY;

        background = new Background(screenX, screenY, getResources());
//        background2 = new Background(screenX, screenY, getResources());

        background.x = screenX;
//      background2.x = screenX;

        paint = new Paint();

//        screenRatioX =*/
    }

    @Override
    public void run() {

        while (isPlaying) {

            update ();
            draw ();
//            sleep ();
        }
    }

    private void update () {

////        background.x *= screenRatioX;

//        background1.x -= 10* screenRatioX;
//        background2.x -= 10 * screenRatioX;

/*        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX;
        }*/

    }

    private void draw () {

////////        GameActivity = new GameActivity();

////////        background = new Background();
        //if (getHolder().getSurface().isValid()) {

            /*Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background.background, background.x, background.y, paint);

//            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
//            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);

            getHolder().unlockCanvasAndPost(canvas);*/
    }

    private void sleep () {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume () {

        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause () {

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
