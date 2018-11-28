package traore.adama.kotlinmedium

import android.os.Handler


class RepoModel{

    fun getRepos(onReposCallBack: OnReposCallBack){
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 100 , false))
        arrayList.add(Repository("Second", "Owner 2", 30 , true))
        arrayList.add(Repository("Third", "Owner 3", 430 , false))

        Handler().postDelayed({onReposCallBack.onDataReady(arrayList)}, 2000)
    }
}


interface OnReposCallBack{
    fun onDataReady(data: ArrayList<Repository>)
}