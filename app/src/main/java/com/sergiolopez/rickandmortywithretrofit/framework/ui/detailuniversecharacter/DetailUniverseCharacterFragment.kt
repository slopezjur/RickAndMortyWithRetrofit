package com.sergiolopez.rickandmortywithretrofit.framework.ui.detailuniversecharacter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.sergiolopez.rickandmortywithretrofit.R
import com.sergiolopez.rickandmortywithretrofit.databinding.DetailUniverseCharacterFragmentBinding
import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailUniverseCharacterFragment : Fragment(R.layout.detail_universe_character_fragment) {

    private val viewModel: DetailUniverseCharacterViewModel by viewModels()

    private var fragmentBinding: DetailUniverseCharacterFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding = DetailUniverseCharacterFragmentBinding.bind(view)
        fragmentBinding?.run {
            viewModel.character.onEach {
                setCharacterDetail(this, it)
            }.launchIn(lifecycleScope)
        }
    }

    private fun setCharacterDetail(
        fragmentBinding: DetailUniverseCharacterFragmentBinding,
        universeCharacter: UniverseCharacter
    ) {
        fragmentBinding.run {
            characterImage.load(universeCharacter.image)
            characterName.text = universeCharacter.name
            characterSpecies.text = universeCharacter.species
        }
    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }
}