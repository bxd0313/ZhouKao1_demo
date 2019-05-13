package com.bawei.zhoukao1_demo.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.zhoukao1_demo.R;
import com.bawei.zhoukao1_demo.base.BaseActivity;
import com.bawei.zhoukao1_demo.mvp.user.IUserContract;
import com.bawei.zhoukao1_demo.mvp.user.UserPresenterImpl;

/**
 * @Author：边旭东
 * @E-mail： bxd313@vip.qq.com
 * @Date： 2019/5/12 19:33
 * @Description：描述信息
 */
public class LoginAndRegisterActivity extends BaseActivity implements IUserContract.IUserView {
    private EditText edit_name,edit_pwd;
    private Button btn_login,btn_register;
    private IUserContract.IUserPresenter userPresenter;
    @Override
    public int initLayout() {
        return R.layout.activity_loginandregister;
    }

    @Override
    public void initControl() {
       edit_name=findViewById(R.id.edit_name);
       edit_pwd=findViewById(R.id.edit_pwd);
       btn_login=findViewById(R.id.btn_login);
       btn_register=findViewById(R.id.btn_register);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
      btn_register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //注册
              userPresenter.register(edit_name.getText().toString(),edit_pwd.getText().toString());
          }
      });
      btn_login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //登录
              userPresenter.login(edit_name.getText().toString(),edit_pwd.getText().toString());
          }
      });

      //实例化 user p
       userPresenter =new UserPresenterImpl();
       //绑定
        userPresenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userPresenter.detach();
    }

    @Override
    public void registerSuccess(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,MainActivity.class));
    }
}
