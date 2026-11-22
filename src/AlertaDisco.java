import java.time.Instant;
//Usamos records para garantir que, assimque o evento é criado,ninguém o altera.
public record AlertaDisco(String nomeServidor, int percentagemUso, Instant timestamp) implements EventoSistema{

}
