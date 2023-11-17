package com.andre.guryanov.cryptoapptest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.andre.guryanov.cryptoapptest.databinding.FragmentCoinListBinding
import com.andre.guryanov.cryptoapptest.presentation.adapters.CoinInfoAdapter

class CoinListFragment : Fragment() {

    private var _binding: FragmentCoinListBinding? = null
    private val binding: FragmentCoinListBinding
        get() = _binding ?: throw java.lang.RuntimeException("FragmentCoinListBinding is null")

    private lateinit var viewModel: CoinViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CoinInfoAdapter(requireContext())

        binding.rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        adapter.setOnCoinClickListener {
            ActivityCompanion.launchCoinDetailFragment(requireActivity(), it.fromSymbol)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}