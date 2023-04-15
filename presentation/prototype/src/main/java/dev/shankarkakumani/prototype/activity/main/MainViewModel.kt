package dev.shankarkakumani.prototype.activity.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.shankarkakumani.data.repository.ProtoTypeRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val protoTypeRepository: ProtoTypeRepository
) : ViewModel() {


}