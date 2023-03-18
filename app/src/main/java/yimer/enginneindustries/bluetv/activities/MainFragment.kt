package yimer.enginneindustries.bluetv.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import yimer.enginneindustries.bluetv.PageRowFragmentFactory
import yimer.enginneindustries.bluetv.R
import yimer.enginneindustries.bluetv.custom.BackgroundState
import yimer.enginneindustries.bluetv.custom.CardPresenter
import yimer.enginneindustries.bluetv.domain.Movie
import yimer.enginneindustries.bluetv.data.MoviesRepository
import yimer.enginneindustries.bluetv.detail.DetailActivity
import yimer.enginneindustries.bluetv.domain.Channels



class MainFragment: BrowseSupportFragment() {

    private lateinit var moviesRepository: MoviesRepository

    private val backgroundState = BackgroundState(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = getString(R.string.browse)
        moviesRepository = MoviesRepository(getString(R.string.api_key))

        viewLifecycleOwner.lifecycleScope.launch {
            adapter = buildAdapterChannels()
            mainFragmentRegistry.registerFragment(PageRow::class.java, PageRowFragmentFactory())


        }

        onItemViewClickedListener = OnItemViewClickedListener { vh, channels, _, _ ->
            val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                requireActivity(),
                (vh.view as ImageCardView).mainImageView,
                DetailActivity.SHARED_ELEMENT_CHANNEL_NAME

            ).toBundle()
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra(DetailActivity.CHANNEL_EXTRA, channels as Channels)
            }
            startActivity(intent, bundle)
        }

        onItemViewSelectedListener = OnItemViewSelectedListener { _, channels, _, _ ->
            (channels as? Channels)?.let { backgroundState.loadUrl(it.urlImage) }
        }


    }






        private suspend fun buildAdapterChannels():ArrayObjectAdapter {

            val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
            val cardPresenter = CardPresenter()
           moviesRepository.getChannels().forEach { (category,channels) ->
               val listRowsAdapter = ArrayObjectAdapter(cardPresenter)
               listRowsAdapter.addAll(0, channels)

               val header = HeaderItem(category.ordinal.toLong(),   category.name)
               rowsAdapter.add(ListRow(header, listRowsAdapter))

           }


         return rowsAdapter

     }

    }

