package analyzer.interest.admin.interestanalyzer.util

import analyzer.interest.admin.interestanalyzer.App
import analyzer.interest.admin.interestanalyzer.model.UserModel
import android.content.Context
import com.google.gson.Gson


object SPUtil {

    private val gson = Gson()

    private const val PreferenceName = "SPUtil"

    fun getUserModel(): UserModel? {
        return gson.fromJson(
                App.instance.getSharedPreferences(PreferenceName, Context.MODE_PRIVATE)
                        .getString(Constants.KEY_USER_MODEL, ""), UserModel::class.java)
    }

    fun saveUserModel(user: UserModel) {
        App.instance.getSharedPreferences(PreferenceName, Context.MODE_PRIVATE)
                .edit().putString(Constants.KEY_USER_MODEL, gson.toJson(user)).apply()
    }

    fun getStatusRegistration(): Boolean {
        return App.instance.getSharedPreferences(PreferenceName, Context.MODE_PRIVATE)
                .getBoolean(Constants.KEY_STATUS_REGISTRATION, false)
    }

    fun saveStatusRegistration() {
        App.instance.getSharedPreferences(PreferenceName, Context.MODE_PRIVATE)
                .edit().putBoolean(Constants.KEY_STATUS_REGISTRATION, true).apply()
    }
}