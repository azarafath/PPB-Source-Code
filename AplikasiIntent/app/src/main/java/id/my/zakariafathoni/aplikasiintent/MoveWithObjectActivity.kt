package id.my.zakariafathoni.aplikasiintent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tvActivityData)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person

        val teks = "Nama : ${person.name}\n" +
                "Umur : ${person.age}\n" +
                "Email : ${person.email}\n" +
                "Lokasi : ${person.city}"

        tvObject.text = teks
    }
}