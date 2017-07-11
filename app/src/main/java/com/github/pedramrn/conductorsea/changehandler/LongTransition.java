package com.github.pedramrn.conductorsea.changehandler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;

import com.github.pedramrn.conductorsea.changehandler.ArcFadeMoveChangeHandler;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2017-07-11
 */

public class LongTransition extends ArcFadeMoveChangeHandler {

    private int duration = 1000;

    public LongTransition() {
    }

    public LongTransition(String... sharedElementNames) {
        super(sharedElementNames);
    }

    @Nullable
    @Override
    public Transition getEnterTransition(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush) {
        return super.getEnterTransition(container, from, to, isPush).setDuration(duration);
    }

    @Nullable
    @Override
    public Transition getExitTransition(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush) {
        return super.getExitTransition(container, from, to, isPush).setDuration(duration);
    }

    @Nullable
    @Override
    public Transition getSharedElementTransition(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush) {
        return super.getSharedElementTransition(container, from, to, isPush).setDuration(duration);
    }

    @Override
    public boolean allowTransitionOverlap(boolean isPush) {
        return false;
    }
}
