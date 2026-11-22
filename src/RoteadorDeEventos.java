public class RoteadorDeEventos {
    //Aqui um metodo para simular o nosso backend e que irá receber um evento XPTO
    public void processar(EventoSistema evento) {
        /* PATTERN MATCHING- Uma sintaxe que permite testar se um objecto tem um determinado tipo e, simultaneamente
        e de forma segura, extrair o seu valor para uma variável, eliminando de casts explícitos.
         */
        //SWITCH EXPRESSION - O java avalia o tipo do objecto em tempo de execução e aplíca a lógica.
        //Por que? Ficou potente porque deminui erros humanos e não precisamos maís fazer casts manuais
        //Por ser selead não precisamos do DEFAULT

        String acao = switch (evento) {

            //GUARD CLAUSES - Uso do 'when' para lógica específica de negócio
            //Porcentagem de uso
            case AlertaDisco d when d.percentagemUso() >= 95 ->
                    "CRÍTICO: Disparar SMS para equipa de DevOps! Servidor " + d.nomeServidor() + " quase cheio (" + d.percentagemUso() + "% )";
            case AlertaDisco d -> "Aviso: Limpar ficheiros temporários no servidor " + d.nomeServidor() + ".";
            // Avaliação de temperatura
            case RelatorioCpu c when c.temperatura() > 85.0 ->
                    "ALERTA TÉRMICO: Reduzir carga no servidor " + c.nomeServidor() + ". Temp: " + c.temperatura() + "°C";

            case RelatorioCpu c -> "Info: CPU do servidor " + c.nomeServidor() + " está estável.";

            //Tramento de falha
            case FalhaRede f ->
                    "ERRO DE REDE: O servidor " + f.nomeServidor() + " perdeu a ligação no IP " + f.enderecoIp() + ". Reiniciar placa de rede";

            //default ->
            //    "Erro descolhecido";  --- neste caso o defaultnào é necessário
        };
        System.out.println("[LOG ROTEADOR] " + acao);


    }
}
