package com.example.standard_week4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.standard_week4.databinding.FragmentDetailBinding

private const val ARG_PARAM1 = "param1"

class DetailFragment : Fragment() {
    private var cardData: Card? = null
    private val binding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cardData = it.getParcelable(ARG_PARAM1)?: cardList[0]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val text ="Owner: " + cardData?.owner +
                "\nCard Number: " + cardData?.cardNumber +
                "\nDate: " + cardData?.cardDate +
                "\nBalance: $" + decimalFormat.format(cardData?.cardValue) +
                "\nCard Type: " + cardData?.cardType
        binding.text1.text = text
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1:Card) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }
}