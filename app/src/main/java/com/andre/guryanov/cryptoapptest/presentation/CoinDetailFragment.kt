package com.andre.guryanov.cryptoapptest.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.andre.guryanov.cryptoapptest.R
import com.andre.guryanov.cryptoapptest.databinding.ActivityCoinDetailBinding
import com.andre.guryanov.cryptoapptest.databinding.FragmentCoinDetailBinding
import com.squareup.picasso.Picasso

class CoinDetailFragment : Fragment() {

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw java.lang.RuntimeException("FragmentCoinDetailBinding is null")
    private lateinit var viewModel: CoinViewModel
    val name = "CoinDetailFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (requireArguments().isEmpty) {
            return
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initObservers() {
        val fromSymbol = getSymbol()
        viewModel.getDetailInfo(fromSymbol).observe(viewLifecycleOwner) {
            with(binding) {
                tvPrice.text = it.price
                tvMinPrice.text = it.lowDay
                tvMaxPrice.text = it.highDay
                tvLastMarket.text = it.lastMarket
                tvLastUpdate.text = it.lastUpdate
                tvFromSymbol.text = it.fromSymbol
                tvToSymbol.text = it.toSymbol
                Picasso.get().load(it.imageURL).into(ivLogoCoin)
            }
        }
    }

    private fun getSymbol(): String {
        return requireArguments().getString(EXTRA_FROM_SYMBOL, EMPTY_SYMBOL)
    }


    companion object {

        private const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_SYMBOL = ""

        fun newInstance(fromSymbol: String) =
            CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_SYMBOL, fromSymbol)
                }
            }
    }
}