package eu.kanade.tachiyomi.data.database

import android.content.Context
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite
import eu.kanade.tachiyomi.data.database.mappers.*
import eu.kanade.tachiyomi.data.database.models.*
import eu.kanade.tachiyomi.data.database.queries.*

/**
 * This class provides operations to manage the database through its interfaces.
 */
open class DatabaseHelper(context: Context)
: MangaQueries, ChapterQueries, MangaSyncQueries, CategoryQueries, MangaCategoryQueries, HistoryQueries {

    override val db = DefaultStorIOSQLite.builder()
            .sqliteOpenHelper(DbOpenHelper(context))
            .addTypeMapping(Manga::class.java, MangaTypeMapping())
            .addTypeMapping(Chapter::class.java, ChapterTypeMapping())
            .addTypeMapping(MangaSync::class.java, MangaSyncTypeMapping())
            .addTypeMapping(Category::class.java, CategoryTypeMapping())
            .addTypeMapping(MangaCategory::class.java, MangaCategoryTypeMapping())
            .addTypeMapping(History::class.java, HistoryTypeMapping())
            .build()

    inline fun inTransaction(block: () -> Unit) = db.inTransaction(block)

}
