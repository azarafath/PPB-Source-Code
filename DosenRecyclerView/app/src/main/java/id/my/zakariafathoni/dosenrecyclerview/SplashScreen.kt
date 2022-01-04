package id.my.zakariafathoni.dosenrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class SplashScreen : AppCompatActivity() {
    private var TIME_OUT:Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        loadSplashScreen()
    }
    private fun loadSplashScreen(){
        Handler().postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },TIME_OUT)
    }
}

