package com.merax.myapplication.api

class API {

    var isOnline = false

    fun get(route: String):String{
        if(isOnline)
            return request(route)
        return  fromLocalStorage(route)
    }

    private fun request(route: String):String{
        return when(route) {
            "stores/one" -> "One object"
            "stores/multiple" -> hashMapOf(
                1 to "First",
                2 to "Second"
            ).toString()
            else -> "Route not found"
        } + ": online=" + isOnline
    }

    private fun fromLocalStorage(route: String):String{
        return when(route) {
            "stores/one" -> "One object (cached)"
            "stores/multiple" -> hashMapOf(
                1 to "First (cached)"
            ).toString()
            else -> "Route not found"
        } + ": online=" + isOnline
    }
}