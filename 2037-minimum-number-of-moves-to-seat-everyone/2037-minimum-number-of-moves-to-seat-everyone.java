class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // Sort the seats and students arrays
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;
        int n = seats.length;

        // Calculate the total number of moves
        for (int i = 0; i < n; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}