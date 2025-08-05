package processors;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;


@RegisterForReflection
@ApplicationScoped
public class ProcesadorMayuscula implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody().toString();
        String mayuscula = body.toUpperCase();
        exchange.getIn().setBody(mayuscula);
    }
}
