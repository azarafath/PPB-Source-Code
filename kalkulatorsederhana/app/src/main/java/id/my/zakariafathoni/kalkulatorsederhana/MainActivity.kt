package id.my.zakariafathoni.kalkulatorsederhana

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
    private lateinit var editBil1: EditText
    private lateinit var editBil2: EditText
    private lateinit var btnPlus: Button
    private lateinit var btnMin: Button
    private lateinit var btnKali: Button
    private lateinit var btnBagi: Button
    private lateinit var btnClear: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editBil1 = findViewById(R.id.editAngka1)
        editBil2 = findViewById(R.id.editAngka2)
        btnPlus = findViewById(R.id.btnPlus)
        btnMin = findViewById(R.id.btnMin)
        btnKali = findViewById(R.id.btnKali)
        btnBagi = findViewById(R.id.btnBagi)
        btnClear = findViewById(R.id.btnClear)
        tvHasil = findViewById(R.id.tvHasil)

        btnPlus.setOnClickListener(this)
        btnMin.setOnClickListener(this)
        btnKali.setOnClickListener(this)
        btnBagi.setOnClickListener(this)
        btnClear.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            val inputAngka1 = editBil1.text.toString().trim()
            val inputAngka2 = editBil2.text.toString().trim()
            var isEmptyField = false
            if (inputAngka1.isEmpty()){
                isEmptyField = true
                editBil1.error = "Field Tidak Boleh Kosong"
            }
            if (inputAngka2.isEmpty()){
                isEmptyField = true
                editBil2.error = "Field Tidak Boleh Kosong"
            }
            if(v.id == R.id.btnPlus){
                if (!isEmptyField){
                    val jumlah = inputAngka1.toDouble() + inputAngka2.toDouble()
                    tvHasil.text = jumlah.toString()
                }
            }

            if(v.id == R.id.btnMin){
                if (!isEmptyField){
                    val jumlah = inputAngka1.toDouble() - inputAngka2.toDouble()
                    tvHasil.text = jumlah.toString()
                }

            }
            if(v.id == R.id.btnKali){
                if (!isEmptyField){
                    val jumlah = inputAngka1.toDouble() * inputAngka2.toDouble()
                    tvHasil.text = jumlah.toString()
                }

            }
            if(v.id == R.id.btnBagi){
                if (!isEmptyField){
                    val jumlah = inputAngka1.toDouble() / inputAngka2.toDouble()
                    tvHasil.text = jumlah.toString()
                }

            }
            if(v.id == R.id.btnClear){
                editBil1.text = null
                editBil2.text = null
                tvHasil.text = "0"
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvHasil.text.toString())
    }


}