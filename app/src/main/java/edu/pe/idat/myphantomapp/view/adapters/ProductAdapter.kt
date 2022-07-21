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
//                    .load("${Env().DOMAIN_URL}${attributes?.picture?.data?.attributes?.url}")
                    .load("https://phantom.pe/pub/media/catalog/product/cache/71a032b60710d907b279b6023a79a12b/p/s/ps5_playstation_5_disco_ranura_1_1.jpg")
                    .into(binding.ivProductImage)
            }
        }
    }

    override fun getItemCount() = listProducts.data.size

}