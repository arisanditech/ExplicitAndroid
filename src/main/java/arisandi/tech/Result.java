package arisandi.tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Result extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup Group;
    private Button Choose;

    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Choose = findViewById(R.id.choose);
        Choose.setOnClickListener(this);
        Group = findViewById(R.id.group);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.choose) {
            if (Group.getCheckedRadioButtonId() != 0) {
                int value = 0;
                switch (Group.getCheckedRadioButtonId()) {
                    case R.id.satu:
                        value = 50;
                        break;
                    case R.id.dua:
                        value = 100;
                        break;
                    case R.id.tiga:
                        value = 150;
                        break;
                    case R.id.empat:
                        value = 200;
                        break;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}
