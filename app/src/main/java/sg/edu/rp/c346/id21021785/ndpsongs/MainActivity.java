package sg.edu.rp.c346.id21021785.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert, showList;
    EditText etTitle, etSinger, etYear;
    RadioGroup stars;
    RadioButton star1, star2, star3, star4, star5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.btnInsert);
        showList = findViewById(R.id.btnShow);
        etTitle = findViewById(R.id.etUpdateSongTitle);
        etSinger = findViewById(R.id.etUpdateSingers);
        etYear = findViewById(R.id.etUpdateYear);
        stars = findViewById(R.id.stars);
        star1 = findViewById(R.id.updateStar1);
        star2 = findViewById(R.id.updateStar2);
        star3 = findViewById(R.id.updateStar3);
        star4 = findViewById(R.id.updateStar4);
        star5 = findViewById(R.id.updateStar5);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etTitle.getText().toString().isEmpty() && !etSinger.getText().toString().isEmpty() && !etYear.getText().toString().isEmpty() && stars.getCheckedRadioButtonId() != -1) {

                    String title = etTitle.getText().toString();
                    String singer = etSinger.getText().toString();
                    String year = etYear.getText().toString();
                    int yearToInt = Integer.parseInt(year);


                    int checkedRadioId = stars.getCheckedRadioButtonId();
                    int starRating = 0;

                    if (checkedRadioId == R.id.updateStar1) {
                        starRating = 1;
                    } else if (checkedRadioId == R.id.updateStar2) {
                        starRating = 2;
                    } else if (checkedRadioId == R.id.updateStar3) {
                        starRating = 3;
                    } else if (checkedRadioId == R.id.updateStar4) {
                        starRating = 4;
                    } else if (checkedRadioId == R.id.updateStar5) {
                        starRating = 5;
                    }


                    DBHelper dbh = new DBHelper(MainActivity.this);
                    long inserted_id = dbh.insertSong(title, singer, yearToInt, starRating);
                    if (inserted_id != -1){
                        Toast.makeText(MainActivity.this, "Insert successful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });




    }
}