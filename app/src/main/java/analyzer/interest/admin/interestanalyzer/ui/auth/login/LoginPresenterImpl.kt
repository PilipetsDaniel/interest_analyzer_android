package analyzer.interest.admin.interestanalyzer.ui.auth.login

import analyzer.interest.admin.interestanalyzer.model.UserModel
import analyzer.interest.admin.interestanalyzer.util.SPUtil

class LoginPresenterImpl(var view: LoginContract.View?) : LoginContract.Presenter {

    var serverOk: Boolean = false

    override fun login(password: String) {
        if (serverOk) {
            SPUtil.saveUserModel(UserModel("Пилипец Даня"))
            view?.showResponseOk()
        } else {
            serverOk = true
            view?.showResponseError("Ошибка пароля")
        }
    }

    override fun onDestroy() {
        view = null
    }
}