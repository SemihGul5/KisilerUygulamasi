package com.abrebo.kisiler.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.abrebo.kisiler.data.entity.Kisiler;
import com.abrebo.kisiler.databinding.CardTasarimBinding;
import com.abrebo.kisiler.databinding.FragmentAnaSayfaBinding;
import com.abrebo.kisiler.ui.fragments.AnaSayfaFragmentDirections;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.KartTasarimTutucu> {
    private Context mContext;
    private List<Kisiler> kisilerList;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerList) {
        this.mContext = mContext;
        this.kisilerList = kisilerList;
    }

    @NonNull
    @Override
    public KartTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding= CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new KartTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KartTasarimTutucu holder, int position) {
        Kisiler kisi= kisilerList.get(position);
        CardTasarimBinding binding=holder.binding;

        binding.textViewAd.setText(kisi.getAd());
        binding.textViewTel.setText(kisi.getTel());

        //karta tıklandığında detaya git
        binding.rvCard.setOnClickListener(view -> {
            AnaSayfaFragmentDirections.ActionAnaSayfaFragmentToDetayFragment gecis=AnaSayfaFragmentDirections.actionAnaSayfaFragmentToDetayFragment(kisi);
            Navigation.findNavController(view).navigate(gecis);
        });

        //sil resmine tıklandı
        binding.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,kisi.getAd()+" silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET",view1 -> {
                        sil(kisi.getId());
                    }).show();
        });
    }
    public void setFiltrelenmisKisiler(List<Kisiler> filtrelenmisKisiler) {
        this.kisilerList = filtrelenmisKisiler;
        notifyDataSetChanged(); // Adapter'i güncelleyin
    }

    private void sil(int id) {
        //silme işlemi
    }

    @Override
    public int getItemCount() {
        return kisilerList.size();
    }


    public class KartTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding binding;

        public KartTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
