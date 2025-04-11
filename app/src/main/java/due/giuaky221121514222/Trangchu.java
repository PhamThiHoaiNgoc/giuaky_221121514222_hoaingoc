package due.giuaky221121514222;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.ui.AppBarConfiguration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import due.giuaky221121514222.databinding.ActivityTrangchuBinding;
import due.giuaky221121514222.day1.MainActivity;
import due.giuaky221121514222.day1.MaytinhActivity;

import due.giuaky221121514222.day2.Danhba2Activity;
import due.giuaky221121514222.day2.DanhbaActivity;
import due.giuaky221121514222.day2.LoginActivity;

import due.giuaky221121514222.day3.ListnewsActivity;
import due.giuaky221121514222.day3.Main2Activity;
import due.giuaky221121514222.day3.activity.WeatherActivity;

public class Trangchu extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityTrangchuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTrangchuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Thiết lập toolbar
        setSupportActionBar(binding.appBarTrangchu.toolbar);

        // Kích hoạt nút "Up" (nút quay lại) trên thanh công cụ
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // Hiển thị nút quay lại
        }

        // Kết nối DrawerLayout và NavigationView
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Kết nối với ActionBarDrawerToggle để thanh điều hướng hoạt động
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.appBarTrangchu.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Cài đặt mục tiêu các hoạt động từ menu
        binding.navView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent = null;

            if (id == R.id.nav_b1) {
                intent = new Intent(this, MainActivity.class);
            } else if (id == R.id.nav_b2) {
                intent = new Intent(this, MaytinhActivity.class);
            } else if (id == R.id.nav_b3) {
                intent = new Intent(this, LoginActivity.class);
            } else if (id == R.id.nav_b4) {
                intent = new Intent(this, DanhbaActivity.class);
            } else if (id == R.id.nav_b5) {
                intent = new Intent(this, Danhba2Activity.class);
            } else if (id == R.id.nav_b6) {
                intent = new Intent(this, Main2Activity.class);
            } else if (id == R.id.nav_b7) {
                intent = new Intent(this, ListnewsActivity.class);
            } else if (id == R.id.nav_b8) {
                intent = new Intent(this, WeatherActivity.class);
            }

            if (intent != null) {
                startActivity(intent);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

            return false;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trangchu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {

        DrawerLayout drawer = binding.drawerLayout;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        return super.onSupportNavigateUp();
    }
}
