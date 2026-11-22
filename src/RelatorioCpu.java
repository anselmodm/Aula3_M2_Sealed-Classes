import java.time.Instant;
//Usamos records para garantir que, assimque o evento é criado,ninguém o altera.
public record RelatorioCpu(String nomeServidor, double temperatura, Instant timestamp) implements EventoSistema {
}
