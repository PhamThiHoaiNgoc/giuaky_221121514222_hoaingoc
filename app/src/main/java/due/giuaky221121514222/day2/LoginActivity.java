package due.giuaky221121514222.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import due.giuaky221121514222.BaseScreen;
import due.giuaky221121514222.R;


public class LoginActivity extends BaseScreen implements View.OnClickListener {
    private EditText edUser;
    private EditText edPassword;
    private Button btLogin;
    @Override
    protected int getLayoutResource() {
        return R.layout.day2_activity_login;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        edUser=(EditText)findViewById(R.id.edUser);
        edPassword=(EditText)findViewById(R.id.edPassword);
        btLogin=(Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId()==R.id.btLogin){
            onLogin();
        }
    }
    private void onLogin(){
        if(edUser.getText().toString().isEmpty()|| edPassword.getText().toString().isEmpty()){
            Toast.makeText(this,"Bạn chưa nhập user hoặc password", Toast.LENGTH_SHORT).show();

        }else{
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USER_NAME",edUser.getText().toString());
            startActivity(intent);
        }
    }
}