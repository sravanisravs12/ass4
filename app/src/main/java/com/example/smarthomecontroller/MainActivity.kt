package com.example.smarthomecontroller

import  android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(this)

        // Example: Fetching all devices
        fetchAllDevices()

        // Example: Adding a new device
        val newDevice = JSONObject().apply {
            put("name", "New Device")
            put("type", "Type")
            put("status", false)
        }
        addDevice(newDevice)
    }

    private fun fetchAllDevices() {
        val url = "https://ass4-1-m0vc.onrender.com/api/devices"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d("Response", response.toString())
                // Handle response here
            },
            Response.ErrorListener { error ->
                Log.e("Error", error.toString())
                // Handle error here
            }
        )

        requestQueue.add(jsonObjectRequest)
    }

    private fun addDevice(newDevice: JSONObject) {
        val url = "http://localhost:5001/api/devices/api/devices"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, newDevice,
            Response.Listener { response ->
                Log.d("Response", response.toString())
                // Handle response here
            },
            Response.ErrorListener { error ->
                Log.e("Error", error.toString())
                // Handle error here
            }
        )

        requestQueue.add(jsonObjectRequest)
    }
}