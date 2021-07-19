package ir.sarasaghaei.instagram_adv04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.sarasaghaei.instagram_adv04.adapter.MainViewPageAdapter;
import ir.sarasaghaei.instagram_adv04.adapter.PostGridAdapter;
import ir.sarasaghaei.instagram_adv04.adapter.ProfileViewPagerAdapter;
import ir.sarasaghaei.instagram_adv04.database.UserDBHelper;
import ir.sarasaghaei.instagram_adv04.entity.User;
import ir.sarasaghaei.instagram_adv04.fragment.GridFragment;
import ir.sarasaghaei.instagram_adv04.fragment.TagedFragment;

public class ProfileActivity extends AppCompatActivity {
    CircleImageView img_userpic;
    int id_user;
    TextView tv_countpost,tv_countfllowers,tv_countfllowing,tv_more,tv_backtoolbar;
    TextView tv_nameuser, tv_detailuser,tv_pagename;
    LinearLayout linear_post, linear_fllowers, linear_fllowing;
    NavigationView navigationView,nav_menu_bottom;
    DrawerLayout drawer_layout;
    ViewPager profileviewpager;
    TabLayout tab_post;
    ProfileViewPagerAdapter profileViewPagerAdapter;
    //Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        id_user = intent.getIntExtra("id_user", 0);
        User user = new UserDBHelper(this).select_user(id_user);
        init();


        img_userpic.setImageResource(user.getPic_user());
        tv_nameuser.setText(user.getName());
        tv_detailuser.setText(user.getDetail());
        tv_pagename.setText(user.getName());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(ProfileActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

                if(drawer_layout.isDrawerOpen(GravityCompat.END))
                {
                    drawer_layout.closeDrawer(GravityCompat.END);
                }
                return false;
            }
        });

        nav_menu_bottom.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(ProfileActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

                if(drawer_layout.isDrawerOpen(GravityCompat.END))
                {
                    drawer_layout.closeDrawer(GravityCompat.END);
                }
                return false;
            }
        });


    }
    private void init(){
        drawer_layout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_menu);
        nav_menu_bottom = findViewById(R.id.nav_menu_bottom);
        tv_backtoolbar = findViewById(R.id.tv_backtoolbar);
        tv_backtoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Map<String, Fragment> map = new HashMap<>();
        map.put("Post",new GridFragment());
        map.put("Tagpost",new TagedFragment());

        profileviewpager = findViewById(R.id.viewPager_grid_postprofile);
        profileViewPagerAdapter = new ProfileViewPagerAdapter(getSupportFragmentManager(),map,id_user);
        profileviewpager.setAdapter(profileViewPagerAdapter);

        tab_post = findViewById(R.id.tab_post);
        tab_post.setupWithViewPager(profileviewpager);

        tab_post.getTabAt(0).setIcon(R.drawable.ic_archive);
        tab_post.getTabAt(1).setIcon(R.drawable.ic_insights);


        img_userpic = findViewById(R.id.img_userpic);
        tv_countpost = findViewById(R.id.tv_countpost);
        tv_countfllowers = findViewById(R.id.tv_countfllowers);
        tv_countfllowing = findViewById(R.id.tv_countfllowing);
        tv_nameuser = findViewById(R.id.tv_nameuser);
        tv_detailuser = findViewById(R.id.tv_detailuser);
        tv_more = findViewById(R.id.tv_more);

        linear_post = findViewById(R.id.linear_post);
        linear_fllowers = findViewById(R.id.linear_fllowers);
        linear_fllowing = findViewById(R.id.linear_fllowing);

        linear_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,tv_countpost.getText().toString(), BaseTransientBottomBar.LENGTH_SHORT);
                View view= snackbar.getView();

                view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                TextView textView = view.findViewById(R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                snackbar.show();
            }
        });
        linear_fllowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,tv_countfllowers.getText().toString(), BaseTransientBottomBar.LENGTH_SHORT);
                View view= snackbar.getView();

                view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                TextView textView = view.findViewById(R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                snackbar.show();
            }
        });
        linear_fllowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,tv_countfllowing.getText().toString(), BaseTransientBottomBar.LENGTH_SHORT);
                View view= snackbar.getView();

                view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                TextView textView = view.findViewById(R.id.snackbar_text);
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                snackbar.show();
            }
        });

        tv_more = findViewById(R.id.tv_more);
        tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.openDrawer(GravityCompat.END);
            }
        });

        tv_pagename = findViewById(R.id.tv_pagename);




    }

}