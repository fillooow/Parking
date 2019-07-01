package com.fillooow.parking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.fillooow.parking.storage.SharedPrefsStorageCaseImpl
import com.fillooow.parking.storage.StorageCaseImpl
import com.fillooow.parking.ui.NetworkViewModel
import com.fillooow.parking.ui.StorageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val storageViewModel = StorageViewModel( StorageCaseImpl() )

    private val sharedStorageViewModel = StorageViewModel( SharedPrefsStorageCaseImpl(this) )

    private val networkViewModel = NetworkViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn_search.setOnClickListener {

            //Crashlytics.getInstance().crash() fixme: выпилить крешлитикс
            networkViewModel.onClickPressed(edit_search.text.toString())
        }

        onClickSave()
        onClickLoadPrefs()
    }

    fun onClickSave(){

        storageViewModel.onSave()
    }

    fun onClickLoadPrefs(){

        sharedStorageViewModel.onSave()
    }
}