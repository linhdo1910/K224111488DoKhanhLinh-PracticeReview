package com.example.k224111488dokhanhlinh;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k224111488dokhanhlinh.connectors.EmployeeConnector;
import com.example.k224111488dokhanhlinh.models.Employee;

import java.lang.reflect.Array;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserName;
    EditText edtPassword;
    CheckBox chkSaveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        addViews();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtUserName = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkSaveLogin = findViewById(R.id.chkSaveLoginInfor);
    }

    public void do_login(View view) {
        EmployeeConnector ec = new EmployeeConnector();

        String usr = edtUserName.getText().toString();
        String pwd = edtPassword.getText().toString();

        Employee e_login = ec.login(usr, pwd);
        if (e_login != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login failed! Check your account again!", Toast.LENGTH_LONG).show();
        }
    }

    public void do_exit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

        builder.setTitle(R.string.title_confirm_exit_title);
        builder.setMessage(R.string.title_confirm_exit_message);
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton(R.string.title_confirm_exit_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Đóng Activity
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    private int backPressCount = 0;

    @SuppressWarnings("MissingSuperCall")
    @Override
    public void onBackPressed() {
        backPressCount++;

        if (backPressCount == 3) {
            backPressCount = 0;
            showExitConfirmationDialog();
        } else {
            Toast.makeText(this, "Nhấn quay lại " + (3 - backPressCount) + " lần nữa để thoát", Toast.LENGTH_SHORT).show();
        }
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle(getResources().getText(R.string.title_confirm_exit_title));
        builder.setMessage(getResources().getText(R.string.title_confirm_exit_message));
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton(getResources().getText(R.string.title_confirm_exit_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton(getResources().getText(R.string.title_confirm_exit_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    public void saveLoginInformation()
    {
        SharedPreferences preferences=getSharedPreferences("LOGIN_PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        String usr = edtUserName.getText().toString();
        String pwd = edtPassword.getText().toString();
        boolean isSave=chkSaveLogin.isChecked();
        editor.putString("USER_NAME",usr);
        editor.putString("PASSWORD",pwd);
        editor.putBoolean("SAVED", isSave);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveLoginInformation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreLoginInformation();
    }

    public void restoreLoginInformation(){
        SharedPreferences preferences=getSharedPreferences("LOGIN_PREFERENCE",MODE_PRIVATE);
        String usr=preferences.getString("USER_NAME","");
        String pwd=preferences.getString("PASSWORD","");
        boolean isSave=preferences.getBoolean("SAVED",false);
        if(isSave){
            edtUserName.setText(usr);
            edtPassword.setText(pwd);
            chkSaveLogin.setChecked(isSave);
        }
    }
}
