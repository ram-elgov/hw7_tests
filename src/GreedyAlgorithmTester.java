import java.util.*;

public class GreedyAlgorithmTester {
    public static void main(String[] args){
        coinsTest();
        fksTest();
        mstTest();
    }
    public static void coinsTest(){
        System.out.println("---------------------coinsTest()---------------------");
        System.out.println((new Coins(1)).greedyAlgorithm().equals(Collections.singletonList(1)));
        System.out.println((new Coins(2)).greedyAlgorithm().equals(Collections.singletonList(2)));
        System.out.println((new Coins(5)).greedyAlgorithm().equals(Collections.singletonList(5)));
        System.out.println((new Coins(10)).greedyAlgorithm().equals(Collections.singletonList(10)));
        System.out.println((new Coins(9)).greedyAlgorithm().equals(Arrays.asList(5,2,2)));
        System.out.println((new Coins(19)).greedyAlgorithm().equals(Arrays.asList(10,5,2,2)));
        System.out.println((new Coins(30)).greedyAlgorithm().equals(Arrays.asList(10,10,10)));
        System.out.println((new Coins(36)).greedyAlgorithm().equals(Arrays.asList(10,10,10,5,1)));
        System.out.println((new Coins(0)).greedyAlgorithm() == null);
        System.out.println((new Coins(156)).greedyAlgorithm()
                .equals(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 1)));
        System.out.println((new Coins(100)).greedyAlgorithm()
                .equals(Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)));




    }
    public static void fksTest(){
        System.out.println("---------------------fksTest()---------------------");
        FractionalKnapSack.Item s1 = new FractionalKnapSack.Item(10,60);
        FractionalKnapSack.Item s2 = new FractionalKnapSack.Item(20,100);
        FractionalKnapSack.Item s3 = new FractionalKnapSack.Item(30,120);
        FractionalKnapSack s = new FractionalKnapSack(50, Arrays.asList(s3,s1,s2));
        System.out.println(s.greedyAlgorithm().toString().equals("[{weight=10.0, value=60.0}, {weight=20.0, value=100.0}, {weight=20.0, value=80.0}]"));

        FractionalKnapSack.Item s11 = new FractionalKnapSack.Item(10,60);
        FractionalKnapSack.Item s22 = new FractionalKnapSack.Item(20,100);
        FractionalKnapSack.Item s33 = new FractionalKnapSack.Item(30,120);
        FractionalKnapSack fractionalKnapSack = new FractionalKnapSack(20, Arrays.asList(s33,s11,s22));
        System.out.println(fractionalKnapSack.greedyAlgorithm().toString().equals("[{weight=10.0, value=60.0}, {weight=10.0, value=50.0}]"));

        FractionalKnapSack.Item s111 = new FractionalKnapSack.Item(10,50);
        FractionalKnapSack.Item s222 = new FractionalKnapSack.Item(20,100);
        FractionalKnapSack.Item s333 = new FractionalKnapSack.Item(30,120);
        FractionalKnapSack fractionalKnapSack1 = new FractionalKnapSack(20, Arrays.asList(s222,s333,s111));
        System.out.println(fractionalKnapSack1.greedyAlgorithm().toString().equals("[{weight=20.0, value=100.0}]"));
    }
    public static void mstTest(){
        System.out.println("---------------------mstTest()---------------------");
        Graph.Edge s1 = new Graph.Edge(0,1,1);
        Graph.Edge s2 = new Graph.Edge(1,2,4);
        Graph.Edge s3 = new Graph.Edge(2,3,1);
        Graph.Edge s4 = new Graph.Edge(2,4,3);
        Graph.Edge s5 = new Graph.Edge(3,4,3);
        Graph.Edge s6 = new Graph.Edge(0,4,4);
        Graph s = new Graph(4, Arrays.asList(s1,s2,s3,s4,s5,s6));
        List<Graph.Edge> lst = s.greedyAlgorithm();
        List<Graph.Edge> sol1 = Arrays.asList(s1,s3,s5,s6);
        List<Graph.Edge> sol2 = Arrays.asList(s1,s3,s4,s2);
        List<Graph.Edge> sol3 = Arrays.asList(s1,s3,s4,s6);
        List<Graph.Edge> sol4 = Arrays.asList(s1,s3,s5,s2);
        if (lst.equals(sol3))
            System.out.println("true");
        else if (lst.equals(sol1) || lst.equals(sol2) || lst.equals(sol4))
            System.out.println("false (This is an MST, but not in the right order)");
        else {
            System.out.println(lst);
            System.out.println("false");
        }

        Graph.Edge s11 = new Graph.Edge(0,1,10);
        Graph.Edge s22 = new Graph.Edge(0,2,6);
        Graph.Edge s33 = new Graph.Edge(0,3,5);
        Graph.Edge s44 = new Graph.Edge(1,3,15);
        Graph.Edge s55 = new Graph.Edge(2,3,4);
        Graph graph = new Graph(3, Arrays.asList(s11,s22,s33,s44,s55));
        List<Graph.Edge> lst1 = graph.greedyAlgorithm();
        List<Graph.Edge> sol11 = Arrays.asList(s33,s11,s55);
        List<Graph.Edge> sol22 = Arrays.asList(s33,s55,s11);
        List<Graph.Edge> sol33 = Arrays.asList(s55,s33,s11);
        List<Graph.Edge> sol44 = Arrays.asList(s55,s11,s33);
        if (lst1.equals(sol33))
            System.out.println("true");
        else if (lst1.equals(sol11) || lst.equals(sol22) || lst.equals(sol44))
            System.out.println("false (This is an MST, but not in the right order)");
        else {
            System.out.println("false");
        }

        Graph.Edge s111 = new Graph.Edge(0,1,20);
        Graph.Edge s222 = new Graph.Edge(0,2,50);
        Graph.Edge s333 = new Graph.Edge(0,3,70);
        Graph.Edge s444 = new Graph.Edge(1,2,30);
        Graph.Edge s555 = new Graph.Edge(2,3,40);
        Graph.Edge s666 = new Graph.Edge(0,4,90);
        Graph.Edge s777 = new Graph.Edge(3,4,60);
        Graph graph1 = new Graph(4, Arrays.asList(s111,s222,s333,s444,s555,s666, s777));
        List<Graph.Edge> lst2 = graph1.greedyAlgorithm();
        List<Graph.Edge> sol333 = Arrays.asList(s111,s444,s555,s777);
        if (lst2.equals(sol333))
            System.out.println("true");
        else {
            System.out.println("false");
        }
    }
}
