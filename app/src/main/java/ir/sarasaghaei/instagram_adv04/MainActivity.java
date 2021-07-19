package ir.sarasaghaei.instagram_adv04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.HashMap;
import java.util.Map;
import ir.sarasaghaei.instagram_adv04.adapter.MainViewPageAdapter;
import ir.sarasaghaei.instagram_adv04.adapter.PostAdapter;
import ir.sarasaghaei.instagram_adv04.database.UserDBHelper;
import ir.sarasaghaei.instagram_adv04.fragment.MainFragment;
import ir.sarasaghaei.instagram_adv04.fragment.MessageFragment;
import ir.sarasaghaei.instagram_adv04.fragment.MoreBottomSheetFragment;
import ir.sarasaghaei.instagram_adv04.fragment.StoryFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.CallbackMainFragment, PostAdapter.CallbackpostAdapter {

    ViewPager mainviewPager;
    MainViewPageAdapter mainViewPageAdapter;
    LinearLayout linear_bottomsheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    private void init() {

        // import data to data base for base lode
        if (new UserDBHelper(this).isEmpty()) {
            new UserDBHelper(this).First_loade();
        }


        Map<String, Fragment> map = new HashMap<>();
        map.put("Story", new StoryFragment());
        map.put("Main", new MainFragment());
        map.put("Message", new MessageFragment());


        mainviewPager = findViewById(R.id.mainviewPager);
        mainViewPageAdapter = new MainViewPageAdapter(getSupportFragmentManager(), map);
        mainviewPager.setAdapter(mainViewPageAdapter);
        mainviewPager.setCurrentItem(1);


    }

    @Override
    public void onclickmore(boolean isclick) {
        MoreBottomSheetFragment fragment = new MoreBottomSheetFragment();
        fragment.show(getSupportFragmentManager(), "TAG");
    }

    @Override
    public void onclickmessage(boolean isclick) {

        mainviewPager.setCurrentItem(2);
    }


    @Override
    public void onBackPressed() {

        if (mainviewPager.getCurrentItem() == 1) {
            super.onBackPressed();
        } else {
            mainviewPager.setCurrentItem(1);
        }
    }
}