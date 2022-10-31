package com.huynguyen.realestate.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.huynguyen.realestate.R
import com.huynguyen.realestate.data.model.EstateProperty
import com.huynguyen.realestate.databinding.EstateItemBinding

class EstateRecyclerViewAdapter(val mListener : OnItemClickListener): RecyclerView.Adapter<EstateRecyclerViewAdapter.EstateViewHolder>() {

    private lateinit var data:List<EstateProperty>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstateViewHolder {
        val binding: EstateItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.estate_item, parent, false)
        return EstateViewHolder(binding, mListener)
    }

    override fun onBindViewHolder(holder: EstateViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            mListener.onItemClick(data[position])
        }
    }

    override fun getItemCount(): Int {
        return if(::data.isInitialized) data.size else 0
    }

    fun updateDataList(data:List<EstateProperty>){
        this.data = data
        notifyDataSetChanged()
    }


    class EstateViewHolder(
        private val viewBinding: EstateItemBinding,
        private val listener: EstateRecyclerViewAdapter.OnItemClickListener
    ) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: EstateProperty){
            viewBinding.apply {
                estateName.text = item.name
                estateAddress.text = item.location
                estatePrice.text = item.price
                Glide.with(estateImage.context)
                    .load(item.image)
                    .diskCacheStrategy( DiskCacheStrategy.AUTOMATIC  )
                    .into(estateImage)
                setLikedProperty(estateLiked, item.isLiked)
                estateLiked.setOnClickListener {
                    setLikedProperty(estateLiked, !item.isLiked)
                    listener.onLiked(item)
                }
            }
        }

        private fun setLikedProperty(image: ImageView, isLiked: Boolean) {
            if(isLiked) {
                image.setImageResource(R.drawable.ic_heart_selected)
            } else {
                image.setImageResource(R.drawable.ic_heart_unselected)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(estate: EstateProperty)
        fun onLiked(estate: EstateProperty)
    }
}



