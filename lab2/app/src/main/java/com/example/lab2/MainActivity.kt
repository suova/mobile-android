package com.example.lab2

 import android.annotation.SuppressLint
 import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2.databinding.MainLayoutBinding
 import java.time.LocalDateTime
import java.util.*
 import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var locale: Locale
    private var currentLang: String? = null
    private lateinit var binding: MainLayoutBinding
    private val newData = NewData("The best city ever")


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        binding.button.setOnClickListener {
            val current = LocalDateTime.now()
            binding.textView2?.text = "$current"
        }
        setContentView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.language) {
            if(getString(R.string.language_eng)=="Язык: рус"){
                setLocale("en")
            }else{
                setLocale("ru")
            }
            return true
        }

        if (id == R.id.love) {
            Toast.makeText(this, getString(R.string.this_love), Toast.LENGTH_LONG).show()
            return true
        }

        return super.onOptionsItemSelected(item)

    }

    private fun setLocale(localeName: String) {
        locale = Locale(localeName)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = locale
        res.updateConfiguration(conf, dm)
        val refresh = Intent(
            this,
            MainActivity::class.java
        )
        refresh.putExtra(currentLang, localeName)
        startActivity(refresh)
    }
}