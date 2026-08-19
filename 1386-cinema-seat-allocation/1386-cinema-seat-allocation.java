class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // row -> set of reserved seats in that row
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Store reservations row-wise
        for (int[] reservation : reservedSeats) {

            int row = reservation[0];
            int seat = reservation[1];

            // If this row is not present, create a new set
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }

            // Add the reserved seat to this row
            map.get(row).add(seat);
        }

        // Initially assume every row can fit 2 families
        int answer = 2 * n;

        // Check only rows that have reservations
        for (int row : map.keySet()) {

            HashSet<Integer> seats = map.get(row);

            // Check whether each group is available

            boolean left = true;    // seats 2,3,4,5
            boolean middle = true;  // seats 4,5,6,7
            boolean right = true;   // seats 6,7,8,9

            // Check LEFT group
            for (int seat = 2; seat <= 5; seat++) {
                if (seats.contains(seat)) {
                    left = false;
                    break;
                }
            }

            // Check MIDDLE group
            for (int seat = 4; seat <= 7; seat++) {
                if (seats.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            // Check RIGHT group
            for (int seat = 6; seat <= 9; seat++) {
                if (seats.contains(seat)) {
                    right = false;
                    break;
                }
            }

            // Decide how many families this row can actually fit

            if (left && right) {
                // Can fit 2 families
                // No change to answer
            }
            else if (left || middle || right) {
                // Can fit only 1 family
                answer--;
            }
            else {
                // Cannot fit any family
                answer -= 2;
            }
        }

        return answer;
    }
}