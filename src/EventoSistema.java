/**
 * Vamos lidar aqui com umamonitorização simples.
 * Pensemos que temos um sistema que possui serviços que ficam em fila de milhares de eventos
 * e precisamos processar os pedidos da fila de acordo com o que é permitido.
 *
 * Como era feito antes do Java 21? Em cascata e mais cascata de if, por exemplo,
 * if (evento instanceof AlertaQualquer) { ... } else if ...
 *
 * Por ser lento, frágil e dificil de ler e fazer manunteção foi implementado o Sealed e o Pattern Matching
 */

/*
SEALED CLASS - Uma funcionalidade que permite restringir quais as classes ou interfaces que podem
estender ou implementar uma  determinada classe/interface base.
 */
public sealed interface EventoSistema permits AlertaDisco, RelatorioCpu,FalhaRede {
}
