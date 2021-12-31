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
        val btnContactMe: Button = findViewById(R.id.btn_contactMe)
        btnContactMe.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_contactMe -> {
                val tel = 6282322093690
                val telIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$tel")
                }
                startActivity(telIntent)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}