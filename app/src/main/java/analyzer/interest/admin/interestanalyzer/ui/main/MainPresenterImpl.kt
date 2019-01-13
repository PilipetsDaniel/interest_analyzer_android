package analyzer.interest.admin.interestanalyzer.ui.main

import analyzer.interest.admin.interestanalyzer.bd.HelperEvent
import analyzer.interest.admin.interestanalyzer.model.EventModel

class MainPresenterImpl(var view: MainContract.View?) : MainContract.Presenter {

    override fun getAllEvents() {
        view?.updateAllEvents(HelperEvent().getAllEvents())
    }

    override fun getNewData() {
        //TODO get events from server
        val list: ArrayList<EventModel> = ArrayList()
        list.add(EventModel(System.currentTimeMillis().toString()))
        HelperEvent().addNewEventModels(list)
        getAllEvents()
        view?.setRefreshing(false)
    }

    override fun onDestroy() {
        view = null
    }
}