package ir.sarasaghaei.instagram_adv04.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.sarasaghaei.instagram_adv04.R;
import ir.sarasaghaei.instagram_adv04.adapter.PostAdapter;
import ir.sarasaghaei.instagram_adv04.adapter.UserAdapter;
import ir.sarasaghaei.instagram_adv04.database.UserDBHelper;

public class MainFragment extends Fragment {

    RecyclerView recyclerView,recycleviewpost;
    UserAdapter userAdapter;
    PostAdapter postAdapter;
    Toolbar toolbar;
    TextView tv_message, more_menu_post;

    public interface CallbackMainFragment{
        void onclickmessage(boolean isclick);
    }
    CallbackMainFragment listener;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentmain, container, false);

        recyclerView = view.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        userAdapter = new UserAdapter(getContext(), new UserDBHelper(getContext()).select_user());
        recyclerView.setAdapter(userAdapter);


        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        tv_message = view.findViewById(R.id.tv_message);
        tv_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onclickmessage(true);
                }
            }
        });


        recycleviewpost = view.findViewById(R.id.recycleviewpost);
        recycleviewpost.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        postAdapter = new PostAdapter(getContext(),new UserDBHelper(getContext()).select_post());
        recycleviewpost.setAdapter(postAdapter);

        return view;


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof CallbackMainFragment)
        {
            listener = (CallbackMainFragment) context;
        }
    }
}
