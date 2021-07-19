package ir.sarasaghaei.instagram_adv04.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ir.sarasaghaei.instagram_adv04.ProfileActivity;
import ir.sarasaghaei.instagram_adv04.R;
import ir.sarasaghaei.instagram_adv04.entity.User;

public class PostGridAdapter extends RecyclerView.Adapter<PostGridAdapter.PostGridViewHolder> {

    Context context;
    List<User> post_user;

    public PostGridAdapter(Context context, List<User> post_user) {
        this.context = context;
        this.post_user = post_user;
    }


    @NonNull
    @Override
    public PostGridAdapter.PostGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_post_grid,parent,false);
        return new PostGridAdapter.PostGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostGridViewHolder holder, int position) {
        final User user = post_user.get(position);

        holder.img_postgrid.setImageResource(user.getLink_post1());
        holder.img_postgrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,String.valueOf(user.getId_post()), BaseTransientBottomBar.LENGTH_SHORT);
                View view= snackbar.getView();

                view.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                TextView textView = view.findViewById(R.id.snackbar_text);
                textView.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                snackbar.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return post_user.size();
    }

     class PostGridViewHolder extends RecyclerView.ViewHolder {
        ImageView img_postgrid;

        public PostGridViewHolder(@NonNull View itemView) {
            super(itemView);

            img_postgrid = itemView.findViewById(R.id.img_postgrid);
        }
    }
}
