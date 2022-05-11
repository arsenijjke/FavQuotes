package com.arsenijjke.favquotes.ui.main

import androidx.lifecycle.ViewModel
import com.arsenijjke.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: MainRepository) : ViewModel() {

}