package com.greenshift.petclinicmx.view.step;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import ernestoyaquello.com.verticalstepperform.Step;

public class OwnerIDStep extends Step<Integer> {

    private EditText id_view;

    public OwnerIDStep(String title) {
        super(title);
    }

    @Override
    public Integer getStepData() {
        Integer data;
        Log.i("asd", id_view.getText().toString());
        if(!id_view.getText().toString().equals("")){
            data = Integer.parseInt(id_view.getText().toString());

        }else{
            return 0;
        }
        return data;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(Integer data) {
        id_view.setText(data);
    }

    @Override
    protected IsDataValid isStepDataValid(Integer stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {

        id_view = new EditText(getContext());
        id_view.setSingleLine(true);
        id_view.setHint("ID");
        id_view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            markAsCompleted(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return id_view;
    }

    @Override
    protected void onStepOpened(boolean animated) {

    }

    @Override
    protected void onStepClosed(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {

    }
}
