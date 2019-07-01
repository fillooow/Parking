package com.fillooow.parking.ui

import com.fillooow.parking.storage.StorageCase

class StorageViewModel(

    private val storageCase: StorageCase

){

    fun onSave(){

        storageCase.saveText("")
    }
}