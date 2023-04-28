package com.hni.notification.push;

import com.hni.notification.common.BaseTimeEntity;
import com.hni.notification.common.OsType;
import javax.persistence.*;

@Entity
@Table(name = "SEND_HISTORY_TH")
public class Push extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private String deviceId;

    @Column(length = 50)
    private String requestServer;

    @Column(length = 50, nullable = false)
    private OsType osType;

    @Column(length = 2000, nullable = false)
    private String message;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column
    private String resultCode;

    private Push(Builder builder) {
        entityId = builder.entityId;
        token = builder.token;
        deviceId = builder.deviceId;
        requestServer = builder.requestServer;
        osType = builder.osType;
        message = builder.message;
        title = builder.title;
        body = builder.body;
        resultCode = builder.resultCode;
    }

    public Push() {}

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setRequestServer(String requestServer) {
        this.requestServer = requestServer;
    }

    public void setOsType(OsType osType) {
        this.osType = osType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getToken() {
        return token;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getRequestServer() {
        return requestServer;
    }

    public OsType getOsType() {
        return osType;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public static class Builder {

        private Long entityId;
        private String token;
        private String deviceId;
        private String requestServer;
        private OsType osType;
        private String message;
        private String title;
        private String body;
        private String resultCode;

        public Builder setEntityId(Long entityId) {
            this.entityId = entityId;
            return this;
        }

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public Builder setDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public Builder setRequestServer(String requestServer) {
            this.requestServer = requestServer;
            return this;
        }

        public Builder setOsType(OsType osType) {
            this.osType = osType;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setResultCode(String resultCode) {
            this.body = resultCode;
            return this;
        }

        public Push build() {
            return new Push(this);
        }
    }
}

