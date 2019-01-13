package analyzer.interest.admin.interestanalyzer.ui.main.adapter

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.model.EventModel
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list_main.view.*

class EventListAdapter(private val context: Context,
                       private var events: ArrayList<EventModel>,
                       private var listener: MainListActivityListener) : RecyclerView.Adapter<EventListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_main, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events[position])
        if (position == events.size - 1) {
            holder.itemView.view_bottom_line.visibility = View.INVISIBLE
        } else {
            holder.itemView.view_bottom_line.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener { listener.onClickToEventItem(events[position].name) }
    }

    override fun getItemCount() = events.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView

        fun bind(wallet: EventModel) {
            view.tv_name.text = wallet.name
        }
    }

    interface MainListActivityListener {

        fun onClickToEventItem(name: String)
    }

    fun updateCoins(events: ArrayList<EventModel>) {
        this.events = events
        notifyDataSetChanged()
    }
}