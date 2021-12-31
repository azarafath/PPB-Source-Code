package id.my.zakariafathoni.dosenrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.my.zakariafathoni.dosenrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvDosen : RecyclerView
    private var list: ArrayList<Dosen> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDosen = findViewById(R.id.rv_dosen)
        rvDosen.setHasFixedSize(true)

        list.addAll(DataDosen.listData)

        val cardViewHolder = DosenAdapter(list)
        rvDosen.adapter = cardViewHolder

        rvDosen.layoutManager = LinearLayoutManager(this)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                val i = Intent(this, MenuActivity::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }
}