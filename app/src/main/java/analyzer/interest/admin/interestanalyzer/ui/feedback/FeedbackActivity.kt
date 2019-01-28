package analyzer.interest.admin.interestanalyzer.ui.feedback

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_feedback.*
import org.jetbrains.anko.toast

class FeedbackActivity : BaseActivity(), FeedbackContract.View {

    private lateinit var presenter: FeedbackContract.Presenter

    override fun layoutId(): Int {
        return R.layout.activity_feedback
    }

    override fun initViewsAndData() {
        presenter = FeedbackPresenterImpl(this)
        initButtonListener()
    }

    override fun showResponseOk() {
        toast(getString(R.string.comment_sent))
        onBackPressed()
    }

    override fun showResponseError(text: String) {
        til_feedback.error = text
    }

    private fun initButtonListener() {
        button_send_feedback.setOnClickListener {
            if (et_feedback.text.toString().isEmpty()) {
                til_feedback.error = getString(R.string.field_is_empty)
            } else {
                til_feedback.error = null
                presenter.sendFeedback(et_feedback.text.toString())
            }
        }
    }
}