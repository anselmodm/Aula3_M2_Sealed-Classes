import java.time.Instant;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Onde vemos se o código está a fazer o que queremos que ele faça

    public static void main(String[] args){
        RoteadorDeEventos roteador = new RoteadorDeEventos();

        //Simulamos a receção de eventos do sistema
        List<EventoSistema> eventosRecebidos = List.of(
           new RelatorioCpu("srv-app-01",85.5, Instant.now()),
           new AlertaDisco("srv-db-01",96,Instant.now()),
           new FalhaRede("srv-proxy","192.168.1.50",Instant.now())
        );
        System.out.println("--- A INICIAR PROCESSAMENTO DE EVENTOS ---");
        for (EventoSistema e : eventosRecebidos){
            roteador.processar(e);
        }
    }
}