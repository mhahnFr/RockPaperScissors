package com.example.manuel.ssp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends ActionBarActivity
{
    private TextView sieger;
    private ImageView comImage;
    private ImageView userImage;
    private ImageButton schere;
    private ImageButton stein;
    private ImageButton papier;
    private Spiel spiel;
    private int winner;
    private InterstitialAd mInterstitialAd;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spiel = new Spiel();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                startActivity(intent);
            }
        });
        requestNewInterstitial();
        sieger = (TextView) findViewById(R.id.sieger);
        comImage = (ImageView) findViewById(R.id.comImage);
        userImage = (ImageView) findViewById(R.id.userImage);
        schere = (ImageButton) findViewById(R.id.schere);
        stein = (ImageButton) findViewById(R.id.stein);
        papier = (ImageButton) findViewById(R.id.papier);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        schere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winner = spiel.choosen('s', 'r', 'p');
                userImage.setImageResource(R.drawable.sdu);
                report();
            }
        });
        stein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winner = spiel.choosen('r', 'p', 's');
                userImage.setImageResource(R.drawable.zdu);
                report();
            }
        });
        papier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winner = spiel.choosen('p', 's', 'r');
                userImage.setImageResource(R.drawable.pdu);
                report();
            }
        });
    }

    private void report()
    {
        char cw = spiel.getComWahl();
        switch(cw)
        {
            case 's' : comImage.setImageResource(R.drawable.scomputer);
            break;
            case 'r' : comImage.setImageResource(R.drawable.zcomputer);
            break;
            case 'p' : comImage.setImageResource(R.drawable.pcomputer);
            break;
        }
        switch(winner)
        {
            case 0: sieger.setText(R.string.won);
            break;
            case 1: sieger.setText(R.string.lost);
            break;
            default: sieger.setText(R.string.draw);
            break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        /*Intent */intent = new Intent(MainActivity.this, StatsActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            startActivity(intent);
        }
        //startActivity(intent);
        return true;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("0DD59B251A8686AA8BB76177D6780F49")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}