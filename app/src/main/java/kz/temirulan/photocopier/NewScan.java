package kz.temirulan.photocopier;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class NewScan extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scan);
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
        String names = name.getText().toString();
        int bright = brightness.getProgress();
        int contr = contrast.getProgress();

        RadioGroup extension = (RadioGroup) findViewById(R.id.extension);
        int radioButtonID = extension.getCheckedRadioButtonId();
        View radioButton = extension.findViewById(radioButtonID);
        int idx = extension.indexOfChild(radioButton);

        RadioGroup scanner = (RadioGroup) findViewById(R.id.scanner);
        int radioButtonS = scanner.getCheckedRadioButtonId();
        View radioButtonV = scanner.findViewById(radioButtonS);
        int ids = scanner.indexOfChild(radioButtonV);

        Database.putScan(this, user, names, bright, contr, idx, ids);
    }
}
