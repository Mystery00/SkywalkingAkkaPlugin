package vip.mystery0.external.tools.message;

import java.io.Serializable;

/**
 * @author mystery0
 * Create at 2020/7/23
 */
public class AkkaMessage<T> implements Serializable {
    private T data;
    private String traceId;

    public static <T> AkkaMessage<T> ofData(T data) {
        return new AkkaMessage<>(data);
    }

    private AkkaMessage(T data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "AkkaMessage{" +
                "data=" + data +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}
