package analyzer.interest.admin.interestanalyzer.ui.feedback

class FeedbackPresenterImpl(var view: FeedbackContract.View?) : FeedbackContract.Presenter {

    var serverOk: Boolean = false

    override fun sendFeedback(text: String) {
        if (serverOk) {
            view?.showResponseOk()
        } else {
            serverOk = true
            view?.showResponseError("")
        }
    }

    override fun onDestroy() {
        view = null
    }
}