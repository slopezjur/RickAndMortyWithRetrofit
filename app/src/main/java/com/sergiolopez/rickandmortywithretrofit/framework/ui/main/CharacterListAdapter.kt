package com.sergiolopez.rickandmortywithretrofit.framework.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sergiolopez.rickandmortywithretrofit.databinding.CharacterItemBinding
import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter

class CharacterListAdapter(
    private val universeCharacters: List<UniverseCharacter>
) : RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    class ViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return universeCharacters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = universeCharacters[position]
        holder.binding.apply {
            characterImage.load(character.image)
            characterName.text = character.name
            characterSpecies.text = character.species

            universeCharacter.setOnClickListener {
                val direction =
                    CharacterListFragmentDirections.actionCharacterListFragmentToDetailUniverseCharacterFragment(
                        character.id
                    )
                root.findNavController().navigate(direction)
            }
        }
    }
}