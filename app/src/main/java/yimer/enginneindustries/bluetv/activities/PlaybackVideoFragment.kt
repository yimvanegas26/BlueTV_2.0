package yimer.enginneindustries.bluetv.activities

import android.graphics.Movie
import android.net.Uri
import android.os.Bundle
import androidx.leanback.app.VideoSupportFragment
import androidx.leanback.app.VideoSupportFragmentGlueHost
import androidx.leanback.media.MediaPlayerAdapter
import androidx.leanback.media.PlaybackTransportControlGlue
import androidx.leanback.widget.PlaybackControlsRow
import yimer.enginneindustries.bluetv.detail.DetailActivity

class PlaybackVideoFragment : VideoSupportFragment() {
    private lateinit var mTransportControlGlue: PlaybackTransportControlGlue<MediaPlayerAdapter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val (_, title, description, _, _, videoUrl) =
        //activity?.intent?.getSerializableExtra(DetailActivity.MOVIE_EXTRA) as Movie

    //val glueHost = VideoSupportFragmentGlueHost(this)
 //   val playerAdapter = MediaPlayerAdapter(activity)
  //  playerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE)

 //    mTransportControlGlue = PlaybackTransportControlGlue(activity, playerAdapter)
  //   mTransportControlGlue.host = glueHost
  //   mTransportControlGlue.title = title
   //    mTransportControlGlue.subtitle = description
   //   mTransportControlGlue.playWhenPrepared()

    //  playerAdapter.setDataSource(Uri.parse(videoUrl))/
    }

    override fun onPause() {
        super.onPause()
      //  mTransportControlGlue.pause()
    }
}