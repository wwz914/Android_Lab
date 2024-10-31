import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myapplication3.MainActivity_Context

class MyListAdapter(
    context: Context,
    items: List<String>,
    private val itemClickListener: MainActivity_Context
) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_activated_1, items) {

    var selectedItemPosition: Int = -1

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_activated_1, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = getItem(position)

        // Highlight the selected item
        view.setBackgroundResource(if (position == selectedItemPosition) android.R.color.holo_blue_light else android.R.color.transparent)

        view.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
            itemClickListener.onItemClick(position)
        }

        return view
    }
}