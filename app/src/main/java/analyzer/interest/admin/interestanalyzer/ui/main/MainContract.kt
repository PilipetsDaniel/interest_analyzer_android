package analyzer.interest.admin.interestanalyzer.ui.main

import analyzer.interest.admin.interestanalyzer.model.EventModel
import analyzer.interest.admin.interestanalyzer.ui.base.BasePresenter

interface MainContract {

    interface View {

        fun updateAllEvents(events: ArrayList<EventModel>)

        fun setRefreshing(boolean: Boolean)
    }

    interface Presenter : BasePresenter {

        fun getAllEvents()

        fun getNewData()
    }
}