package com.merax.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.merax.myapplication.api.API
import com.merax.myapplication.viewmodels.StoreListViewModel
import com.merax.myapplication.viewmodels.StoreViewModel

class MainActivity : AppCompatActivity() {

    private var routeViewModel =  StoreListViewModel()
    private var storeViewModel =  StoreViewModel()
    private var apiObject: API = API()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOne:Button = findViewById(R.id.getOne)
        val btnMultiple:Button = findViewById(R.id.getMultiple)
        val isOnlineSwitcher:CheckBox = findViewById(R.id.isOnline)


        btnOne.setOnClickListener {
            apiObject.isOnline = isOnlineSwitcher.isChecked

            val result: TextView = findViewById(R.id.result)
            result.text = apiObject.get("stores/one")
        }


        btnMultiple.setOnClickListener {
            apiObject.isOnline = isOnlineSwitcher.isChecked
            routeViewModel.updateData(
                apiObject.get("stores/multiple")
            )
            val result: TextView = findViewById(R.id.result)
            result.text = routeViewModel.getData()
        }
    }

}
