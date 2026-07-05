package com.tuan.shadowenglish

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.tuan.shadowenglish.data.local.DatabaseSeeder
import com.tuan.shadowenglish.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var databaseSeeder: DatabaseSeeder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            try {
                databaseSeeder.seedIfEmpty()
            } catch (exception: Exception) {
                Toast.makeText(this@MainActivity, "Không thể tải dữ liệu ban đầu", Toast.LENGTH_SHORT).show()
            } finally {
                binding.progressBar.visibility = View.GONE
                binding.navHostFragment.visibility = View.VISIBLE
            }
        }
    }
}
