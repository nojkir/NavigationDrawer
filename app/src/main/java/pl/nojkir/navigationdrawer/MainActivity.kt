package pl.nojkir.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener    {
        private lateinit var drawer : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)
        val navigationView : NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this,drawer,toolbar,
        R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            LoginFragment()).commit()


        }



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_przysiad -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                PrzysiadFragment()).commit()
            R.id.nav_kalkulator -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            KalkulatorFragment()).commit()
            R.id.nav_wyciskanie -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            WyciskanieFragment()).commit()
            R.id.nav_martwy -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            MartwyFragment()).commit()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.profil_button){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            MainFragment()).commit()
        }
        return super.onOptionsItemSelected(item)
    }


}
