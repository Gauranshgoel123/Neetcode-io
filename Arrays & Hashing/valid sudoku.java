class Solution{
    public boolean isValidSudoku(char[][] board) {
    // Use arrays instead of HashMaps
    boolean[][] rows = new boolean[9][9];
    boolean[][] columns = new boolean[9][9];
    boolean[][] squares = new boolean[9][9];

    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') {
                continue; // Skip empty cells
            }

            int num = board[i][j] - '1'; // Convert char ('1'-'9') to index (0-8)
            int squareIndex = (i / 3) * 3 + (j / 3); // Calculate sub-box index

            // Check if the number already exists in the row, column, or sub-box
            if (rows[i][num] || columns[j][num] || squares[squareIndex][num]) {
                return false;
            }

            // Mark the number as seen in the row, column, and sub-box
            rows[i][num] = true;
            columns[j][num] = true;
            squares[squareIndex][num] = true;
        }
    }
    return true;
    }
}


//using hashmaps instead of arrays givs more time complexity

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows= new HashMap<>();
        Map<Integer,Set<Character>> cols= new HashMap<>();
        Map<String,Set<Character>> squares= new HashMap<>();

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){

                if(board[r][c]=='.') continue;

                String squarekey=(r/3) + "," + (c/3);

                if(rows.computeIfAbsent(r,k->new HashSet<>()).contains(board[r][c]) || 
                cols.computeIfAbsent(c,k->new HashSet<>()).contains(board[r][c]) || 
                squares.computeIfAbsent(squarekey,k->new HashSet<>()).contains(board[r][c])){
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squarekey).add(board[r][c]);
            }
        }
        return true;
    }
}
