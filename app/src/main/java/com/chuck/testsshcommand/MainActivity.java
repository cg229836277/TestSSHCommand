package com.chuck.testsshcommand;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends Activity {
    private final String TAG = "chuck";
    private String dropbearCommands = "dropbear -d /data/dropbear/dss_host_key -F -E -s -v &";
    private String[] reverseToServer = {"ssh -f -N -R 168:localhost:22 root@10.0.7.20","y\n","cloudroom\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                executeCommand();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                executeReverseCommand();
            }
        }).start();
    }

    private void executeCommand(){
        ShellUtils.CommandResult dropbearResult = ShellUtils.execCommand(dropbearCommands , true , true);
        Log.e(TAG , "fail result = " + dropbearResult.errorMsg);
        Log.e(TAG , "success result = " + dropbearResult.successMsg);
    }

    private void executeReverseCommand(){
        ShellUtils.CommandResult reverseResult = ShellUtils.execCommand(reverseToServer , true , true);
        Log.e(TAG , "fail result = " + reverseResult.errorMsg);
        Log.e(TAG , "success result = " + reverseResult.successMsg);
    }
}
