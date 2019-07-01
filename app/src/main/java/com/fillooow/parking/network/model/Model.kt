package com.fillooow.parking.network.model

object Model {

    data class Result(val query: Query)

    data class Query(val searchinfo: SearchInfo)

    data class SearchInfo(val totalhits: Int)
}