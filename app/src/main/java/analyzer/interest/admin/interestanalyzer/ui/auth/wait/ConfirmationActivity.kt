package analyzer.interest.admin.interestanalyzer.ui.auth.wait

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.ui.base.BaseActivity
import analyzer.interest.admin.interestanalyzer.ui.main.MainActivity
import android.os.Handler
import org.jetbrains.anko.startActivity

class ConfirmationActivity : BaseActivity(), ConfirmationContract.View, Runnable {

    private lateinit var presenter: ConfirmationContract.Presenter
    private val handler: Handler = Handler()

    override fun layoutId(): Int {
        return R.layout.activity_after_registration
    }

    override fun initViewsAndData() {
        presenter = ConfirmationPresenterImpl(this)
    }

    override fun showResponseOk() {
        startActivity<MainActivity>()
        finishAffinity()
    }

    override fun onResume() {
        super.onResume()
        handler.post(this)
    }

    override fun onPause() {
        handler.removeCallbacks(this)
        super.onPause()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun run() {
        presenter.checkRegistration()
        handler.postDelayed(this, 1000)
    }
}