package com.pym.littlemvp.login.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pym.littlemvp.R;
import com.pym.littlemvp.login.Presenter.LoginPresenter;
import com.pym.littlemvp.login.interfaces.ILogin;
import com.pym.littlemvp.login.interfaces.ILoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements ILogin, View.OnClickListener {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.progress)
    ProgressBar progress;
    private ILoginPresenter iLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        tvLogin.setOnClickListener(this);
        iLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View view) {
        iLoginPresenter.login(etUsername.getText().toString(),etPwd.getText().toString());
    }

    @Override
    public void showTips(String tips) {
        Toast.makeText(this, tips, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);

    }
}
