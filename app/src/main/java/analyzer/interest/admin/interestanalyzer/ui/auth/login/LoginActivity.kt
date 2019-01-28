package analyzer.interest.admin.interestanalyzer.ui.auth.login

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.ui.base.BaseActivity
import analyzer.interest.admin.interestanalyzer.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initViewsAndData() {
        presenter = LoginPresenterImpl(this)
        initButtonListener()
    }

    override fun showResponseOk() {
        startActivity<MainActivity>()
        finishAffinity()
    }

    override fun showResponseError(text: String) {
        til_password.error = text
    }

    private fun initButtonListener() {
        button_login.setOnClickListener {
            if (et_password.text.toString().isEmpty()) {
                til_password.error = getString(R.string.field_is_empty)
            } else {
                til_password.error = null
                presenter.login(et_password.text.toString())
            }
        }
    }
}