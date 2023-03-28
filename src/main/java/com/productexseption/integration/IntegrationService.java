package com.productexseption.integration;

import com.productexseption.core.page_request.PageableRequest;
import com.productexseption.exception.ResourceNotFoundException;
import com.productexseption.integration.pojo.Advice;
import com.productexseption.integration.pojo.AdvocacyRegister;
import com.productexseption.integration.pojo.LicenseSearchDto;
import com.productexseption.integration.pojo.Licenses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IntegrationService {

    @Value("${lawyer}")
    String lawyerRegister;

    public ResponseEntity<AdvocacyRegister> getRegister(String search,
                                                        Long contragentId,
                                                        Long regionId,
                                                        PageableRequest pageableRequest) {
        var restTemplate = new RestTemplate();
        var mapUrl = new HashMap<String, Object>();
        mapUrl.put("search", search);
        mapUrl.put("contragentId", contragentId);
        mapUrl.put("regionId", regionId);
        var builder = UriComponentsBuilder.fromHttpUrl(lawyerRegister);
        builder.queryParam("search", search);
        builder.queryParam("contragentId", contragentId);
        builder.queryParam("regionId", regionId);
        var body = new HashMap<String, Object>();
        body.put("limit", pageableRequest.getPerPage());
        body.put("page", pageableRequest.getPage());
        var response = restTemplate
                .postForEntity(
                        builder.build().encode().toUri(),
                        body,
                        AdvocacyRegister.class
                );
        //request param request body
        return response;
    }

    public Advice getAdviceCategoryChild(Long id) throws ResourceNotFoundException {
        String url = "https://advice.uz/api/uz/categories?id=" + id;
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] xcs, String string) {
                }

                public void checkServerTrusted(X509Certificate[] xcs, String string) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLContext.setDefault(ctx);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<Advice> entity = new HttpEntity<>(headers);
            return restTemplate.exchange(
                    url, HttpMethod.GET, entity, Advice.class).getBody();
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    public Licenses getLicensesBySearch(LicenseSearchDto searchDto) {
        String url = "https://api.licenses.uz/v1/register/open_source?page=" + searchDto.getPage() + "&size=" + searchDto.getPerPage();
        RestTemplate restTemplate=new RestTemplate();
        Map<String, Object> params = new HashMap<>();
        if (searchDto.getDocumentId() != null) {
            params.put("document_id", searchDto.getDocumentId());
        }
        if (searchDto.getDocumentType() != null) {
            params.put("document_type", searchDto.getDocumentType());
        }
        if (searchDto.getTin() != null) {
            params.put("tin", searchDto.getTin());
        }
        if (searchDto.getPin() != null) {
            params.put("pin", searchDto.getPin());
        }
        if (searchDto.getName() != null) {
            params.put("name", searchDto.getName());
        }
        if (searchDto.getNumber() != null) {
            params.put("number", searchDto.getNumber());
        }
        try {
            Licenses res = restTemplate.getForObject(url, Licenses.class);

            if (res == null) {
               throw new ResourceNotFoundException("Not found");
            }

            return res;

        } catch (Exception e) {
            e.getMessage();

        }
        return null;
    }
}
