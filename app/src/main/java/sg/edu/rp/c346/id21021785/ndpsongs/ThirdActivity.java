package sg.edu.rp.c346.id21021785.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ThirdActivity extends AppCompatActivity {

    Button update, delete, cancel;
    EditText etUpdateTitle, etUpdateSinger, etUpdateYear;
    RadioGroup updatestars;
    RadioButton updateStar1, updateStar2, updateStar3, updateStar4, updateStar5;
    Song songDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        cancel = findViewById(R.id.btnCancel);
        etUpdateTitle = findViewById(R.id.etUpdateSongTitle);
        etUpdateSinger = findViewById(R.id.etUpdateSingers);
        etUpdateYear = findViewById(R.id.etUpdateYear);
        updatestars = findViewById(R.id.starUpdate);
        updateStar1 = findViewById(R.id.updateStar1);
        updateStar2 = findViewById(R.id.updateStar2);
        updateStar3 = findViewById(R.id.updateStar3);
        updateStar4 = findViewById(R.id.updateStar4);
        updateStar5 = findViewById(R.id.updateStar5);

        Intent i = getIntent();
        songDetails = (Song) i.getSerializableExtra("song");

        etUpdateTitle.setText(songDetails.getTitle());
        etUpdateSinger.setText(songDetails.getSingers());
        etUpdateYear.setText(songDetails.getYear() + "");
        int starCount = 0;
        if (songDetails.getStar() == 1) {
            updateStar1.setChecked(true);
        } else if (songDetails.getStar() == 2) {
            updateStar2.setChecked(true);
        } else if (songDetails.getStar() == 3) {
            updateStar3.setChecked(true);
        } else if (songDetails.getStar() == 4) {
            updateStar4.setChecked(true);
        } else if (songDetails.getStar() == 5) {
            updateStar5.setChecked(true);
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                String newTitle = etUpdateTitle.getText().toString();
                String newSinger = etUpdateSinger.getText().toString();
                String newYear = etUpdateYear.getText().toString();
                int newYearToInt = Integer.parseInt(newYear);

                int checkedRadioId = updatestars.getCheckedRadioButtonId();
                int newStarRating = 0;

                if (checkedRadioId == R.id.updateStar1) {
                    newStarRating = 1;
                } else if (checkedRadioId == R.id.updateStar2) {
                    newStarRating = 2;
                } else if (checkedRadioId == R.id.updateStar3) {
                    newStarRating = 3;
                } else if (checkedRadioId == R.id.updateStar4) {
                    newStarRating = 4;
                } else if (checkedRadioId == R.id.updateStar5) {
                    newStarRating = 5;
                }

                songDetails.setSongContent(newTitle, newSinger, newYearToInt, newStarRating);
                dbh.updateSong(songDetails);
                dbh.close();
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteSong(songDetails.get_id());
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}