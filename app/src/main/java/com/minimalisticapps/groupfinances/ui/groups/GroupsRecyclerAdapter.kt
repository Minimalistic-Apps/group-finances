package com.minimalisticapps.groupfinances.ui.groups

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.minimalisticapps.groupfinances.R

class GroupsRecyclerAdapter(private val context: Context, private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<GroupsRecyclerAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)

        init {
            itemView.setOnLongClickListener { v: View ->
                AlertDialog.Builder(context)
                    .setTitle("Delete")
                    .setIcon(R.drawable.ic_warning)
                    .setMessage("Are you sure delete this group?")
                    .setPositiveButton("Yes") { dialog, _ ->
                        dataSet.removeAt(adapterPosition)
                        notifyItemRemoved(adapterPosition)
                        dialog.dismiss()
                    }
                    .setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                    .show()

                true
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.groups_recyclerview_item_row, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
