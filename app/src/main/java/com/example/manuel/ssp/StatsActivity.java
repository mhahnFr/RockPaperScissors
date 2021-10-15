package com.example.manuel.ssp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class StatsActivity extends ActionBarActivity {

    private TextView standDu;
    private TextView standCom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        standDu = (TextView) findViewById(R.id.statDu);
        standCom = (TextView) findViewById(R.id.statCom);
        standDu.setText(Spiel.getDu());
        standCom.setText(Spiel.getCom());
    }

}