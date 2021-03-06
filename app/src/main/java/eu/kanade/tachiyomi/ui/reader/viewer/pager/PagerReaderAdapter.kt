package eu.kanade.tachiyomi.ui.reader.viewer.pager

import android.view.View
import android.view.ViewGroup
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.data.source.model.Page
import eu.kanade.tachiyomi.util.inflate
import eu.kanade.tachiyomi.widget.ViewPagerAdapter

/**
 * Adapter of pages for a ViewPager.
 */
class PagerReaderAdapter(private val reader: PagerReader) : ViewPagerAdapter() {

    /**
     * Pages stored in the adapter.
     */
    var pages: List<Page>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun createView(container: ViewGroup, position: Int): View {
        val view = container.inflate(R.layout.item_pager_reader) as PageView
        view.initialize(reader, pages?.getOrNull(position))
        return view
    }

    /**
     * Returns the number of pages.
     *
     * @return the number of pages or 0 if the list is null.
     */
    override fun getCount(): Int {
        return pages?.size ?: 0
    }

}
