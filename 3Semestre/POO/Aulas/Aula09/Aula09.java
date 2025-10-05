import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Aula09 {
    public static void main(String[] args){
        //--Rascunho
        //----------

        int[] meusInteiros = {2,3,4,1};

        List<Integer> minhaLista = new ArrayList();
        minhaLista.add( 2 );
        minhaLista.add( 3 );
        minhaLista.add( 4 );
        minhaLista.add( 1 );
        minhaLista.add( -72 );

        System.out.println( minhaLista );
        System.out.println( minhaLista.get(0) );
        System.out.println( minhaLista.contains(0) );
        
        minhaLista.remove( 4 );
        minhaLista.add(-1);

        System.out.println( minhaLista );

        List<Integer> lista2 = new ArrayList();
        lista2.add(5);
        lista2.add(99);

        minhaLista.addAll(lista2);
        System.out.println( minhaLista );


        //--Doubles
        List<Double> listaDouble = new ArrayList();
        listaDouble.add( 2.9 );
        listaDouble.add( 3.1 );
        listaDouble.add( -93.1 );
        listaDouble.add( 0.0 );
        System.out.println(listaDouble);

        //--Pessoas
        List<Pessoa> listaDePessoas = new ArrayList();
        listaDePessoas.add( new Pessoa("Pedro",30) );
        listaDePessoas.add( new Pessoa("Maria",20) );
        listaDePessoas.add( new Pessoa("Lucia",40) );
        listaDePessoas.add( new Pessoa("José",50) );
        System.out.println( listaDePessoas );
        //----------

        Disciplina d1 = new Disciplina( "POO", 4);
        Disciplina d2 = new Disciplina("Alg1", 4);
        Disciplina d3 = new Disciplina("PI1", 4);
        Disciplina d4 = new Disciplina("ED", 4);
        Disciplina d5 = new Disciplina("Adm", 1);
        Disciplina d6 = new Disciplina("Matemática", 3);
        Disciplina d7 = new Disciplina("Alg2", 4);

        Professor p1 = new Professor( "Ludovica" );
        p1.atribuiDisciplina( d1 );

        Professor p2 = new Professor("Rogério", new Disciplina[]{ d2, d3, d4 } );

        Professor p3 = new Professor("Cláudio");
        p3.atribuiDisciplina(d5);
        p3.atribuiDisciplina(d6);
        p3.atribuiDisciplina(d7);

        System.out.println( p1 );
        System.out.println( p2 );
        System.out.println( p3 );

        //--HashSet
        //-----------
        System.out.println("\n###############HashSet\n");

        Set<Integer> setDeInteiros = new HashSet();
        setDeInteiros.add( 6 );
        setDeInteiros.add( 4 );
        setDeInteiros.add( 2 );
        setDeInteiros.add( -5 );

        System.out.println( setDeInteiros );

        boolean adicionou = setDeInteiros.add( 2 );
        System.out.println( setDeInteiros );
        System.out.println(adicionou);

        adicionou = setDeInteiros.add( 72 );
        System.out.println( setDeInteiros );
        System.out.println(adicionou);

        System.out.println(
            setDeInteiros.contains(-72)
        );

        Set<Disciplina> setDisc = new HashSet<>();
        setDisc.add(d1);
        setDisc.add(d2);
        setDisc.add(d3);
        setDisc.add(d4);
        setDisc.add(d5);
        setDisc.add(d6);
        setDisc.add(d7);
        setDisc.add(d1);
        System.out.println( setDisc );


        //--HashMap
        //----------------------------
        System.out.println("\n###############\nHashMap");
        Map<String,Pessoa> mapDePessoas = new HashMap();
        
        Pessoa pessoa1 = new Pessoa("Teresa", 60);
        Pessoa pessoa2 = new Pessoa("Osvaldo", 70);
        Pessoa pessoa3 = new Pessoa( "Enzo", 12 );
        Pessoa pessoa4 = new Pessoa( "Valentina", 9 );

        mapDePessoas.put( pessoa1.getNome(), pessoa1 );
        mapDePessoas.put( pessoa2.getNome(), pessoa2 );
        mapDePessoas.put( pessoa3.getNome(), pessoa3 );
        mapDePessoas.put( pessoa4.getNome(), pessoa4 );
        mapDePessoas.put( "asdfasdfasdf", new Pessoa("a",0) );

        System.out.println( mapDePessoas.get("Valentina") );
        System.out.println( mapDePessoas.size() );

        System.out.println( mapDePessoas.containsKey("Valentina") );
        System.out.println( mapDePessoas.containsKey("Pedro") );
        System.out.println( mapDePessoas.containsValue(pessoa1) );

        Map<Double,String> mapEstranho = new HashMap();
        mapEstranho.put( 2.5, "Oi" );
        mapEstranho.put( -9.3, "Tchau" );


        System.out.println( mapDePessoas );
        System.out.println( mapEstranho );

        for (Map.Entry<String, Pessoa> entry : mapDePessoas.entrySet()) {
            String key = entry.getKey();
            Pessoa value = entry.getValue();
            System.out.println("Key=" + key + ", Value=" + value);
        }

    }
}