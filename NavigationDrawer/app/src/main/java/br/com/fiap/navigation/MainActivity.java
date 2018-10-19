package br.com.fiap.navigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawelayout);
        toogle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.abrir,
                R.string.fechar
        );
        toogle.syncState();

        NavigationView navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                
                if (menuItem.getItemId() == R.id.mniHome) {
                    changeFragment(new HomeFragment());
                } else {
                    changeFragment(new SobreFragment());
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

    }

    private void changeFragment(Fragment fragment) {

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragmentWrapper, fragment)
            .addToBackStack(null)
            .commit();

    }
    
}
