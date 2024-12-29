package com.performance.improvement.notice.service;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

@Service
public class MailApiService {

    private final String API_KEY;
    private final String API_SECRET_KEY;

    Logger log = Logger.getLogger(MailApiService.class.getName());

    public MailApiService(
            @Value("${auth.mail-api.key}") String apiKey,
            @Value("${auth.mail-api.secret-key}") String apiSecretKey) {
        this.API_KEY = apiKey;
        this.API_SECRET_KEY = apiSecretKey;
    }

    public MailjetResponse callSyncSendNoticeEmail(String email) {
        ClientOptions clientOptions = ClientOptions.builder()
                .apiKey(API_KEY)
                .apiSecretKey(API_SECRET_KEY)
                .build();
        MailjetClient client = new MailjetClient(clientOptions);

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(
                        Emailv31.MESSAGES,
                        new JSONArray()
                                .put(
                                        new JSONObject()
                                                .put(
                                                        Emailv31.Message.FROM, new JSONObject()
                                                                .put("Email", "together.english.manager@gmail.com")
                                                                .put("Name", "backend-performance-improvement")
                                                )
                                                .put(
                                                        Emailv31.Message.TO, new JSONArray()
                                                                .put(
                                                                        new JSONObject()
                                                                                .put("Email", email)
                                                                                .put("Name", "홍길동님")
                                                                )
                                                )
                                                .put("TemplateID", 6595370)
                                                .put("TemplateLanguage", true)
                                                .put(Emailv31.Message.SUBJECT, "[backend-performance-improvement] 전체 공지 메일입니다.")
//                                                .put(Emailv31.Message.TEXTPART, "TEXT-PART")
//                                                .put(
//                                                        Emailv31.Message.HTMLPART,
//                                                        "<h3>안녕하세요 전체 공지 메일입니다.<br />" +
//                                                                "<a href=\"" + "http://localhost:8080/swagger-ui/index.html" + "\">공지사항</a></h3>" +
//                                                        "<h3>전체인원에게 공지 알림 드립니다(테스트).</h3><br />" +
//                                                                "<h3>공지사항 내용1</h3><br />" +
//                                                                "<h3>공지사항 내용2</h3><br />" +
//                                                                "<h3>공지사항 내용3</h3><br />"
//                                                )
                                )
                );

        try {
            log.info("Running send email tread: " + Thread.currentThread().getName());
            MailjetResponse response = client.post(request);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Failed to send password reset email", e);
        }
    }

    @Async
    public CompletableFuture<MailjetResponse> callAsyncSendNoticeEmail(String email) {
        ClientOptions clientOptions = ClientOptions.builder()
                .apiKey(API_KEY)
                .apiSecretKey(API_SECRET_KEY)
                .build();
        MailjetClient client = new MailjetClient(clientOptions);

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(
                        Emailv31.MESSAGES,
                        new JSONArray()
                                .put(
                                        new JSONObject()
                                                .put(
                                                        Emailv31.Message.FROM, new JSONObject()
                                                                .put("Email", "together.english.manager@gmail.com")
                                                                .put("Name", "backend-performance-improvement")
                                                )
                                                .put(
                                                        Emailv31.Message.TO, new JSONArray()
                                                                .put(
                                                                        new JSONObject()
                                                                                .put("Email", email)
                                                                                .put("Name", "홍길동님")
                                                                )
                                                )
                                                .put("TemplateID", 6595370)
                                                .put("TemplateLanguage", true)
                                                .put(Emailv31.Message.SUBJECT, "[backend-performance-improvement] 전체 공지 메일입니다.")
                                )
                );

        try {
            log.info("Running async send email tread: " + Thread.currentThread().getName());

            MailjetResponse response = client.post(request);
            return CompletableFuture.completedFuture(response)
                    .exceptionally(throwable -> {
                        log.info("Failed to send password reset email, throwableMsg :" + throwable.getMessage());
                        return null;
                    });
        } catch (Exception e) {
            throw new RuntimeException("Failed to send password reset email", e);
        }
    }
}