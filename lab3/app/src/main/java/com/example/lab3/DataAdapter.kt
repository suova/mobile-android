import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.Contact
import com.example.lab3.R

class DataAdapter (private val mContacts: List<Contact>) : RecyclerView.Adapter<DataAdapter.ViewHolder>()
{
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {

        val messageButton = itemView.findViewById<Button>(R.id.message_button)
        val nameTextView = itemView.findViewById<TextView>(R.id.info_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_card, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: DataAdapter.ViewHolder, position: Int) {
        val contact: Contact = mContacts.get(position)
        val textView = viewHolder.nameTextView
        textView.setText(contact.name)
        val button = viewHolder.messageButton
        button.text = if (contact.isOnline) "Message" else "Offline"
        button.isEnabled = contact.isOnline
    }

    override fun getItemCount(): Int {
        return mContacts.size
    }
}