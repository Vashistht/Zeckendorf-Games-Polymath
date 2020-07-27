enum Status { UNKNOWN, WINNING, LOSING };


// boards are immutable except for status
// add and split return new boards with the change made
public class Board {
	private int[] board;
	private Status status;
	public Board(int num) {
		board = new int[9];
		board[0] = num;
		status = Status.UNKNOWN;
	}
	private Board(int[] b) {
		board = b;
		status = Status.UNKNOWN;
	}
	public boolean canSplit(int index) {
		return index > 0 && board[index] >= 2;
	}
	public Board split(int index) {
		int[] b = board.clone();
		b[index] -= 2;
		b[index + 1]++;
		if(index == 1) b[0]++;
		else b[index - 2]++;
		return new Board(b);
	}
	public boolean canAdd(int index) {
		if(index == 0) return board[index] >= 2;
		return board[index - 1] >= 1 && board[index] >= 1;
	}
	public Board add(int index) {
		int[] b = board.clone();
		b[index]--;
		if(index == 0) b[index]--;
		else b[index - 1]--;
		b[index + 1]++;
		return new Board(b);
	}
	public void setStatus(Status s) {
		status = s;
	}
	public Status getStatus() {
		return status;
	}
	private int[] getBoard() {
		return board;
	}
	public boolean equals(Board b) {
		int[] newBoard = b.getBoard();
		for(int i = 1; i < board.length; i++) {
			if(newBoard[i] != board[i]) return false;
		}
		return true;
	}
	public int getSize() {
		return board.length;
	}
	public String toString() {
		String s = "";
		for(int i : board) {
			if(i < 10) s += "0";
			s += i + " ";
		}
		return s.substring(3);// + "\n";
	}
	public boolean isZeck() {
		for(int i = 0; i < board.length; i++) {
			if(canSplit(i) || canAdd(i)) return false;
		}
		return true;
	}
}
