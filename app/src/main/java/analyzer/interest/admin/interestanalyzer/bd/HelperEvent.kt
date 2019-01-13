package analyzer.interest.admin.interestanalyzer.bd

import analyzer.interest.admin.interestanalyzer.App
import analyzer.interest.admin.interestanalyzer.model.EventModel
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperEvent : SQLiteOpenHelper(App.instance.applicationContext, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(("CREATE TABLE " + TABLE_EVENTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT" + ")"))
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_EVENTS")
        onCreate(db)
    }

    fun deleteAllEventModels() {
        val db = this.writableDatabase
        db.delete(TABLE_EVENTS, null, null)
        db.close()
    }

    fun addNewEventModels(events: ArrayList<EventModel>) {
        val db = this.writableDatabase

        for (item: EventModel in events) {
            val cv = ContentValues()
            cv.put(COLUMN_NAME, item.name)
            db.insert(TABLE_EVENTS, null, cv)
        }

        db.close()
    }

    fun getAllEvents(): ArrayList<EventModel> {
        val db = this.writableDatabase
        val cursor = db.query(TABLE_EVENTS, null, null,
                null, null, null, null)

        val events: ArrayList<EventModel> = ArrayList()

        if (cursor.moveToFirst()) {

            do {
                events.add(EventModel(
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME))))
            } while (cursor.moveToNext())
            cursor.close()
            db.close()
        }

        return events
    }

    companion object {

        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "eventDB.db"
        private const val TABLE_EVENTS = "events"

        private const val COLUMN_ID = "_id"
        private const val COLUMN_NAME = "name"
    }
}