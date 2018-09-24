package es.iessaladillo.yeraymoreno.ymg_pr01_greet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements OnClickListener, OnCheckedChangeListener {

    private EditText txtName;
    private EditText txtSurname;
    private CheckBox chkPolite;
    @SuppressWarnings("FieldCanBeLocal")
    private Button btnGreet;
    private Button btnReset;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        chkPolite = findViewById(R.id.chkPolite);
        btnGreet = findViewById(R.id.btnGreet);
        btnReset = findViewById(R.id.btnReset);

        //This is to make the button work when pressed
        chkPolite.setOnCheckedChangeListener(this);
        btnGreet.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }
    //This checks where i click, if it's one of the buttons, it will do it's function.
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnGreet) {
            greet();
        }
        if(id == R.id.btnReset){
            reset();
        }
    }

    //Function to pop-up a greet, checks if polite mode is active and pops up a different message on click.
    private void greet() {
        String message =
                getString(R.string.main_activity_greetings);
        if (chkPolite.isChecked()) {
            message = message +
                    getString(R.string.main_activity_i_salute_you);
        }
        message += " " + txtName.getText() + " " + txtSurname.getText();

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void reset() {
        txtName.setText("");
        txtSurname.setText("");
        chkPolite.setChecked(false);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView,
                                 boolean isChecked) {
        chkPolite.setText(isChecked ?
                getString(R.string.main_activity_polite_mode) :
                getString(R.string.main_activity_impolite_mode));
    }

}
