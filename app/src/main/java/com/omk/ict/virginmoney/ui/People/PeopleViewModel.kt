package com.omk.ict.virginmoney.ui.People

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omk.ict.virginmoney.model.data.people.People
import com.omk.ict.virginmoney.model.data.people.PeopleItem
import com.omk.ict.virginmoney.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    var currentData= PeopleItem()
    private val _people = MutableLiveData<People>()
    val people: LiveData<People> = _people

    // API call to fetch the data
    fun getPeople() {
        CoroutineScope(Dispatchers.Main).launch {
            val peopleList = repository.getPeople()

            // verify if the response was successful
            if (peopleList.isSuccessful) {
                _people.postValue(peopleList.body())
            } else {
                _people.postValue(People())
            }
        }
    }
}