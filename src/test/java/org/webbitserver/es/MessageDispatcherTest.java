package org.webbitserver.es;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessageDispatcherTest {
    public EventSourceHandler h;
    public MessageDispatcher md;

    @Before
    public void setup() {
        h = mock(EventSourceHandler.class);
        md = new MessageDispatcher(h);
    }

    @Test
    public void dispatchesSingleLineMessages() throws Exception {
        md.line("data: hello");
        md.line("");

        verify(h).onMessage(eq(new MessageEvent("hello")));
    }
}