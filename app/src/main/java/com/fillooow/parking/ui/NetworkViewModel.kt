package com.fillooow.parking.ui

import com.fillooow.parking.network.net.WikiApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NetworkViewModel {

    private var disposable: Disposable? = null

    private val wikiApiService by lazy {

        WikiApiService.create()
    }

    fun onClickPressed(text: String){

        if (text.isNotEmpty()) {

            beginSearch(text)
        }
    }

    private fun beginSearch(searchString: String) {
        disposable = wikiApiService.hitCountCheck("query", "json", "search", searchString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> /* txt_search_result.text = "${result.query.searchinfo.totalhits} result found" */},
                { error -> /* Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() */}
            )
    }
}