package FinalProject.antermakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import FinalProject.antermakan.fragments.HomeFragment;
import FinalProject.antermakan.fragments.OrderFragment;
import FinalProject.antermakan.fragments.ProfileFragment;
import FinalProject.antermakan.fragments.StallFragment;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView navigation;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment homeFragment = new HomeFragment();
    private Fragment stallFragment = new StallFragment();
    private Fragment orderFragment = new OrderFragment();
    private Fragment profileFragment = new ProfileFragment();
    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        fragmentManager.beginTransaction().add(R.id.fragment_container, profileFragment).hide(profileFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, orderFragment).hide(orderFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, stallFragment).hide(stallFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, homeFragment).commit();

        activeFragment = homeFragment;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_menu_home){
            fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
            activeFragment = homeFragment;
            return true;
        }else if(item.getItemId() == R.id.navigation_menu_stall) {
            fragmentManager.beginTransaction().hide(activeFragment).show(stallFragment).commit();
            activeFragment = stallFragment;
            return true;
        }else if(item.getItemId() == R.id.navigation_menu_order) {
            fragmentManager.beginTransaction().hide(activeFragment).show(orderFragment).commit();
            activeFragment = orderFragment;
            return true;
        }else if(item.getItemId() == R.id.navigation_menu_profile) {
            fragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit();
            activeFragment = profileFragment;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}