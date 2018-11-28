package traore.adama.kotlinmedium

import android.databinding.BaseObservable
import android.databinding.Bindable

class Repository(repoName: String, var repoOwner: String?, var numberOfStars:Int?, var hasIssues:Boolean = false) : BaseObservable(){


    @get:Bindable
    var repoName: String = repoName
    set(value) {
        field = value
        notifyPropertyChanged(BR.repoName)
    }
}