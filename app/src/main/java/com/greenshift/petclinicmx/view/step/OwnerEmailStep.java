package com.greenshift.petclinicmx.view.step;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import ernestoyaquello.com.verticalstepperform.Step;

public class OwnerEmailStep extends Step<String> {

    private EditText name;

    public OwnerEmailStep(String title) {
        super(title);
    }

    @Override
    public String getStepData() {
        Editable user = name.getText();
        return user != null ? user.toString() : "";
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        String user = getStepData();
        return !user.isEmpty() ? user : "(Empty)";
    }

    @Override
    public void restoreStepData(String data) {
        name.setText(data);
    }

    @Override
    protected IsDataValid isStepDataValid(String stepData) {
        boolean isNameValid = stepData.length() > 0;
        String error = !isNameValid ? "Not empty email " : "";
        return new IsDataValid(isNameValid,error);
    }

    @Override
    protected View createStepContentLayout() {
        name = new EditText(getContext());
        name.setSingleLine(true);
        name.setHint("Owner's email");
        name.addTextChangedListener(new TextWatcher() {
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
        return name;
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

