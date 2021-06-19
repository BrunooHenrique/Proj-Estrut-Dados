import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Random ran = new Random();
    private static long[] arrayNum;

    public static void gerarNum(int num){
        arrayNum = new long[num];
        while(arrayNum[num-1] == 0) {
            long x = ran.nextInt((num*10)) + 1;
            boolean check = false;
            for (int j = 0; j < arrayNum.length; j++) {
                if(x == arrayNum[j]){
                    System.out.println("o número "+ x + " não foi armazenado novamente");
                    check = true;
                    break;
                }
            }
            if (check == false){
                for (int ii = 0; ii < arrayNum.length;ii++){
                    if(arrayNum[ii]== 0){
                        arrayNum[ii] = x;
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BinaryTree arvBin = new BinaryTree();
        AvlTree avl = new AvlTree();
        System.out.println("Digite o número de números a serem gerados:");
        int num = scanner.nextInt();
        gerarNum(num);
        int opcao;
        long x;
        System.out.print("\n Programa Arvore binaria de long");
        do {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n ----1: Inserir");
            System.out.print("\n ----2: Excluir");
            System.out.print("\n ----3: Pesquisar");
            System.out.print("\n ----4: Exibir");
            System.out.print("\n ----99: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            opcao = scanner.nextInt();
            LocalDateTime start;
            LocalDateTime end;
            long tempBin;
            long tempAvl;
            switch(opcao) {
                case 1: {                        
                        start = LocalDateTime.now();                    
                        for (long i : arrayNum) {
                            arvBin.inserir(i);
                            
                        }
                        end = LocalDateTime.now();
                        tempBin = ChronoUnit.NANOS.between(start, end);
                        System.out.println("BIN Insert Time Elapsed in: " + tempBin + "nanosegundos");
                        //
                        start = LocalDateTime.now();
                        for (long i : arrayNum) {
                            avl.insert(i);
                            
                        }
                        end = LocalDateTime.now();
                        tempAvl = ChronoUnit.NANOS.between(start, end);
                        System.out.println("AVL Insert Time Elapsed in: " + tempAvl + "nanosegundos");
                        if(tempBin < tempAvl)
                                    System.out.println("A árvore mais rápida foi a Binária");
                                else System.out.println("A árvore mais rápida foi a AVL");
                        break;
                }
                case 2: {
                        System.out.print("\n Informe o valor (long) -> ");
                        x = scanner.nextLong();
                            start = LocalDateTime.now(); 
                        if ( !arvBin.remover(x) ) System.out.println("\n Valor nao encontrado!");
                            end = LocalDateTime.now();
                            tempBin = ChronoUnit.NANOS.between(start, end);
                            System.out.println("Remove Time Elapsed in: " + tempBin  + "nanosegundos");
                            start = LocalDateTime.now(); 
                        if ( avl.remove(x) == null ) System.out.println("\n Valor " + (x) + " Removido.");
                        else System.out.println("Valor não encontrado.");
                            end = LocalDateTime.now();
                            tempAvl = ChronoUnit.NANOS.between(start, end);
                            System.out.println("Remove Time Elapsed in: " + tempAvl  + "nanosegundos");
                            if(tempBin < tempAvl)
                                    System.out.println("A árvore mais rápida foi a Binária");
                                else System.out.println("A árvore mais rápida foi a AVL");
                       //falta função avlTree remover
                        break;
                }
                case 3: {
                        System.out.print("\n Informe o valor (long) -> ");
                            x = scanner.nextLong();
                            start = LocalDateTime.now();
                            
                            if( arvBin.buscar(x) != null )
                                System.out.println("\n Valor Encontrado");
                            else 
                                System.out.println("\n Valor nao encontrado!");
                                end = LocalDateTime.now();
                                
                                tempBin = ChronoUnit.NANOS.between(start, end);
                                System.out.println("BIN Search Time Elapsed in: " + tempBin + "nanosegundos");
                                start = LocalDateTime.now();
                            if (avl.search(x) != null)
                                System.out.println("\n Valor Encontrado");
                            else 
                                System.out.println("\n Valor nao encontrado!");
                                
                                end = LocalDateTime.now();
                                tempAvl = ChronoUnit.NANOS.between(start, end);
                                System.out.println("AVL Search Time Elapsed in: " + tempAvl + "nanosegundos");
                                if(tempBin < tempAvl)
                                    System.out.println("A árvore mais rápida foi a Binária");
                                else System.out.println("A árvore mais rápida foi a AVL");
                                
                            
                            
                        break;
                }	  
                case 4: {
                        start = LocalDateTime.now();
                        arvBin.caminhar();
                        
                        avl.displayTree();
                        break; 
                }
                    } // fim switch
                } while(opcao != 99);

    

    for( long v: arrayNum){
        System.out.println(v);
    }
}
}
