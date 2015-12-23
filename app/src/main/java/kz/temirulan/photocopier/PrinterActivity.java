package kz.temirulan.photocopier;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class PrinterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button new_scan = (Button) findViewById(R.id.new_scan);
        new_scan.setOnClickListener(this);

        Button scan_history = (Button) findViewById(R.id.scan_history);
        scan_history.setOnClickListener(this);

        Button new_print = (Button) findViewById(R.id.new_print);
        new_print.setOnClickListener(this);

        Button print_history = (Button) findViewById(R.id.print_history);
        print_history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.new_scan:
                intent = new Intent(this, NewScan.class);
                break;
            case R.id.new_print:
                intent = new Intent(this, NewPrint.class);
                break;
            case R.id.scan_history:
                intent = new Intent(this, ScanHistory.class);
                break;
            case R.id.print_history:
                intent = new Intent(this, PrintHistory.class);
                break;
        }
        intent.putExtra("user", getIntent().getStringExtra("user"));
        startActivity(intent);
    }
}
