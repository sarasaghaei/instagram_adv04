package ir.sarasaghaei.instagram_adv04.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.sarasaghaei.instagram_adv04.ProfileActivity;
import ir.sarasaghaei.instagram_adv04.R;
import ir.sarasaghaei.instagram_adv04.database.UserDBHelper;
import ir.sarasaghaei.instagram_adv04.entity.User;
import ir.sarasaghaei.instagram_adv04.fragment.MainFragment;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    Context context;
    List<User> userpost;

    public interface CallbackpostAdapter{
        void onclickmore(boolean isclick);
    }
    CallbackpostAdapter listener;

    public PostAdapter(Context context, List<User> userpost) {
        this.context = context;
        this.userpost = userpost;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_poat,null,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder holder, int position) {
        final User user_post = userpost.get(position);
        holder.img_userpost.setImageResource(user_post.getPic_user());
        holder.tv_username_post.setText(user_post.getName());
        holder.imgview_post.setImageResource(user_post.getLink_post1());
        holder.tv_idliked.setText(String.valueOf(user_post.getLike_post()));
        holder.tv_detailpost.setText(user_post.getDetail_post());
        holder.tv_id_post.setText(String.valueOf(user_post.getId_post()));
        holder.tv_id_user.setText(String.valueOf(user_post.getId_user()));

        holder.img_userpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("id_user",user_post.getId_user());
                context.startActivity(intent);
            }
        });

        holder.tv_likepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num_likepost = Integer.parseInt(holder.tv_idliked.getText().toString());

                if(holder.tv_likepost.getTag().equals("Like")){
                    holder.tv_likepost.setBackgroundResource(R.drawable.ic_liked);
                    num_likepost += 1;
                    int liked = new UserDBHelper(context).updatelikedpost(
                            user_post.getId_post(),num_likepost);
                    holder.tv_idliked.setText(String.valueOf(liked));
                    holder.tv_likepost.setTag("Liked");
                }else {
                    holder.tv_likepost.setBackgroundResource(R.drawable.ic_like);
                    num_likepost -= 1;
                    int liked = new UserDBHelper(context).updatelikedpost(
                            user_post.getId_post(),num_likepost);
                    holder.tv_idliked.setText(String.valueOf(liked));
                    holder.tv_likepost.setTag("Like");
                }
            }
        });

        holder.tv_markedpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.tv_markedpost.getTag().equals("off")){
                    holder.tv_markedpost.setBackgroundResource(R.drawable.ic_marked);
                    holder.tv_markedpost.setTag("on");
                }else {
                    holder.tv_markedpost.setBackgroundResource(R.drawable.ic_marke);
                    holder.tv_markedpost.setTag("off");
                }
            }
        });



        holder.more_menu_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onclickmore(true);
            }
        });


    }

    @Override
    public int getItemCount() {
        return userpost.size();
    }


    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tv_username_post,more_menu_post, tv_likepost, tv_commentpost,
                tv_sendpost, tv_markedpost, tv_idliked, tv_detailpost,tv_id_post,tv_id_user;
        CircleImageView img_userpost;
        ImageView imgview_post;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_username_post = itemView.findViewById(R.id.tv_username_post);
            img_userpost = itemView.findViewById(R.id.img_userpost);
            more_menu_post = itemView.findViewById(R.id.more_menu_post);
            imgview_post = itemView.findViewById(R.id.imgview_post);
            tv_likepost = itemView.findViewById(R.id.tv_likepost);
            tv_commentpost = itemView.findViewById(R.id.tv_commentpost);
            tv_sendpost = itemView.findViewById(R.id.tv_sendpost);
            tv_markedpost = itemView.findViewById(R.id.tv_markedpost);
            tv_idliked = itemView.findViewById(R.id.tv_idliked);
            tv_detailpost = itemView.findViewById(R.id.tv_detailpost);
            tv_id_post = itemView.findViewById(R.id.tv_id_post);
            tv_id_user = itemView.findViewById(R.id.tv_id_user);

        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if(context instanceof MainFragment.CallbackMainFragment)
        {
            listener = (PostAdapter.CallbackpostAdapter) context;
        }
    }
}
