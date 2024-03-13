package com.abrebo.kisiler.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abrebo.kisiler.R;
import com.abrebo.kisiler.data.entity.Kisiler;
import com.abrebo.kisiler.databinding.FragmentDetayBinding;

public class DetayFragment extends Fragment {
    private FragmentDetayBinding binding;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentDetayBinding.inflate(inflater, container, false);

        binding.materialToolbar.setTitle("Kişi Detay");
        binding.materialToolbar.setTitleTextColor(R.color.white);


        DetayFragmentArgs args=DetayFragmentArgs.fromBundle(getArguments());
        Kisiler kisi=args.getKisi();
        binding.editTextAd.setText(kisi.getAd());
        binding.editTextKisiTel.setText(kisi.getTel());


        binding.buttonGuncelle.setOnClickListener(view -> {
            String ad=binding.editTextAd.getText().toString();
            String tel=binding.editTextKisiTel.getText().toString();

            guncelle(kisi.getId(),ad,tel);
        });







        return binding.getRoot();
    }

    private void guncelle(int id,String ad, String tel) {
    }
}