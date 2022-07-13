/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.supersim.v1.sim;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class SimIpAddressTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SUPERSIM.toString(),
                                          "/v1/Sims/HSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/IpAddresses");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            SimIpAddress.reader("HSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"key\": \"ip_addresses\",\"first_page_url\": \"https://supersim.twilio.com/v1/Sims/HSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/IpAddresses?PageSize=50&Page=0\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://supersim.twilio.com/v1/Sims/HSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/IpAddresses?PageSize=50&Page=0\"},\"ip_addresses\": []}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(SimIpAddress.reader("HSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testReadNonEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"key\": \"ip_addresses\",\"first_page_url\": \"https://supersim.twilio.com/v1/Sims/HSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/IpAddresses?PageSize=50&Page=0\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://supersim.twilio.com/v1/Sims/HSaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/IpAddresses?PageSize=50&Page=0\"},\"ip_addresses\": [{\"ip_address\": \"8.8.8.8\",\"ip_address_version\": \"IPv4\"}]}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(SimIpAddress.reader("HSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }
}