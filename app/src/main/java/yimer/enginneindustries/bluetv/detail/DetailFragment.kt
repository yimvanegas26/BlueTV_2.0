package yimer.enginneindustries.bluetv.detail


import android.content.Intent
import android.os.Bundle
import android.view.View


import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.widget.*
import yimer.enginneindustries.bluetv.domain.Channels

import yimer.enginneindustries.bluetv.domain.Movie

import yimer.enginneindustries.bluetv.iu.common.loadImageUrl



class DetailFragment: DetailsSupportFragment() {

    private val detailsBackgroundState = DetailsBackgroundState(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val channel = requireActivity().intent.getParcelableExtra<Channels>(DetailActivity.CHANNEL_EXTRA)
            ?: throw IllegalStateException("Canal no disponible")


        val presenterChannels = FullWidthDetailsChannelsRowPresenter(requireActivity(),requireContext(), channel)


        val rowsAdapterChannels = ArrayObjectAdapter(presenterChannels)

        val detailsOverviewRowChannels = DetailsOverviewRow(channel)

        detailsOverviewRowChannels.loadImageUrl(requireContext(), channel.urlImage)

        detailsOverviewRowChannels.actionsAdapter = presenterChannels.buildActionsChannels(presenterChannels)



        rowsAdapterChannels.add(detailsOverviewRowChannels)

        adapter = rowsAdapterChannels
        detailsBackgroundState.loadUrl(channel.urlImage)




    }



}






