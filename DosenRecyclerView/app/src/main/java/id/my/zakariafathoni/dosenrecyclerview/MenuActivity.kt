package id.my.zakariafathoni.dosenrecyclerview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnWaMe: Button = findViewById(R.id.btn_wa)
        btnWaMe.setOnClickListener(this)
        val btnGithub: Button = findViewById(R.id.btn_github)
        btnGithub.setOnClickListener(this)
        val btnLinkedin: Button = findViewById(R.id.btn_linked)
        btnLinkedin.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_wa -> {
                val waMe = "http://wa.me/6282322093690"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(waMe)
                startActivity(i)
            }
            R.id.btn_github -> {
                val gitMe = "https://github.com/azarafath"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(gitMe)
                startActivity(i)
            }
            R.id.btn_linked -> {
                val linkMe = "https://www.linkedin.com/in/ahmad-zakaria-fathoni-42316420b/"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(linkMe)
                startActivity(i)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}