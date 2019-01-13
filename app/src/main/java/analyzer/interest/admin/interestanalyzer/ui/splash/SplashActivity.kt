package analyzer.interest.admin.interestanalyzer.ui.splash

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.ui.auth.LoginOrRegistrationActivity
import analyzer.interest.admin.interestanalyzer.ui.main.MainActivity
import analyzer.interest.admin.interestanalyzer.util.SPUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        checkAndStartActivity()
    }

    private fun checkAndStartActivity() {
        if (SPUtil.getUserModel() != null) {
            startActivity<MainActivity>()
        } else {
            startActivity<LoginOrRegistrationActivity>()
        }
        finish()
    }
}