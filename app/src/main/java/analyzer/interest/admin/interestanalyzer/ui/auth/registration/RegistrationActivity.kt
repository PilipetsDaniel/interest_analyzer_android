package analyzer.interest.admin.interestanalyzer.ui.auth.registration

import analyzer.interest.admin.interestanalyzer.R
import analyzer.interest.admin.interestanalyzer.ui.auth.wait.ConfirmationActivity
import analyzer.interest.admin.interestanalyzer.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_registration.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegistrationActivity : BaseActivity(), RegistrationContract.View {

    private lateinit var presenter: RegistrationContract.Presenter

    override fun layoutId(): Int {
        return R.layout.activity_registration
    }

    override fun initViewsAndData() {
        presenter = RegistrationPresenterImpl(this)
        initButtonListener()
    }

    override fun showResponseOk() {
        startActivity<ConfirmationActivity>()
        finishAffinity()
    }

    override fun showResponseError(text: String) {
        toast(text)
    }

    private fun initButtonListener() {
        button_registration.setOnClickListener {
            til_firstName.error = null
            til_name.error = null
            til_email.error = null
            if (check()) {
                presenter.registration(
                        et_firstName.text.toString(),
                        et_name.text.toString(),
                        et_email.text.toString()
                )
            }
        }
    }

    private fun check(): Boolean {
        when {
            et_firstName.text.toString().isEmpty() -> {
                til_firstName.error = getString(R.string.field_is_empty)
                return false
            }
            et_name.text.toString().isEmpty() -> {
                til_name.error = getString(R.string.field_is_empty)
                return false
            }
            et_email.text.toString().isEmpty() -> {
                til_email.error = getString(R.string.field_is_empty)
                return false
            }
            else -> {
                til_firstName.error = null
                til_name.error = null
                til_email.error = null
                return true
            }
        }
    }
}