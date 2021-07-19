package ir.sarasaghaei.instagram_adv04.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.Map;

import ir.sarasaghaei.instagram_adv04.fragment.GridFragment;
import ir.sarasaghaei.instagram_adv04.fragment.TagedFragment;

public class ProfileViewPagerAdapter extends FragmentPagerAdapter {
    Map<String,Fragment> map;
    int id_user;

    public ProfileViewPagerAdapter(@NonNull FragmentManager fm, Map<String,Fragment> map,int id_user) {
        super(fm);
        this.map = map;
        this.id_user = id_user;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            {
                GridFragment gridFragment = GridFragment.newInstance(id_user);
                Bundle bundle = new Bundle();
                bundle.putString("id_user", String.valueOf(id_user));
                gridFragment.setArguments(bundle);
                return gridFragment;
            }
            case 1: return new TagedFragment();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return map.size();
    }
}
