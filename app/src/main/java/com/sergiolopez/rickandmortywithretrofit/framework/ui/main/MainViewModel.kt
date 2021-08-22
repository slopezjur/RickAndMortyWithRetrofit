package com.sergiolopez.rickandmortywithretrofit.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergiolopez.rickandmortywithretrofit.domain.model.UniverseCharacter
import com.sergiolopez.rickandmortywithretrofit.usescases.GetUniverseCharacterList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUniverseCharacterList: GetUniverseCharacterList
) : ViewModel() {

    private val _characters = MutableLiveData<List<UniverseCharacter>>()
    val characters: LiveData<List<UniverseCharacter>> get() = _characters

    fun getUniverseCharacterList() {
        viewModelScope.launch {
            getUniverseCharacterList.load(getNextPage()).collect {
                _characters.value = _characters.value?.plus(it) ?: it
            }
        }
    }

    fun onCharacterClicked(universeCharacter: UniverseCharacter) {
        // TODO : not impelementd
    }

    private fun getNextPage(): Int {
        return _characters.value?.lastOrNull()?.page?.plus(1) ?: 1
    }

    operator fun <T> MutableLiveData<ArrayList<T>>.plusAssign(values: List<T>) {
        val value = this.value ?: arrayListOf()
        value.addAll(values)
        this.value = value
    }
}