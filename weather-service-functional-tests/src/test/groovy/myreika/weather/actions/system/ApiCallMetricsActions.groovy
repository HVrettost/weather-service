package myreika.weather.actions.system

import myreika.weather.domain.enums.metrics.ApiCallType
import myreika.weather.request.metrics.DeleteApiCallMetricsByApiCallTypeRequest
import myreika.weather.request.metrics.GetApiCallMetricsByApiCallTypeRequest
import org.springframework.boot.test.web.client.TestRestTemplate

trait ApiCallMetricsActions {

    def deleteApiCallMetricsByApiCallType(TestRestTemplate restTemplate, ApiCallType apiCallType) {
        DeleteApiCallMetricsByApiCallTypeRequest request = new DeleteApiCallMetricsByApiCallTypeRequest(restTemplate, apiCallType)
        request.executeRequest()
    }

    def getApiCallMetricsByApiCallType(TestRestTemplate restTemplate, ApiCallType apiCallType) {
        GetApiCallMetricsByApiCallTypeRequest request = new GetApiCallMetricsByApiCallTypeRequest(restTemplate, apiCallType)
        request.executeRequest()
    }
}