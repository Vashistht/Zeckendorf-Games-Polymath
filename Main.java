import java.util.Set;

public class Main {
	static Graph[] graphs;
	// just for reference; these are the weird move 2 cases
	// I must've been doing something with them earlier
	static int[] nums = new int[] {7,8,11,12,17,23,27,28,43};
	public static void main(String[] args) {
		// this code will run 50 cases and print out the winning moves after 5 moves
		graphs = new Graph[86];
		for(int size = 3; size < 53; size++) {
			Board b = new Board(size);
			Graph g = new Graph(b, size);
			
			// recursively puts all the nodes in the graph
			add(b.add(0), 0, g);
			
			// labels all the vertices winning or losing
			while(!g.isDone()) {
				g.checkBoard();
			}
			System.out.println(size);
			
			Set<Board> s = g.findWinning(5);
			System.out.println(s.size());
			for(Board bo : s) System.out.print(bo.toString().substring(3, 11) + ",");
			System.out.println();
			graphs[size - 3] = g;
		}
	}
	
	// recursive method to fill in the graph
	public static void add(Board b, int from, Graph g) {
		int index = g.addVertex(b, from);
		if(index != -1) {
			if(b.isZeck()) {
				b.setStatus(Status.WINNING);
			} else {
				for(int i = 0; i < b.getSize(); i++) {
					if(b.canSplit(i)) add(b.split(i), index, g);
					if(b.canAdd(i)) add(b.add(i), index, g);
				}
			}
		}
	}
}
