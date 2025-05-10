package Dynamic;

class LongestCommonSubseq {
    static class Cell {
        int v;
        char d; // 'H' for none, 'U' for up, 'S' for side, 'D' for diagonal
    }

    static void computeLCS(String a, String b) {
        int m = a.length();
        int n = b.length();
        Cell[][] cost = new Cell[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                cost[i][j] = new Cell();
                if (i == 0 || j == 0) {
                    cost[i][j].v = 0;
                    cost[i][j].d = 'H';
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cost[i][j].v = cost[i - 1][j - 1].v + 1;
                    cost[i][j].d = 'D';
                } else {
                    if (cost[i - 1][j].v > cost[i][j - 1].v) {
                        cost[i][j].v = cost[i - 1][j].v;
                        cost[i][j].d = 'U';
                    } else {
                        cost[i][j].v = cost[i][j - 1].v;
                        cost[i][j].d = 'S';
                    }
                }
            }
        }

        System.out.print("LCS of " + a + " and " + b + " is: ");
        int count = printLCS(m, n, cost, a, b)-1;
        System.out.println("\nTherefore Second LCS Length: " + count);
    }

    static int printLCS(int i, int j, Cell[][] cost, String a, String b) {
        if (i == 0 || j == 0) return 0;
        if (cost[i][j].d == 'D') {
            int count = printLCS(i - 1, j - 1, cost, a, b) + 1;
            System.out.print(a.charAt(i - 1));
            return count;
        } else if (cost[i][j].d == 'U') {
            return printLCS(i - 1, j, cost, a, b);
        } else { // 'S'
            return printLCS(i, j - 1, cost, a, b);
        }
    }

    public static void main(String[] args) {
        String a = "ABCBDAB";
        String b = "BDCAB";
        computeLCS(a, b);
    }
}