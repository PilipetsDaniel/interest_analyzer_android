package analyzer.interest.admin.interestanalyzer.ui.auth.login

import analyzer.interest.admin.interestanalyzer.ui.base.BasePresenter

interface LoginContract {

    interface View {

        fun showResponseOk()

        fun showResponseError(text: String)
    }

    interface Presenter : BasePresenter {

        fun login(password: String)
    }
}