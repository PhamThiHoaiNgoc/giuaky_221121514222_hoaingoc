package due.giuaky221121514222;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import due.giuaky221121514222.day1.MainActivity;
import due.giuaky221121514222.day1.MaytinhActivity;
import due.giuaky221121514222.day2.Danhba2Activity;
import due.giuaky221121514222.day2.DanhbaActivity;
import due.giuaky221121514222.day2.LoginActivity;
import due.giuaky221121514222.day3.ListnewsActivity;
import due.giuaky221121514222.day3.Main2Activity;
import due.giuaky221121514222.day3.activity.WeatherActivity;

public abstract class BaseScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        // Setup Navigation Drawer
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    // Hàm này bắt buộc các Activity con phải override để set layout
    protected abstract int getLayoutResource();

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_b1) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_b2) {
            startActivity(new Intent(this, MaytinhActivity.class));
        } else if (id == R.id.nav_b3) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.nav_b4) {
            startActivity(new Intent(this, DanhbaActivity.class));
        } else if (id == R.id.nav_b5) {
            startActivity(new Intent(this, Danhba2Activity.class));
        } else if (id == R.id.nav_b6) {
            startActivity(new Intent(this, Main2Activity.class));
        } else if (id == R.id.nav_b7) {
            startActivity(new Intent(this, ListnewsActivity.class));
        } else if (id == R.id.nav_b8) {
            startActivity(new Intent(this, WeatherActivity.class));
        }
        drawerLayout.closeDrawers();
        return true;
    }
}

