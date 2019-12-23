package arisandi.tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);

        Button pindah = findViewById(R.id.move);
        pindah.setOnClickListener(this);

        Button Dial = findViewById(R.id.dial);
        Dial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.move:
                Person person = new Person();
                person.setName("Arisandi");
                person.setAge(5);
                person.setEmail("arisandi0197@gmail.com");
                person.setCity("Makassar");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObject.class);
                moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.dial:
                String phoneNumber = "081210841382";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, Result.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Result.RESULT_CODE) {
                int selectedValue = data.getIntExtra(Result.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
