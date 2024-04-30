package com.example.standard_week4

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_week4.DetailActivity.Companion.EXTRA_ID
import com.example.standard_week4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val cardAdapter by lazy {
        CardAdapter{ card ->
            cardOnClick(card)
        }
    }
    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModel.CardViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val gapDeco = VerticalSpaceItemDecoration(80)

        cardAdapter.cardList = cardViewModel.cardLiveData

        binding.cardRecyclerView.apply {
            adapter = cardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(gapDeco)
        }

    }

    private fun cardOnClick(card: Card){
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        //intent.putExtra(EXTRA_CARD, card)
        intent.putExtra(EXTRA_ID, card.id)
        startActivity(intent)
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