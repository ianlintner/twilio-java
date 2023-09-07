/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Numbers
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.numbers.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class BulkHostedNumberOrder extends Resource {

    private static final long serialVersionUID = 251635704058877L;

    public static BulkHostedNumberOrderFetcher fetcher(
        final String pathBulkHostingSid
    ) {
        return new BulkHostedNumberOrderFetcher(pathBulkHostingSid);
    }

    /**
     * Converts a JSON String into a BulkHostedNumberOrder object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return BulkHostedNumberOrder object represented by the provided JSON
     */
    public static BulkHostedNumberOrder fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, BulkHostedNumberOrder.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a BulkHostedNumberOrder object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return BulkHostedNumberOrder object represented by the provided JSON
     */
    public static BulkHostedNumberOrder fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, BulkHostedNumberOrder.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum RequestStatus {
        QUEUED("QUEUED"),
        IN_PROGRESS("IN_PROGRESS"),
        PROCESSED("PROCESSED");

        private final String value;

        private RequestStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static RequestStatus forValue(final String value) {
            return Promoter.enumFromString(value, RequestStatus.values());
        }
    }

    private final String bulkHostingSid;
    private final BulkHostedNumberOrder.RequestStatus requestStatus;
    private final String friendlyName;
    private final String notificationEmail;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateCompleted;
    private final URI url;
    private final Integer totalCount;
    private final List<Map<String, Object>> results;

    @JsonCreator
    private BulkHostedNumberOrder(
        @JsonProperty("bulk_hosting_sid") final String bulkHostingSid,
        @JsonProperty(
            "request_status"
        ) final BulkHostedNumberOrder.RequestStatus requestStatus,
        @JsonProperty("friendly_name") final String friendlyName,
        @JsonProperty("notification_email") final String notificationEmail,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_completed") final String dateCompleted,
        @JsonProperty("url") final URI url,
        @JsonProperty("total_count") final Integer totalCount,
        @JsonProperty("results") final List<Map<String, Object>> results
    ) {
        this.bulkHostingSid = bulkHostingSid;
        this.requestStatus = requestStatus;
        this.friendlyName = friendlyName;
        this.notificationEmail = notificationEmail;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateCompleted =
            DateConverter.iso8601DateTimeFromString(dateCompleted);
        this.url = url;
        this.totalCount = totalCount;
        this.results = results;
    }

    public final String getBulkHostingSid() {
        return this.bulkHostingSid;
    }

    public final BulkHostedNumberOrder.RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public final String getFriendlyName() {
        return this.friendlyName;
    }

    public final String getNotificationEmail() {
        return this.notificationEmail;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateCompleted() {
        return this.dateCompleted;
    }

    public final URI getUrl() {
        return this.url;
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final List<Map<String, Object>> getResults() {
        return this.results;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BulkHostedNumberOrder other = (BulkHostedNumberOrder) o;

        return (
            Objects.equals(bulkHostingSid, other.bulkHostingSid) &&
            Objects.equals(requestStatus, other.requestStatus) &&
            Objects.equals(friendlyName, other.friendlyName) &&
            Objects.equals(notificationEmail, other.notificationEmail) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateCompleted, other.dateCompleted) &&
            Objects.equals(url, other.url) &&
            Objects.equals(totalCount, other.totalCount) &&
            Objects.equals(results, other.results)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            bulkHostingSid,
            requestStatus,
            friendlyName,
            notificationEmail,
            dateCreated,
            dateCompleted,
            url,
            totalCount,
            results
        );
    }
}
