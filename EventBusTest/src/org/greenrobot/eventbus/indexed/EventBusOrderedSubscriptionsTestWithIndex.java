package org.greenrobot.eventbus.indexed;

import org.greenrobot.eventbus.EventBusOrderedSubscriptionsTest;
import org.junit.Before;

public class EventBusOrderedSubscriptionsTestWithIndex extends EventBusOrderedSubscriptionsTest {
    @Before
    public void overwriteEventBus() throws Exception {
        eventBus = Indexed.build();
    }
}