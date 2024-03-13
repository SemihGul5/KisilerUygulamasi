package com.abrebo.kisiler.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.abrebo.kisiler.R;
import com.abrebo.kisiler.data.entity.Kisiler;
import com.abrebo.kisiler.databinding.FragmentAnaSayfaBinding;
import com.abrebo.kisiler.ui.adapters.KisilerAdapter;

import java.util.ArrayList;


public class AnaSayfaFragment extends Fragment {
    private FragmentAnaSayfaBinding binding;
    ArrayList<Kisiler> kisilers;
    KisilerAdapter adapter;
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAnaSayfaBinding.inflate(inflater, container, false);
        binding.toolbar.setTitle("Kişiler");
        binding.toolbar.setTitleTextColor(R.color.white);


        /*binding.buttonDetay.setOnClickListener(view -> {
            Kisiler kisiler= new Kisiler(1,"Ahmet","1111");
            AnaSayfaFragmentDirections.ActionAnaSayfaFragmentToDetayFragment gecis=AnaSayfaFragmentDirections.actionAnaSayfaFragmentToDetayFragment(kisiler);
            Navigation.findNavController(view).navigate(gecis);
        });*/

        binding.rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        //binding.rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));//2 li 2li aşapı doğru
        //binding.rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));//insta hikaye kısmı gibi


        kisilers=new ArrayList<>();
        Kisiler k1= new Kisiler(1,"Ahmet","1111");
        Kisiler k2= new Kisiler(1,"Ali","2222");
        Kisiler k3= new Kisiler(1,"Veli","3333");
        Kisiler k4= new Kisiler(1,"Deli","4444");

        kisilers.add(k1);
        kisilers.add(k2);
        kisilers.add(k3);
        kisilers.add(k4);

        adapter= new KisilerAdapter(requireContext(),kisilers);
        binding.rv.setAdapter(adapter);


        binding.floatingActionButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_anaSayfaFragment_to_kaydetFragment);
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ara(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ara(s);
                return true;
            }
        });





        return binding.getRoot();
    }

    private void ara(String s) {
        ArrayList<Kisiler> filtrelenmisKisiler = new ArrayList<>();
        for (Kisiler kisi : kisilers) {
            if (kisi.getAd().toLowerCase().contains(s.toLowerCase())) {
                filtrelenmisKisiler.add(kisi);
            }
        }
        adapter.setFiltrelenmisKisiler(filtrelenmisKisiler); // Filtrelenmiş verileri RecyclerView adapter'ına ayarlayın
    }


}