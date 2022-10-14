/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.service.conversation;

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

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Webhook extends Resource {
    private static final long serialVersionUID = 228548505277204L;

    public static WebhookCreator creator(final String chatServiceSid, final String conversationSid, final Webhook.Target target){
        return new WebhookCreator(chatServiceSid, conversationSid, target);
    }

    public static WebhookFetcher fetcher(final String chatServiceSid, final String conversationSid, final String sid){
        return new WebhookFetcher(chatServiceSid, conversationSid, sid);
    }

    public static WebhookDeleter deleter(final String chatServiceSid, final String conversationSid, final String sid){
        return new WebhookDeleter(chatServiceSid, conversationSid, sid);
    }

    public static WebhookReader reader(final String chatServiceSid, final String conversationSid){
        return new WebhookReader(chatServiceSid, conversationSid);
    }

    public static WebhookUpdater updater(final String chatServiceSid, final String conversationSid, final String sid){
        return new WebhookUpdater(chatServiceSid, conversationSid, sid);
    }

    /**
    * Converts a JSON String into a Webhook object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Webhook object represented by the provided JSON
    */
    public static Webhook fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Webhook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Webhook object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Webhook object represented by the provided JSON
    */
    public static Webhook fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Webhook.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Method {
        GET("GET"),
        POST("POST");

        private final String value;

        private Method(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Method forValue(final String value) {
            return Promoter.enumFromString(value, Method.values());
        }
    }
    public enum Target {
        WEBHOOK("webhook"),
        TRIGGER("trigger"),
        STUDIO("studio");

        private final String value;

        private Target(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Target forValue(final String value) {
            return Promoter.enumFromString(value, Target.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String chatServiceSid;
    private final String conversationSid;
    private final String target;
    private final URI url;
    private final Map<String, Object> configuration;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;

    @JsonCreator
    private Webhook(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("chat_service_sid")
        final String chatServiceSid,

        @JsonProperty("conversation_sid")
        final String conversationSid,

        @JsonProperty("target")
        final String target,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("configuration")
        final Map<String, Object> configuration,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.chatServiceSid = chatServiceSid;
        this.conversationSid = conversationSid;
        this.target = target;
        this.url = url;
        this.configuration = configuration;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getChatServiceSid() {
            return this.chatServiceSid;
        }
        public final String getConversationSid() {
            return this.conversationSid;
        }
        public final String getTarget() {
            return this.target;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Map<String, Object> getConfiguration() {
            return this.configuration;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Webhook other = (Webhook) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(chatServiceSid, other.chatServiceSid) &&  Objects.equals(conversationSid, other.conversationSid) &&  Objects.equals(target, other.target) &&  Objects.equals(url, other.url) &&  Objects.equals(configuration, other.configuration) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, chatServiceSid, conversationSid, target, url, configuration, dateCreated, dateUpdated);
    }

}

