package kz.temirulan.photocopier;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class NewPrint extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_print);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button scan = (Button) findViewById(R.id.scan);
        scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText name = (EditText) findViewById(R.id.name);
        SeekBar brightness = (SeekBar) findViewById(R.id.brightness);
        SeekBar contrast = (SeekBar) findViewById(R.id.contrast);

        String user = getIntent().getStringExtra("user");
        int bright = brightness.getProgress();
        int contr = contrast.getProgress();

        RadioGroup scanner = (RadioGroup) findViewById(R.id.scanner);
        int radioButtonS = scanner.getCheckedRadioButtonId();
        View radioButtonV = scanner.findViewById(radioButtonS);
        int ids = scanner.indexOfChild(radioButtonV);

        Database.putPrint(this, user, bright, contr, ids);
    }
}
