package com.example.cake_shop.ui.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cake_shop.R
import com.example.cake_shop.databinding.ActivityProductsBinding
import com.example.cake_shop.model.data.ProductsDataClass
import com.example.cake_shop.ui.adapter.ProductsFastAdapter
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class ProductsActivity : AppCompatActivity() {

    private lateinit var productsActivityBinding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productsActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_products)

        val itemAdapter =
            ItemAdapter<ProductsFastAdapter>()
        val fastAdapter =
            FastAdapter.with(itemAdapter)

        productsActivityBinding.recyclerview.layoutManager =
            LinearLayoutManager(this)
        productsActivityBinding.recyclerview.adapter =
            fastAdapter // Nastavuje recyclerview co bude obsahem
        productsActivityBinding.recyclerview.setHasFixedSize(true)

        productsActivityBinding.imbtnBack.setOnClickListener {
            setResult(0)
            finish()
        }

        itemAdapter.add(
            ProductsFastAdapter(
                ProductsDataClass(
                    "CAKES", R.drawable.cake
                )
            )
        )
        itemAdapter.add(
            ProductsFastAdapter(
                ProductsDataClass(
                    "ICE CREAMES", R.drawable.ice_creame
                )
            )
        )
        itemAdapter.add(
            ProductsFastAdapter(
                ProductsDataClass(
                    "DESSERTS", R.drawable.desert
                )
            )
        )
    }
}