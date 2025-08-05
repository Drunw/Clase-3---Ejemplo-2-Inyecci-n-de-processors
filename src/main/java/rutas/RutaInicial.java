package rutas;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.builder.RouteBuilder;
import processors.ProcesadorMayuscula;


@RegisterForReflection
@ApplicationScoped
public class RutaInicial extends RouteBuilder {

    @Inject
    ProcesadorMayuscula procesadorMayuscula;

    @Override
    public void configure() throws Exception {

        from("direct:rutaInicial")
                .log("Entro la peticion: ${body}")
                .transform(simple("Este es mi texto."))
              //  .process(new ProcesadorMayuscula())
                .process(procesadorMayuscula)
                .log("Segundo log: ${body}")
                .end();
    }
}
