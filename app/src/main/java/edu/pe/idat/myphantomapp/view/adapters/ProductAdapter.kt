package edu.pe.idat.myphantomapp.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.pe.idat.myphantomapp.databinding.ItemProductBinding
import edu.pe.idat.myphantomapp.retrofit.responses.ResponseListProducts
import edu.pe.idat.myphantomapp.utils.Env

class ProductAdapter(private var listProducts: ResponseListProducts): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder (val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listProducts.data[position]){
                binding.tvProductName.text = attributes?.title
                binding.tvProductDescription.text = attributes?.description
                binding.tvProductPrice.text = attributes?.price.toString()
                binding.tvProductStock.text = attributes?.stock.toString()
                Glide.with(holder.itemView.context)
                    .load("${attributes?.picture?.data?.attributes?.url}")
                    //.load("https://www.notebookcheck.org/fileadmin/_processed_/0/9/csm_Sony_Playstation_5_Pro_Rendervideo_ccb1030d9d.jpg")
                    .into(binding.ivProductImage)
            }
        }
    }

    override fun getItemCount() = listProducts.data.size

}