package traore.adama.kotlinmedium

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import traore.adama.kotlinmedium.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RepoAdapter.OnItemClickListener{

    lateinit var binding: ActivityMainBinding
    var mainViewModel: MainViewModel = MainViewModel()
    private val repoAdapter = RepoAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var repo: Repository = Repository("KotlinMedium", "Adama Tarawalé", 4544, false)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.rcvMain.layoutManager = LinearLayoutManager(this)
        binding.rcvMain.adapter = repoAdapter
/*        viewModel.repositories.observe(this, Observer<ArrayList<Repository>> {array ->
            if (array != null) {
                repoAdapter.replaceData(array)
            }
        }) SAME MAIS AVEC Lambda
        */
        viewModel.repositories.observe(this, Observer<ArrayList<Repository>> {it?.let {repoAdapter.replaceData(it)}})

    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
