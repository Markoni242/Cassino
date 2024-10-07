package jogosCassino;

import itensBuckshotRoulette.*;

import java.util.ArrayList;
import java.util.List;

public class BuckshotRoulette extends Jogo {
    private boolean[] quantidade = new boolean[8]; //(true = cartucho vermelho, false = cartucho cinza)
    private int indiceCartuchoAtual; 
    private int vida; 
    private int vidaDealer; 
    private int dano; 
    private boolean espingardaSerrada = false; // Indica se a espingarda foi transformada em serrada
    private boolean bloqueadoProximoTurno = false; 
    private boolean turnoDealer; // Verifica se é a vez do dealer
    private List<Item> itens = new ArrayList<>(); // Lista de itens disponíveis para o jogador
    private boolean lupaAtivada = false; // Indica se a lupa foi ativada

    
    public BuckshotRoulette() {
        vidaDealer = 100; 
        vida = 100; 
        dano = 20; 
        indiceCartuchoAtual = -1;
    }

    // Adiciona um item à lista de itens
    public void adicionarItem(Item item) {
        itens.add(item);
    }

    // Usa um item da lista, ativando seu efeito
    public void usarItem(int index) {
        // Verifica se o índice do item é válido
        if (index >= 0 && index < itens.size()) {
            Item itemUsado = itens.get(index);
            itemUsado.usar(this); // Aplica o efeito do item no jogo
            if (itemUsado instanceof Lupa) {
                lupaAtivada = true; // Ativa a lupa se o item usado for uma lupa
            }
        } else {
            System.out.println("Item inválido!"); 
        }
    }

    
    public void restaurarVida(int quantidade) {
        vida += quantidade;
        if (vida > 100) {
            vida = 100; 
        }
        System.out.println("Vida restaurada para: " + vida);
    }

  
    public void restaurarVidaDealer(int quantidade) {
        vidaDealer += quantidade; 
        if (vidaDealer > 100) {
            vidaDealer = 100; 
        }
        System.out.println("Vida restaurada para: " + vidaDealer);
    }

    
    public void ejetarCartucho() {
        System.out.println("Cartucho ejetado.");
    }
    
    public void revelarCartucho() {
        int indiceAtual = indiceCartuchoAtual;
        if (indiceAtual >= 0 && indiceAtual < quantidade.length) {
            if (quantidade[indiceAtual]) {
                System.out.println("O cartucho é vermelho.");
            } else {
                System.out.println("O cartucho é cinza.");
            }
        } else {
            System.out.println("Índice de cartucho inválido."); 
        }
    }

    // Transforma a espingarda em serrada
    public void transformarEmSerrada() {
        espingardaSerrada = true;
        System.out.println("Espingarda transformada em serrada.");
    }

    // Bloqueia o jogador de agir no próximo turno
    public void bloquearProximoTurno() {
        bloqueadoProximoTurno = true;
    }

    // Aplica dano ao jogador ou ao dealer
    private void aplicarDano(boolean paraDealer) {
        int danoAplicado = espingardaSerrada ? 2 * dano : dano; // Dano dobrado se a espingarda estiver serrada
        if (paraDealer) {
            vidaDealer -= danoAplicado;
            System.out.println("Dealer perdeu vida. Vida do dealer: " + vidaDealer);
        } else {
            vida -= danoAplicado; 
            System.out.println("Você perdeu vida. Vida atual: " + vida);
        }
    }

    // O jogador atira em si mesmo
    public void atirarEmSiMesmo() {
        if (quantidade[indiceCartuchoAtual]) {
            aplicarDano(false); // Aplica dano se o cartucho for vermelho
        } else {
            System.out.println("Cartucho vazio!!!"); 
        }
    }

    // O jogador atira no dealer
    public void atirarNoDealer() {
        if (quantidade[indiceCartuchoAtual]) {
            aplicarDano(true); // Aplica dano ao dealer se o cartucho for vermelho
        } else {
            System.out.println("Cartucho vazio!!!"); 
        }
    }

    // Retorna se é a vez do dealer
    public boolean turnoDealer() {
        return turnoDealer;
    }

    // Verifica se o cartucho atual é vermelho
    public boolean getCartuchoAtual() {
        return indiceCartuchoAtual >= 0 && indiceCartuchoAtual < quantidade.length && quantidade[indiceCartuchoAtual];
    }

