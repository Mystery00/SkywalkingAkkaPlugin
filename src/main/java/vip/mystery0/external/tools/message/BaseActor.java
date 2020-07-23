package vip.mystery0.external.tools.message;

import akka.actor.AbstractActor;
import akka.actor.PoisonPill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mystery0
 * Create at 2020/7/23
 */
public abstract class BaseActor<T> extends AbstractActor {
    private static final Logger log = LoggerFactory.getLogger(BaseActor.class);

    public abstract void handleReceive(T data);

    @Override
    @SuppressWarnings("unchecked")
    public Receive createReceive() {
        return receiveBuilder()
                .match(AkkaMessage.class, data -> {
                    try {
                        handleReceive((T) data.getData());
                    } catch (Exception e) {
                        log.error("", e);
                    } finally {
                        getSelf().tell(PoisonPill.getInstance(), getSelf());
                    }
                })
                .build();
    }
}