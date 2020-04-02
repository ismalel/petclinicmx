package com.greenshift.petclinicmx.presenter;

import android.content.Context;

import com.greenshift.petclinicmx.contract.Login;

public class LoginPresenter implements Login.Presenter {

    private Login.View view;

    public LoginPresenter(Login.View view){
        this.view = view;
    }
    @Override
    public void login(String email, String password) {
        view.changeView();
    }

    @Override
    public Context getPetClinicMxContext() {
        return view.getPetClinicMxContext();
    }
}
