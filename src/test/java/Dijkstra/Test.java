package Dijkstra;

public class Test {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();

        int[][] adjMatrix = {{1,2,3,11,5,1},
                            {6,0,2,5,1,1},
                            {3,2,0,3,4,1},
                            {1,5,3,0,2,3},
                            {1,5,4,2,0,5},
                            {1,1,1,3,5,0}};
        dijkstra.dijkstra(0, adjMatrix);
        int[] distance = dijkstra.getDistance();
        for (int i = 0; i < distance.length; i ++){
            System.out.println(distance[i]+ "   ");
        }
    }
}
