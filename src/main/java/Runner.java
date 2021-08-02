public class Runner {

    public static void main(final String[] args) {

        Cofre cofre = new Cofre(20);
        System.out.println(cofre); //Cofre{volume=0/20, inteiro=true, moedas=0.0, itens='vazio'}
        cofre.add(Moeda.M10);
        cofre.add(Moeda.M50);
        System.out.println(cofre); //Cofre{volume=4/20, inteiro=true, moedas=0.6, itens=''}

        cofre.add(new Item("ouro", 3));
        System.out.println(cofre); //Cofre{volume=7/20, inteiro=true, moedas=0.6, itens='ouro'}

        cofre.add(new Item("passaporte", 2));
        System.out.println(cofre); //Cofre{volume=9/20, inteiro=true, moedas=0.6, itens='ouro, passaporte'}

        if (cofre.obterItens() == null) {
            System.out.println("Voce deve quebrar o cofre primeiro"); //Voce deve quebrar o cofre primeiro
        }

        if( cofre.obterMoedas() == -1){
            System.out.println("Voce deve quebrar o cofre primeiro"); //"Voce deve quebrar o cofre primeiro"
        }
        System.out.println(cofre); //Cofre{volume=9/20, inteiro=true, moedas=0.6, itens='ouro, passaporte'}

        cofre.quebrar();
        cofre.quebrar();

        System.out.println(cofre.obterItens());  //ouro, passaporte
        System.out.println(cofre.obterMoedas()); //0.6
        System.out.println(cofre); //Cofre{volume=9/20, inteiro=false, moedas=0.6, itens='ouro, passaporte, '}

    }
}
