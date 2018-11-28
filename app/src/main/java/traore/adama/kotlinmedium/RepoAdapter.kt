package traore.adama.kotlinmedium

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import traore.adama.kotlinmedium.databinding.RvItemRepositoryBinding

class RepoAdapter(private var items: ArrayList<Repository>, private var listener: OnItemClickListener):RecyclerView.Adapter<RepoAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemRepositoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


    class ViewHolder(private var binding: RvItemRepositoryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(repo:Repository, listener: OnItemClickListener){
            binding.repository = repo
            if(listener != null)
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition)}

            binding.executePendingBindings()
        }
    }

    fun replaceData(neoItems: ArrayList<Repository>){
        items = neoItems
        notifyDataSetChanged()
    }
}