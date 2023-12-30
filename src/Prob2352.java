import java.util.*;

public class Prob2352 {
//
//	Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
//
//	A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

	public int equalPairs(int[][] grid) {
		Map<String, Integer> mapColumn = new HashMap<>();
		Map<String, Integer> mapRow = new HashMap<>();
		int c = 0;
        for (int[] ints : grid) {
            StringBuilder s = new StringBuilder();
            for (var j = 0; j < grid.length; j++) {
                s.append(ints[j] + (j == grid.length - 1 ? "" : "-"));
            }
            if (mapColumn.containsKey(s.toString())) {
				mapColumn.put(s.toString(),  mapColumn.get(s.toString()) + 1);
            } else {
				mapColumn.put(s.toString(), 1);
			}
        }

		for (var i = 0; i < grid.length; i++) {
			StringBuilder s = new StringBuilder();
			for (var j = 0; j < grid.length; j++) {
				s.append(grid[j][i] + (j == grid.length - 1 ? "" : "-"));
			}
			if (mapRow.containsKey(s.toString())) {
				mapRow.put(s.toString(), mapRow.get(s.toString()) + 1);
            }
			else {
				mapRow.put(s.toString(), 1);
			}
		}
		for (var item: mapRow.keySet()) {
			if (mapColumn.containsKey(item)) {
				c += mapRow.get(item) * mapColumn.get(item);
			}
		}
		return c;
    }
}
