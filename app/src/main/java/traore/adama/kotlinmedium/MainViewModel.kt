package traore.adama.kotlinmedium

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MainViewModel : ViewModel() {

    var repoModel: RepoModel = RepoModel()
    val text = ObservableField<String>("old data")
    val isLoading = ObservableField<Boolean>(false)


    fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }

}