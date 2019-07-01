package com.fillooow.parking.storage

import android.app.Activity
import android.content.Context.MODE_PRIVATE

class SharedPrefsStorageCaseImpl(val activity: Activity) : StorageCase{

    override fun saveText(text: String) {

        val sPref = activity.getPreferences(MODE_PRIVATE)
        val ed = sPref.edit()
        ed.putString("TAG", text)
        ed.commit()
    }

    override fun loadText() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}