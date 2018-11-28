package traore.adama.kotlinmedium

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MainViewModel : ViewModel() {

    var repoModel: RepoModel = RepoModel()
    val text = ObservableField<String>("old data")
    val isLoading = ObservableField<Boolean>(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()


    fun loadRepos(){
        isLoading.set(true)
        repoModel.getRepos(object : OnReposCallBack{
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }

}