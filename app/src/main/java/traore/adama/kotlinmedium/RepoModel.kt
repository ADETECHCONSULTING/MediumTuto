package traore.adama.kotlinmedium

import android.os.Handler


class RepoModel{
    fun refreshData(onDataReadyCallback: OnDataReadyCallback){
        Handler().postDelayed({ onDataReadyCallback.onDataReady("new Data")}, 3000)
    }
}

interface OnDataReadyCallback{
    fun onDataReady(data: String)
}