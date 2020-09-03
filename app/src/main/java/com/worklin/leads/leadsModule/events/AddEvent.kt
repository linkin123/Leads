package com.worklin.leads.leadsModule.events

class AddEvent {
    companion object {
        val INSERT_LEAD = 10
        val ERROR_SERVER = 11
    }

    private var typeEvent = 0

    fun AddEvent() {}

    fun getTypeEvent(): Int {
        return typeEvent
    }

    fun setTypeEvent(typeEvent: Int) {
        this.typeEvent = typeEvent
    }


}