package com.example.viewpager;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Bottom extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        loadFragment(new Home());

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       Fragment fragment=null;
       switch (menuItem.getItemId()){

           case R.id.home:
               fragment=new Home();
               break;
           case R.id.profile:
               fragment=new Profile();
               break;
           case  R.id.add:
               fragment=new Add();
               break;

          default:
              fragment=new Home();
              break;



       }



        return loadFragment(fragment);
    }
}
