package com.abrebo.kisiler.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abrebo.kisiler.R;
import com.abrebo.kisiler.databinding.FragmentKaydetBinding;

public class KaydetFragment extends Fragment {

    private FragmentKaydetBinding binding;
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentKaydetBinding.inflate(inflater, container, false);
        binding.toolbar2.setTitle("Kişi Kayıt");
        binding.toolbar2.setTitleTextColor(R.color.white);

        binding.buttonKaydet.setOnClickListener(view -> {
            String ad=binding.editTextAd.getText().toString();
            String tel=binding.editTextKisiTel.getText().toString();

            kaydet(ad,tel);
        });









        return binding.getRoot();

    }

    private void kaydet(String ad, String tel) {
        //kayıt işlemleri

    }
}