package com.thunder4.favors;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class APostActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Post");
        setContentView(R.layout.activity_apost);

        final Button accept_button = (Button) findViewById(R.id.accept_button);
        accept_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                acceptPost(v);
            }
        });
        final Button nah_button = (Button) findViewById(R.id.nah_button);
        nah_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nahPost(v);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.apost, menu);
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

    public void acceptPost(View view) {
        this.finish();
    }
    public void nahPost(View view) {
        this.finish();
    }
}
