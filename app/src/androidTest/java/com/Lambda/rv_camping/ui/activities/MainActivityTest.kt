package com.Lambda.rv_camping.ui.activities


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.Lambda.rv_camping.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textInputEditText = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("roonn"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withText("roonn"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(click())

        val textInputEditText3 = onView(
            allOf(
                withText("roonn"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(click())

        val textInputEditText4 = onView(
            allOf(
                withText("roonn"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(replaceText("ronnie"))

        val textInputEditText5 = onView(
            allOf(
                withText("ronnie"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(closeSoftKeyboard())

        pressBack()

        val appCompatButton = onView(
            allOf(
                withId(R.id.btn_register), withText("Register new Account"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.cl_activity_main_parent),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val textInputEditText6 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_first_name_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText6.perform(click())

        val textInputEditText7 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_first_name_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText7.perform(click())

        val textInputEditText8 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_first_name_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText8.perform(replaceText("ro"), closeSoftKeyboard())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
