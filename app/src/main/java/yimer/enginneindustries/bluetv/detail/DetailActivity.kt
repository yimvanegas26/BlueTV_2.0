package yimer.enginneindustries.bluetv.detail


import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import yimer.enginneindustries.bluetv.R

class DetailActivity : FragmentActivity() {

    companion object{
        const val MOVIE_EXTRA= "extra:movie"
        const val SHARED_ELEMENT_NAME="extra:hero"
        const val CHANNEL_EXTRA= "extra:channel"
        const val SHARED_ELEMENT_CHANNEL_NAME="extra:channelsHero"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}