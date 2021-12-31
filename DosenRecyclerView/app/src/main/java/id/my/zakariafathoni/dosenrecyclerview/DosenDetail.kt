package id.my.zakariafathoni.dosenrecyclerview

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DosenDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NIP = "extra_nip"
        const val EXTRA_KEAHLIAN = "extra_keahlian"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dosen_detail)
        var imgPhoto: ImageView = findViewById(R.id.img_item_foto)
        val tvNama: TextView = findViewById(R.id.tv_item_nama)
        val tvNip: TextView = findViewById(R.id.tv_item_nip)
        val tvKeahlian: TextView = findViewById(R.id.tv_item_keahlian)

        val name = intent.getStringExtra(EXTRA_NAME)
        val nip = intent.getStringExtra(EXTRA_NIP)
        val keahlian = intent.getStringExtra(EXTRA_KEAHLIAN)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        imgPhoto.setImageResource(photo)
        tvNama.text = name
        tvNip.text = "NIP  :  " + nip
        tvKeahlian.text = "KEAHLIAN  :  " + keahlian
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}