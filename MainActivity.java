package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jaffer.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "My Key For Order Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(intent);
            }
        });

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
       // int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_call_us:
                Uri uri = Uri.parse("tel:0758862586");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(callIntent);
                return true;
            case R.id.action_location:
                String location = String.format(Locale.ENGLISH, "geo:%f,%f", 35.155947, -98.444700);
                Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                startActivity(locationIntent);
                return true;
            case R.id.action_about_us:
                String url = "https://www.backyardburgers.com/";
                Intent browse = new Intent(Intent.ACTION_VIEW);
                browse.setData(Uri.parse(url));
                startActivity(browse);
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutMessage(View view) {
        //displayToast(getString(R.string.donut_order));
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showIceCreamMessage(View view) {
        //displayToast(getString(R.string.ice_cream_order));
        mOrderMessage = getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showFroyoMessage(View view) {
       // displayToast(getString(R.string.froyo_order));
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}