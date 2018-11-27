package wards.jungle.archcomps

import androidx.lifecycle.ViewModelProviders
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import wards.jungle.archcomps.Activity.MainActivity
import wards.jungle.archcomps.ViewModel.MainActivity.UserViewModel
import java.lang.Exception


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(application = ArchApp::class)
class UserViewModelTest {

    lateinit var mainActivity: MainActivity
    lateinit var userViewModel: UserViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mainActivity = Robolectric.buildActivity(MainActivity::class.java)
                .create()
                .resume()
                .get()

        userViewModel = ViewModelProviders.of(mainActivity).get(UserViewModel::class.java)
    }

    @Test
    fun testingIfEmailIdIsValid() {
        val mockedEmailId = "test@test.com"
        assertTrue(userViewModel.validateEmail(mockedEmailId))
    }

    @Test
    fun testingIfEmailIdIsValidIfPatternMatchFails() {
        val mockedEmailId = "test-test.com"
        assertTrue(!userViewModel.validateEmail(mockedEmailId))

    }

    @Test
    fun testingIfEmailIdIsValidIfEmptyStringIsPassed() {
        val mockedEmailId = ""
        assertTrue(!userViewModel.validateEmail(mockedEmailId))
    }

    @After
    fun finishUp() {

    }
}
