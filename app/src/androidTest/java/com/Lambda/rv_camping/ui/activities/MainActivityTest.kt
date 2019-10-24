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
import org.hamcrest.Matchers.`is`
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
    fun mainActivityTest3() {
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

        val textInputEditText = onView(
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
        textInputEditText.perform(replaceText("ronnie"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_last_name_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("dip"), closeSoftKeyboard())

        val textInputEditText3 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_email_register),
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
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_email_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(replaceText("ronniedipple@gmail.com"), closeSoftKeyboard())

        val textInputEditText5 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText("ronn"), closeSoftKeyboard())

        pressBack()

        val textInputEditText6 = onView(
            allOf(
                withText("ronn"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText6.perform(replaceText("ronn"))

        val textInputEditText7 = onView(
            allOf(
                withText("ronn"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_username_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText7.perform(closeSoftKeyboard())

        pressBack()

        val appCompatCheckBox = onView(
            allOf(
                withId(R.id.cb_register_land_owner), withText("Are you a Land Owner?"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.cl_activity_main_parent),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatCheckBox.perform(click())

        val textInputEditText8 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_password_register),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText8.perform(replaceText("221"), closeSoftKeyboard())

        pressBack()

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.btn_register_create), withText("Complete Registration"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.cl_activity_main_parent),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val textInputEditText9 = onView(
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
        textInputEditText9.perform(click())

        val textInputEditText10 = onView(
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
        textInputEditText10.perform(click())

        val textInputEditText11 = onView(
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
        textInputEditText11.perform(replaceText("ronn"), closeSoftKeyboard())

        val textInputEditText12 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_password),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText12.perform(replaceText("2111"), closeSoftKeyboard())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.btn_login), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.cl_activity_main_parent),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.btn_property_reserve), withText("Reserve Property"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.cardview.widget.CardView")),
                        0
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        pressBack()

        val appCompatButton5 = onView(
            allOf(
                withId(R.id.btn_main_add_property), withText("Add New Property"),
                childAtPosition(
                    allOf(
                        withId(R.id.cl_activity_main_parent),
                        childAtPosition(
                            withId(R.id.cl_activity_main_parent),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton5.perform(click())

        val textInputEditText13 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_property_name),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText13.perform(click())

        val textInputEditText14 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_property_name),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText14.perform(replaceText("test"), closeSoftKeyboard())

        val textInputEditText15 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_description),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText15.perform(replaceText("test"), closeSoftKeyboard())

        val textInputEditText16 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_address),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText16.perform(replaceText("test"), closeSoftKeyboard())

        val textInputEditText17 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_city),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText17.perform(replaceText("tes"), closeSoftKeyboard())

        pressBack()

        val textInputEditText18 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_state),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText18.perform(replaceText("test"), closeSoftKeyboard())

        val textInputEditText19 = onView(
            allOf(
                withText("tes"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_city),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText19.perform(replaceText("test"))

        val textInputEditText20 = onView(
            allOf(
                withText("test"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_add_city),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText20.perform(closeSoftKeyboard())

        pressBack()

        val textInputEditText21 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.text_input_price),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText21.perform(replaceText("299"), closeSoftKeyboard())

        pressBack()

        val appCompatButton6 = onView(
            allOf(
                withId(R.id.btn_property_add), withText("Add Property"),
                childAtPosition(
                    allOf(
                        withId(R.id.mAddPlaceLayout),
                        childAtPosition(
                            withId(R.id.cl_activity_main_parent),
                            0
                        )
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        appCompatButton6.perform(click())

        val appCompatButton7 = onView(
            allOf(
                withId(R.id.btn_property_reserve), withText("Reserve Property"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("androidx.cardview.widget.CardView")),
                        0
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        appCompatButton7.perform(click())

        pressBack()
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
