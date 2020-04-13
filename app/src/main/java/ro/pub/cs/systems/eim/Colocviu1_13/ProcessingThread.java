package ro.pub.cs.systems.eim.Colocviu1_13;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessingThread extends Thread {
    private Context context;
    private String cardinalMsg;

    public ProcessingThread(Context context, String cardinalMsg) {
        this.context = context;
        this.cardinalMsg = cardinalMsg;
    }

    @Override
    public void run() {
        Log.d("THREAD", "Will send msg after 5 sec");
        sleep();
        sendMessage(cardinalMsg);
    }

    private void sendMessage(String cardinalMsg) {
        Intent intent = new Intent();
        intent.setAction("CARDINAL_BROADCAST");
        intent.putExtra("CARDINAL_POINTS", cardinalMsg);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            Log.e("SLEEP_LOG", interruptedException.getMessage());
            interruptedException.printStackTrace();
        }
    }
}
