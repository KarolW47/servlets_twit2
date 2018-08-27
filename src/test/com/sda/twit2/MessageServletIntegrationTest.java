package com.sda.twit2;

import com.github.mjeanroy.junit.servers.annotations.TestServer;
import com.github.mjeanroy.junit.servers.jetty.EmbeddedJetty;
import com.github.mjeanroy.junit.servers.runner.JunitServerRunner;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(JunitServerRunner.class)
public class MessageServletIntegrationTest {
    @TestServer
    public static EmbeddedJetty jetty;
    private HttpClient client;

    @Before
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @Test
    public void should_ReturnMessageForm_When_PerformGetOnMsgEndpoint() throws IOException {
        //when
        HttpResponse response = client.execute(new HttpGet(jetty.getUrl()));
        //then
        String html = EntityUtils.toString(response.getEntity());
        Assert.assertThat(html, Matchers.containsString("form"));

    }
}
