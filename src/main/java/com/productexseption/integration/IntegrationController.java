package com.productexseption.integration;

import com.productexseption.core.SuccessfulResponse;
import com.productexseption.core.page_request.PageableRequest;
import com.productexseption.exception.ResourceNotFoundException;
import com.productexseption.integration.pojo.Advice;
import com.productexseption.integration.pojo.AdvocacyRegister;
import com.productexseption.integration.pojo.LicenseSearchDto;
import com.productexseption.integration.pojo.Licenses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/integration")
public class IntegrationController {
    private final IntegrationService integrationService;

    @PostMapping(value = "/lawyer")
    private ResponseEntity<AdvocacyRegister> getRegister(@RequestParam(required = false) String search,
                                                         @RequestParam(required = false) Long contragentId,
                                                         @RequestParam(required = false) Long regionId,
                                                         @RequestBody PageableRequest pageableRequest) {
        return integrationService.getRegister(search, contragentId, regionId, pageableRequest);
    }

    @GetMapping(value = "/{id}")
    private Advice getAdviceCategories(@PathVariable Long id)
            throws ResourceNotFoundException {
        return integrationService.getAdviceCategoryChild(id);
    }
    @PostMapping(value = "/licenses")
    private Licenses getLicensesRestServiceUtil(@RequestBody LicenseSearchDto searchDto) {
        return integrationService.getLicensesBySearch(searchDto);
    }
}
