package com.sergiolopez.rickandmortywithretrofit.framework.ui.main

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sergiolopez.rickandmortywithretrofit.databinding.CharacterListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var fragmentBinding: CharacterListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = CharacterListFragmentBinding.inflate(inflater)

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            fragmentBinding.run {
                val recyclerViewState: Parcelable? =
                    charactersRecycler.layoutManager?.onSaveInstanceState();

                val characterAdapter = CharacterListAdapter(characters)

                charactersRecycler.layoutManager = LinearLayoutManager(requireContext())
                charactersRecycler.adapter = characterAdapter

                charactersRecycler.layoutManager?.onRestoreInstanceState(recyclerViewState)
            }
        }

        initInfiniteScrollListener(fragmentBinding.charactersRecycler)
        viewModel.getUniverseCharacterList()
    }

    private fun initInfiniteScrollListener(charactersRecycler: RecyclerView) {
        charactersRecycler.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                    if (linearLayoutManager != null
                        && linearLayoutManager.findLastCompletelyVisibleItemPosition() == (
                                viewModel.characters.value?.size ?: 0) - 1
                    ) {
                        viewModel.getUniverseCharacterList()
                    }
                }
            }
        )
    }
}