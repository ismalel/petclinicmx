package com.greenshift.petclinicmx.contract;

import android.content.Context;

public interface Base {

    interface View {
        void showToast(String msg);
        Context getPetClinicMxContext();
    }

    interface Presenter{
        Context getPetClinicMxContext();
    }
}
