/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Updater;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.ZonedDateTime;

public class TaskUpdater extends Updater<Task> {

    private String pathWorkspaceSid;
    private String pathSid;
    private String ifMatch;
    private String attributes;
    private Task.Status assignmentStatus;
    private String reason;
    private Integer priority;
    private String taskChannel;
    private ZonedDateTime virtualStartTime;

    public TaskUpdater(final String pathWorkspaceSid, final String pathSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.pathSid = pathSid;
    }

    public TaskUpdater setIfMatch(final String ifMatch) {
        this.ifMatch = ifMatch;
        return this;
    }

    public TaskUpdater setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    public TaskUpdater setAssignmentStatus(final Task.Status assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
        return this;
    }

    public TaskUpdater setReason(final String reason) {
        this.reason = reason;
        return this;
    }

    public TaskUpdater setPriority(final Integer priority) {
        this.priority = priority;
        return this;
    }

    public TaskUpdater setTaskChannel(final String taskChannel) {
        this.taskChannel = taskChannel;
        return this;
    }

    public TaskUpdater setVirtualStartTime(
        final ZonedDateTime virtualStartTime
    ) {
        this.virtualStartTime = virtualStartTime;
        return this;
    }

    @Override
    public Task update(final TwilioRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Tasks/{Sid}";

        path =
            path.replace(
                "{" + "WorkspaceSid" + "}",
                this.pathWorkspaceSid.toString()
            );
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "Task update failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Task.fromJson(response.getStream(), client.getObjectMapper());
    }

    private void addPostParams(final Request request) {
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }
        if (assignmentStatus != null) {
            request.addPostParam(
                "AssignmentStatus",
                assignmentStatus.toString()
            );
        }
        if (reason != null) {
            request.addPostParam("Reason", reason);
        }
        if (priority != null) {
            request.addPostParam("Priority", priority.toString());
        }
        if (taskChannel != null) {
            request.addPostParam("TaskChannel", taskChannel);
        }
        if (virtualStartTime != null) {
            request.addPostParam(
                "VirtualStartTime",
                virtualStartTime.toInstant().toString()
            );
        }
    }

    private void addHeaderParams(final Request request) {
        if (ifMatch != null) {
            request.addHeaderParam("If-Match", ifMatch);
        }
    }
}
