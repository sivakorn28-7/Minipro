package com.example.minipro

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManage(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "MiniProUser.db"
        private const val DATABASE_VERSION = 2
        private const val TABLE_NAME_USERDATA = "userdata"
        private const val TABLE_NAME_GAMEDATA = "gamedata"
        private const val COLUMN_USERID = "userid"
        private const val COLUMN_GAMEID = "gameid"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_SURNAME = "surname"
        private const val COLUMN_PHONE_NUMBER = "phonenumber"
        private const val COLUMN_GAMENAME = "gamename"
        private const val COLUMN_GAMEPRICE = "gameprice"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createUserTableQuery = ("CREATE TABLE $TABLE_NAME_USERDATA (" +
                "$COLUMN_USERID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_EMAIL TEXT, " +
                "$COLUMN_PASSWORD TEXT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_SURNAME TEXT, " +
                "$COLUMN_PHONE_NUMBER TEXT)")
        db?.execSQL(createUserTableQuery)

        val createGameDataTableQuery = ("CREATE TABLE $TABLE_NAME_GAMEDATA (" +
                "$COLUMN_GAMEID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERID INTEGER, " +
                "$COLUMN_GAMENAME TEXT, " +
                "$COLUMN_GAMEPRICE REAL, " +
                "FOREIGN KEY($COLUMN_USERID) REFERENCES $TABLE_NAME_USERDATA($COLUMN_USERID))")
        db?.execSQL(createGameDataTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropUserTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME_USERDATA"
        db?.execSQL(dropUserTableQuery)
        val dropGameDataTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME_GAMEDATA"
        db?.execSQL(dropGameDataTableQuery)
        onCreate(db)
    }

    fun insertUser(email: String, password: String, name: String, surname: String, phoneNumber: String): Long {
        val values = ContentValues().apply {
            put(COLUMN_EMAIL, email)
            put(COLUMN_PASSWORD, password)
            put(COLUMN_NAME, name)
            put(COLUMN_SURNAME, surname)
            put(COLUMN_PHONE_NUMBER, phoneNumber)
        }
        val db = writableDatabase
        return db.insert(TABLE_NAME_USERDATA, null, values)
    }

    fun insertGame(userid: Int, gamename: String, gameprice: Double): Long {
        val values = ContentValues().apply {
            put(COLUMN_USERID, userid)
            put(COLUMN_GAMENAME, gamename)
            put(COLUMN_GAMEPRICE, gameprice)
        }
        val db = writableDatabase
        return db.insert(TABLE_NAME_GAMEDATA, null, values)
    }

    fun readUser(email: String, password: String): Boolean {
        val db = readableDatabase
        val selection = "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val selectionArgs = arrayOf(email, password)
        val cursor = db.query(TABLE_NAME_USERDATA, null, selection, selectionArgs, null, null, null)

        val userExists = cursor.count > 0
        cursor.close()
        return userExists
    }

    fun readGame(userId: Long): List<Pair<String, Double>> {
        val db = readableDatabase
        val games = mutableListOf<Pair<String, Double>>()
        val selection = "$COLUMN_USERID = ?"
        val selectionArgs = arrayOf(userId.toString())
        val cursor = db.query(TABLE_NAME_GAMEDATA, null, selection, selectionArgs, null, null, null)

        cursor.use {
            while (it.moveToNext()) {
                val gameName = it.getString(it.getColumnIndexOrThrow(COLUMN_GAMENAME))
                val gamePrice = it.getDouble(it.getColumnIndexOrThrow(COLUMN_GAMEPRICE))
                games.add(Pair(gameName, gamePrice))
            }
        }

        return games
    }

    data class UserInfo(val userid: Int, val name: String, val surname: String, val email: String, val phoneNumber: String)

    fun getUserInfo(email: String, password: String): List<UserInfo> {
        val db = readableDatabase
        val userInfoList = mutableListOf<UserInfo>()
        val selection = "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val selectionArgs = arrayOf(email, password)
        val cursor = db.query(TABLE_NAME_USERDATA, null, selection, selectionArgs, null, null, null)

        cursor.use {
            while (it.moveToNext()) {
                val userid = it.getInt(it.getColumnIndexOrThrow(COLUMN_USERID))
                val name = it.getString(it.getColumnIndexOrThrow(COLUMN_NAME))
                val surname = it.getString(it.getColumnIndexOrThrow(COLUMN_SURNAME))
                val email = it.getString(it.getColumnIndexOrThrow(COLUMN_EMAIL))
                val phoneNumber = it.getString(it.getColumnIndexOrThrow(COLUMN_PHONE_NUMBER))
                val userInfo = UserInfo(userid, name, surname, email, phoneNumber)
                userInfoList.add(userInfo)
            }
        }

        return userInfoList
    }
    fun updateUser(email: String, password: String, newEmail: String, newName: String, newSurname: String, newPhoneNumber: String, newPassword: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_EMAIL, newEmail) // Update email
            put(COLUMN_NAME, newName)
            put(COLUMN_SURNAME, newSurname)
            put(COLUMN_PHONE_NUMBER, newPhoneNumber)
            put(COLUMN_PASSWORD, newPassword)
        }
        val selection = "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val selectionArgs = arrayOf(email, password)
        val rowsAffected = db.update(TABLE_NAME_USERDATA, values, selection, selectionArgs)
        return rowsAffected > 0
    }
}