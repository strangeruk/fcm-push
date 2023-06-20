package com.hni.notification.push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/pushes")
public class PushController {

    private final PushService pushService;

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public PushController(PushService pushService) {
        this.pushService = pushService;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String SendNotification(Push push) throws UnsupportedEncodingException {

        return pushService.sendPushServer(push);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String SendNotificationForJson(@RequestBody Push push) throws UnsupportedEncodingException {

        return pushService.sendPushServer(push);
    }

    @RequestMapping(value = "/agip/event", method = { RequestMethod.POST }, consumes = {  MediaType.APPLICATION_JSON_VALUE })
    public void receiveWebhooksFromAGIP(@RequestBody List<Map<String, Object>> payload) {
        logger.info("성공");
        logger.info("payload:::{}", payload);
    }
}
