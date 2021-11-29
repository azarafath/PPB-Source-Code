package id.my.zakariafathoni.dosenrecyclerview

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DosenAdapter(private val listDosen: ArrayList<Dosen>) : RecyclerView.Adapter<DosenAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvNIP: TextView = itemView.findViewById(R.id.tv_item_nip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_card_dosen, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dosen = listDosen[position]
        Glide.with(holder.itemView.context)
            .load(dosen.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = dosen.name
        holder.tvNIP.text = dosen.nip
        holder.itemView.setOnClickListener {
            val activity = holder.itemView.context as Activity
            val dataView = Intent(activity, DosenDetail::class.java)
            dataView.putExtra(DosenDetail.EXTRA_PHOTO, dosen.photo)
            dataView.putExtra(DosenDetail.EXTRA_NAME, dosen.name)
            dataView.putExtra(DosenDetail.EXTRA_NIP, dosen.nip)
            dataView.putExtra(DosenDetail.EXTRA_KEAHLIAN, dosen.keahlian)
            activity.startActivity(dataView)
        }

    }

    override fun getItemCount(): Int {
        return listDosen.size
    }
}


