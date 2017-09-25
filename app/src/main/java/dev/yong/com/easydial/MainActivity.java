package dev.yong.com.easydial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.dial_bt_one)
    Button dialBtOne;
    @BindView(R.id.dial_bt_two)
    Button dialBtTwo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        checkPermissions();
        initEvent();
    }

    private void initEvent() {
        dialBtOne.setOnClickListener(this);
        dialBtTwo.setOnClickListener(this);
    }

    private void checkPermissions() {
        int checkCode = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
        //如果拒绝
        if (checkCode== PackageManager.PERMISSION_DENIED){
            //申请权限
            if (checkCode==PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},100);
            }
        }else if (checkCode==PackageManager.PERMISSION_GRANTED){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dial_bt_one:

                intent = new Intent();

                intent.setAction("android.intent.action.CALL");

                intent.setData(Uri.parse("tel:"+"18513468050"));

                startActivity(intent);
                break;
            case R.id.dial_bt_two:

                intent.setAction("android.intent.action.CALL");

                intent.setData(Uri.parse("tel:"+"15630587067"));

                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {

        return;
    }
}
