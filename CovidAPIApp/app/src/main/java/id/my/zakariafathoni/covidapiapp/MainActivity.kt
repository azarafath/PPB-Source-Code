package id.my.zakariafathoni.covidapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import id.my.zakariafathoni.covidapiapp.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCovidAPI()
    }

    private fun getCovidAPI() {
        val client = AsyncHttpClient()
        val url = "https://api.kawalcorona.com/indonesia/"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                var result = String(responseBody)
                val jsonArray = JSONArray(result)
                val jsonObject = jsonArray.getJSONObject(0)
                val positif = jsonObject.getString("positif")
                val sembuh = jsonObject.getString("sembuh")
                val meninggal = jsonObject.getString("meninggal")
                val dirawat = jsonObject.getString("dirawat")
                binding.tvPositif.text = positif
                binding.tvSembuh.text = sembuh
                binding.tvMeninggal.text = meninggal
                binding.tvDirawat.text = dirawat
                print(responseBody.toString())
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }

}