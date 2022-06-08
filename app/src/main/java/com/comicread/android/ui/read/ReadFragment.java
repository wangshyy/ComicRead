package com.comicread.android.ui.read;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.comicread.android.R;

public class ReadFragment extends Fragment {
    private String imageUri;
    private ImageView comicImage;

    public ReadFragment(String imageUri) {
        this.imageUri = imageUri;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.read_fragment,container);
        comicImage = view.findViewById(R.id.comic_image);
        Glide.with(getActivity()).load(imageUri).into(comicImage);
        return view;
    }
}
