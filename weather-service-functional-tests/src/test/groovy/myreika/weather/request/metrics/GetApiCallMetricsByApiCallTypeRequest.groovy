package myreika.weather.request.metrics

import myreika.weather.domain.enums.metrics.ApiCallType
import myreika.weather.request.TestRequest
import org.springframework.boot.test.web.client.TestRestTemplate

class GetApiCallMetricsByApiCallTypeRequest implements TestRequest {

    private TestRestTemplate restTemplate
    private String url = '%s/api/test/api-call-metrics/%s'

    GetApiCallMetricsByApiCallTypeRequest(TestRestTemplate testRestTemplate, ApiCallType apiCallType) {
        this.restTemplate = testRestTemplate
        url = String.format(url, HOST, apiCallType.name())
    }

    @Override
    def executeRequest() {
        restTemplate.getForEntity(url, Object)
    }
}
