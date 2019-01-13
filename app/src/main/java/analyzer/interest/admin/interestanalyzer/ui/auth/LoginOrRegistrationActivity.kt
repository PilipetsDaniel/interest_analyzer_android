package analyzer.interest.admin.interestanalyzer.ui.auth

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.ui.auth.login.LoginActivity
import analyzer.interest.admin.interestanalyzer.ui.auth.registration.RegistrationActivity
import analyzer.interest.admin.interestanalyzer.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login_or_registration.*
import org.jetbrains.anko.startActivity

class LoginOrRegistrationActivity : BaseActivity() {

    override fun layoutId(): Int {
        return R.layout.activity_login_or_registration
    }

    override fun initViewsAndData() {
        initButtonListener()
    }

    private fun initButtonListener() {
        button_login.setOnClickListener {
            startActivity<LoginActivity>()
        }
        button_registration.setOnClickListener {
            startActivity<RegistrationActivity>()
        }
    }
}