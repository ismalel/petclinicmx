package com.greenshift.petclinicmx.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.greenshift.petclinicmx.MainActivity;
import com.greenshift.petclinicmx.R;
import com.greenshift.petclinicmx.contract.Login;
import com.greenshift.petclinicmx.presenter.LoginPresenter;

public class LoginView extends AppCompatActivity implements Login.View {

    private EditText txtEmail;
    private EditText txtPassword;
    private ProgressBar progressBar;
    private Button btnLogin;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);

        txtEmail = findViewById(R.id.email);
        txtPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        btnLogin = findViewById(R.id.btn_login);
        presenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(v -> {

            String email = txtEmail.getText().toString();
            String password = txtPassword.getText().toString();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            presenter.login(email,password);
        });
    }

    @Override
    public void changeView() {
        progressBar.setVisibility(View.GONE);
        Intent intent = new Intent(LoginView.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showToast(String msg) {
        runOnUiThread(() -> Toast.makeText(LoginView.this, msg, Toast.LENGTH_SHORT).show());
    }

    @Override
    public Context getPetClinicMxContext() {
        return this.getApplicationContext();
    }
}
