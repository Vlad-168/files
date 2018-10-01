package com.example.proga.urbanhack;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class base extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int NOTIFY_ID = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Intent basetoochered = new Intent(base.this, ochered.class);
        startActivity(basetoochered);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                GlobalVars.value += 1;
                if (GlobalVars.value % 2 == 0) {
                    Snackbar.make(view, "Уведомления включены", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent notificationIntent = new Intent(base.this, base.class);
                    PendingIntent contentIntent = PendingIntent.getActivity(base.this,
                            0, notificationIntent,
                            PendingIntent.FLAG_CANCEL_CURRENT);
                    Resources res = base.this.getResources();
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(base.this);

                    builder.setContentIntent(contentIntent)

                            .setSmallIcon(R.drawable.foodfreelogo)
                            .setContentTitle("Внимание")
                            .setContentText("Магазин раздает продукты")
                            .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.foodfreelogo))
                            .setTicker("Успейте до конца раздачи!")
                            .setWhen(System.currentTimeMillis())
                            .setAutoCancel(true);

                    NotificationManager notificationManager =
                            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(NOTIFY_ID, builder.build());

                } else {
                    Snackbar.make(view, "Уведомления отключены", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item){
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.to_och) {
                Intent ocheredintent = new Intent(base.this, ochered.class);
                startActivity(ocheredintent);
            } else if (id == R.id.exit) {
                Intent ocheredintent = new Intent(base.this, MainActivity.class);
                startActivity(ocheredintent);
            } else if (id == R.id.nav_share) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Ïðèëîæåíèå Food for Free, ñêà÷èâàé îò ñþäà - http://vk.com");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Ïîäåëèòüñÿ"));
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
}

