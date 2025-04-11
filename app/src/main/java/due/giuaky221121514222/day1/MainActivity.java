package due.giuaky221121514222.day1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import due.giuaky221121514222.BaseScreen;
import due.giuaky221121514222.R;


public class MainActivity extends BaseScreen {

    @Override
    protected int getLayoutResource() {
        return R.layout.day1_activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View mainView = findViewById(android.R.id.content);
        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MaytinhActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}