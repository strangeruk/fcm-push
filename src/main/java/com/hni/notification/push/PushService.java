package com.hni.notification.push;

import com.google.firebase.messaging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class PushService {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String sendPushServer(Push push) throws UnsupportedEncodingException {
        push.setMessage(URLDecoder.decode(push.getMessage(), StandardCharsets.UTF_8.name()));
        push.setToken(URLDecoder.decode(push.getToken(), StandardCharsets.UTF_8.name()));

        switch (push.getOsType()) {
            case AOS:
                Message aosMessage = buildAosMessage(push);
                return sendMessage(aosMessage, push);
            case IOS:
                Message iosMessage = buildIosMessage(push);
                return sendMessage(iosMessage, push);
            default:
                return null;
        }
    }

    private Message buildAosMessage(Push push) throws UnsupportedEncodingException {
        return Message.builder()
                .putData("title", push.getTitle())
                .putData("body", push.getBody())
                .setToken(push.getToken())
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(0)
                        .setPriority(AndroidConfig.Priority.NORMAL)
                        .putData("latitude", (push.getLatitude().isEmpty()) ? "" : push.getLatitude()) // 위도 Test custom data code
                        .putData("longitude", (push.getLongitude().isEmpty()) ? "" : push.getLatitude()) // 경도 Test custom data code
                        .putData("address", (push.getAddress().isEmpty()) ? "" : push.getLatitude()) // Test custom data code
                        .putData("body", push.getBody())
                        .setNotification(AndroidNotification.builder()
                                .setTitle(push.getTitle())
                                .setBody(push.getBody())
                                .build()
                        ).build()
                ).build();
    }

    private Message buildIosMessage(Push push) throws UnsupportedEncodingException {

        return Message.builder()
                .setApnsConfig(ApnsConfig.builder()
                        .putCustomData("latitude", (push.getLatitude().isEmpty()) ? "" : push.getLatitude()) // 위도 Test custom data code
                        .putCustomData("longitude", (push.getLongitude().isEmpty()) ? "" : push.getLatitude()) // 경도 Test custom data code
                        .putCustomData("address", (push.getAddress().isEmpty()) ? "" : push.getLatitude()) // Test custom data code
                        .setAps(Aps.builder().build())
                        .build())
                .setToken(push.getToken())
                .setNotification(new com.google.firebase.messaging.Notification(push.getTitle(), push.getBody()))
                .build();
    }

    private String sendMessage(Message message, Push push) throws UnsupportedEncodingException {
        try {
            String result = FirebaseMessaging.getInstance().send(message);
            push.setResultCode(result);


            logger.info("success message sending | {} | {}", push.getDeviceId(), result);

            return result;
        } catch (FirebaseMessagingException e) {
            push.setResultCode("Failed");

            logger.error("Failed to send push notification: {}", push.getDeviceId(), e);
            logger.error("Failed to send push notification token: {}", push.getToken(), e);
            return null;
        }
    }
}
