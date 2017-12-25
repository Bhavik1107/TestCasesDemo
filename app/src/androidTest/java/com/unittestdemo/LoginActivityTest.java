package com.unittestdemo;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void checkForErrorText() throws InterruptedException {
        Thread.sleep(5000);

        onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_login)).perform(click());

        onView(withId(R.id.edt_email)).check((matches(hasErrorText("Enter Email"))));
        onView(withId(R.id.edt_pwd)).check((matches(hasErrorText("Enter Password"))));
    }

    @Test
    public void checkValidEmail() throws InterruptedException {
        Thread.sleep(5000);
        //type the text in the edit text
        onView(withId(R.id.edt_email)).perform(typeText("bhavik.makwana"));
        //closes the key board
        closeSoftKeyboard();
        //click on the login button
        onView(withId(R.id.btn_login)).perform(click());
        //check for the validation message
        onView(withId(R.id.edt_email)).check((matches(hasErrorText("Enter valid email"))));
    }

    @Test
    public void checkValidPassword() throws InterruptedException {
        Thread.sleep(5000);
        //type the text in the edit text
        onView(withId(R.id.edt_email)).perform(typeText("bhavik.makwana@multidots.com")).perform(pressImeActionButton());
        onView(withId(R.id.edt_pwd)).perform(typeText("12345"));
        //closes the key board
        closeSoftKeyboard();
        //click on the login button
        onView(withId(R.id.btn_login)).perform(click());
        //check for the validation message
        onView(withId(R.id.edt_pwd)).check((matches(hasErrorText("Enter password in between 6 - 30"))));
    }

    @Test
    public void launchNextScreen() throws InterruptedException {
        Thread.sleep(5000);
        //type the text in the edit text
        onView(withId(R.id.edt_email)).perform(typeText("bhavik.makwana@multidots.com")).perform(pressImeActionButton());
        onView(withId(R.id.edt_pwd)).perform(typeText("123456"));
        //closes the key board
        closeSoftKeyboard();
        //click on the login button
        onView(withId(R.id.btn_login)).perform(click());
        //check for Home activity open or not
        onView(withText("Home")).check(matches(isDisplayed()));
    }
}