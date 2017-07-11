package com.github.pedramrn.conductorsea;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.github.pedramrn.conductorsea.databinding.ControllerHomeBinding;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2017-05-09
 */

@SuppressWarnings("SpellCheckingInspection")
public class ControllerHome extends Controller {
    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        ControllerHomeBinding binding = ControllerHomeBinding.inflate(inflater, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(new Adapter(getRouter()));

        return binding.getRoot();

    }
}