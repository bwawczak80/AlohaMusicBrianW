package net.wawczak.brian.alohamusicbrianw;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;

    MediaPlayer mpUkulele, mpDrums;

    int playing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btnUkulele);
        button2 = findViewById(R.id.btnDrums);

        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);

        playing = 0;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing){
                    case 0:
                        mpUkulele.start();
                        playing = 1;
                        button1.setText(R.string.btnUkulelePause);
                        button2.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpUkulele.pause();
                        playing = 0;
                        button1.setText(R.string.btnUkulele);
                        button2.setVisibility(View.VISIBLE);
                        break;
                }



            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (playing){
                    case 0:
                        mpDrums.start();
                        playing = 1;
                        button2.setText(R.string.btnDrumsPause);
                        button1.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpDrums.pause();
                        playing = 0;
                        button2.setText(R.string.btnDrums);
                        button1.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });


    }
}
