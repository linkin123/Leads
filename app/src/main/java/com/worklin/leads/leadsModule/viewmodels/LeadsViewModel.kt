package com.worklin.leads.leadsModule.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.worklin.leads.db.LeadsDao
import com.worklin.leads.leadsModule.models.Lead
import kotlinx.coroutines.*

class LeadsViewModel(dataSource: LeadsDao) : ViewModel() {

    val database = dataSource
    private var viewmodelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewmodelJob)
    private var lead = MutableLiveData<Lead?>()
    val leads = database.getAllLeads()

    private val _navigateToLeadDetail = MutableLiveData<Int>()
    val navigateToLeadDetail get() = _navigateToLeadDetail

    fun onLeadCliked(id: Int){
        _navigateToLeadDetail.value = id
    }

    fun onLeadDetailNavigated(){
        _navigateToLeadDetail.value = null
    }

    private suspend fun insert(lead: Lead){
        withContext(Dispatchers.IO){
            database.insert(lead)
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    /*ciclo de vida*/
    fun onStart() {
        uiScope.launch {
            clear()
            insert(Lead(0, "Luis Gerardo rangel", "4433777570", "linkin@gmail.com", true, "https://diseno.uc.cl/wp/wp-content/uploads/2016/11/Andres-6773_-500x500.jpg",true, "facebook"))
            insert(Lead(1, "Luz maria ponce", "4433773370", "totalitoplay@gmail.com", true, "https://www.ashoka.org/sites/default/files/styles/medium_1600x1000/public/thumbnails/images/daniela-kreimer.jpg?itok=R89tVtb4", false, "google"))
            insert(Lead(2, "Maria esther", "4433387570", "eltoken@gmail.com", false, "https://www.contrareplica.mx/uploads/galerias/normal/d51adde6198cd2e5a32ddda82d2ee9b6.jpg", true, "facebook"))
            insert(Lead(3, "Santiago soto", "4433777200", "ramires@gmail.com", true, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSuboyBRjBGHxU5fFnkuB3DKPmtIDY-qvrm5w&usqp=CAU", false, "facebook"))
        }
    }

    fun onClear(){
        uiScope.launch {
            clear()
            lead.value = null
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewmodelJob.cancel()
    }


}