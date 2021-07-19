package ir.sarasaghaei.instagram_adv04.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.sarasaghaei.instagram_adv04.ProfileActivity;
import ir.sarasaghaei.instagram_adv04.R;
import ir.sarasaghaei.instagram_adv04.entity.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycleview,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserViewHolder holder, int position) {
        final User user = userList.get(position);

        holder.img_item_recycle.setImageResource(user.getPic_user());
        holder.tv_item_recycle.setText(user.getName());
        holder.tv_iduserrecycle.setText(String.valueOf(user.getId_user()));
        holder.img_item_recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("id_user",user.getId_user());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img_item_recycle;
        TextView tv_item_recycle,tv_iduserrecycle;
        CardView cardview_item;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item_recycle = itemView.findViewById(R.id.img_item_recycle);
            tv_item_recycle = itemView.findViewById(R.id.tv_item_recycle);
            cardview_item = itemView.findViewById(R.id.cardview_item);
            tv_iduserrecycle = itemView.findViewById(R.id.tv_iduserrecycle);

        }
    }
}
