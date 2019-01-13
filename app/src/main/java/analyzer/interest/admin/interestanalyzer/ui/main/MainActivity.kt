package analyzer.interest.admin.interestanalyzer.ui.main

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.model.EventModel
import analyzer.interest.admin.interestanalyzer.ui.base.BaseActivity
import analyzer.interest.admin.interestanalyzer.ui.feedback.FeedbackActivity
import analyzer.interest.admin.interestanalyzer.ui.main.adapter.EventListAdapter
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity(), MainContract.View, EventListAdapter.MainListActivityListener {

    private lateinit var presenter: MainContract.Presenter

    private lateinit var listAdapter: EventListAdapter

    private var events: ArrayList<EventModel> = ArrayList()

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewsAndData() {
        presenter = MainPresenterImpl(this)
        initSwipeRefreshLayout()
        initListAdapter()
        presenter.getAllEvents()
        presenter.getNewData()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun updateAllEvents(events: ArrayList<EventModel>) {
        listAdapter.updateCoins(events)
    }

    override fun setRefreshing(boolean: Boolean) {
        srl_event_data.isRefreshing = boolean
    }

    private fun initSwipeRefreshLayout() {
        srl_event_data.setOnRefreshListener {
            presenter.getNewData()
        }
    }

    private fun initListAdapter() {
        listAdapter = EventListAdapter(this, events, this)
        rv_event_data.layoutManager = LinearLayoutManager(this)
        rv_event_data.adapter = listAdapter
    }

    override fun onClickToEventItem(name: String) {
        startActivity<FeedbackActivity>("name" to name)
    }
}
