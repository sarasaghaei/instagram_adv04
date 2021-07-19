package ir.sarasaghaei.instagram_adv04.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Map;
import ir.sarasaghaei.instagram_adv04.fragment.MainFragment;
import ir.sarasaghaei.instagram_adv04.fragment.MessageFragment;
import ir.sarasaghaei.instagram_adv04.fragment.StoryFragment;

public class MainViewPageAdapter extends FragmentPagerAdapter {

    Map<String,Fragment> map;




    public MainViewPageAdapter(@NonNull FragmentManager fm,Map<String,Fragment> map) {
        super(fm);
        this.map = map;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new StoryFragment();
                // This is the fragment that needs focus
            case 1:
                return new MainFragment();
            case 2:
                return new MessageFragment();
            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return map.size();
    }
}
