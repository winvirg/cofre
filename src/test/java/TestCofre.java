import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCofre {

    @Test
    public void testMoedas() {
        assertTrue(Moeda.M10 instanceof Enum, "As moedas devem ser enumeracoes");
        assertTrue(Moeda.M25 instanceof Enum, "As moedas devem ser enumeracoes");
        assertTrue(Moeda.M50 instanceof Enum, "As moedas devem ser enumeracoes");
        assertTrue(Moeda.M100 instanceof Enum, "As moedas devem ser enumeracoes");
    }

    @Test
    public void testInicializacao() {
        Cofre cofre = new Cofre(25);
        assertEquals(25, cofre.getVolumeMaximo(),
                "Ao inicializar o volumeMaximo do cofre deve ser igual ao informado no construtor");
        assertEquals(0, cofre.getVolume(),
                "Ao inicializar o volume do cofre deve ser igual ao zero");
        assertTrue(cofre.taInteiro(), "Ao criar um cofre, ele deve estar inteiro");
    }

    @Test
    public void testInserirMoedaCofreQuebrado() {
        Cofre cofre = new Cofre(25);
        cofre.quebrar();
        assertFalse(cofre.add(Moeda.M50), "Nao deve ser possivel adicionar uma moeda em um cofre quebrado");
    }

    @Test
    public void testInserirItemCofreQuebrado() {
        Cofre cofre = new Cofre(25);
        cofre.quebrar();
        Item teste = new Item("Item teste", 10);
        assertFalse(cofre.add(teste), "Nao deve ser possivel adicionar uma moeda em um cofre quebrado");
    }

    @Test
    public void testInserirItemVolumoso() {
        Cofre cofre = new Cofre(25);
        Item arvore = new Item("Arvore", 1000);
        assertFalse(cofre.add(arvore), "Nao deve ser possivel adicionar um item com volume maior que o do cofre");
    }

    @Test
    public void testInserirItem() {
        Cofre cofre = new Cofre(25);
        Item passporte = new Item("Passaporte", 5);
        assertTrue(cofre.add(passporte), "Tem espaco sobrando, entao deve ser possivel adicionar o item");
        assertEquals(20, cofre.getVolumeRestante(), "Ao adicionar um item, o volume restante do cofre deve ser atualizado");
    }

    @Test
    public void testInserirMoeda() {
        Cofre cofre = new Cofre(10);
        assertTrue(cofre.add(Moeda.M10), "Tem espaco sobrando, entao deve ser possivel adicionar o item");
        assertEquals(9, cofre.getVolumeRestante(), "Ao adicionar uma moeda, o volume restante do cofre deve ser atualizado");
    }

    @Test
    public void testInserirItemEmCofreCheio() {
        Cofre cofre = new Cofre(4);
        cofre.add(Moeda.M100);
        Item passporte = new Item("Passaporte", 5);
        assertFalse(cofre.add(Moeda.M10), "Nao deve ser possivel adicionar algo em um cofre cheio");
        assertFalse(cofre.add(passporte), "Nao deve ser possivel adicionar algo em um cofre cheio");
    }

    @Test
    public void testQuebrar() {
        Cofre cofre = new Cofre(25);
        assertTrue(cofre.quebrar(), "Deve ser possel quebrar um cofre inteiro");
    }

    @Test
    public void testQuebrarQuebrado() {
        Cofre cofre = new Cofre(25);
        assertTrue(cofre.quebrar(), "Deve ser possel quebrar um cofre inteiro");
        assertFalse(cofre.quebrar(), "Nao deve ser possivel quebrar um cofre quebrado");
    }

    @Test
    public void testObterMoedaDeCofreInteiro() {
        Cofre cofre = new Cofre(10);
        cofre.add(Moeda.M10);
        assertEquals(-1, cofre.obterMoedas(),
                "Nao deve ser possivel obter moedas de um cofre inteiro (-1)");
    }

    @Test
    public void testObterItemDeCofreInteiro() {
        Cofre cofre = new Cofre(10);
        cofre.add(Moeda.M10);
        assertNull(cofre.obterItens(),
                "Nao deve ser possivel obter itens de um cofre inteiro (null)");
    }


    @Test
    public void testObterMoedas() {
        Cofre cofre = new Cofre(10);
        cofre.add(Moeda.M10);
        cofre.add(Moeda.M100);
        cofre.quebrar();
        assertEquals(1.1, cofre.obterMoedas(),
                "Ao obter as moedas, o cofre deve retornar a some de valores da moedas nele contidas");
    }

    @Test
    public void testObterItems() {
        Cofre cofre = new Cofre(10);
        Item passporte = new Item("Passaporte", 5);
        Item chave = new Item("Chave do carro", 3);
        cofre.add(passporte);
        cofre.add(chave);
        cofre.quebrar();
        assertEquals("Passaporte, Chave do carro", cofre.obterItens(),
                "Ao obter as moedas, o cofre deve retornar a descricao dos itens nele contidos");
    }

    @Test
    public void testObterCofreVazio() {
        Cofre cofre = new Cofre(10);
        cofre.quebrar();
        assertEquals(0, cofre.obterMoedas(),
                "Ao obter as moedas, se o cofre estiver vazio ele deve retornar zero");
        assertEquals("vazio", cofre.obterItens(),
                "Ao obter itens, se cofre estiver vazio ele deve retornar 'vazio'");
    }
}