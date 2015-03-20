package com.fredmedlin.wikilooks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml", emulateSdk = 18)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void itShouldFail() {
        assert(activity != null);
    }
}
