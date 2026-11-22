import java.time.Instant;

public record FalhaRede(String nomeServidor, String enderecoIp, Instant timestamp)implements EventoSistema {
}
