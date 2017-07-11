package com.github.pedramrn.conductorsea;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.github.pedramrn.conductorsea.changehandler.LongTransition;
import com.github.pedramrn.conductorsea.databinding.RowItemBinding;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2017-05-09
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private final Router router;

    public Adapter(Router router) {
        this.router = router;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowItemBinding binding = RowItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RowItemBinding binding;

        public ViewHolder(RowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final int position) {
            @DrawableRes final int id;
            switch (position % 6) {
                case 0:
                    id = R.drawable.placekitten_1;
                    binding.imageViewIcon.setImageResource(id);
                    break;
                case 1:
                    id = R.drawable.placekitten_2;
                    binding.imageViewIcon.setImageResource(id);
                    break;
                case 2:
                    id = R.drawable.placekitten_3;
                    binding.imageViewIcon.setImageResource(id);
                    break;
                case 3:
                    id = R.drawable.placekitten_4;
                    binding.imageViewIcon.setImageResource(id);
                    break;
                case 4:
                    id = R.drawable.placekitten_5;
                    binding.imageViewIcon.setImageResource(id);
                    break;
                case 5:
                    id = R.drawable.placekitten_6;
                    binding.imageViewIcon.setImageResource(id);
                    break;
                default:
                    id = R.drawable.placekitten_1;
                    binding.imageViewIcon.setImageResource(id);
            }
            final String transitionName = "tran_" + position;
            binding.imageViewIcon.setTransitionName(transitionName);
            binding.textViewTitle.setText(transitionName);
            Log.d(TAG, "bind() called " + transitionName);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    router.pushController(RouterTransaction.with(new ControllerDetails(id, transitionName))
                            .pushChangeHandler(new LongTransition())
                            .popChangeHandler(new LongTransition()));
                    //// TODO: 2017-07-11 uncomment
                    // .pushChangeHandler(new LongTransition(transitionName))
                    // .popChangeHandler(new LongTransition(transitionName)));
                }
            });
        }
    }

    private static final String TAG = Adapter.class.getSimpleName();
}
