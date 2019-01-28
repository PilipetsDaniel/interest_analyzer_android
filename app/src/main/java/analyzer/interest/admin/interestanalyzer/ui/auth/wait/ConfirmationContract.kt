package analyzer.interest.admin.interestanalyzer.ui.auth.wait

import analyzer.interest.admin.interestanalyzer.ui.base.BasePresenter

interface ConfirmationContract {

    interface View {

        fun showResponseOk()
    }

    interface Presenter : BasePresenter {

        fun checkRegistration()
    }
}