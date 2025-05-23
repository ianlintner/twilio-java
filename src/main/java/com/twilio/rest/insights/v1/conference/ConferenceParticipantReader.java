/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Insights
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.insights.v1.conference;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ConferenceParticipantReader extends Reader<ConferenceParticipant> {

    private String pathConferenceSid;
    private String participantSid;
    private String label;
    private String events;
    private Long pageSize;

    public ConferenceParticipantReader(final String pathConferenceSid) {
        this.pathConferenceSid = pathConferenceSid;
    }

    public ConferenceParticipantReader setParticipantSid(
        final String participantSid
    ) {
        this.participantSid = participantSid;
        return this;
    }

    public ConferenceParticipantReader setLabel(final String label) {
        this.label = label;
        return this;
    }

    public ConferenceParticipantReader setEvents(final String events) {
        this.events = events;
        return this;
    }

    public ConferenceParticipantReader setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<ConferenceParticipant> read(
        final TwilioRestClient client
    ) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<ConferenceParticipant> firstPage(
        final TwilioRestClient client
    ) {
        String path = "/v1/Conferences/{ConferenceSid}/Participants";
        path =
            path.replace(
                "{" + "ConferenceSid" + "}",
                this.pathConferenceSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.INSIGHTS.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<ConferenceParticipant> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "ConferenceParticipant read failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException(
                    "Server Error, no content",
                    response.getStatusCode()
                );
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "participants",
            response.getContent(),
            ConferenceParticipant.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<ConferenceParticipant> previousPage(
        final Page<ConferenceParticipant> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.INSIGHTS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<ConferenceParticipant> nextPage(
        final Page<ConferenceParticipant> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.INSIGHTS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<ConferenceParticipant> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (participantSid != null) {
            request.addQueryParam("ParticipantSid", participantSid);
        }
        if (label != null) {
            request.addQueryParam("Label", label);
        }
        if (events != null) {
            request.addQueryParam("Events", events);
        }
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
