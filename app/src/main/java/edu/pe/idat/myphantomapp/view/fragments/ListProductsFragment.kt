package edu.pe.idat.myphantomapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.pe.idat.myphantomapp.R
import edu.pe.idat.myphantomapp.databinding.FragmentListProductsBinding
import edu.pe.idat.myphantomapp.view.adapters.ProductAdapter
import edu.pe.idat.myphantomapp.viewmodel.ProductViewModel

class ListProductsFragment : Fragment() {

    private var _binding: FragmentListProductsBinding? = null
    private val binding get() =_binding!!
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListProductsBinding.inflate(inflater, container, false)
        binding.rvProducts.layoutManager = LinearLayoutManager(
            requireActivity()
        )
        productViewModel = ViewModelProvider(requireActivity()).get(ProductViewModel::class.java)
        listAllProducts()
        return binding.root
    }

    private fun listAllProducts() {
        productViewModel.listAllProducts().observe(viewLifecycleOwner, {
            binding.rvProducts.adapter = ProductAdapter(it)
        })
    }

}