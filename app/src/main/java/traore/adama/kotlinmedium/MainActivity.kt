package traore.adama.kotlinmedium

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import traore.adama.kotlinmedium.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var repo: Repository = Repository("KotlinMedium", "Adama Tarawalé", 4544, false)

        binding.repo = repo
        binding.executePendingBindings()


        Handler().postDelayed({repo.repoName = "Kotlin Medium 2"}, 2000)
    }
}
