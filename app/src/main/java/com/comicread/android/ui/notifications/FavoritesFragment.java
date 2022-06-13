package com.comicread.android.ui.notifications;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.comicread.android.databinding.FragmentFavoritesBinding;


public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        return root;
    }
}