package due.giuaky221121514222.day2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import due.giuaky221121514222.BaseScreen;
import due.giuaky221121514222.R;


public class EditUserActivity extends BaseScreen implements View.OnClickListener {
    private Button btDone;
    private EditText edUser;
    @Override
    protected int getLayoutResource() {
        return R.layout.day2_activity_edit_user;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        edUser=(EditText) findViewById(R.id.edUser);
        btDone=(Button)findViewById(R.id.btDone);
        btDone.setOnClickListener(this);

        Intent intent =getIntent();
        String username  = intent.getStringExtra("USER_NAME");
        edUser.setText(username);
    }
    @Override
    public void onClick(View view){
        if (view.getId()==R.id.btDone){
            onDone();
        }

    }
    private void onDone() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESULT",edUser.getText().toString());
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}