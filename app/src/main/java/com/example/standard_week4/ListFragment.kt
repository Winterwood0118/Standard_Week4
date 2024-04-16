package com.example.standard_week4

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_week4.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val listAdapter by lazy {
        CardAdapter2{
            cardOnClick(it)
        }
    }
    private val context by lazy { requireActivity() }
    private val gapDeco = VerticalSpaceItemDecoration(150)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listManager = LinearLayoutManager(context)
        listAdapter.cardList = cardList
        binding.cardRecyclerView.apply {
            adapter = listAdapter
            layoutManager = listManager
            if (itemDecorationCount == 0){
                addItemDecoration(gapDeco)
            }
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {

            }
    }

    private fun cardOnClick(card: Card){
       context.supportFragmentManager.beginTransaction().apply {
           replace(R.id.fragmentContainer, DetailFragment.newInstance(card))
           addToBackStack("main")
           commit()
       }
    }

    class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) :
        RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect, view: View, parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.bottom = verticalSpaceHeight
        }
    }
}