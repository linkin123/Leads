package com.worklin.leads.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.worklin.leads.leadsModule.models.Lead

@Dao
interface LeadsDao {

    @Insert
    fun insert(lead: Lead)

    @Insert
    fun insert(lead: List<Lead>)

    @Query("DELETE FROM lead_table")
    fun clear()

    @Update
    fun update(lead: List<Lead>)

    @Query("SELECT * FROM lead_table ORDER BY id DESC")
    fun getAllLeads(): LiveData<List<Lead>>

    @Query("SELECT * FROM lead_table WHERE id = :id")
    fun getLeadById(id : Int): Lead


    @Delete
    fun detele(lead : Lead)
}