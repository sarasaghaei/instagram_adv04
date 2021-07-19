package ir.sarasaghaei.instagram_adv04.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ir.sarasaghaei.instagram_adv04.Const;
import ir.sarasaghaei.instagram_adv04.R;
import ir.sarasaghaei.instagram_adv04.adapter.PostGridAdapter;
import ir.sarasaghaei.instagram_adv04.adapter.UserAdapter;
import ir.sarasaghaei.instagram_adv04.database.UserDBHelper;

public class GridFragment extends Fragment {
    RecyclerView recycle_postgrid;
    PostGridAdapter postGridAdapter;


    public static GridFragment newInstance(int id_user)
    {
        GridFragment fragment=new GridFragment();

        Bundle bundle=new Bundle();
        bundle.putInt(Const.ID_USER, id_user);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_grid =  inflater.inflate(R.layout.fragmentgrid , null);

        Bundle args = getArguments();
        int id_user = Integer.parseInt(Const.ID_USER);



        recycle_postgrid = view_grid.findViewById(R.id.recycle_postgrid);
        int cluom = 3;
        recycle_postgrid.setLayoutManager(new GridLayoutManager(getContext(), cluom));
        postGridAdapter = new PostGridAdapter(getContext(), new UserDBHelper(getContext()).select_post(id_user));
        recycle_postgrid.setAdapter(postGridAdapter);

        return view_grid;
    }
}
