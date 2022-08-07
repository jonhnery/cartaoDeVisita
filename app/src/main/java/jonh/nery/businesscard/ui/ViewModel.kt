package jonh.nery.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jonh.nery.businesscard.data.BusinessCard
import jonh.nery.businesscard.data.BusinessCardRepository
import java.lang.IllegalArgumentException

class ViewModel (private val businessCardRepository: BusinessCardRepository) :ViewModel(){

    fun insert(businessCard: BusinessCard){
        businessCardRepository.insert(businessCard)

    }
    fun getAll() : LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }
}


class ViewModelFactory(private val repository: BusinessCardRepository) :
        ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
           return ViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

        }