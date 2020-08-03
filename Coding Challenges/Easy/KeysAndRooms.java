import java.util.Queue;

/*************************************************************************************************
 * Keys and Rooms
 * 
 * We are given a 2D array arr where each element (item arr(i)) represents a room. Each "room"
 *  contains a set of "keys" that unlock other rooms in arr.
 * 
 * You cannot open a room unless you have a key to it. By default, room 0 will be unlocked for
 * you to enter at first.
 * 
 * Given arr, determine if all rooms can be opened. Return true if it is possible, false otherwise.
 *
 * 
 * Input: [[1], [2], [3], []]
 * Output: true
 * Explanation: Room 0 has the key to room 1. Room 1 has the key to room 2. Room 2 has the key to
 *  room 3. All rooms have been opened. 
 * 
 * Input: [[], [2], [3], []]
 * Output: false
 * Explanation: Room 0 has no keys and all other rooms are locked.
 **************************************************************************************************/
public class KeysAndRooms {
    public boolean keysAndRooms(List<List<Integer>> rooms)
    {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);

        while(!queue.isEmpty())
        {
            int currInd = queue.poll();
            List<Integer> currList = rooms.get(currInd);

            for(int key: currList)
            {
                if(!visited.contains(key)){
                    visited.add(key);
                    queue.offer(key);
                }

                if(visited.size() == rooms.size()){
                    return true;
                }
            }
        }

        return visited.size() == rooms.size();
    }
}