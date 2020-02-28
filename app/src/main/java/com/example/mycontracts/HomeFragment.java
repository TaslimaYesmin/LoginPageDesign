package com.example.mycontracts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    private TextView singInTv, signUpTv;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        singInTv = view.findViewById(R.id.signInTv);
        signUpTv = view.findViewById(R.id.signUpTv);

        replaceFragment(new SignInFragment());
        singInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SignInFragment());
                changeBackground(singInTv, signUpTv);
            }
        });
        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SignUpFragment());
                changeBackground(signUpTv, singInTv);
            }
        });


        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment).commit();
    }

    public void changeBackground(TextView active, TextView deactive) {
        active.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        active.setTextColor(getResources().getColor(R.color.white));
        deactive.setBackground(getResources().getDrawable(R.drawable.custom_border_without_bg));
        deactive.setTextColor(getResources().getColor(R.color.black));

    }
}
