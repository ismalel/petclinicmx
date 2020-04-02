package com.greenshift.petclinicmx.contract;

public interface Login {

    interface View extends Base.View{
        void changeView();
    }

    interface Presenter extends Base.Presenter{
        void login(String email, String password);
    }
}
