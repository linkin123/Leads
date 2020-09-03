package com.worklin.leads.leadsModule.dataAccess

import com.worklin.leads.leadsModule.models.Lead
import com.worklin.leads.leadsModule.utils.*
import com.worklin.leads.base.dataAccess.APIS.FirebaseRealtimeDatabaseAPI
import java.util.HashMap

class RealtimeDatabase {
    private val mDatabaseAPI: FirebaseRealtimeDatabaseAPI = FirebaseRealtimeDatabaseAPI.getInstance()


    fun addLead(lead: Lead){
        val values: MutableMap<String, Any> =
            HashMap()
        values[LEAD_NAME] = lead.name as String
        values[LEAD_PHONE] = lead.phone as String
        values[LEAD_EMAIL] = lead.email as String
        values[LEAD_STATUS] = lead.status as Boolean
        values[LEAD_URL] = lead.url as String
        values[LEAD_CONTACT] = lead.contact as Boolean
        values[LEAD_CHANNEL] = lead.canal as String


    }
}