    // Lógica do dealer para atirar ou usar item
    public void dealerAtirarOuUsarItem() {
        if (bloqueadoProximoTurno) {
            System.out.println("O dealer está bloqueado e não pode agir neste turno.");
            bloqueadoProximoTurno = false; // Reseta o bloqueio
            return;
        }

        turnoDealer = true; // É a vez do dealer

        boolean usarItem = gerador.nextBoolean(); // Decide aleatoriamente se o dealer usará um item

        if (usarItem && !itens.isEmpty()) {
            int itemIndex = gerador.nextInt(itens.size()); // Escolhe um item aleatório
            Item itemUsado = itens.get(itemIndex);
            System.out.println("O dealer decidiu usar um item: " + itemUsado.getClass().getSimpleName());
            itemUsado.usar(this); // Usa o item
        } else {
            // Dealer escolhe atirar
            indiceCartuchoAtual = gerador.nextInt(8); // Escolhe um cartucho aleatório
            boolean dealerAtiraEmSiMesmo = gerador.nextBoolean(); 
            if (dealerAtiraEmSiMesmo) {
                System.out.println("O dealer escolheu atirar em si mesmo.");
                if (quantidade[indiceCartuchoAtual]) {
                    aplicarDano(true); // Aplica dano ao dealer
                } else {
                    System.out.println("Cartucho vazio!!! O dealer não causou dano a si mesmo.");
                }
            } else {
                System.out.println("O dealer escolheu atirar em você.");
                if (quantidade[indiceCartuchoAtual]) {
                    aplicarDano(false); // Aplica dano ao jogador
                } else {
                    System.out.println("Cartucho vazio!!! O dealer não causou dano."); 
                }
            }
        }

        turnoDealer = false; // Volta para o jogador
    }

    // Inicia o jogo
    public boolean start() {
        System.out.println();

        // Loop principal do jogo
        while (vidaDealer > 0 && vida > 0) {
            // Verifica se o jogador está bloqueado
            if (bloqueadoProximoTurno) {
                bloqueadoProximoTurno = false; // Reseta o bloqueio
                System.out.println("O dealer joga novamente.");
                dealerAtirarOuUsarItem(); // Dealer joga novamente
                continue;
            }

            // Inicializa os cartuchos aleatoriamente
            for (int i = 0; i < 8; i++) {
                quantidade[i] = gerador.nextBoolean();
            }

            // Revela o cartucho se a lupa estiver ativada
            if (lupaAtivada) {
                revelarCartucho();
            }

            // Verifica se o jogo acabou
            if (vidaDealer <= 0 || vida <= 0) {
                System.out.println("Fim de jogo!!!");
                if (vidaDealer <= 0) {
                    System.out.println("O dealer morreu, você venceu");
                    return true; 
                } else {
                    System.out.println("Você morreu");
                    return false;
                }
            }

            // O jogador faz sua jogada
            if (vidaDealer > 0 && vida > 0) {
                // Inicializa um índice de cartucho válido antes de atirar
                indiceCartuchoAtual = gerador.nextInt(8); // Escolhe um índice aleatório de cartucho

                System.out.println("É seu turno, o que deseja fazer?");
                System.out.println("1 - Atirar em si mesmo");
                System.out.println("2 - Atirar no dealer");
                System.out.println("3 - Usar item");
                String escolha = sc.next(); // Captura a escolha do jogador

                if (escolha.equals("1")) {
                    atirarEmSiMesmo(); // Jogador atira em si mesmo
                } else if (escolha.equals("2")) {
                    atirarNoDealer(); // Jogador atira no dealer
                } else if (escolha.equals("3")) {
                    System.out.println("Escolha um item para usar:");
                    // Exibe a lista de itens disponíveis
                    for (int j = 0; j < itens.size(); j++) {
                        System.out.println((j + 1) + " - " + itens.get(j).getClass().getSimpleName());
                    }
                    int itemEscolhido = sc.nextInt() - 1; // Lê a escolha do item
                    usarItem(itemEscolhido); // Usa o item escolhido
                } else {
                    System.out.println("Escolha inválida!"); // Mensagem se a escolha não for válida
                }
            }

            // Turno do dealer
            if (vidaDealer > 0 && vida > 0) {
                System.out.println("É a vez do dealer...");
                dealerAtirarOuUsarItem(); // Dealer realiza sua ação
            }

            // Verifica se o jogo acabou novamente
            if (vidaDealer <= 0 || vida <= 0) {
                System.out.println("Fim de jogo!!!");
                if (vidaDealer <= 0) {
                    System.out.println("O dealer morreu, você venceu");
                    return true;
                } else {
                    System.out.println("Você morreu");
                    return false; 
                }
            }
        }
        return false; // Retorna false se o jogo não terminar
    }
}
