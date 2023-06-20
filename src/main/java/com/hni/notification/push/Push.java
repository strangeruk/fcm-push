package com.hni.notification.push;

import com.hni.notification.common.OsType;


public class Push {

    private Long entityId;
    private String token;
    private String deviceId;
    private String requestServer;
    private OsType osType;
    private String message;
    private String title;
    private String body;
    private String resultCode;
    private String latitude;
    private String longitude;
    private String address;
    private String type;


    private Push(Builder builder) {
        entityId = builder.entityId;
        token = builder.token;
        deviceId = builder.deviceId;
        requestServer = builder.requestServer;
        osType = builder.osType;
        message = builder.message;
        title = builder.title;
        body = builder.body;
        latitude = builder.resultCode;
        latitude = builder.latitude;
        longitude = builder.longitude;
        address = builder.address;
        type = builder.type;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        private String latitude;
        private String longitude;
        private String address;
        private String type;

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

        public Builder setLatitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Push build() {
            return new Push(this);
        }
    }
}

