package com.greenshift.petclinicmx.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.greenshift.petclinicmx.R;
import com.greenshift.petclinicmx.entity.Owner;
import com.greenshift.petclinicmx.view.adapter.OwnerListAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OwnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OwnerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<Owner> list = new ArrayList<>();

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    Bundle bundle;
    Gson gson = new Gson();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OwnerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OwnerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OwnerFragment newInstance(String param1, String param2) {
        OwnerFragment fragment = new OwnerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_owner, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        OwnerListAdapter myRecyclerViewAdapter=new OwnerListAdapter(getActivity().getApplicationContext(),list);
        recyclerView.setLayoutManager(layoutManager);;
        recyclerView.setAdapter(myRecyclerViewAdapter);

        fab = view.findViewById(R.id.add_owner);
        fab.setOnClickListener(v -> {
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.add_ownerScreen);

        });
        bundle = this.getArguments();
        if(bundle != null){
            Owner owner = gson.fromJson(bundle.getString("key"), Owner.class);
            addOwner(owner);
            Toast.makeText(getActivity().getApplicationContext(), "sd  " + owner.toString(), Toast.LENGTH_SHORT).show();

        }
        return view;
    }

    public void addOwner(Owner owner){
        owner.setAvatar(R.drawable.placerholder);
        this.list.add(owner);
   
    }
}
