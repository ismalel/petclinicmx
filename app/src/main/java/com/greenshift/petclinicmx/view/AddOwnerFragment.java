package com.greenshift.petclinicmx.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.greenshift.petclinicmx.R;
import com.greenshift.petclinicmx.entity.Owner;
import com.greenshift.petclinicmx.view.step.OwnerAddressStep;
import com.greenshift.petclinicmx.view.step.OwnerEmailStep;
import com.greenshift.petclinicmx.view.step.OwnerIDStep;
import com.greenshift.petclinicmx.view.step.OwnerNameStep;
import com.greenshift.petclinicmx.view.step.OwnerTelStep;

import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddOwnerFragment extends Fragment implements StepperFormListener {

    private VerticalStepperFormView verticalStepperForm;
    private OwnerIDStep id;
    private OwnerNameStep name;
    private OwnerAddressStep address;
    private OwnerTelStep tel;
    private OwnerEmailStep email;
    Gson gson;

    public AddOwnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_owner, container, false);
        id = new OwnerIDStep("Owner's ID");
        name = new OwnerNameStep("Owner Name");
        address = new OwnerAddressStep("Owner Address");
        tel = new OwnerTelStep("Owner Telephone");
        email = new OwnerEmailStep("Owner Email");
        gson = new Gson();
        verticalStepperForm = view.findViewById(R.id.stepper_form);
        verticalStepperForm.setup(this,id,name,address,tel,email).init();
        return view;
    }

    @Override
    public void onCompletedForm() {
        //Toast.makeText(getActivity().getApplicationContext(), "asd", Toast.LENGTH_SHORT).show();
        Owner owner = new Owner();
        owner.setId(id.getStepData());
        owner.setName(name.getStepData());
        owner.setAddress(address.getStepData());
        owner.setTel(tel.getStepData());
        owner.setEmail(email.getStepData());
        String result = gson.toJson(owner);
        Bundle bunlde = new Bundle();
        bunlde.putString("key",result);
        Toast.makeText(getActivity().getApplicationContext(), owner.toString(), Toast.LENGTH_SHORT).show();
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.ownerScreen, bunlde);

    }

    @Override
    public void onCancelledForm() {

    }
}
