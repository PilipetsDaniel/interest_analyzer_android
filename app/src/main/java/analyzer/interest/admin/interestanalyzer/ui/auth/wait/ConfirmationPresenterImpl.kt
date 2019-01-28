package analyzer.interest.admin.interestanalyzer.ui.auth.wait

import analyzer.interest.admin.interestanalyzer.model.UserModel
import analyzer.interest.admin.interestanalyzer.util.SPUtil

class ConfirmationPresenterImpl(var view: ConfirmationContract.View?) : ConfirmationContract.Presenter {

    var serverOk: Boolean = false

    override fun checkRegistration() {
        if (serverOk) {
            SPUtil.saveUserModel(UserModel(""))
            view?.showResponseOk()
        } else {
            serverOk = true
        }
    }

    override fun onDestroy() {
        view = null
    }
}