package com.example.navdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.navdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toKeepItClose();
        binding.layoutLogin.checkboxTermsAndCondition.setOnClickListener(this);
        binding.layoutTermsAndCond.buttonAccept.setOnClickListener(this);
        binding.layoutTermsAndCond.buttonDecline.setOnClickListener(this);
    }

    private void toKeepItClose() {
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void toKeepItOpen() {
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
    }

    private void toUnlock() {
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    private void toOpen() {
        binding.drawerLayout.openDrawer(GravityCompat.END);
    }

    private void toClose() {
        binding.drawerLayout.closeDrawer(GravityCompat.END);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_accept:
                handleCheckBoxSetToTrue();
                toClose();
                break;
            case R.id.button_decline:
                handleCheckBoxSetToFalse();
                toClose();
                break;
            case R.id.checkbox_terms_and_condition:
                toOpen();
                break;
            default:
                break;
        }
    }

    private void handleCheckBoxSetToTrue(){
       binding.layoutLogin.checkboxTermsAndCondition.setChecked(true);
    }

    private void handleCheckBoxSetToFalse(){
        binding.layoutLogin.checkboxTermsAndCondition.setChecked(false);
    }

}