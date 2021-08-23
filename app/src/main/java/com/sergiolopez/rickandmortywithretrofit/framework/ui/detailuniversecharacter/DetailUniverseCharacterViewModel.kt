package com.sergiolopez.rickandmortywithretrofit.framework.ui.detailuniversecharacter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter
import com.sergiolopez.rickandmortywithretrofit.usescases.GetUniverseCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DetailUniverseCharacterViewModel @Inject constructor(
    getUniverseCharacter: GetUniverseCharacter,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val universeCharacterId: Int =
        savedStateHandle.get<Int>(UNIVERSE_CHARACTER_ID_SAVED_STATE_KEY) ?: 0

    val character: Flow<UniverseCharacter> = getUniverseCharacter.load(universeCharacterId)

    companion object {
        private const val UNIVERSE_CHARACTER_ID_SAVED_STATE_KEY = "universeCharacterId"
    }
}
