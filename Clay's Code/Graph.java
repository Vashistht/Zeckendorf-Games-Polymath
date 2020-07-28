import java.util.HashSet;
import java.util.Set;

// graph marking which positions are winning or losing
// I don't entirely know why I wrote my own, I probably could've imported this
public class Graph {
	private final int[] SIZES = new int[] {
		1,1,2,3,4,6,8,10,14,17,22,27,33,41,49,59,71,83,99,115,134,157,180,208,239,272,312,353,400,
		453,509,573,642,717,803,892,993,1102,1219,1350,1489,1640,1808,1983,2178,2386,2609,2854,3113,
		3393,3697,4017,4367,4737,5134,5564,6016,6504,7025,7575,8171,8797,9466,10183,10936,11744,12599,
		13502,14471,15486,16568,17715,18921,20207,21559,22987,24506,26094,27782,29558,31425,33405,35478,
		37664,39973,42386,44939
	};
	Board[] vertices;
	private int index;
	private boolean[][] edges;
	public Graph(Board b, int num) {
		int size = SIZES[num];
		vertices = new Board[size];
		vertices[0] = b;
		index = 1;
		edges = new boolean[size][size];
	}
	// looks for board b and adds it in if it's not there yet
	// puts the vertex in place regardless of if it put it in or not
	// returns -1 if the board was already there to prevent double-covering cases
	public int addVertex(Board b, int from) {
		for(int i = 0; i < index; i++) {
			if(vertices[i].equals(b)) {
				edges[from][i] = true;
				return -1;
			}
		}
		vertices[index] = b;
		edges[from][index] = true;
		index++;
		return index - 1;
	}
	public String toString() {
		String s = "";
		for(int i = 0; i < index; i++) {
			Board b = vertices[i];
			s += b.toString();
		}
		return s;
	}
	public boolean isDone() {
		for(int i = 0; i < index; i++) {
			if(vertices[i].getStatus() == Status.UNKNOWN) return false; 
		}
		return true;
	}
	// labels anything that can be labeled now as winning or losing
	public void checkBoard() {
		for(int i = 0; i < index; i++) {
			boolean b = true;
			for(int j = 0; j < index; j++) {
				if(edges[i][j]) {
					switch(vertices[j].getStatus()) {
					case WINNING:
						vertices[i].setStatus(Status.LOSING);
					case UNKNOWN:
						b = false;
					case LOSING:
						break;
					}
				}
			}
			if(b) vertices[i].setStatus(Status.WINNING);
		}
	}
	
	// I honestly forget what this method does
	// looks like it gives a board, then everywhere that board can go
	public String go() {
		String s = "";
		for(int i = 0; i < index; i++) {
			s += vertices[i].toString() + ",";
			for(int j = 0; j < index; j++) {
				if(edges[i][j])
					s += vertices[j].toString() + ",";
			}
			s += "\n";
		}
		return s;
	}
	// puts all the winning board states after numMoves moves in a set
	// @param numMoves what number move you want to look at for player 2 to make
	public Set<Board> findWinning(int numMoves) {
		Set<Board> s = new HashSet<Board>();
		helperWinning(0, numMoves * 2, s);
		return s;
	}
	private void helperWinning(int index, int movesLeft, Set<Board> s) {
		if(movesLeft == 0) {
			if(vertices[index].getStatus() == Status.WINNING) s.add(vertices[index]);
			return;
		}
		for(int i = 0; i < edges.length; i++) {
			if(edges[index][i]) helperWinning(i, movesLeft - 1, s);
		}
	}
}



