import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.minipro.R

class GameAdapter : ListAdapter<Triple<Int, String, Double>, GameAdapter.GameViewHolder>(GameDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_game_adapter, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = getItem(position)
        holder.bind(game)
    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewGameId: TextView = itemView.findViewById(R.id.textViewGameId)
        private val textViewGameName: TextView = itemView.findViewById(R.id.textViewGameName)
        private val textViewGamePrice: TextView = itemView.findViewById(R.id.textViewGamePrice)

        fun bind(game: Triple<Int, String, Double>) {
            textViewGameId.text = "${game.first}"
            textViewGameName.text = "${game.second}"
            textViewGamePrice.text = "${game.third}"
        }
    }

    class GameDiffCallback : DiffUtil.ItemCallback<Triple<Int, String, Double>>() {
        override fun areItemsTheSame(oldItem: Triple<Int, String, Double>, newItem: Triple<Int, String, Double>): Boolean {
            return oldItem.first == newItem.first
        }

        override fun areContentsTheSame(oldItem: Triple<Int, String, Double>, newItem: Triple<Int, String, Double>): Boolean {
            return oldItem == newItem
        }
    }
}