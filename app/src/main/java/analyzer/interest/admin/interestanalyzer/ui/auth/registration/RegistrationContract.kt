package analyzer.interest.admin.interestanalyzer.ui.auth.registration

import analyzer.interest.admin.interestanalyzer.ui.base.BasePresenter

interface RegistrationContract {

    interface View {

        fun showResponseOk()

        fun showResponseError(text: String)
    }

    interface Presenter : BasePresenter {

        fun registration(firstName: String,
                         name: String,
                         email: String)
    }
}