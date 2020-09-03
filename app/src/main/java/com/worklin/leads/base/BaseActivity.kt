package com.worklin.leads.base

import android.R
import android.view.InflateException
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    private var toolbarEnabled = true
    private val homeAsUpEnabled = false
    var mToolbar: Toolbar? = null

    protected fun setToolbarEnabled(enabled: Boolean) {
        this.toolbarEnabled = enabled
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        if (toolbarEnabled) {
            val toolbar: View? = findToolbar(findViewById(R.id.content))
            if (toolbar != null) {
                mToolbar = toolbar as Toolbar
                setupToolbar()
            } else {
                throw InflateException(
                    "You must add a Toolbar on the Activity or " +
                            "setToolbarEnabled(false) before setContentView()"
                )
            }
        }
    }

    private fun findToolbar(view: View): View? {
        if (view is Toolbar) return view
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                val possibleToolbar = findToolbar(child)
                if (possibleToolbar != null && possibleToolbar is Toolbar) return possibleToolbar
            }
        }
        return null
    }

    private fun setupToolbar() {
        setSupportActionBar(mToolbar)
        if (supportActionBar != null && homeAsUpEnabled) supportActionBar!!.setDisplayHomeAsUpEnabled(
            true
        )
    }
}