package analyzer.interest.admin.interestanalyzer.ui.auth.registration

class RegistrationPresenterImpl(var view: RegistrationContract.View?) : RegistrationContract.Presenter {

    var serverOk: Boolean = false

    override fun registration(firstName: String, name: String, email: String) {
        if (serverOk) {
            view?.showResponseOk()
        } else {
            serverOk = true
            view?.showResponseError("Ошибка создания пользователя")
        }
    }

    override fun onDestroy() {
        view = null
    }
}