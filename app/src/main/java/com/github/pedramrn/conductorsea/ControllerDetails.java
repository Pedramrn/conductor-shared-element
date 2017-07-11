package com.github.pedramrn.conductorsea;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.github.pedramrn.conductorsea.databinding.ControllerDetailsBinding;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2017-05-09
 */

public class ControllerDetails extends Controller {


    private int res;
    private String sharedEl;

    public ControllerDetails(@DrawableRes int res, String sharedEl) {
        this.res = res;
        this.sharedEl = sharedEl;
    }

    public ControllerDetails() {
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        ControllerDetailsBinding binding = ControllerDetailsBinding.inflate(inflater, container, false);
        binding.imageView.setImageResource(res);
        binding.imageView.setTransitionName(sharedEl);
        Log.d(TAG, "bind() called " + sharedEl);

        return binding.getRoot();
    }

    private static final String TAG = ControllerDetails.class.getSimpleName();
}
