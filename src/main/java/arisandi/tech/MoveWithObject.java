package arisandi.tech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObject extends AppCompatActivity {

    public static final String EXTRA_PERSON  = "extra person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView go = findViewById(R.id.object);
//        go.setOnClickListener(this);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+ person.getName()+ ",\nEmail : "+person.getEmail()+",\nUmur"+ person.getAge()+",\nKota"+person.getCity();
        go.setText(text);
    }
}
