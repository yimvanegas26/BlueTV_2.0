package yimer.enginneindustries.bluetv.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.leanback.widget.*
import yimer.enginneindustries.bluetv.R
import yimer.enginneindustries.bluetv.activities.PlayBackActivity
import yimer.enginneindustries.bluetv.domain.Channels


class FullWidthDetailsChannelsRowPresenter(private val activity: Activity, private val context: Context, private val channels: Channels):
    FullWidthDetailsOverviewRowPresenter(DetailsDescriptionChannelsPresenter()) {
    private enum class Options(@StringRes val stringRes: Int) {
        VER_AHORA(R.string.ver_ahora),
        FAVORITE(R.string.favorite)
    }

    init {
        val sharedElementHelper = FullWidthDetailsOverviewSharedElementHelper()
        sharedElementHelper.setSharedElementEnterTransition(
            activity,
            DetailActivity.SHARED_ELEMENT_CHANNEL_NAME
        )

        setListener(sharedElementHelper)
        isParticipatingEntranceTransition = true
    }




    fun buildActionsChannels(presenter: FullWidthDetailsOverviewRowPresenter): ArrayObjectAdapter {


        presenter.setOnActionClickedListener { action,  ->
            val option = Options.values().first { it.ordinal == action.id.toInt() }

                val intent = Intent(context, PlayBackActivity::class.java)
                intent.putExtra("Channel","channel")

                context.startActivity(intent)

        }

        return ArrayObjectAdapter().apply {
            Options.values().forEach { option ->
                add(Action(option.ordinal.toLong(), activity.getString(option.stringRes)))
            }

        }

    }
}



class DetailsDescriptionChannelsPresenter: AbstractDetailsDescriptionPresenter() {
    override fun onBindDescription(vh: ViewHolder, item: Any) {
        val channels = item as Channels
        vh.title.text = channels.name
        vh.subtitle.text = channels.category
        vh.body.text = channels.description




    }

}



