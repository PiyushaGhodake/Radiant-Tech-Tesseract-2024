package com.example.pathsage;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class DetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomnav;
    FragmentManager fragmentManager;

    Toolbar toolbar;

    Button b3;
    FirebaseAuth mAuth;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        toolbar=findViewById(R.id.toolbar);
        bottomnav=findViewById(R.id.bottom_navigation);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        toggle.syncState();
        NavigationView navigationView=findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        bottomnav.setBackground(null);
        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId=item.getItemId();
                if(itemId==R.id.nav_home)
                {
                    openFragment(new HomeFragment());
                    return true;
                }
                else if(itemId==R.id.nav_counsellor)
                {
                    openFragment(new CounsellorhelpFragment());
                    return true;
                }
                else if(itemId==R.id.nav_chatbot)
                {
                    openFragment(new ChatbotFragment());
                    return true;
                }
                return false;
            }
        });
        fragmentManager=getSupportFragmentManager();
        openFragment(new HomeFragment());

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.nav_home)
        {
            openFragment(new HomeFragment());

        }
        else if(itemId==R.id.nav_counsellor)
        {
            openFragment(new CounsellorhelpFragment());
        }
        else if(itemId==R.id.nav_chatbot)
        {
            openFragment(new ChatbotFragment());
        }
        else if(itemId==R.id.nav_logout)
        {

                    //mAuth.getInstance().signOut();
                   // finish();
            open();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
    private void openFragment(Fragment fragment)
    {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();

    }
    private void open() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("LOGOUT");
        builder.setMessage("Are you sure you want to log out?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                mAuth.getInstance().signOut();
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();

    }

}