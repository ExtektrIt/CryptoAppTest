package com.andre.guryanov.cryptoapptest.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andre.guryanov.cryptoapptest.R
import com.andre.guryanov.cryptoapptest.databinding.ItemCoinInfoBinding
import com.andre.guryanov.cryptoapptest.domain.CoinInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(
    private val context: Context
) : ListAdapter<CoinInfo, CoinInfoAdapter.CoinInfoViewHolder>(Comparator()) {

    private var onCoinClick: ( (CoinInfo) -> Unit )? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {

        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            with(coin) {
                val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                tvSymbols.text = String.format(symbolsTemplate, fromSymbol, toSymbol)
                tvPrice.text = price
                tvLastUpdate.text = String.format(lastUpdateTemplate, lastUpdate)
                Picasso.get().load(imageURL).into(ivLogoCoin)
                root.setOnClickListener {
                    onCoinClick?.let { click -> click(coin) }//?.onCoinClick(this)
                }
            }
        }
    }

    class CoinInfoViewHolder(
        val binding: ItemCoinInfoBinding
    ) : RecyclerView.ViewHolder(binding.root)


    fun setOnCoinClickListener(func: (coinInfo: CoinInfo) -> Unit) {
        onCoinClick = func
    }

//    interface OnCoinClickListener {
//        fun onCoinClick(coinPriceInfo: CoinInfo)
//    }

    class Comparator : DiffUtil.ItemCallback<CoinInfo>() {

        override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
            return oldItem.fromSymbol == newItem.fromSymbol
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
            return oldItem == newItem
        }

    }


}