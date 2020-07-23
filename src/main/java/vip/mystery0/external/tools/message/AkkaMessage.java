package vip.mystery0.external.tools.message;

import org.slf4j.MDC;
import vip.mystery0.external.tools.config.Constants;

import java.io.Serializable;

/**
 * @author mystery0
 * Create at 2020/7/23
 */
public class AkkaMessage<T> implements Serializable {
    private T data;
    private String traceId;
    private Object metadata;

    public AkkaMessage(T data) {
        this.data = data;
        captureTrace();
    }

    public void captureTrace() {
        this.traceId = MDC.get(Constants.MDC_TRACE_ID);
    }

    public void restoreTrace() {
        MDC.put(Constants.MDC_TRACE_ID, this.traceId);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "AkkaMessage{" +
                "data=" + data +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}
