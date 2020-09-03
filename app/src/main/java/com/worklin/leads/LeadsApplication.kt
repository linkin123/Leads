package com.worklin.leads

import android.app.Application
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.firebase.database.FirebaseDatabase

class LeadsApplication : Application() {
    private var mRequestQueue: RequestQueue? = null
    private var mInstance: LeadsApplication? = null

    override fun onCreate() {
        super.onCreate()
        configFirebase()
        mInstance = this
    }

    private fun configFirebase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }

    @Synchronized
    fun getInstance(): LeadsApplication? {
        return mInstance
    }

    fun getmRequestQueue(): RequestQueue? {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(applicationContext)
        }
        return mRequestQueue
    }

    fun <T> addToReqQueue(request: Request<T>) {
        request.retryPolicy = DefaultRetryPolicy(
            10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        getmRequestQueue()!!.add(request)
    }


}