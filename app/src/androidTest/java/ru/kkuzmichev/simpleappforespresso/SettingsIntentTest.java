package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static ru.kkuzmichev.simpleappforespresso.TestUtils.waitFor;

@RunWith(AndroidJUnit4.class)
public class SettingsIntentTest {

    @Test
    public void testSettingsOpens() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        onView(isRoot()).perform(waitFor(1000)); // ждем появления экрана

        openActionBarOverflowOrOptionsMenu(context);

        onView(isRoot()).perform(waitFor(500)); // ждем появления меню

        onView(withText("Settings")).check(matches(isDisplayed())); // проверка
    }
}
