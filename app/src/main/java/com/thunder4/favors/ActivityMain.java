package com.thunder4.favors;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.thunder4.favors.R;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ActivityMain extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.main_btn_login);
        button.setOnClickListener(this);
        logKeyHash();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logKeyHash() {
        // Add code to print out the key hash
        try {
             PackageInfo info = getPackageManager().getPackageInfo(
                    "net.clementhoang.facebooktest",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("KeyHash:", "Oh noo name not found");
        } catch (NoSuchAlgorithmException e) {
            Log.w("KeyHash:", "Oh goddd no such algorithm");
        }
    }

    @Override
    public void onClick(View view) {
        System.out.println("HELLO");
        final Intent homeActivityIntent = new Intent(this, HomeActivity.class);

//        Session.openActiveSession(this, true, new Session.StatusCallback() {
//            @Override
//            public void call(Session session, SessionState state, Exception exception) {
//                if (state.isOpened()) {
//                    System.out.println("HERE");
//                    startActivity(homeActivityIntent);
//
//                } else {
//                    System.out.println("ELSE");
//                }
//            }
//        });
        Session.openActiveSession(this, true, new Session.StatusCallback() {

            // callback when session changes state
            @Override
            public void call(Session session, SessionState state, Exception exception) {
                if (session.isOpened()) {

                    // make request to the /me API
                    Request.newMeRequest(session, new Request.GraphUserCallback() {

                        // callback after Graph API response with user object
                        @Override
                        public void onCompleted(GraphUser user, Response response) {
                            if (user != null) {
//                                TextView welcome = (TextView) findViewById(R.id.welcome);
//                                welcome.setText("Hello " + user.getName() + "!");
                                System.out.println("Hello" + user.getName());
                                startActivity(homeActivityIntent);
                            }
                        }
                    }).executeAsync();
                }
            }
        });
        System.out.println("LAST");
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }
    /**
     * Logout From Facebook
     */
    public static void callFacebookLogout(Context context) {
        Session session = Session.getActiveSession();
        if (session != null) {

            if (!session.isClosed()) {
                session.closeAndClearTokenInformation();
                //clear your preferences if saved
            }
        } else {

            session = new Session(context);
            Session.setActiveSession(session);

            session.closeAndClearTokenInformation();
            //clear your preferences if saved

        }

    }
}
