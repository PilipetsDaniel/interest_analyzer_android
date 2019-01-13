package analyzer.interest.admin.interestanalyzer.ui.feedback

import analyzer.interest.admin.interestanalyzer.ui.base.BasePresenter

interface FeedbackContract {

    interface View {

        fun showResponseOk()

        fun showResponseError(text: String)
    }

    interface Presenter : BasePresenter {

        fun sendFeedback(text: String)
    }
}