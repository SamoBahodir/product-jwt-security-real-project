package com.productexseption.sms;

import com.productexseption.core.enumeration.SmsStatus;
import com.productexseption.core.enumeration.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SmsService {
    private final SmsRepository smsRepository;

    private void sentSms(Sms sms) {
        HttpEntity<String> request = new HttpEntity<>("");
        RestTemplate restTemplate = new RestTemplate();
        String urlVariables = "http://94.158.52.192/api/v2/sendsms.php?username=DXA&password=47ab77271f2d974db3d41a20f07f8696&from=DAVXIZMAT&coding=0";
        try {
            String url = urlVariables + "&id=" + sms.getId() + "&to=" + sms.getPhoneNumber() + "&text=" + sms.getText();
            System.out.println("send sms info=" + url);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            System.out.println("send sms response=" + response);
            if (response.getStatusCode().equals(HttpStatus.OK))
                sms.setSmsStatus(SmsStatus.SENT);
            else
                sms.setSmsStatus(SmsStatus.ERROR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sms create(Long userId, String phoneNumber, String text) {
        Sms sms = new Sms();
        sms.setUserId(userId);
        sms.setPhoneNumber(phoneNumber);
        sms.setText(text);
        sms.setSmsStatus(SmsStatus.SEND);
        sms.setStatus(Status.ACTIVE);
        smsRepository.save(sms);
        sentSms(sms);
        return sms;
    }

}