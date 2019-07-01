package com.fillooow.parking.storage

interface StorageCase {

    fun saveText(text: String)

    fun loadText()
}