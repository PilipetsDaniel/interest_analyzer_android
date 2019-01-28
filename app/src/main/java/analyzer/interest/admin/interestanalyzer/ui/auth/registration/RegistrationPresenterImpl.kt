package analyzer.interest.admin.interestanalyzer.ui.auth.registration

import analyzer.interest.admin.interestanalyzer.util.SPUtil

class RegistrationPresenterImpl(var view: RegistrationContract.View?) : RegistrationContract.Presenter {

    var serverOk: Boolean = false

    override fun registration(firstName: String, name: String, email: String) {
        if (serverOk) {
            SPUtil.saveStatusRegistration()
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