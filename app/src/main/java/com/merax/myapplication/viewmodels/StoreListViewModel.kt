package com.merax.myapplication.viewmodels

import androidx.lifecycle.ViewModel

class StoreListViewModel(): ViewModel() {
    private var data: String = ""

    fun updateData (apiData: String){
        data = apiData
    }

    fun getData():String{
        return data
    }
}