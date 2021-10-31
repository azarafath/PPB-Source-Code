package id.my.zakariafathoni.aplikasihitungvolumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val STATE_RESULT = "state_result"
    }
    private lateinit var bilPanjang: EditText
    private lateinit var bilLebar: EditText
    private lateinit var bilTinggi: EditText
    private lateinit var btnHasil: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bilPanjang = findViewById(R.id.fieldPanjang)
        bilLebar = findViewById(R.id.fieldLebar)
        bilTinggi = findViewById(R.id.fieldTinggi)
        btnHasil = findViewById(R.id.btnHitung)
        tvHasil = findViewById(R.id.tvHasil)


        btnHasil.setOnClickListener(this)
        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if(v.id == R.id.btnHitung){
                val panjang = bilPanjang.text.toString().trim()
                val lebar = bilLebar.text.toString().trim()
                val tinggi = bilTinggi.text.toString().trim()
                var isEmptyField = false
                if (panjang.isEmpty()){
                    isEmptyField = true
                    bilPanjang.error = "Field Tidak Boleh Kosong"
                }
                if (lebar.isEmpty()){
                    isEmptyField = true
                    bilLebar.error = "Field Tidak Boleh Kosong"
                }
                if (tinggi.isEmpty()){
                    isEmptyField = true
                    bilTinggi.error = "Field Tidak Boleh Kosong"
                }
                if (!isEmptyField){
                    val jumlah = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                    tvHasil.text = jumlah.toString()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvHasil.text.toString())
    }
}