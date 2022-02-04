package jp.dorakura.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import jp.dorakura.myapplication.databinding.ActivityMainBinding

import jp.dorakura.myapplication.ui.todo.ToDoList


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main) )


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bnMenu

        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragcon) as NavHostFragment\

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragcon) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)



    }
}