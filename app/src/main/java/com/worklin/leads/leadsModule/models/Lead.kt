package com.worklin.leads.leadsModule.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lead_table")
data class Lead(@PrimaryKey var id: Int = 0,
                @ColumnInfo(name = "name_lead")
                var name: String = "",
                @ColumnInfo(name = "phone_lead")
                var phone: String = "",
                @ColumnInfo(name = "email_lead")
                var email : String  = "",

                @ColumnInfo(name = "status_lead")
                var status: Boolean  = true,

                @ColumnInfo(name = "url_lead")
                var url: String = "",

                @ColumnInfo(name = "contact_lead")
                var contact: Boolean = true,

                @ColumnInfo(name = "canal_lead")
                var canal: String = "")

